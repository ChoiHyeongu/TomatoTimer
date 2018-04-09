package a.choi.tomatotimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button controll = (Button) findViewById(R.id.controllButton);
        controll.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                controll.setText("멈춤");
                TimerOn();
            }
        });
    }

    public void TimerOn(){

        final TextView timeView  = (TextView) findViewById(R.id.timeView);

        Timer mTimer;
        TimerTask mTask;
        int count = 0;

        mTask=new TimerTask() {
            @Override
            public void run() {
                timeView.setText("25:00");
            }
        };
        mTimer=new Timer();
        mTimer.scheduleAtFixedRate(mTask,0,2000);
    }
}