package com.proyectos.khanakat.tienda.Recargas;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.proyectos.khanakat.tienda.R;

public class RecargasSlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //lista de imagenes
    public int[] lst_images = {
            R.drawable.payment,
            R.drawable.payment,
            R.drawable.payment,
            R.drawable.payment
    };

    //lista de titulos
    public String[] lst_title = {
            "100 Monedas",
            "400 Monedas",
            "1000 Monedas",
            "10000 Monedas"
    };

    //lista de descripciones
    public String[] lst_description = {
            "s/. 20\n\nCancelar el monto en cualquier sucursal autorizada. El saldo sera recargado a su cuenta de cliente.",
            "s/. 50\n\nCancelar el monto en cualquier sucursal autorizada. El saldo sera recargado a su cuenta de cliente.",
            "s/. 100\n\nCancelar el monto en cualquier sucursal autorizada. El saldo sera recargado a su cuenta de cliente.",
            "s/. 500\n\nCancelar el monto en cualquier sucursal autorizada. El saldo sera recargado a su cuenta de cliente."
    };

    //lista de fondo de colores
    public int[] lst_bgcolor = {
            Color.rgb(53,0,212),
            Color.rgb(53,0,212),
            Color.rgb(53,0,212),
            Color.rgb(53,0,212)
    };

    public RecargasSlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_recargas,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.SlideLinearLayout);
        ImageView slideimg = (ImageView) view.findViewById(R.id.slideimg);
        TextView slidetxttitle = (TextView) view.findViewById(R.id.tv_slidetitle1);
        TextView slidetxtdesc = (TextView) view.findViewById(R.id.tv_slidedescription1);
        layoutslide.setBackgroundColor(lst_bgcolor[position]);
        slideimg.setImageResource(lst_images[position]);
        slidetxttitle.setText(lst_title[position]);
        slidetxtdesc.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
