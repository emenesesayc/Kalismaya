package com.example.emene.myapplication4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class Horario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);

        Button buttons[][] = new Button[7][5];

        TableLayout table = (TableLayout) findViewById(R.id.table);
        for (int i = 0; i < 7; ++i) {
            TableRow row = new TableRow(this);
            table.addView(row);
            for (int j = 0; j < 5; ++j) {
                int id = 5 * i + j;
                SharedPreferences pref = getApplicationContext().getSharedPreferences("pref", MODE_PRIVATE);
                String text = pref.getString("" + id, null);
                if (text == null) {
                    text = "";
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("" + id, text);
                    editor.commit();
                }

                buttons[i][j] = new Button(this);
                int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
                int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
                buttons[i][j].setLayoutParams(new TableRow.LayoutParams(width, height));
                buttons[i][j].setText(text);
                buttons[i][j].setId(id);
                //buttons[i][j].setBackgroundColor(0xFFFFFFFF);
                buttons[i][j].setBackgroundResource(R.drawable.border);
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = v.getId();
                        Intent intent = new Intent(Horario.this, Modify.class);
                        intent.putExtra("button", id);
                        //startActivity(intent);
                        startActivityForResult(intent, 0);
                    }
                });
                row.addView(buttons[i][j]);
            }
        }
    }

    @Override
    protected void onActivityResult(int a, int b, Intent intent) {
        super.onActivityResult(a, b, intent);

        Button button = (Button) findViewById(intent.getIntExtra("button", -1));
        button.setText(intent.getStringExtra("text"));
    }

}
