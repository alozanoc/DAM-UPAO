package com.proyectos.khanakat.tienda.Ayuda;

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

public class AyudaSlideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater inflater;

    //lista de imagenes
    public int[] lst_images2 = {
            R.drawable.recharges,
            R.drawable.payment,
            R.drawable.where,
            R.drawable.key
    };

    //lista de titulos
    public String[] lst_title2 = {
            "¿Como puedo comprar?",
            "¿Como recargo saldo?",
            "¿Donde recargo saldo?",
            "¿Como recupero mi clave?"
    };

    //lista de descripciones
    public String[] lst_description2 = {
            "Debes iniciar sesion con tu cuenta de cliente. Ir al boton de Tienda, presionar el boton de Ver Lista de Productos. Seleccionar el producto deseado, se abrira un menu para poder añadir el producto al carrito de compra.",
            "Ver la lista de tarifas en el menu de Recargas. Se debe acercar a un centro autorizado para realizar la recarga de saldo.",
            "Para reconocer un centro autorizado debe tener el afiche y sello oficial de nuestro empresa. No olvidar verificar el saldo despues de efectuar la recarga.",
            "Ir al menu de Conectarse como cliente, y seleccionar la opcion de recuperar contraseña."
    };

    //lista de fondo de colores
    public int[] lst_bgcolor2 = {
            Color.rgb(53,0,212),
            Color.rgb(53,0,212),
            Color.rgb(53,0,212),
            Color.rgb(53,0,212)
    };

    public AyudaSlideAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title2.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_ayuda,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.SlideLinearLayout2);
        ImageView slideimg = (ImageView) view.findViewById(R.id.slideimg2);
        TextView slidetxttitle = (TextView) view.findViewById(R.id.tv_slidetitle2);
        TextView slidetxtdesc = (TextView) view.findViewById(R.id.tv_slidedescription2);
        layoutslide.setBackgroundColor(lst_bgcolor2[position]);
        slideimg.setImageResource(lst_images2[position]);
        slidetxttitle.setText(lst_title2[position]);
        slidetxtdesc.setText(lst_description2[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}