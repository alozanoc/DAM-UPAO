package com.proyectos.khanakat.tienda.Administrador;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.proyectos.khanakat.tienda.R;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

public class AdmincpActivity extends AppCompatActivity {

    EditText prodName, prodPrice, prodDesc;
    Button btnAdd, btnList;
    ImageView prodPhoto;

    final int REQUEST_CODE_GALLERY = 999;

    public static AdmincpSQLiteHelper mAdmincpSQLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincp);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nuevo registro");

        prodName = findViewById(R.id.et_prodname);
        prodPrice = findViewById(R.id.et_price);
        prodDesc = findViewById(R.id.et_description);
        btnAdd = findViewById(R.id.btn_add);
        btnList = findViewById(R.id.btn_list);
        prodPhoto = findViewById(R.id.iv_imgProducto);

        //crear base de datos
        mAdmincpSQLiteHelper = new AdmincpSQLiteHelper(this,"RECORDDB.sqlite",null,1);

        //crear tabla en la db
        mAdmincpSQLiteHelper.queryData("CREATE TABLE IF NOT EXISTS RECORD(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, price VARCHAR, description VARCHAR, image BLOB)");

        //seleccionar imagen con click
        prodPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //leer permiso externo de almacenamiento para poder seleccionar imagen de galeria
                ActivityCompat.requestPermissions(
                        AdmincpActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        //agregar registros a sqlite
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mAdmincpSQLiteHelper.insertData(
                            prodName.getText().toString().trim(),
                            prodPrice.getText().toString().trim(),
                            prodDesc.getText().toString().trim(),
                            imageViewToByte(prodPhoto)
                    );
                    Toast.makeText(AdmincpActivity.this, "Se agrego exitosamente", Toast.LENGTH_SHORT).show();
                    //reiniciar vistas
                    prodName.setText("");
                    prodPrice.setText("");
                    prodDesc.setText("");
                    prodPhoto.setImageResource(R.drawable.ic_addphoto);
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }

        });

        //mostrar lista de productos
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //iniciar recordlist activity
                startActivity(new Intent(AdmincpActivity.this,AdmincpRecordListActivity.class));
            }
        });

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

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //galeria intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,REQUEST_CODE_GALLERY);
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

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK){
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
                prodPhoto.setImageURI(resultUri);
            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
