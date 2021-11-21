package blohins.game.ugadaika;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;
final static String TAG = "LOG"

public class Level1 extends AppCompatActivity {
    private AdView adView;
    int counter = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1);

        //ad
        MobileAds.initialize(this);
        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);


        final EditText input_et = (EditText) findViewById(R.id.input_et);
        final TextView result_tv = (TextView)findViewById(R.id.result_tv);
        final TextView attempt_tv = (TextView) findViewById(R.id.attempt_tv);
        final Button btn_send = (Button)findViewById(R.id.btn_send);
        
     //btn_back begin
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.i(TAG, "btn_back exception");
                }
            }
        });
        // end
        
    }
    
    public void getResult(){
       Random random = new Random();
        final int number = random.nextInt(101);
        
       btn_send.setOnClickListener(new View.OnClickListener() {
           @SuppressLint("SetTextI18n")
           @Override
           public void onClick(View v) {
               try {
                   counter ++ ;
                   String s = "";
                   attempt_tv.setText(getResources().getString(R.string.attempt)+ " " + counter );
                   Long num = Long.valueOf(number);
                   Long user_num = Long.valueOf(input.getText().toString()); 
                   if (user_num == num) {
                       s= getResources().getString(R.string.win);
                   } else if (user_num < num) {
                       s= getResources().getString(R.string.low);
                   } else if (user_num > num) {
                       s = getResources().getString(R.string.high);

                   }
               } catch (Exception e) {
                   Log.i(TAG, "getResult exception");
               }
           }
       });
    }
    
    public void setResult(String s){
        result_tv.setText(s);
        input.setText("");
    }

    //System button Back START
    @Override
    public void onBackPressed () {
        super.onBackPressed();

        try {
            Intent intent = new Intent(Level1.this, GameLevels.class);
            startActivity(intent);
        } catch (Exception e) {
            Log.i(TAG, "onBackPressed exception");
        }
    }
    //end
    
}



   
   
