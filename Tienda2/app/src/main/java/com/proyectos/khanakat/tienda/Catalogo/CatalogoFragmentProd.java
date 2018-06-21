package com.proyectos.khanakat.tienda.Catalogo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyectos.khanakat.tienda.Administrador.AdmincpProduct;
import com.proyectos.khanakat.tienda.R;
import com.proyectos.khanakat.tienda.Administrador.AdmincpRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class CatalogoFragmentProd extends Fragment {

    View v;

    private RecyclerView myrecyclerview;
    private List<AdmincpProduct> lstProduct;

    public CatalogoFragmentProd() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_catalogo_prod,container,false);

        myrecyclerview = (RecyclerView) v.findViewById(R.id.product_recyclerview);
        AdmincpRecyclerViewAdapter recyclerAdapter = new AdmincpRecyclerViewAdapter(getContext(),lstProduct);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstProduct = new ArrayList<>();

        //Productos de prueba
        lstProduct.add(new AdmincpProduct("Cocacola", "S./ 2.00", R.drawable.coke));
        lstProduct.add(new AdmincpProduct("Montain Dew", "S./ 3.00", R.drawable.mountaindew));
        lstProduct.add(new AdmincpProduct("Mini Oreo", "S./ 1.50", R.drawable.minioreo));
        lstProduct.add(new AdmincpProduct("Mini Cookies", "S./ 2.20", R.drawable.minicookies));
        lstProduct.add(new AdmincpProduct("Chocolate Milka", "S./ 3.00", R.drawable.chocolatemilka));
        lstProduct.add(new AdmincpProduct("Pringles", "S./ 6.00", R.drawable.pringles));
        lstProduct.add(new AdmincpProduct("Azucar", "S./ 2.50", R.drawable.sugar));

        lstProduct.add(new AdmincpProduct("Cocacola", "S./ 2.00", R.drawable.coke));
        lstProduct.add(new AdmincpProduct("Montain Dew", "S./ 3.00", R.drawable.mountaindew));
        lstProduct.add(new AdmincpProduct("Mini Oreo", "S./ 1.50", R.drawable.minioreo));
        lstProduct.add(new AdmincpProduct("Mini Cookies", "S./ 2.20", R.drawable.minicookies));
        lstProduct.add(new AdmincpProduct("Chocolate Milka", "S./ 3.00", R.drawable.chocolatemilka));
        lstProduct.add(new AdmincpProduct("Pringles", "S./ 6.00", R.drawable.pringles));
        lstProduct.add(new AdmincpProduct("Azucar", "S./ 2.50", R.drawable.sugar));

        lstProduct.add(new AdmincpProduct("Cocacola", "S./ 2.00", R.drawable.coke));
        lstProduct.add(new AdmincpProduct("Montain Dew", "S./ 3.00", R.drawable.mountaindew));
        lstProduct.add(new AdmincpProduct("Mini Oreo", "S./ 1.50", R.drawable.minioreo));
        lstProduct.add(new AdmincpProduct("Mini Cookies", "S./ 2.20", R.drawable.minicookies));
        lstProduct.add(new AdmincpProduct("Chocolate Milka", "S./ 3.00", R.drawable.chocolatemilka));
        lstProduct.add(new AdmincpProduct("Pringles", "S./ 6.00", R.drawable.pringles));
        lstProduct.add(new AdmincpProduct("Azucar", "S./ 2.50", R.drawable.sugar));

        lstProduct.add(new AdmincpProduct("Cocacola", "S./ 2.00", R.drawable.coke));
        lstProduct.add(new AdmincpProduct("Montain Dew", "S./ 3.00", R.drawable.mountaindew));
        lstProduct.add(new AdmincpProduct("Mini Oreo", "S./ 1.50", R.drawable.minioreo));
        lstProduct.add(new AdmincpProduct("Mini Cookies", "S./ 2.20", R.drawable.minicookies));
        lstProduct.add(new AdmincpProduct("Chocolate Milka", "S./ 3.00", R.drawable.chocolatemilka));
        lstProduct.add(new AdmincpProduct("Pringles", "S./ 6.00", R.drawable.pringles));
        lstProduct.add(new AdmincpProduct("Azucar", "S./ 2.50", R.drawable.sugar));

    }
}
