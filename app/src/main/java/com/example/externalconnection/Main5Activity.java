package com.example.externalconnection;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

public class Main5Activity extends AppCompatActivity {

    ImageView photo;
    TextView name,email,id;
    Button sign_out;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        sign_out = findViewById(R.id.log_out);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        id = findViewById(R.id.id);
        photo = findViewById(R.id.photo);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(Main5Activity.this);
        if(acct != null){
            name.setText(acct.getDisplayName());
            email.setText(acct.getEmail());
            id.setText(acct.getId());
            Uri personPhoto = acct.getPhotoUrl();

            Picasso.get().load(personPhoto).memoryPolicy(MemoryPolicy.NO_STORE).resize(250,250).centerCrop().noFade().into(photo);
        }
    }

    public void signOut(View view){
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Main5Activity.this, "Successfully signed out", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Main5Activity.this, Main4Activity.class));
                        finish();
                    }
                });//.addOnCompleteListener(this,{task} - {

    }
}
