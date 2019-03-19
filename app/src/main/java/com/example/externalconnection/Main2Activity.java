package com.example.externalconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.externalconnection.model.CEP;
import com.example.externalconnection.service.HTTPService;

import java.util.concurrent.ExecutionException;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        final EditText editText = findViewById(R.id.editText);
        final TextView resposta = findViewById(R.id.tvResposta);
        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cep = editText.getText().toString();
                if(cep.length() > 0 && !editText.getText().toString().equals("") && cep.length() == 8){

                    HTTPService httpService = new HTTPService(cep);
                    try {
                        CEP retorno = httpService.execute().get();
                        if(retorno != null) {
                            resposta.setText(retorno.toString());
                        }
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Toast.makeText(Main2Activity.this,"CEP válido", Toast.LENGTH_SHORT).show();
                }else {
                    editText.setError("CEP inválido!");
                }
            }
        });
    }
}
