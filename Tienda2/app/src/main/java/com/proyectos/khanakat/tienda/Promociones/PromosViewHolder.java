package com.proyectos.khanakat.tienda.Promociones;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectos.khanakat.tienda.R;
import com.squareup.picasso.Picasso;

public class PromosViewHolder extends RecyclerView.ViewHolder {

    View promosView;

    public PromosViewHolder(View itemView) {
        super(itemView);

        promosView = itemView;
    }

    //Settear detalles a recyclerview row
    public void setDetails(Context ctx, String titulo, String imagen, String descripcion){
        //Vistas
        TextView promosTitleView = promosView.findViewById(R.id.tv_promostitle);
        ImageView promosImgView = promosView.findViewById(R.id.iv_promosimg);
        TextView promosDescView = promosView.findViewById(R.id.tv_promosdesc);

        //Settear datos a vistas
        promosTitleView.setText(titulo);
        Picasso.get().load(imagen).into(promosImgView);
        promosDescView.setText(descripcion);
    }
}
