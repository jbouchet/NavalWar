package com.example.imie.navalwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Battlefield extends Activity {

    Joueur player1;
    Joueur player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battlefield);

        Intent myIntent = getIntent();
        if (myIntent != null) {
            player1 = (Joueur) myIntent.getSerializableExtra("player1");
            player2 = (Joueur) myIntent.getSerializableExtra("player2");
        }

       if(player1.getRectangles() == null){
            this.setTitle(player1.getName());
        }else{
            this.setTitle(player2.getName());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        /*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            ActionBar actionBar = getActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            /*case android.R.id.home :
                onBackPressed();*/
            case R.id.menu_next :

                Intent myIntent;
                Grille grille = (Grille) findViewById(R.id.grille);

                if(player1.getRectangles() == null){
                    myIntent = new Intent(Battlefield.this, Battlefield.class);
                    player1.setRectangles(grille.rectangles);
                    myIntent.putExtra("player1", player1);
                    myIntent.putExtra("player2", player2);
                    Battlefield.this.startActivity(myIntent);
                }else{
                    myIntent = new Intent(Battlefield.this, ReadyActivity.class);
                    player2.setRectangles(grille.rectangles);
                    myIntent.putExtra("player1", player1);
                    myIntent.putExtra("player2", player2);
                    Battlefield.this.startActivity(myIntent);
                }
                return true;
            /*case R.id.menu_help :
                // comportement
                Log.i("Alert", "Help");
                return true;
            case R.id.menu_about :
                // comportement
                Log.i("Alert", "About");
                return true;
            case R.id.menu_settings :
                // comportement
                Log.i("Alert", "Settings");
                return true;*/
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
