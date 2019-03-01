package ie.cm.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import ie.cm.R;
import ie.cm.models.Creature;

public class Add extends Base {

    private String 		creatureName, creautreclasstype;
    private double 		creatureArmor, ratingValue;
    private EditText name, classtype, armorClass;
    private RatingBar challangerating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        name = findViewById(R.id.addNameET);
        classtype =  findViewById(R.id.addClassET);
        armorClass =  findViewById(R.id.editArmorCET);
        challangerating =  findViewById(R.id.addCRatingBar);
    }

    public void addCreature(View v) {

        creatureName = name.getText().toString();
        creautreclasstype = classtype.getText().toString();
        try {
            creatureArmor = Double.parseDouble(armorClass.getText().toString());
        } catch (NumberFormatException e) {
            creatureArmor = 0.0;
        }
        ratingValue = challangerating.getRating();

        if ((creatureName.length() > 0) && (creautreclasstype.length() > 0)
                && (armorClass.length() > 0)) {
            Creature c = new Creature(creatureName, creautreclasstype, ratingValue,
                    creatureArmor, false);

            app.creatureList.add(c);
            startActivity(new Intent(this, Home.class));
        } else
            Toast.makeText(
                    this,
                    "You must Enter Something for "
                            + "\'Name\', \'Class\' and \'Armor Class\'",
                    Toast.LENGTH_SHORT).show();
    }
}
