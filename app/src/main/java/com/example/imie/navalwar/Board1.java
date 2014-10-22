package com.example.imie.navalwar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class Board1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board1);
        if (savedInstanceState == null) {
           // getFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.action_bar, menu);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            ActionBar actionBar = getActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case android.R.id.home :
                onBackPressed();
            case R.id.menu_next :
                // comportement
                Log.i("Alert", "Next");
                return true;
            case R.id.menu_help :
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
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
