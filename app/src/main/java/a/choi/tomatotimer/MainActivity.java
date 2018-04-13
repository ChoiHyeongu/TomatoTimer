package a.choi.tomatotimer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity{

    private static final int MILLISINFUTURE = 1500*1000;
    private static final int COUNT_DOWN_INTERVAL = 1000;

    private int count = 1500, minute, second;
    private CountDownTimer countDownTimer;
    private TextView timeview;
    private boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeview = (TextView)findViewById(R.id.timeView);

        final Button controll = (Button) findViewById(R.id.controllButton);
        controll.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                if(status == true) {
                    countDownTimer();
                    countDownTimer.start();
                    controll.setBackgroundResource(R.drawable.stop);
                    status = false;
                }
                else{
                    countDownTimer.onFinish();
                    controll.setBackgroundResource(R.drawable.play);
                    status = true;
                }
            }
        });
    }

    public void countDownTimer(){

        countDownTimer = new CountDownTimer(MILLISINFUTURE,COUNT_DOWN_INTERVAL){

          @Override
          public void onTick(long millisUntilFinished){
                timeview.setText(timeText(count));
                count--;
          }
          @Override
          public void onFinish(){
              countDownTimer.cancel();
              count = 1500;
              timeview.setText("25:00");
          }
        };
    }

    public String timeText(int count){

        minute = count / 60;
        second = count % 60;

        if(minute < 10 && second <10)
            return "0"+minute+":"+"0"+second;

        else if(minute < 10 )
            return "0"+minute+":"+second;

        else if(second < 10)
            return minute+":"+"0"+second;

        else
            return minute + ":" + second;
    }
}