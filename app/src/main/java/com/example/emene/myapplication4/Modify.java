package com.example.emene.myapplication4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Modify extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
    }

    public void save(View view) {
        EditText edit = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        int id = intent.getIntExtra("button",-1);

        SharedPreferences.Editor editor = getSharedPreferences("pref", MODE_PRIVATE).edit();
        editor.putString("" + id, edit.getText().toString());
        editor.commit();

        intent.putExtra("text", edit.getText().toString());

        setResult(0,intent);
        finish();
        //startActivity(new Intent(Modify.this, Horario.class));
    }
}
