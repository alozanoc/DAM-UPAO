package com.proyectos.khanakat.tienda.Ayuda;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.proyectos.khanakat.tienda.R;

public class AyudaActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private AyudaSlideAdapter ayudaAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        viewPager = (ViewPager) findViewById(R.id.vp_help);
        ayudaAdaptador = new AyudaSlideAdapter(this);
        viewPager.setAdapter(ayudaAdaptador);

    }
}
