package com.example.gabc_.app_fcc;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAnalisis = findViewById(R.id.btn_analisis);

        btnAnalisis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avanzar = new Intent(MainActivity.this, TomaMuestraActivity.class);
                startActivity(avanzar);
            }
        });
    }
}
