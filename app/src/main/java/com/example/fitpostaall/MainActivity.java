package com.example.fitpostaall;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.viewmodel.AuthViewModelBase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MainActivity extends Activity {
    private static final int RC_SIGN_IN = 123;
    FragmentManager manager;
    FragmentTransaction transacFrag;

    Boolean entroConGoogle = false;

    FirebaseUser user;

    Boolean entroxPrimeraVez = null;

    String[] nameUsuario;

    String UIDUSR;

    Uri ur;

    BottomNavigationView nav;
    //AuthViewModelBase auth;
    Usuario usuarioActivo;
    plato plat = new plato();
    boolean TodosPermisos;
    CallbackManager callbackManager;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;



    Usuario usuarioACrear;

    //database

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<Ejercicio> ListaADevolver;

    private ArrayList<Ejercicio> ListaDevolverCompleta;



    ArrayList<Ejercicio> ListaSup = new ArrayList<>();
    ArrayList<Ejercicio> ListaMed = new ArrayList<>();
    ArrayList<Ejercicio> ListaInf = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();



        listaIdDeEjerciciosSegunZona("Superior");
        listaIdDeEjerciciosSegunZona("Inferior");
        listaIdDeEjerciciosSegunZona("Medio");






        usuarioACrear = new Usuario();

        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();

        String uid = prefs.getString("UID", "");

        if(uid =="") {
            pasarAingresodeuser();
        }
        else{
            guardarInfoUsuarioActivo(uid);
        }




/*
        // Escribir en BD
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Federico");
        user.put("last", "Kozak");
// Add a new document with a generated ID
        db.collection("usuarios")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("TAG", "Error adding document", e);
                    }
                });
        // Leer info de BD
        db.collection("usuarios")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });
 */

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i = 0; i < permissions.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                TodosPermisos = false;
            } else {
                TodosPermisos = true;
            }
        }
    }

    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }

    void pasarAingresodeuser() {
        Fragment fragingresodeuser;
        fragingresodeuser = new fragmentInicio();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragingresodeuser);
        transacFrag.addToBackStack(null).commit();
    }


    void pasarAregister() {
        Fragment fragSexo;
        fragSexo = new fragmentSexo();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragSexo);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAaltura() {

        Fragment fragAlt;
        fragAlt = new fragAltura();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragAlt);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarApeso() {
        Fragment fragPes;
        fragPes = new fragPeso();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragPes);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAedad() {
        Fragment fragEdad;
        fragEdad = new fragEdad();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragEdad);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAdedicacion() {
        Fragment fragDed;
        fragDed = new fragDedicacion();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragDed);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAobjetivo() {
        Fragment fragObj;
        fragObj = new fragObjetivo();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragObj);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAfoto() {
        Fragment fragFot;
        fragFot = new fragIngresoFoto();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragFot);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAcita() {
        Fragment fragCita;
        fragCita = new fragIngresoCita();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragCita);
        transacFrag.addToBackStack(null).commit();
    }


    void pasarAregistroDatos() {
        Fragment fragDatos;
        fragDatos = new fragmenteRegistroDatos();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragDatos);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAcompletado() {
        Fragment fragComplet;
        fragComplet = new FragmentCompletado();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragComplet);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAonboraingrango() {
        Fragment fragOrang;
        fragOrang = new fragmenOnboardingRango();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragOrang);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAonboraingBloq() {
        Fragment fragBloq;
        fragBloq = new fragmentOnboardingBloq();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragBloq);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAonboraingCom() {
        Fragment fragCom;
        fragCom = new fragmentOnboardingComida();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragCom);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAPrin() {
        Fragment fragPrin;
        fragPrin = new fragmentPaginaPrincipal();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPrin);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAcomida() {

        Fragment fragCom;
        fragCom = new fragmentComida();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragCom);
        transacFrag.addToBackStack(null).commit();
    }
    void pasarARutina() {

        Fragment fragRut;
        fragRut = new fragmentListaRutina();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragRut);
        transacFrag.addToBackStack(null).commit();
    }
    void pasarAejercicio()
    {
        Fragment fragEje;
        fragEje = new fragmentListaEjere();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragEje);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAEditar() {

        Fragment fragEd;
        fragEd = new fragPerfilEditar();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragEd);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarALogros() {

        Fragment fragLog;
        fragLog = new fragPerfilLogros();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragLog);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarATrenSuperior() {

        Fragment fragSup;
        fragSup = new fragListaTipoEjerciciosSuperior();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragSup);
        transacFrag.addToBackStack(null).commit();
    }


    void pasarAPlato() {

        Fragment fragPlato;
        fragPlato = new fragPlato();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPlato);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarANav() {

        Fragment fragNav;
        fragNav = new fragNavbar();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragNav);
        transacFrag.addToBackStack(null).commit();
    }

    void pasarAPerfil() {
        Fragment fragPer;
        fragPer = new fragPerfil();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPer);
        transacFrag.addToBackStack(null).commit();
    }


    void recebirDatosUnplato(plato unplato) {
        plat = unplato;
    }

    plato traerDatos() {
        return plat;
    }

    void alertaIngresoIncorrecto() {
        AlertDialog.Builder mensaje;
        mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("El ingreso es incorrecto");
        mensaje.setTitle("Ingreso de datos");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }

    void alertaNoIngreso() {
        AlertDialog.Builder mensaje;
        mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("Falta el ingreso de datos");
        mensaje.setTitle("Ingreso de datos");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }

    void alertaUsuarioNoVerificado() {
        AlertDialog.Builder mensaje;
        mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("El usuario no esta verificado");
        mensaje.setTitle("Error en usuario");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }


    public void createSignInMailIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }


    public void createSignInGoogleIntent() {
        // [START auth_fui_create_intent]
        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build());
        entroConGoogle = true;

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
        // [END auth_fui_create_intent]
    }


    // [START auth_fui_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                user = FirebaseAuth.getInstance().getCurrentUser();

                UIDUSR = user.getUid();

                    ur = user.getPhotoUrl();


                boolean ver = user.isEmailVerified();
                if (ver) {
                    guardarInfoUsuarioActivo(UIDUSR);

                } else {
                    alertaUsuarioNoVerificado();
                }


            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...

                alertaIngresoIncorrecto();
            }

        }

    }
    // [END auth_fui_result]


    public void guardarInfoUsuarioActivo(final String UID) {


        db.collection("usuarios")
                .whereEqualTo("UID", UID)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                                           @Override
                                           public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                               entroxPrimeraVez = true;
                                               if (task.isSuccessful()) {
                                                   //cuando es correcto el ingreso
                                                   for (QueryDocumentSnapshot document1 : task.getResult()) {
                                                       Log.d("TAG", document1.getId() + " => " + document1.getData());
                                                       String idusuario = document1.getId();
                                                       String nombre = document1.getString("Nombre");
                                                       String apellido = document1.getString("Apellido");
                                                       String sexo = document1.getString("Sexo");
                                                       Date edad = document1.getDate("Edad");
                                                       Double altura = document1.getDouble("Altura");
                                                       Double peso = document1.getDouble("Peso");
                                                       String tipoalimentacion = document1.getString("Tipo_De_Alimentacion");
                                                       String idexperiencia = document1.getString("idExperiencia");
                                                       Boolean modolesion = document1.getBoolean("Modo_Lesion");
                                                       String foto = document1.getString("Foto");
                                                       String cita = document1.getString("Cita");
                                                       String idcalendario = document1.getString("idCalendario");
                                                       List<String> logros = (List<String>) document1.get("Logros");
                                                       Double ded = document1.getDouble("Dedicacion");
                                                       String obj = document1.getString("Objetivo");
                                                       Double xpMed = document1.getDouble("XPMedio");
                                                       Double xpSup = document1.getDouble("XPSuperior");
                                                       Double xpInf = document1.getDouble("XPInferior");




                                                       usuarioActivo = new Usuario();
                                                       usuarioActivo.set_idUsuario(idusuario);
                                                       usuarioActivo.set_Nombre(nombre);
                                                       usuarioActivo.set_Apellido(apellido);
                                                       usuarioActivo.set_Sexo(sexo);
                                                       usuarioActivo.set_Edad(edad);
                                                       usuarioActivo.set_Altura(altura);
                                                       usuarioActivo.set_Peso(peso);
                                                       usuarioActivo.set_TipoAlimentacion(tipoalimentacion);
                                                       usuarioActivo.set_idExperiencia(idexperiencia);
                                                       usuarioActivo.set_ModoLesion(modolesion);
                                                       usuarioActivo.set_Foto(foto);
                                                       usuarioActivo.set_Cita(cita);
                                                       usuarioActivo.set_idCalendario(idcalendario);
                                                       usuarioActivo.set_Logros(logros);
                                                       usuarioActivo.set_Dedicacion(ded);
                                                       usuarioActivo.set_Objetivo(obj);
                                                       usuarioActivo.set_xpInferior(xpInf);
                                                       usuarioActivo.set_xpSuperior(xpSup);
                                                       usuarioActivo.set_xpMedio(xpMed);


                                                       editor.putString("UID", UID);
                                                       editor.commit();

                                                       entroxPrimeraVez = false;


                                                   }
                                               } else {

                                                   alertaIngresoIncorrecto();

                                                   Log.d("TAG", "Error getting documents: " + task.getException());
                                               }
                                               if (entroxPrimeraVez == null) {
                                                   alertaIngresoIncorrecto();
                                               } else if (!entroxPrimeraVez) {
                                                   pasarANav();
                                               } else {
                                                   pasarAregister();
                                               }
                                           }
                                       }

                );


    }


    public Usuario devolverUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Usuario usr) {
        usuarioActivo = usr;
    }


    public void setUsuarioACrear(Usuario usr) {
        usuarioACrear = usr;
    }

    public Usuario devolverUsuarioACrear() {
        return usuarioACrear;
    }


    public static java.util.Date getDateFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }


    public void cargarUsuarioEnBD() {

        Usuario usuarioACargar = new Usuario();
        usuarioACargar = devolverUsuarioACrear();


        // Add a new document with a generated id.
        Map<String, Object> data = new HashMap<>();
        data.put("Altura", usuarioACargar.get_Altura());
        data.put("Apellido", usuarioACargar.get_Apellido());
        data.put("Cita", usuarioACargar.get_Cita());
        data.put("Dedicacion", usuarioACargar.get_Dedicacion());
        data.put("Edad", usuarioACargar.get_Edad());
        if(entroConGoogle) {
            data.put("Foto", ur.toString());
        } else{
            data.put("Foto", "");

        }
        data.put("Logros", usuarioACargar.get_Logros());
        data.put("Modo_Lesion", usuarioACargar.get_ModoLesion());
        data.put("Nombre", usuarioACargar.get_Nombre());
        data.put("Objetivo", usuarioACargar.get_Objetivo());
        data.put("Peso", usuarioACargar.get_Peso());
        data.put("Sexo", usuarioACargar.get_Sexo());
        data.put("Tipo_De_Alimentacion", usuarioACargar.get_TipoAlimentacion());
        data.put("UID", UIDUSR);
        data.put("idCalendario", usuarioACargar.get_idCalendario());
        data.put("idExperiencia", usuarioACargar.get_idExperiencia());
        data.put("XPMedio",0.0);
        data.put("XPSuperior",0.0);
        data.put("XPInferior",0.0);



        db.collection("usuarios")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        // Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        Log.d("CargarUsuarioABD", "Se cargo exitosamente");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("CargarUsuarioABD", "Error agregando usuario a BD" + e);

                        // Log.w(TAG, "Error adding document", e);
                    }
                });

    }


