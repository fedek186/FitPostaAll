package com.example.fitpostaall;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


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

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private static final int RC_SIGN_IN = 123;
    FragmentManager manager;
    FragmentTransaction transacFrag;
    BottomNavigationView nav;
    //AuthViewModelBase auth;
    String mailUsuarioActual;
    Usuario usuarioActivo;
    plato plat=new plato();
    boolean TodosPermisos;

    //database

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        Fragment fragInicio;
        fragInicio = new fragmentInicio();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragInicio);
        transacFrag.commit();

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

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i=0;i<permissions.length;i++)
        {
            if(grantResults[i]==PackageManager.PERMISSION_DENIED)
            {
                TodosPermisos=false;
            }
            else{
                TodosPermisos=true;
            }
        }
    }




    void pasarAingresodeuser() {
        Fragment fragingresodeuser;
        fragingresodeuser = new fragmentInicio();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragingresodeuser);
        transacFrag.commit();
    }


    void pasarAregister() {
        Fragment fragSexo;
        fragSexo = new fragmentSexo();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragSexo);
        transacFrag.commit();
    }

    void pasarAaltura() {

        Fragment fragAlt;
        fragAlt = new fragAltura();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragAlt);
        transacFrag.commit();
    }

    void pasarApeso() {
        Fragment fragPes;
        fragPes = new fragPeso();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragPes);
        transacFrag.commit();
    }

    void pasarAedad() {
        Fragment fragEdad;
        fragEdad = new fragEdad();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragEdad);
        transacFrag.commit();
    }

    void pasarAdedicacion() {
        Fragment fragDed;
        fragDed = new fragDedicacion();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragDed);
        transacFrag.commit();
    }

    void pasarAobjetivo() {
        Fragment fragObj;
        fragObj = new fragObjetivo();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragObj);
        transacFrag.commit();
    }

    void pasarAfoto() {
        Fragment fragFot;
        fragFot = new fragIngresoFoto();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragFot);
        transacFrag.commit();
    }

    void pasarAcita() {
        Fragment fragCita;
        fragCita = new fragIngresoCita();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragCita);
        transacFrag.commit();
    }


    void pasarAregistroDatos() {
        Fragment fragDatos;
        fragDatos = new fragmenteRegistroDatos();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragDatos);
        transacFrag.commit();
    }

    void pasarAcompletado() {
        Fragment fragComplet;
        fragComplet = new FragmentCompletado();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragComplet);
        transacFrag.commit();
    }

    void pasarAonboraingrango() {
        Fragment fragOrang;
        fragOrang = new fragmenOnboardingRango();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragOrang);
        transacFrag.commit();
    }

    void pasarAonboraingBloq() {
        Fragment fragBloq;
        fragBloq = new fragmentOnboardingBloq();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragBloq);
        transacFrag.commit();
    }

    void pasarAonboraingCom() {
        Fragment fragCom;
        fragCom = new fragmentOnboardingComida();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragCom);
        transacFrag.commit();
    }

    void pasarAPrin() {
        Fragment fragPrin;
        fragPrin = new fragmentPaginaPrincipal();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPrin);
        transacFrag.commit();
    }

    void pasarAcomida() {

        Fragment fragCom;
        fragCom = new fragmentComida();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragCom);
        transacFrag.commit();
    }

    void pasarAEditar() {

        Fragment fragEd;
        fragEd = new fragPerfilEditar();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragEd);
        transacFrag.commit();
    }

    void pasarALogros() {

        Fragment fragLog;
        fragLog = new fragPerfilLogros();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragLog);
        transacFrag.commit();
    }

    void pasarATrenSuperior() {

        Fragment fragSup;
        fragSup = new fragListaTipoEjerciciosSuperior();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragSup);
        transacFrag.commit();
    }


    void pasarAPlato() {

        Fragment fragPlato;
        fragPlato = new fragPlato();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPlato);
        transacFrag.commit();
    }

    void pasarANav() {

        Fragment fragNav;
        fragNav = new fragNavbar();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragNav);
        transacFrag.commit();
    }

    void pasarAPerfil(){
        Fragment fragPer;
        fragPer = new fragPerfil();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolderDelNavBar, fragPer);
        transacFrag.commit();
    }


    void recebirDatosUnplato(plato unplato )
    {
    plat=unplato;
    }

    plato traerDatos()
    {
        return plat;
    }
    void alertaIngresoIncorrecto() {
        AlertDialog.Builder mensaje;
        mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("el ingreso de mail/contraseña es incorrecto");
        mensaje.setTitle("Ingreso de datos");
        mensaje.setPositiveButton("Aceptar", null);
        mensaje.create();
        mensaje.show();
    }



    public void createSignInIntent() {
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


    // [START auth_fui_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                guardarInfoUsuarioActivo(uid);


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





    public void guardarInfoUsuarioActivo(String UID)
    {

        db.collection("usuarios")
                .whereEqualTo("UID", UID)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
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





                               pasarANav();





                            }
                        } else {

                            alertaIngresoIncorrecto();

                            Log.d("TAG", "Error getting documents: " + task.getException());
                        }
                    }
                });

    }



    public Usuario devolverUsuarioActivo(){return usuarioActivo;}




}




