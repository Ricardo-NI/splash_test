package com.example.externalconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = findViewById(R.id.btnCriarContato);
        btnCadastrar.setOnClickListener(new CreateContatoOnClickListener());

        contadorDeRegistros();
    }

    public void contadorDeRegistros(){

        String msg;
        int contador = new ContatoController(this).totalDeContatos();

        TextView txtTotalDeContatos = findViewById(R.id.txContadorContatos);

        if(contador == 0){
            msg = "Nenhum contato cadastrado";
        }else if(contador == 1){
            msg = contador + " contato cadastrado";
        }else {
            msg = contador + " contatos cadastrados";
        }

        txtTotalDeContatos.setText(msg);
        atualizarListaDeContatos();

    }

    public void atualizarListaDeContatos(){
        LinearLayout linearLayoutRecords = (LinearLayout)findViewById(R.id.objetosContatos);

        linearLayoutRecords.removeAllViews();

        List<Contato> students = new ContatoController(this).listarContatos();

        if(students.size() > 0){

            for(Contato obj : students){
                 int id = obj.getId();
                 String nome = obj.getNome();
                 String email = obj.getEmail();

                 String textViewContents = nome + " - " + email;
                 TextView textViewContatoItem = new TextView(this);
                 textViewContatoItem.setPadding(0,10,0,10);
                 textViewContatoItem.setText(textViewContents);
                 textViewContatoItem.setTag(Integer.toString(id));

                 linearLayoutRecords.addView(textViewContatoItem);
                 textViewContatoItem.setOnLongClickListener(new RetrieveOnLongClickListener());
            }
        }else {
            TextView locationItem = new TextView(this);
            locationItem.setPadding(8,8,8,8);
            locationItem.setText("Nenhum Contato Cadastrado");
        }
    }

}
