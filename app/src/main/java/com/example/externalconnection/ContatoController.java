package com.example.externalconnection;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContatoController extends DataBaseAdapter {

    SQLiteDatabase db;

    public ContatoController(Context context){
        super(context);

    }

    public boolean create(Contato contato){

        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", contato.getNome());
        contentValues.put("email", contato.getEmail());

        db = this.getWritableDatabase();
        db.insertOrThrow("contato", null, contentValues);

        return true;
    }

    public int totalDeContatos(){

        db = this.getReadableDatabase();

        String sql = "SELECT * FROM contato";

        return db.rawQuery(sql,null).getCount();

    }

    public List<Contato> listarContatos(){

        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contato ORDER BY id DESC";
        db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {

                    Contato contato = new Contato();
                    //int id = cursor.getInt(cursor.getColumnIndex("id"));
                    contato.id = cursor.getInt(cursor.getColumnIndexOrThrow("ID"));
                    String nome = cursor.getString(cursor.getColumnIndex("nome"));
                    String email = cursor.getString(cursor.getColumnIndex("email"));


                  //  contato.setId(id);
                    contato.setNome(nome);
                    contato.setEmail(email);

                    contatos.add(contato);

                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
        }

        return contatos;
    }

    public Contato buscarPeloID(int contatoID){
        return null;
    }

    public boolean update(Contato contato){
        return true;
    }

    public boolean delete(int contatoID){
        return true;
    }

}