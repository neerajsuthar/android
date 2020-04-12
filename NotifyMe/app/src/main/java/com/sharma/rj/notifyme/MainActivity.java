package com.sharma.rj.notifyme;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView diceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // final TextView diceNumer = (TextView)findViewById(R.id.dice);
        Button btn;
        //btn = (Button) findViewById(R.id.roll);

        diceView = findViewById(R.id.imageView);
        diceView.setImageResource(R.drawable.dice_six);

        diceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no =(int) (Math.random()*6) + 1;
                //diceNumer.setText(no+"");

                if(no==1){
                    diceView.setImageResource(R.drawable.dice_one);
                }
                else if(no==2){
                    diceView.setImageResource(R.drawable.dice_two);
                }
                else if(no==3){
                    diceView.setImageResource(R.drawable.dice_three);
                }
                else if(no==4){
                    diceView.setImageResource(R.drawable.dice_four);
                }
                else if(no==5){
                    diceView.setImageResource(R.drawable.dice_five);
                }
                else if(no==6){
                    diceView.setImageResource(R.drawable.dice_six);
                }
            }

        });

       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int no =(int) (Math.random()*2) + 1;
                //diceNumer.setText(no+"");

                if(no==1){
                    diceView.setImageResource(R.drawable.one);
                }
                else if(no==2){
                    diceView.setImageResource(R.drawable.two);
                }
                else if(no==3){
                    diceView.setImageResource(R.drawable.three);
                }
                else if(no==4){
                    diceView.setImageResource(R.drawable.four);
                }
                else if(no==5){
                    diceView.setImageResource(R.drawable.five);
                }
                else if(no==6){
                    diceView.setImageResource(R.drawable.six);
                }

            }

        });*/

    }
}


