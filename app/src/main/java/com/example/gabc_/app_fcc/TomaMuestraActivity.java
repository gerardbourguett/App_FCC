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
import android.widget.TextView;

import java.net.URL;

public class TomaMuestraActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView, hexView, color;
    private Bitmap bitmap;
    private Button registro;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toma_muestra);

        imageView = findViewById(R.id.imgImagen);
        textView = findViewById(R.id.txtDarkVibrant);
        hexView = findViewById(R.id.txtVibrant);
        color = findViewById(R.id.txtLightVibrant);
        registro = findViewById(R.id.btn_registro);

        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

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

                    textView.setBackgroundColor(Color.rgb(r,g,b));
                    textView.setText("R("+r+") G("+g+") B("+b+")");

                    String c = ColorHex(r,g,b);
                    hexView.setText("HEX: "+c);
                    color.setBackgroundColor(android.graphics.Color.rgb(r,g,b));
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
}
