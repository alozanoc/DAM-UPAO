package com.proyectos.khanakat.tienda.Promociones;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyectos.khanakat.tienda.R;

public class PromosActivity extends AppCompatActivity {

    RecyclerView promosRecyclerView;
    FirebaseDatabase promosFirebaseDatabase;
    DatabaseReference promosReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promos);

        //Actionbar
        ActionBar actionBar = getSupportActionBar();

        //set titulo
        actionBar.setTitle("Lista de Promociones");

        //recyclerview
        promosRecyclerView = findViewById(R.id.rv_promociones);
        promosRecyclerView.setHasFixedSize(true);

        //set layout como LinearLayout
        promosRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //enviar consulta a Firebase database
        promosFirebaseDatabase = FirebaseDatabase.getInstance();
        promosReference = promosFirebaseDatabase.getReference("promos"); //conectar firebase data

    }

    //cargar datos a recyclerview onStart
    @Override
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<PromosModel, PromosViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<PromosModel, PromosViewHolder>(
                        PromosModel.class,
                        R.layout.row_promos,
                        PromosViewHolder.class,
                        promosReference
                )
                {
                    @Override
                    protected void populateViewHolder(PromosViewHolder viewHolder, PromosModel model, int position) {
                        viewHolder.setDetails(
                                getApplicationContext(),
                                model.getTitulo(),
                                model.getImagen(),
                                model.getDescripcion()
                        );
                    }
                };

        //set adapter al recyclerview
        promosRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
