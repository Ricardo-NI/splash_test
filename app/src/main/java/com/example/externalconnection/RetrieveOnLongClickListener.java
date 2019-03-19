package com.example.externalconnection;

import android.view.View;
import android.widget.Toast;

public class RetrieveOnLongClickListener implements View.OnLongClickListener {
    @Override
    public boolean onLongClick(View v) {

        Toast.makeText(v.getContext(),"Clicou.", Toast.LENGTH_SHORT).show();
        return false;
    }
}
