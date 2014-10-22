package com.example.imie.navalwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button btbegin= (Button) findViewById(R.id.btbegin);
        btbegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                myIntent = new Intent(MyActivity.this, Board.class);
                MyActivity.this.startActivity(myIntent);
            }
        });

        Button btexit= (Button) findViewById(R.id.btexit);
        btexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

}
