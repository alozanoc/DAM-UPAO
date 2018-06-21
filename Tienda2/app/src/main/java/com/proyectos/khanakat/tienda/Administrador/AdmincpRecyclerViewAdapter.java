package com.proyectos.khanakat.tienda.Administrador;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.proyectos.khanakat.tienda.R;

import java.util.List;

public class AdmincpRecyclerViewAdapter extends RecyclerView.Adapter<AdmincpRecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<AdmincpProduct> mData;
    Dialog myDialog;

    public AdmincpRecyclerViewAdapter(Context mContext, List<AdmincpProduct> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_catalogo_producto,parent,false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //dialog ini
        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.dialog_catalogo_producto);

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name_tv = (TextView) myDialog.findViewById(R.id.dialog_name_id);
                TextView dialog_price_tv = (TextView) myDialog.findViewById(R.id.dialog_price_id);
                ImageView dialog_product_img = (ImageView) myDialog.findViewById(R.id.dialog_img_prod);
                dialog_name_tv.setText(mData.get(vHolder.getAdapterPosition()).getName());
                dialog_price_tv.setText(mData.get(vHolder.getAdapterPosition()).getPrice());
                dialog_product_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());

                Toast.makeText(mContext,""+String.valueOf(vHolder.getAdapterPosition()),Toast.LENGTH_SHORT).show();

                myDialog.show();

            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_price.setText(mData.get(position).getPrice());
        holder.img_photo.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout item_product;

        private TextView tv_name;
        private TextView tv_price;
        private ImageView img_photo;

        public MyViewHolder(View itemView) {
            super(itemView);

            item_product = (LinearLayout) itemView.findViewById(R.id.product_item_id);

            tv_name = (TextView) itemView.findViewById(R.id.name_product);
            tv_price = (TextView) itemView.findViewById(R.id.price_product);
            img_photo = (ImageView) itemView.findViewById(R.id.img_product);

        }
    }

}
