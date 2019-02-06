package com.example.gabc_.app_fcc;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegistroMuestraActivity extends AppCompatActivity implements Constantes {

    private TextView rgb,hex,che,r1,g1,b1,r2,g2,b2,color1tv;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_muestra);

        rgb = findViewById(R.id.rgb_tv);
        hex = findViewById(R.id.hex_tv);
        che = findViewById(R.id.chemical_tv);

        r1 = findViewById(R.id.red1);
        r2 = findViewById(R.id.red2);
        g1 = findViewById(R.id.green1);
        g2 = findViewById(R.id.green2);
        b1 = findViewById(R.id.blue1);
        b2 = findViewById(R.id.blue2);

        color1tv = findViewById(R.id.color1);

        Bundle objeto = this.getIntent().getExtras();
        String rgb_tomamuestra = objeto.getString("rgb_tm");
        String hex_tomamuestra = objeto.getString("hex_tm");
        String che_tomamuestra = objeto.getString("che_tm");
        rgb.setText(rgb_tomamuestra);
        hex.setText(hex_tomamuestra);
        che.setText(che_tomamuestra);

        r1.setText("R "+String.valueOf(MARCKIS_B1));
        g1.setText("G "+String.valueOf(MARCKIS_G1));
        b1.setText("B "+String.valueOf(MARCKIS_B1));

        int rojo1 = Color.red(MARCKIS_R1);
        int verde1 = Color.red(MARCKIS_G1);
        int azul1 = Color.red(MARCKIS_B1);

        color1tv.setBackgroundColor(Color.rgb(MARCKIS_R1,MARCKIS_G1,MARCKIS_B1));

    }
}
