package mcm.edu.ph.act3_fruittechies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Hero Class
    int heroHP =        1500;
    int heroMinDPT =    75;
    int heroMaxDPT =    100;
    String heroName  =  "MASH";

    //Monster Class
    int monsHP =        1200;
    int monsMinDPT =    100;
    int monsMaxDPT =    150;
    String monsName  =  "MOMO";


    int turnNumber = 1; //This variable is responsible for counting how many turns the game has.

    @Override
    protected void onCreate(Bundle s) {
        setContentView(R.layout.activity_main);


        super.onCreate(s);
        setContentView(R.layout.activity_main);


        Button nextTurn = findViewById(R.id.btnNextTurn);


        TextView txtMonsName = findViewById(R.id.txtEnemy_name);
        TextView txtHeroName = findViewById(R.id.txtPlayer_name);
        TextView txtMonsHP = findViewById(R.id.txtEnemy_hp);
        TextView txtHeroHP = findViewById(R.id.txtPlayer_hp);
        TextView txtHeroDPT = findViewById(R.id.txtPlayerDPT);
        TextView txtMonsDPT = findViewById(R.id.txtEnemyDPT);


        txtHeroName.setText(heroName);
        txtMonsName.setText(monsName);

        txtHeroHP.setText(String.valueOf(heroHP));
        txtMonsHP.setText(String.valueOf(monsHP));

        txtHeroDPT.setText(heroMinDPT + " ~ " + heroMaxDPT);
        txtMonsDPT.setText(monsMinDPT + " ~ " + monsMaxDPT);
        nextTurn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Random randomizer = new Random();


        Button nextTurn =       findViewById(R.id.btnNextTurn);
        TextView txtMonsHP =    findViewById(R.id.txtEnemy_hp);
        TextView txtHeroHP =    findViewById(R.id.txtPlayer_hp);
        TextView txtCombatLog = findViewById(R.id.txtTurnLog);


        txtMonsHP.setText(String.valueOf(monsHP));
        txtHeroHP.setText(String.valueOf(heroHP));


        int heroDPT = randomizer.nextInt(heroMaxDPT - heroMinDPT) + heroMinDPT;
        int monsDPT = randomizer.nextInt(monsMaxDPT - monsMinDPT) + monsMinDPT;

        switch (v.getId()){
            case R.id.btnNextTurn:


                if(turnNumber%2 == 1){

                    monsHP = monsHP - heroDPT;
                    turnNumber++;

                    txtCombatLog.setText("The Player dealt " +heroDPT+ " damage to the Enemy");

                    txtMonsHP.setText(String.valueOf(monsHP));
                    nextTurn.setText("Enemy's Turn ("+turnNumber+ ")");

                    if (monsHP < 0){
                        txtCombatLog.setText("The Player dealt " +heroDPT+ " damage to the Enemy. The Player was Victorious!");
                        heroHP = 1500;
                        monsHP = 1000;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    } // end of the resetting condition
                } // end of player's turn condition

                else if(turnNumber%2 != 1){
                    heroHP = heroHP - monsDPT;
                    turnNumber++;
                    txtCombatLog.setText("The Monster dealt " +monsDPT+ " damage to the Player");
                    txtHeroHP.setText(String.valueOf(heroHP));
                    nextTurn.setText("Player's Turn ("+turnNumber+ ")");
                    if (heroHP < 0){
                        txtCombatLog.setText("The Monster dealt " +monsDPT+ " damage to the Player. The Player Died");
                        heroHP = 1500;
                        monsHP = 1000;
                        turnNumber = 1;
                        nextTurn.setText("Reset Game");
                    }// end of the resetting condition
                } // end of the monsters turn condition
                break;  // switch breaker for the button function. DO NOT EDIT
        }
    }
}