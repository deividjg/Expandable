package com.example.david.expandable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by David on 02/12/2016.
 */

public class BDAlumnos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "Alumnos.db";
    private static final String ins = "CREATE TABLE ALUMNOS (idAlumno INTEGER PRIMARY KEY, Nombre VARCHAR(50), Grupo VARCHAR(10))";

    public BDAlumnos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ins);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ALUMNOS");
        onCreate(db);
    }

    public long insertarAlumno(long idContacto, String nombre, String grupo){
        long nreg_afectados = -1;
        SQLiteDatabase db = getWritableDatabase();

        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("idAlumno", idContacto);
            valores.put("Nombre", nombre);
            valores.put("Grupo", grupo);
            nreg_afectados = db.insert("ALUMNOS", null, valores);
        }
        db.close();
        return nreg_afectados;
    }

    public ArrayList<Alumno> consultarAlumnos(){
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Alumno> alumnos = new ArrayList();
        Alumno alumno;
        long idAlumno;
        String nombre, grupo;

        if (db != null) {
            String[] campos = {"idAlumno", "Nombre", "Grupo"};
            Cursor c = db.query("ALUMNOS", campos, null, null, null, null, "Nombre ASC");
            c.moveToFirst();
            for(int i=0; i<c.getCount(); i++){
                idAlumno = c.getLong(0);
                nombre = c.getString(1);
                grupo = c.getString(2);
                alumno = new Alumno(idAlumno, nombre, grupo);
                alumnos.add(alumno);
                c.moveToNext();
            }
            c.close();
        }
        db.close();
        return alumnos;
    }

    public long nuevaID(){
        SQLiteDatabase db = getReadableDatabase();
        long nAlumnos;
        if (db != null) {
            String[] campos = {"idAlumno"};
            Cursor c = db.query("ALUMNOS", campos, null, null, null, null, "idAlumno DESC");
            if(c.moveToFirst()){
                nAlumnos = Long.parseLong(c.getString(0));
            }else{
                nAlumnos = 0;
            }
            c.close();
            db.close();
            return nAlumnos + 1;
        }
        return -1;
    }
}
