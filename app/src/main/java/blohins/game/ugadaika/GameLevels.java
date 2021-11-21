
package blohins.game.ugadaika;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {
    public static final String TAG = "LOG";
    String level = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
         //button back begin
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameLevels.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.i(TAG, "button_back exeption");
                }
            }
        });
        //end

        //easy level begin
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   level = "101";
                } catch (Exception e) {
                    Log.i(TAG, "easy lvl TextView exeption");
                }
            }
        });
        //end

        //medium level begin
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    level = "1001";
                } catch (Exception e) {
                     Log.i(TAG, "medium lvl TextView exeption");
                }
            }
        });
        // end

        //hard level begin
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                     level = "100001";
                } catch (Exception e) {
                     Log.i(TAG, "hard lvl TextView exception");
                }
            }
        });
        //end

       startGame(level);

    }
    
    public void startGame(String level){
         Log.i(TAG, "startGAme started");
           Intent intent = new Intent(GameLevels.this, StartGame.class);
           intent.putExtra("level", level);
                    startActivity(intent);
                    finish();
    }
    
    //System Button Back begin
    @Override
    public void onBackPressed () {
          Log.i(TAG, "system button back clicked");
        super.onBackPressed();

        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent);
        } catch (Exception e) {
             Log.i(TAG, "onBackPressed exeption");
        }
    }
     //end
    
}

