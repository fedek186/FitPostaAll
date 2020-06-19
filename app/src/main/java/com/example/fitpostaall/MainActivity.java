package com.example.fitpostaall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;


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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private static final int RC_SIGN_IN = 123;
    FragmentManager manager;
    FragmentTransaction transacFrag;
    BottomNavigationView nav;
    AuthViewModelBase auth;
    String mailUsuarioActual;
    Usuario usuarioActivo = new Usuario();

    //database

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        Fragment fragIncio;
        fragIncio = new fragmentInicio();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragIncio);
        transacFrag.commit();
        nav = findViewById(R.id.nav);
        nav.setOnNavigationItemSelectedListener(navMethod);

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


    }

    private BottomNavigationView.OnNavigationItemSelectedListener navMethod = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment frag = null;
            switch (item.getItemId()) {
                case R.id.home:
                    frag = new fragmentPaginaPrincipal();
                    break;
                case R.id.perfil:
                    frag = new fragPerfil();
                    break;
                case R.id.calendar:
                    frag = new fragCalendario();
                    break;

            }
            transacFrag = manager.beginTransaction();
            transacFrag.replace(R.id.frameHolder, frag);
            transacFrag.commit();
            return true;
        }
    };

    void pasarAingresodeuser() {
        Fragment fragingresodeuser;
        fragingresodeuser = new fragmentInicio();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragingresodeuser);
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
        nav.setVisibility(View.VISIBLE);
        Fragment fragPrin;
        fragPrin = new fragmentPaginaPrincipal();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragPrin);
        transacFrag.commit();
    }

    void pasarAcomida() {

        Fragment fragCom;
        fragCom = new fragmentComida();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragCom);
        transacFrag.commit();
    }

    void pasarAEditar() {

        Fragment fragEd;
        fragEd = new fragPerfilEditar();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragEd);
        transacFrag.commit();
    }

    void pasarALogros() {

        Fragment fragLog;
        fragLog = new fragPerfilLogros();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragLog);
        transacFrag.commit();
    }

    void pasarATrenSuperior() {

        Fragment fragSup;
        fragSup = new fragListaTipoEjerciciosSuperior();
        transacFrag = manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragSup);
        transacFrag.commit();
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
                mailUsuarioActual = user.getEmail();
                guardarInfoUsuarioActivo();


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


    public String[] cortarCadenaPorArroba(String cadena) {
        return cadena.split("\\@");
    }


    public void guardarInfoUsuarioActivo()
    {

        String[] arregloDeMail = cortarCadenaPorArroba(mailUsuarioActual);
        for (int i = 0; i < arregloDeMail.length; i++) {
            Log.d("ConversionMail", arregloDeMail[i]);
        }

        db.collection("usuarios")
                .whereEqualTo("Mail", arregloDeMail[0])
                .whereEqualTo("Dominio", arregloDeMail[1])
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            //cuando es correcto el ingreso
                            for (QueryDocumentSnapshot document1 : task.getResult()) {
                                Log.d("TAG", document1.getId() + " => " + document1.getData());
                                String id = document1.getId();
                               pasarAPrin();





                                DocumentReference docRef = db.collection("usuarios").document(id);
                                docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                                        usuarioActivo = documentSnapshot.toObject(Usuario.class);
                                        String A = usuarioActivo.get_Apellido();

                                    }
                                });
                            }
                        } else {

                            alertaIngresoIncorrecto();

                            Log.d("TAG", "Error getting documents: " + task.getException());
                        }
                    }
                });

    }
}




