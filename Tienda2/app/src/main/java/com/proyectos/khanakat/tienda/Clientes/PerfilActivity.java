package com.proyectos.khanakat.tienda.Clientes;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseUser;
import com.proyectos.khanakat.tienda.Catalogo.CatalogoFragmentAdd;
import com.proyectos.khanakat.tienda.Catalogo.CatalogoFragmentFav;
import com.proyectos.khanakat.tienda.Catalogo.CatalogoFragmentProd;
import com.proyectos.khanakat.tienda.Catalogo.CatalogoViewPagerAdapter;
import com.proyectos.khanakat.tienda.MainMenuActivity;
import com.proyectos.khanakat.tienda.R;

public class PerfilActivity extends AppCompatActivity {

    // FIREBASE AUTH
    FirebaseAuth auth;
    FirebaseUser user;
    TextView profileTxt;

    // CATALOGO
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CatalogoViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        // FIREBASE AUTH
        auth = FirebaseAuth.getInstance();
        profileTxt = (TextView)findViewById(R.id.tv_perfil_name);
        user = auth.getCurrentUser();
        profileTxt.setText(user.getEmail());


        // CATALOGO
        tabLayout = (TabLayout) findViewById(R.id.tl_perfil_id);
        viewPager = (ViewPager) findViewById(R.id.vp_perfil_id);
        adapter = new CatalogoViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new CatalogoFragmentProd(),"");
        adapter.AddFragment(new CatalogoFragmentAdd(),"");
        adapter.AddFragment(new CatalogoFragmentFav(),"");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_card_giftcard_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_shopping_cart_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_star_black_24dp);

    }

    // FIREBASE AUTH
    public void signOut(View v){
        auth.signOut();
        finish();
        Intent i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }


}
