package com.wildlab.travelerstavern.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.utils.Dice;

import java.util.Random;

/**
 * @author Cory Swaller
 * @since 9/30/2017.
 */

public class DiceFragment extends Fragment {
    private static final String TAG = "DiceFragment";

    private Dice d4;
    private EditText d4Edit;
    private Dice d6;
    private EditText d6Edit;
    private Dice d8;
    private EditText d8Edit;
    private Dice d10;
    private EditText d10Edit;
    private Dice d12;
    private EditText d12Edit;
    private Dice d20;
    private EditText d20Edit;
    private Dice d100;
    private EditText d100Edit;
    private Resources resources;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.rolling_dice, container, false);
        resources = this.getResources();
        init();
        Log.e(TAG, "onCreateView: ");
        return rootView;
    }

    private void init() {
        initButtons();
        initListeners();
    }

    private void initListeners() {
        d4.setOnCheckedChangeListener(onCheckedChangeListener);
        d6.setOnCheckedChangeListener(onCheckedChangeListener);
        d8.setOnCheckedChangeListener(onCheckedChangeListener);
        d10.setOnCheckedChangeListener(onCheckedChangeListener);
        d12.setOnCheckedChangeListener(onCheckedChangeListener);
        d20.setOnCheckedChangeListener(onCheckedChangeListener);
        d100.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private void initButtons() {
        d4 = rootView.findViewById(R.id.dice_d4_image);
        d4Edit = rootView.findViewById(R.id.dice_d4_amount);
        d6 = rootView.findViewById(R.id.dice_d6_image);
        d6Edit = rootView.findViewById(R.id.dice_d6_amount);
        d8 = rootView.findViewById(R.id.dice_d8_image);
        d8Edit = rootView.findViewById(R.id.dice_d8_amount);
        d10 = rootView.findViewById(R.id.dice_d10_image);
        d10Edit = rootView.findViewById(R.id.dice_d10_amount);
        d12 = rootView.findViewById(R.id.dice_d12_image);
        d12Edit = rootView.findViewById(R.id.dice_d12_amount);
        d20 = rootView.findViewById(R.id.dice_d20_image);
        d20Edit = rootView.findViewById(R.id.dice_d20_amount);
        d100 = rootView.findViewById(R.id.dice_d100_image);
        d100Edit = rootView.findViewById(R.id.dice_d100_amount);
    }

    Dice.OnCheckedChangeListener onCheckedChangeListener = new Dice.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch(buttonView.getId()){
                case R.id.dice_d4_image:
                    d4Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d6_image:
                    d6Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d8_image:
                    d8Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d10_image:
                    d10Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d12_image:
                    d12Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d20_image:
                    d20Edit.setEnabled(isChecked);
                    break;
                case R.id.dice_d100_image:
                    d100Edit.setEnabled(isChecked);
                    break;
                default:
                    Log.e(TAG, "some weird button got clicked:" + buttonView.getId());
                    break;
            }
            buttonView.toggle();
            buttonView.setChecked(isChecked);
            Log.e(TAG, "onCheckedChanged: ");
        }
    };

    private int generateRandomNumber(int topRoll) {
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(topRoll) + 1;
        return randomNumber;
    }
}
