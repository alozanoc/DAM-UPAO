package com.proyectos.khanakat.tienda.Administrador;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.proyectos.khanakat.tienda.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class AdmincpRecordListActivity extends AppCompatActivity {

    ListView mListView;
    ArrayList<AdmincpModelProduct> mList;
    AdmincpRecordListAdapter mAdapter = null;

    ImageView imageViewIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincp_record_list);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nueva Lista");

        mListView = findViewById(R.id.listViewProd);
        mList = new ArrayList<>();
        mAdapter = new AdmincpRecordListAdapter(this,R.layout.row_admincp_producto,mList);
        mListView.setAdapter(mAdapter);

        //get todos los datos de sqlite
        Cursor cursor = AdmincpActivity.mAdmincpSQLiteHelper.getData("SELECT * FROM RECORD");
        mList.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String desc = cursor.getString(3);
            byte[]image = cursor.getBlob(4);
            //agregar a la lista
            mList.add(new AdmincpModelProduct(id, name, price, desc, image));
        }

        mAdapter.notifyDataSetChanged();
        if(mList.size()==0){
            //si no hay ningun dato en la tabla de la db significa que la listview esta vacia
            Toast.makeText(this, "No hay registros", Toast.LENGTH_SHORT).show();
        }

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {
                //dialogo de alerta para mostrar las opciones de actualizar y eliminar
                final CharSequence[] items = {"Update", "Delete"};

                AlertDialog.Builder dialog = new AlertDialog.Builder(AdmincpRecordListActivity.this);

                dialog.setTitle("Escoger una opcion");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if(i == 0){
                            if(i == 0){
                                //actualizar
                                Cursor c = AdmincpActivity.mAdmincpSQLiteHelper.getData("SELECT id FROM RECORD");
                                ArrayList<Integer>arrID = new ArrayList<Integer>();
                                while(c.moveToNext()){
                                    arrID.add(c.getInt(0));
                                }
                                //mostrar dialog actualizado
                                showDialogUpdate(AdmincpRecordListActivity.this,arrID.get(i));
                            }
                            if(i == 1){
                                //eliminar
                                Cursor c = AdmincpActivity.mAdmincpSQLiteHelper.getData("SELECT id FROM RECORD");
                                ArrayList<Integer> arrID = new ArrayList<>();
                                while (c.moveToNext()){
                                    arrID.add(c.getInt(0));
                                }
                                showDialogDelete(arrID.get(position));
                            }
                        }
                    }
                });
                dialog.show();

                return true;
            }
        });


    }

    private void showDialogDelete(final int idRecord) {
        AlertDialog.Builder dialogDelete = new AlertDialog.Builder(AdmincpRecordListActivity.this);
        dialogDelete.setTitle("Advertencia!");
        dialogDelete.setMessage("Estas seguro de eliminar?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try{
                    AdmincpActivity.mAdmincpSQLiteHelper.deleteData(idRecord);
                    Toast.makeText(AdmincpRecordListActivity.this, "Fue eliminado exitosamente", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Log.e("error",e.getMessage());
                }
                updateRecordList();
            }
        });
        dialogDelete.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void showDialogUpdate(Activity activity, final int position){
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.dialog_admincp_actualizar);
        dialog.setTitle("Actualizar");

        imageViewIcon = dialog.findViewById(R.id.imageViewRecord);
        final EditText edtName = dialog.findViewById(R.id.edtName);
        final EditText edtPrice = dialog.findViewById(R.id.edtPrice);
        final EditText edtDesc = dialog.findViewById(R.id.edtDesc);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

        //set ancho del dialog
        int width = (int)(activity.getResources().getDisplayMetrics().widthPixels*0.95);
        //set alto del dialog
        int height = (int)(activity.getResources().getDisplayMetrics().heightPixels*0.7);
        dialog.getWindow().setLayout(width,height);
        dialog.show();

        //en actualizar dialog click en imageview para actualizar foto
        imageViewIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //revisar permisos de almacenamiento externo
                ActivityCompat.requestPermissions(
                        AdmincpRecordListActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    AdmincpActivity.mAdmincpSQLiteHelper.updateData(
                            edtName.getText().toString().trim(),
                            edtPrice.getText().toString().trim(),
                            edtDesc.getText().toString().trim(),
                            AdmincpActivity.imageViewToByte(imageViewIcon),
                            position
                    );
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Actualizacion exitosa", Toast.LENGTH_SHORT).show();

                }
                catch(Exception error){
                    Log.e("Error al actualizar",error.getMessage());
                }

                updateRecordList();

            }
        });

    }

    private void updateRecordList() {
        //get todos los datos del sqlite
        Cursor cursor = AdmincpActivity.mAdmincpSQLiteHelper.getData("SELECT * FROM RECORD");
        mList.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String desc = cursor.getString(3);
            byte[] image = cursor.getBlob(4);

            mList.add(new AdmincpModelProduct(id, name, price, desc, image));
        }
        mAdapter.notifyDataSetChanged();
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[]byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){

        if(requestCode == 888){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //galeria intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,888);
            }
            else{
                Toast.makeText(this,"No tienes permiso para acceder a la ruta de este archivo.",Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 888 && resultCode == RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON) //activar lineas guias de imagen
                    .setAspectRatio(1,1)
                    .start(this);
        }
        if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                //set imagen escogida de la galeria al imageview
                imageViewIcon.setImageURI(resultUri);
            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}
