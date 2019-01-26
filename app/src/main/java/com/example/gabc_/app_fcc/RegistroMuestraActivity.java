package com.example.gabc_.app_fcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegistroMuestraActivity extends AppCompatActivity {

    private TextView rgb,hex,che;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_muestra);

        rgb = findViewById(R.id.rgb_tv);
        hex = findViewById(R.id.hex_tv);
        che = findViewById(R.id.chemical_tv);

        Bundle objeto = this.getIntent().getExtras();
        String rgb_tomamuestra = objeto.getString("rgb_tm");
        String hex_tomamuestra = objeto.getString("hex_tm");
        String che_tomamuestra = objeto.getString("che_tm");
        rgb.setText(rgb_tomamuestra);
        hex.setText(hex_tomamuestra);
        che.setText(che_tomamuestra);
    }
}
