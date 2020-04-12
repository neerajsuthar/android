package org.nrj.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.nrj.R;

public class HomePageActivity extends AppCompatActivity {

    private static final int EMPTY_SOUND = -99;
    private ImageView diceView;
    AnimationDrawable rocketAnimation;
    private MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        diceView = findViewById(R.id.imageView);
        showStartImage(diceView);


        try {
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            Log.println(Log.INFO, "Sleep Issue", "Issue in Thread Sleep");
        }


        diceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                manageOnClickRequest();

            }
        });
    }

    private void manageOnClickRequest() {

        int number =(int) (Math.random()*16) + 1;

        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.one);
                mediaPlayer.start();
                makePage(R.drawable.one_a, "Its a One.");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.all);
                mediaPlayer.start();
                makePage(R.drawable.two_a, null);
                break;

            case 11:
            case 12:
            case 13:
            case 14:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.all);
                mediaPlayer.start();
                makePage(R.drawable.three_a, null);
                break;
            case 15:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.changa);
                mediaPlayer.start();
                makePage(R.drawable.changa, "Great. Its a Four.");
                break;
            case 16:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.calmer);
                mediaPlayer.start();
                makePage(R.drawable.ishtha, "Bingo. Its a Six.");
                break;
        }
    }

    private void makePage(int image, String toastText) {

        if(null!=toastText){
            showToast(toastText);
        }
        diceView.setImageResource(image);

    }

    private void showStartImage(ImageView diceView) {
        diceView.setImageResource(R.drawable.start);
        MediaPlayer mediaPlayer = MediaPlayer.create (getApplicationContext(), R.raw.start);
        mediaPlayer.start();
    }

//      Toast.makeText(getApplicationContext(),"Great Move.",
//      Toast.LENGTH_SHORT).show();
//      rocketAnimation = (AnimationDrawable) diceView.getBackground();
//      rocketAnimation.start();


    private void showToast(String str){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(str);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();

    }


    public void performAction(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}


