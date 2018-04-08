package a.choi.tomatotimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
            }
        });
    }
}
