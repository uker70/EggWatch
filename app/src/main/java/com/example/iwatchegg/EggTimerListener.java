package com.example.iwatchegg;

//interface for observer pattern
public interface EggTimerListener {

    public void running();
    public void countDown(long countdown);
}
