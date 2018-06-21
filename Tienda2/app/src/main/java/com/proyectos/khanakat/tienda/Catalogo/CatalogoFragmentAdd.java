package com.proyectos.khanakat.tienda.Catalogo;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyectos.khanakat.tienda.R;

public class CatalogoFragmentAdd extends Fragment {

    View v;

    public CatalogoFragmentAdd() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_catalogo_add,container,false);
        return v;
    }
}
