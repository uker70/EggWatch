package com.example.iwatchegg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainPresenter.ViewContract {
    TextView timerView;
    MainPresenter presenter;

    //constructor where view and logic is bound
    public MainActivity(){
        presenter = new MainPresenter(this);
    }

    //sets the egg timer depending on which button was clicked
    public void setTime(View view){
        switch (view.getId()){
            case R.id.buttonOne:
                presenter.setTime(60000L);
                break;

            case R.id.buttonTwo:
                presenter.setTime(120000L);
                break;

            case R.id.buttonThree:
                presenter.setTime(180000L);
                break;
        }
    }

    //starts or stops the timer
    public void startStopTimer(View view){
        presenter.startStopTimer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerView = findViewById(R.id.timerView);
    }

    //changes the button text on the start/stop button
    @Override
    public void setButtonText(String text) {
        ((Button)findViewById(R.id.startButton)).setText(text);
    }

    //updates the time shown on timer
    @Override
    public void setTimeText(Long countdown) {
        timerView.setText(String.format("%0" + 2 +"d",(countdown / 60000))+":"+String.format("%0" + 2 +"d",((countdown%60000)/1000)));
    }
}