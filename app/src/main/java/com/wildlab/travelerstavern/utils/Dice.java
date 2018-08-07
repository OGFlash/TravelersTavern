package com.wildlab.travelerstavern.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Checkable;
import android.widget.CompoundButton;

/**
 * Created by Cory Swaller on 10/17/2017.
 */

public class Dice extends CompoundButton implements Checkable {
    private static final String TAG = "Dice";
    private boolean diceEnabled = false;
    private int numberOfDice = 0;
    private OnCheckedChangeListener onCheckedChangeListener;

    public Dice(Context context) {
        super(context);
    }

    @Override
    public void setChecked(boolean isEnabled){
        diceEnabled = isEnabled;
    }

    @Override
    public boolean isChecked(){
        return this.diceEnabled;
    }

    public void setNumberOfDice(int amountOfDie){
        numberOfDice = amountOfDie;
    }

    public int getNumberOfDice(){
        return(this.numberOfDice);
    }

    public OnCheckedChangeListener getOnCheckedChangeListener(){
        return onCheckedChangeListener;
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked());
        Log.e(TAG, "toggle: ");

    }

}