/*
    public void logout(View view){
        LoginManager.getInstance().logOut();
       pasarAingresodeuser();
    }
*/

    public String[] cortarCadenaPorEspacio(String cadena) {
        return cadena.split("\\ ");
    }

    public void cambiarDatos(Usuario usr) {


        Map<String, Object> data = new HashMap<>();
        data.put("Altura", usr.get_Altura());
        data.put("Apellido", usr.get_Apellido());
        data.put("Cita", usr.get_Cita());
        data.put("Dedicacion", usr.get_Dedicacion());
        data.put("Edad", usr.get_Edad());
        data.put("Foto", usr.get_Foto());
        data.put("Logros", usr.get_Logros());
        data.put("Modo_Lesion", usr.get_ModoLesion());
        data.put("Nombre", usr.get_Nombre());
        data.put("Objetivo", usr.get_Objetivo());
        data.put("Peso", usr.get_Peso());
        data.put("Sexo", usr.get_Sexo());
        data.put("Tipo_De_Alimentacion", usr.get_TipoAlimentacion());
        data.put("UID", UIDUSR);
        data.put("idCalendario", usr.get_idCalendario());
        data.put("idExperiencia", usr.get_idExperiencia());
        data.put("XPMedio", usr.get_xpMedio());
        data.put("XPSuperior",usr.get_xpSuperior());
        data.put("XPInferior",usr.get_xpInferior());
        db.collection("usuarios").document(usr.get_idUsuario()).update(data)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("Editar", "DocumentSnapshot successfully updated!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("Editar", "Error updating document", e);
                    }
                });
    }


    public static Integer getAge(int yearOfBirth, int monthOfBirth, int dayOfBirth) {

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate today = LocalDate.now();
            LocalDate birthdate = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
            Period p = Period.between(birthdate, today);
            return p.getYears();
        }else{
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);

            Calendar c2 = new GregorianCalendar(yearOfBirth,monthOfBirth,dayOfBirth);
            Calendar c1 =  new GregorianCalendar(year, month, day);

            long end = c2.getTimeInMillis();
            long start = c1.getTimeInMillis();

            long milliseconds = TimeUnit.MILLISECONDS.toMillis(Math.abs(end - start));

            Calendar c = Calendar.getInstance();
            c.setTimeInMillis(milliseconds);
            int mYear = c.get(Calendar.YEAR)-1970;

            return mYear;
        }
    }


    public static Calendar toCalendar(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public void cerrarSesion(){
        editor.putString("UID", "");
        editor.commit();
        pasarAingresodeuser();

    }

    public String randomSupInf (){
          final Random generador = new Random();
          final Integer[] preguntas = {1,2};

            int pregunta = preguntas[generador.nextInt(preguntas.length)];
            String p = String.valueOf(pregunta);


        if (p.equals("1")){
            return "Superior";
        }
        else{
            return "Inferior";
        }
    }


    public void listaIdDeEjerciciosSegunZona(final String Zona) {

        ListaADevolver = new ArrayList<>();

        db.collection("zonaDeEjercicios")
                .whereEqualTo("NombreZona", Zona)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            //cuando es correcto el ingreso
                            for (QueryDocumentSnapshot document1 : task.getResult()) {
                                Log.d("TAG", "DocumentSnapshot data: " + document1.getData());

                                List<String> l = (List<String>) document1.get("Ejercicios");

                                if(Zona == "Superior") {
                                    listaDeEjercicios(l, "Superior");
                                }
                                if(Zona == "Inferior") {
                                    listaDeEjercicios(l, "Inferior");
                                }
                                if(Zona == "Medio") {
                                    listaDeEjercicios(l, "Medio");
                                }

                            }
                        } else {
                            Log.d("TAG", "No such document");
                        }
                    }
                });


    }


    public void listaDeEjercicios(List<String> ListaID, final String Z){
        int i;
        ListaDevolverCompleta = new ArrayList<>();
        for(i = 0; i < ListaID.size(); i++){

           String idEj = ListaID.get(i);


            DocumentReference docRef = db.collection("Ejercicios").document(idEj);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                            Ejercicio ej = new Ejercicio();
                            ej.set_NombreEjercicio(document.getString("NombreEjercicio"));
                            ej.set_Destreza(document.getString("Destreza"));
                            ej.set_Dificultad(document.getDouble("Dificultad"));
                            ej.set_Foto(document.getString("Foto"));

                            List<String> mus = (List<String>) document.get("Musculos");
                            ej.set_Musculos(mus);
                            ej.setIdEjercicio(document.getId());

                            if(Z == "Medio"){
                                ListaMed.add(ej);
                            }
                            if(Z == "Superior"){
                                ListaSup.add(ej);
                            }
                            if(Z == "Inferior"){
                                ListaInf.add(ej);
                            }





                        } else {
                            Log.d("TAG", "No such document");
                        }
                    } else {
                        Log.d("TAG", "get failed with ", task.getException());
                    }
                }
            });


        }

    }


    public ArrayList<Ejercicio> devolverListaMedio (){ return ListaMed;}
    public ArrayList<Ejercicio> devolverListaSuperior (){ return ListaSup;}
    public ArrayList<Ejercicio> devolverListaInferior (){ return ListaInf;}


}


