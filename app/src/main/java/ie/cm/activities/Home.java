package ie.cm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ie.cm.R;
import ie.cm.fragments.CreatureFrag;
import ie.cm.models.Creature;

public class Home extends Base {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Information", Snackbar.LENGTH_LONG)
                        .setAction("More Info...", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        }).show();
            }
        });
        if(app.creatureList.isEmpty()) setupCreatures();
    }

    public void add(View v) {
        startActivity(new Intent(this, Add.class));
    }

    public void search(View v) {
        startActivity(new Intent(this, Search.class));
    }

    public void favourites(View v) { startActivity(new Intent(this, Favourites.class));
    }

    @Override
    protected void onResume() {
        super.onResume();

        creatureFrag = CreatureFrag.newInstance(); //get a new Fragment instance
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, creatureFrag)
                .commit(); // add it to the current activity
    }

    public void setupCreatures(){
        app.creatureList.add(new Creature("Loch", "Druid: Circle of the Moon",4,16,true));
        app.creatureList.add(new Creature("Calimastia", "Rogue: Arcane Trickster",4,16,true));
        app.creatureList.add(new Creature("Axe Beak ", "Large Beast",0.25,11,false));
        app.creatureList.add(new Creature("Bandit", "Medium humanoid",0.5,12,false));
        app.creatureList.add(new Creature("Air Elemental ", "Large elemental",5.0,15,false));
    }
}

