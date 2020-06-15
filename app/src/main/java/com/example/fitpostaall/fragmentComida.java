package com.example.fitpostaall;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
public class fragmentComida extends Fragment  {
    FragmentManager managerCom;
    FragmentTransaction transacFragCom;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_comida,container,false);
        managerCom = getFragmentManager();
        Fragment fragListaComida;
        fragListaComida = new fragListaComida();
        transacFragCom = managerCom.beginTransaction();
        transacFragCom.replace(R.id.frameHolderComida, fragListaComida);
        transacFragCom.commit();
        return vista;
    }
}
