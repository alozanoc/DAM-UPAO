package com.proyectos.khanakat.tienda.Administrador;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class AdmincpSQLiteHelper extends SQLiteOpenHelper {

    public AdmincpSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //insertar data
    public void insertData(String name, String price, String description, byte[] image){
        SQLiteDatabase database = getWritableDatabase();
        //consultas para insertar datos en las tablas de la db
        String sql = "INSERT INTO RECORD VALUES(NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1,name);
        statement.bindString(2,price);
        statement.bindString(3,description);
        statement.bindString(4, String.valueOf(image));

        statement.executeInsert();
    }

    //actualizar datos
    public void updateData(String name, String price, String description, byte[] image, int id){
        SQLiteDatabase database = getWritableDatabase();
        //consulta para actualizar registros
        String sql = "UPDATE RECORD SET name=?, price=?, description=?, image=? WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1,name);
        statement.bindString(2,price);
        statement.bindString(3,description);
        statement.bindString(4, String.valueOf(image));
        statement.bindDouble(5,(double)id);

        statement.execute();
        database.close();
    }

    //eliminar datos
    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase();
        //consulta para eliminar registros por id
        String sql = "DELETE FROM RECORD WHERE id=?";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double)id);

        statement.execute();
        database.close();
    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
