package com.proyectos.khanakat.tienda.Recargas;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.proyectos.khanakat.tienda.R;

public class RecargasActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RecargasSlideAdapter recargasAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recargas);

        viewPager = (ViewPager) findViewById(R.id.vp_recargas);
        recargasAdaptador = new RecargasSlideAdapter(this);
        viewPager.setAdapter(recargasAdaptador);

    }
}
