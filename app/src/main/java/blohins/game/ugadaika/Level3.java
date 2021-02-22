package blohins.game.ugadaika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;


public class Level3 extends AppCompatActivity {
    private AdView adView;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level3);
        //ad
        MobileAds.initialize(this);
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);



        final EditText input = (EditText) findViewById(R.id.input);
        final TextView result = (TextView) findViewById(R.id.result);
        final Button send = (Button) findViewById(R.id.send);
        Random random = new Random();
        final int number = random.nextInt(1001);
        final TextView trying = (TextView) findViewById(R.id.trying);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    counter ++ ;
                    trying.setText(getResources().getString(R.string.attempt) + " " + counter );
                    Long num = Long.valueOf(number);
                    if (Long.valueOf(input.getText().toString()).equals(num)) {
                        result.setText(getResources().getString(R.string.win));
                        send.setEnabled(false);
                    } else if (Long.valueOf(input.getText().toString()) < num) {
                        result.setText(getResources().getString(R.string.low));
                        input.setText("");
                    } else if (Long.valueOf(input.getText().toString()) > num) {
                        result.setText(getResources().getString(R.string.high));
                        input.setText("");

                    }
                } catch (Exception e) {

                }
            }
        });
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
    }
    //System button Back START
    @Override
    public void onBackPressed () {
        super.onBackPressed();

        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
        } catch (Exception e) {

        }
    }
    //
    }
