package com.example.fitpostaall;

import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
public class MainActivity extends Activity {
    FragmentManager manager;
    FragmentTransaction transacFrag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager=getFragmentManager();
        Fragment fragIncio;
        fragIncio = new fragmentInicio();
        transacFrag=manager.beginTransaction();
        transacFrag.replace(R.id.frameHolder, fragIncio);
        transacFrag.commit();
    }
}