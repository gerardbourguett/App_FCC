package com.example.gabc_.app_fcc;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gabc_.app_fcc.constantes.Folin;
import com.example.gabc_.app_fcc.constantes.Froehde;
import com.example.gabc_.app_fcc.constantes.Liebermann;
import com.example.gabc_.app_fcc.constantes.Mandelin;
import com.example.gabc_.app_fcc.constantes.Marckis;
import com.example.gabc_.app_fcc.constantes.Mecke;
import com.example.gabc_.app_fcc.constantes.Simon;

public class RegistroMuestraActivity extends AppCompatActivity implements Marckis, Mecke, Mandelin, Simon, Liebermann, Froehde, Folin {

    private TextView rgb,hex,che,r1,g1,b1,sust1,color1tv,rgb2,hex2,che2;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_muestra);

        rgb = findViewById(R.id.rgb_tv);
        hex = findViewById(R.id.hex_tv);
        che = findViewById(R.id.chemical_tv);

        rgb2 = findViewById(R.id.rgb_tv2);
        hex2 = findViewById(R.id.hex_tv2);
        che2 = findViewById(R.id.chemical_tv2);

        r1 = findViewById(R.id.red1);
        g1 = findViewById(R.id.green1);
        b1 = findViewById(R.id.blue1);

        /*r1 = findViewById(R.id.red2);
        g1 = findViewById(R.id.green2);
        b1 = findViewById(R.id.blue2);*/

        color1tv = findViewById(R.id.sustancia);

        Bundle objeto = this.getIntent().getExtras();
        String rgb_tomamuestra = objeto.getString("rgb_tm");
        String hex_tomamuestra = objeto.getString("hex_tm");
        String che_tomamuestra = objeto.getString("che_tm");
        String rgb_tomamuestra2 = objeto.getString("rgb_tm2");
        String hex_tomamuestra2 = objeto.getString("hex_tm2");
        String che_tomamuestra2 = objeto.getString("che_tm2");
        rgb.setText(rgb_tomamuestra);
        hex.setText(hex_tomamuestra);
        che.setText(che_tomamuestra);

        rgb2.setText(rgb_tomamuestra2);
        hex2.setText(hex_tomamuestra2);
        che2.setText(che_tomamuestra2);

        int resta_red1, red1;
        String sustancia_coincide;



        r1.setText("R "+String.valueOf(MARCKIS_RED_MDMA));
        g1.setText("G "+String.valueOf(MARCKIS_GREEN_MDMA));
        b1.setText("B "+String.valueOf(MARCKIS_BLUE_MDMA));

        int rojo1 = Color.red(MARCKIS_RED_MDMA);
        int verde1 = Color.red(MARCKIS_GREEN_MDMA);
        int azul1 = Color.red(MARCKIS_BLUE_MDMA);

        color1tv.setText(MARCKIS_SMDMA);

    }
}
