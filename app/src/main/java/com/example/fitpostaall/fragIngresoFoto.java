package com.example.fitpostaall;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class fragIngresoFoto extends Fragment implements View.OnClickListener {
    private static final int RESULT_OK = -1 ;
    Button flechaD;
    ImageView flechaI,mas;
    de.hdodenhof.circleimageview.CircleImageView foto;
    Button but;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista;
        vista=inflater.inflate(R.layout.layout_ingresarfoto,container,false);
        flechaD=vista.findViewById(R.id.btnFlechaDerFoto);
        flechaI=vista.findViewById(R.id.imageViewFlechaIzqFot);
        foto=vista.findViewById(R.id.imageViewFoto);
        mas=vista.findViewById(R.id.imageViewMas);
        but=vista.findViewById(R.id.buttonFoto);
        flechaD.setOnClickListener(this);
        but.setOnClickListener(this);
        return vista;
    }

    public void onClick(View vista) {
        Button botonApretado;
        botonApretado= (Button) vista;

        if(flechaD.getId()== botonApretado.getId()){
            MainActivity main=(MainActivity) getActivity();
            main.pasarAcita();
        }
        if(but.getId()== botonApretado.getId())
        {

            Intent llamarASacarFoto;
        llamarASacarFoto=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(llamarASacarFoto,1);
        /*Intent llamarAObtFoto;
            llamarAObtFoto=new Intent(Intent.ACTION_GET_CONTENT);
            llamarAObtFoto.setType("image/*");
            startActivityForResult(Intent.createChooser(llamarAObtFoto,"SeleccioneFoto"),1);*/
        }
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            Log.d("rafa", String.valueOf(resultCode));
            if(resultCode==RESULT_OK)
            {
                Bitmap fot = (Bitmap) data.getExtras().get("data");
                Log.d("rafa", "onClick: Funciona");
                foto.setImageBitmap(fot);

            }
        }
    }
}

