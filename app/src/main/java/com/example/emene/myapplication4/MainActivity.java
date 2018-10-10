package com.example.emene.myapplication4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void funcion(View view) {
        Button boton = (Button)findViewById(R.id.button);
        startActivity(new Intent(MainActivity.this, Horario.class));
    }
}
