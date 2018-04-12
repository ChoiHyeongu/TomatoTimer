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

public class MainActivity extends AppCompatActivity{

        private int count = 1500;
        private int MILLISINFUTURE = (count+1) *1000;
        private static final int COUNT_DOWN_INTERVAL = 1000;
        private boolean status = false;
        private CountDownTimer countDownTimer;
        private int second, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button controll = (Button) findViewById(R.id.controllButton);

        controll.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(status == true) {
                    countDownTimer();
                    cancle();
                    controll.setBackgroundResource(R.drawable.play);
                    status = !status;
                }
                else if(status == false){
                    countDownTimer();
                    countDownTimer.start();
                    controll.setBackgroundResource(R.drawable.stop);
                    status = !status;
                }
            }
        });
    }

    public void countDownTimer() {

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            private final TextView timeView = (TextView) findViewById(R.id.timeView);

            @Override
            public void onTick(long millisUntilFinished) {
                timeView.setText(""+millisUntilFinished/1000);
            }

            public void onFinish() {
                count = 1500;
                timeView.setText(timeText(count));
                countDownTimer = null;
            }
        };
    }

    private void cancle(){
        if(countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer = null;
        }
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