package com.example.gabc_.app_fcc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class TomaMuestraActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView, hexView, color, tvQuimico, textView2, hexView2, color2, tvQuimico2, cancelar,
            textView3, textView4, hexView3, hexView4, color3, color4, tvQuimico3, tvQuimico4;
    private Bitmap bitmap;
    private Button registro;
    private RadioGroup quimico, quimico2, quimico3, quimico4;
    private RadioButton marckis1, mecke1, mandelin1, simon1, marckis2, mecke2, mandelin2, simon2,
            marckis3, mecke3, mandelin3, simon3, marckis4, mecke4, mandelin4, simon4;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toma_muestra);

        cancelar = findViewById(R.id.btn_cancelar);
        imageView = findViewById(R.id.imgImagen);
        registro = findViewById(R.id.btn_registro);

        quimico = findViewById(R.id.rgQuimico);
        quimico2 = findViewById(R.id.rgQuimico2);
        quimico3 = findViewById(R.id.rgQuimico3);
        quimico4 = findViewById(R.id.rgQuimico4);

        textView = findViewById(R.id.txtRGB);
        textView2 = findViewById(R.id.txtRGB2);
        textView3 = findViewById(R.id.txtRGB3);
        textView4 = findViewById(R.id.txtRGB4);

        hexView = findViewById(R.id.txtHexa);
        hexView2 = findViewById(R.id.txtHexa2);
        hexView3 = findViewById(R.id.txtHexa3);
        hexView4 = findViewById(R.id.txtHexa4);

        color = findViewById(R.id.txtColor);
        color2 = findViewById(R.id.txtColor2);
        color3 = findViewById(R.id.txtColor3);
        color4 = findViewById(R.id.txtColor4);

        tvQuimico = findViewById(R.id.txtQuimico);
        tvQuimico2 = findViewById(R.id.txtQuimico2);
        tvQuimico3 = findViewById(R.id.txtQuimico3);
        tvQuimico4 = findViewById(R.id.txtQuimico4);

        //RadioButton

        marckis1 = findViewById(R.id.rb_marckis);
        marckis2 = findViewById(R.id.rb_marckis2);
        marckis3 = findViewById(R.id.rb_marckis3);
        marckis4 = findViewById(R.id.rb_marckis4);

        mecke1 = findViewById(R.id.rb_mecke);
        mecke2 = findViewById(R.id.rb_mecke2);
        mecke3 = findViewById(R.id.rb_mecke3);
        mecke4 = findViewById(R.id.rb_mecke4);

        mandelin1 = findViewById(R.id.rb_mandelin);
        mandelin2 = findViewById(R.id.rb_mandelin2);
        mandelin3 = findViewById(R.id.rb_mandelin3);
        mandelin4 = findViewById(R.id.rb_mandelin4);

        simon1 = findViewById(R.id.rb_simon);
        simon2 = findViewById(R.id.rb_simon2);
        simon3 = findViewById(R.id.rb_simon3);
        simon4 = findViewById(R.id.rb_simon4);

        //Botones

        Button registro1 = findViewById(R.id.registro1);
        Button registro2 = findViewById(R.id.registro2);
        Button registro3 = findViewById(R.id.registro3);
        Button registro4 = findViewById(R.id.registro4);

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TomaMuestraActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(event.getAction() == MotionEvent.ACTION_DOWN ||
                        event.getAction() == MotionEvent.ACTION_MOVE){
                    bitmap = imageView.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(), (int) event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    int r2 = Color.red(pixel);
                    int g2 = Color.green(pixel);
                    int b2 = Color.blue(pixel);

                    int r3 = Color.red(pixel);
                    int g3 = Color.green(pixel);
                    int b3 = Color.blue(pixel);

                    int r4 = Color.red(pixel);
                    int g4 = Color.green(pixel);
                    int b4 = Color.blue(pixel);

                    //textView.setBackgroundColor(Color.rgb(r,g,b));
                    textView.setText("("+r+","+g+","+b+")");
                    textView2.setText("("+r2+","+g2+","+b2+")");
                    textView3.setText("("+r3+","+g3+","+b3+")");
                    textView4.setText("("+r4+","+g4+","+b4+")");

                    String c = ColorHex(r,g,b);
                    String c2 = ColorHex(r2,g2,b2);
                    String c3 = ColorHex(r3,g3,b3);
                    String c4 = ColorHex(r4,g4,b4);

                    hexView.setText(c);
                    hexView2.setText(c2);
                    hexView3.setText(c3);
                    hexView4.setText(c4);

                    color.setBackgroundColor(android.graphics.Color.rgb(r,g,b));
                    color2.setBackgroundColor(android.graphics.Color.rgb(r2,g2,b2));
                    color3.setBackgroundColor(android.graphics.Color.rgb(r3,g3,b3));
                    color4.setBackgroundColor(android.graphics.Color.rgb(r4,g4,b4));
                }

                return true;
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TomaMuestraActivity.this, RegistroMuestraActivity.class);
                intent.putExtra("rgb_tm", textView.getText());
                intent.putExtra("hex_tm", hexView.getText());
                intent.putExtra("che_tm", tvQuimico.getText());
                intent.putExtra("rgb_tm2", textView2.getText());
                intent.putExtra("hex_tm2", hexView2.getText());
                intent.putExtra("che_tm2", tvQuimico2.getText());
                startActivity(intent);
            }
        });



    }

    public String ColorHex(int r,int g,int b){
        String color = "";
        color = "#";
        color+=Integer.toHexString(r);
        color+=Integer.toHexString(g);
        color+=Integer.toHexString(b);
        return color;
    }

    public void onclick(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(Intent.createChooser(intent, "Seleccione la aplicación"),10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Uri path = data.getData();
            imageView.setImageURI(path);
        }
    }

    public void onRadioButtonCLicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rb_marckis:
                if (checked)
                    //
                    tvQuimico.setText("Marckis");
                    break;
            case R.id.rb_mecke:
                if (checked)
                    //
                    tvQuimico.setText("Mecke");
                break;
            case R.id.rb_mandelin:
                if (checked)
                    //
                    tvQuimico.setText("Mandelin");
                break;
            case R.id.rb_simon:
                if (checked)
                    //
                    tvQuimico.setText("Simon");
                    break;
        }
    }

}
