package com.example.wansu.reverse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
// import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText edtInput;
    private TextView txtHasil;
    private Button btnReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setTitle("Reverse");
        edtInput = (EditText) findViewById(R.id.edt_input);
        btnReverse = (Button) findViewById(R.id.btn);
        txtHasil = (TextView) findViewById(R.id.txt_hasil);

        btnReverse.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String p = edtInput.getText().toString().trim();
                char[] balik = p.toCharArray();

                    if (p.equals(""))
                    {
                        edtInput.setError("Masukkan Input");
                    }

                int lastposition = p.length()-1;
                String hasil = "";

                    while (lastposition >= 0)
                    {
                        hasil = hasil + balik[lastposition];
                        lastposition--;
                    }

                /*http://examples.javacodegeeks.com/core-java/character/how-to-convert-character-to-string-and-a-string-to-character-array-in-java/
                http://stackoverflow.com/questions/10006165/converting-string-to-character-array-in-java
                System.out.println("String " + p + " Character Array : "  + Arrays.toString(b));
                System.out.println("Char is: " + String.valueOf(b));
                String c = String.valueOf(a);*/

                /*http://java-bae.blogspot.co.id/2014/11/java-basic-bagaimana-cara-membalikan.html
                String hasil = "";
                for ( int i = p.length()-1 ; i >= 0 ; i--)
                    hasil = hasil + p.charAt(i); //--> mengambil karakter pada sebuah String sesuai index
                System.out.println("Kata dibalik : -> "+ hasil );*/

                txtHasil.setText(hasil);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
