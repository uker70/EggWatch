package com.example.iwatchegg;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPresenter implements EggTimerListener{

    EggTimer timer;
    ViewContract mainView;

    //interface to send data to GUI
    public interface ViewContract{
        void setButtonText(String text);
        void setTimeText(Long countdown);
    }

    //constructor where view and logic is bound
    public MainPresenter(ViewContract v){
        mainView = v;
        timer = new EggTimer();
        timer.addListener(this);
    }

    //sets the egg timer and tells GUI to update to the new time
    public void setTime(Long time){
        timer.timerDuration = time;
        mainView.setTimeText(timer.timerDuration);
    }

    //starts or stops the timer
    public void startStopTimer(){
        if (timer.timerDuration != null&&timer.running == false){
            timer.Start();
        }
        else if(timer.running == true){
            timer.Stop();
        }
    }

    //changes button text, depending on running timer
    @Override
    public void running() {
        if(timer.running){
            mainView.setButtonText("Stop");
        }
        else {
            mainView.setButtonText("Start");
        }
    }

    //sends updates to GUI with time
    @Override
    public void countDown(long countdown) {
        mainView.setTimeText(countdown);
    }
}
