package com.example.imie.navalwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreatePlayersActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_players);

        Button btbegin= (Button) findViewById(R.id.btn_create);
        btbegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et1 = (EditText)findViewById(R.id.create_player1);
                String nom_player1 = et1.getText().toString();
                EditText et2 = (EditText)findViewById(R.id.create_player2);
                String nom_player2 = et2.getText().toString();

                if(!nom_player1.isEmpty() && !nom_player2.isEmpty()){
                    Joueur player1 = new Joueur(1, nom_player1);
                    Joueur player2 = new Joueur(2,nom_player2);

                    Intent myIntent;
                    myIntent = new Intent(CreatePlayersActivity.this, Battlefield.class);
                    myIntent.putExtra("player1", player1);
                    myIntent.putExtra("player2", player2);
                    CreatePlayersActivity.this.startActivity(myIntent);
                }
            }
        });
    }
}
