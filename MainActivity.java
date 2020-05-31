package com.example.asus.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

//To implement Itemselected i must press alt + enter and select the first one
public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        descriptions = getResources().getStringArray(R.array.descriptions);
        /*descriptions.add("description for item 1");
        descriptions.add("description for item 2");
        descriptions.add("description for item 3");*/

        if (findViewById(R.id.layout_port) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFrag))   //Which fragment will be hidden
                    .show(manager.findFragmentById(R.id.listFrag))   //Which fragment will be shown
                    .commit();                                     //To save everything
        }

        if (findViewById(R.id.layout_land) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .show(manager.findFragmentById(R.id.listFrag))
                    .commit();
        }
    }

    @Override
    public void onItemSelected(int index) {

        tvDescription.setText(descriptions[index]);

        if (findViewById(R.id.layout_port) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))   //Which fragment will be hidden
                    .show(manager.findFragmentById(R.id.detailFrag))   //Which fragment will be shown
                    .addToBackStack(null)                              //Fix the back button issue
                    .commit();
        }
    }
}
