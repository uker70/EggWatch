package com.example.iwatchegg;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

//Eggtimer class
public class EggTimer {
    //variables
    public Long timerDuration;
    CountDownTimer timer;
    public String time;
    public boolean running;
    List<EggTimerListener> listeners = new ArrayList<>();

    //Starts the egg timer at the selected timerDuration and notifies the observers
    public void Start(){
        timer = new CountDownTimer(timerDuration, 1000) {

            public void onTick(long millisUntilFinished) {
                timerDuration = millisUntilFinished;
                for (EggTimerListener l: listeners) {
                    l.countDown(millisUntilFinished);
                    l.running();
                }
            }

            public void onFinish() {
                running = false;
                timer = null;
                for (EggTimerListener l : listeners) {
                    l.running();
                }
            }
        }.start();
        running = true;
    }

    //stops the egg timer and notifies the observers
    public void Stop(){
        timer.cancel();
        running = false;
        for (EggTimerListener l : listeners) {
            l.running();
        }
    }

    //add observer
    public void addListener(EggTimerListener listener) {
        listeners.add(listener);
    }

    //remove observer
    public void removeListener(EggTimerListener listener) {
        listeners.remove(listener);
    }

}
