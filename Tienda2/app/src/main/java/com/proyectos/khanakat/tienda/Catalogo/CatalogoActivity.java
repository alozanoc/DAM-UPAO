package com.proyectos.khanakat.tienda.Catalogo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.proyectos.khanakat.tienda.R;

public class CatalogoActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CatalogoViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        tabLayout = (TabLayout) findViewById(R.id.tablelayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new CatalogoViewPagerAdapter(getSupportFragmentManager());

        //Add fragment here
        adapter.AddFragment(new CatalogoFragmentProd(),"");
        adapter.AddFragment(new CatalogoFragmentAdd(),"");
        adapter.AddFragment(new CatalogoFragmentFav(),"");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_card_giftcard_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_shopping_cart_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_star_black_24dp);

    }
}
