package com.proyectos.khanakat.tienda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.proyectos.khanakat.tienda.Ayuda.AyudaActivity;
import com.proyectos.khanakat.tienda.Catalogo.CatalogoActivity;
import com.proyectos.khanakat.tienda.Clientes.LoginActivity;
import com.proyectos.khanakat.tienda.Promociones.PromosActivity;
import com.proyectos.khanakat.tienda.Recargas.RecargasActivity;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView cardlogin, cardpromos, cardrecargas, cardayuda, cardcatalogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        cardlogin = (CardView) findViewById(R.id.card_login);
        cardpromos = (CardView) findViewById(R.id.card_promos);
        cardrecargas = (CardView) findViewById(R.id.card_recargas);
        cardayuda = (CardView) findViewById(R.id.card_ayuda);
        cardcatalogo = (CardView) findViewById(R.id.card_catalogo);

        cardlogin.setOnClickListener(this);
        cardpromos.setOnClickListener(this);
        cardrecargas.setOnClickListener(this);
        cardayuda.setOnClickListener(this);
        cardcatalogo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.card_login : i = new Intent(this,LoginActivity.class);startActivity(i); break;
            case R.id.card_promos : i = new Intent(this,PromosActivity.class);startActivity(i); break;
            case R.id.card_recargas : i = new Intent(this,RecargasActivity.class);startActivity(i); break;
            case R.id.card_ayuda : i = new Intent(this,AyudaActivity.class);startActivity(i); break;
            case R.id.card_catalogo : i = new Intent(this,CatalogoActivity.class);startActivity(i); break;
            default: break;
        }
    }

}
