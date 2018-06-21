package com.proyectos.khanakat.tienda.Administrador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyectos.khanakat.tienda.R;

import java.util.ArrayList;

public class AdmincpRecordListAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<AdmincpModelProduct> recordList;

    public AdmincpRecordListAdapter(Context context, int layout, ArrayList<AdmincpModelProduct> recordList) {
        this.context = context;
        this.layout = layout;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return recordList.size();
    }

    @Override
    public Object getItem(int i) {
        return recordList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName, txtPrice, txtDesc;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);
            holder.txtName = row.findViewById(R.id.tv_nameprod);
            holder.txtPrice = row.findViewById(R.id.tv_priceprod);
            holder.txtDesc = row.findViewById(R.id.tv_descprod);
            holder.imageView = row.findViewById(R.id.imgIcon);
            row.setTag(holder);
        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        AdmincpModelProduct model = recordList.get(i);

        holder.txtName.setText(model.getName());
        holder.txtPrice.setText(model.getPrice());
        holder.txtDesc.setText(model.getDescription());

        byte[] recordImage = model.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
