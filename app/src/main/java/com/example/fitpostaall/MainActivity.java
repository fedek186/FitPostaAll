package com.example.fitpostaall;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    FragmentManager manager;
    FragmentTransaction transacFrag;
    BottomNavigationView nav;

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
        nav=findViewById(R.id.nav);
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
   private  BottomNavigationView.OnNavigationItemSelectedListener navMethod= new BottomNavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment frag=null;
           switch (item.getItemId())
           {
               case R.id.home:
                frag= new fragmentPaginaPrincipal();
                break;
               case R.id.perfil:
                   frag= new fragPerfil();
                   break;
               case R.id.calendar:
                   frag= new fragCalendario();
                   break;

           }
           transacFrag = manager.beginTransaction();
           transacFrag.replace(R.id.frameHolder, frag);
           transacFrag.commit();
           return true;
       }
   };

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
}