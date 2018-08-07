package com.wildlab.travelerstavern.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.utils.Dice;

import java.util.Random;

/**
 * @author Cory Swaller
 * @since 9/30/2017.
 */

public class DiceFragment extends Fragment {
    private static final String TAG = "DiceFragment";

    private CompoundButton d4;
    private EditText d4Edit;
    private EditText d4RollEdit;
    private Button d4GoButton;
    private CompoundButton d6;
    private EditText d6Edit;
    private EditText d6RollEdit;
    private Button d6GoButton;
    private CompoundButton d8;
    private EditText d8Edit;
    private EditText d8RollEdit;
    private Button d8GoButton;
    private CompoundButton d10;
    private EditText d10Edit;
    private EditText d10RollEdit;
    private Button d10GoButton;
    private CompoundButton d12;
    private EditText d12Edit;
    private EditText d12RollEdit;
    private Button d12GoButton;
    private CompoundButton d20;
    private EditText d20Edit;
    private EditText d20RollEdit;
    private Button d20GoButton;
    private CompoundButton d100;
    private EditText d100Edit;
    private EditText d100RollEdit;
    private Button d100GoButton;
    private TextView totalSumTextView;
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


        d4GoButton.setOnClickListener(onClickListener);
        d6GoButton.setOnClickListener(onClickListener);
        d8GoButton.setOnClickListener(onClickListener);
        d10GoButton.setOnClickListener(onClickListener);
        d12GoButton.setOnClickListener(onClickListener);
        d20GoButton.setOnClickListener(onClickListener);
        d100GoButton.setOnClickListener(onClickListener);
    }

    private void initButtons() {
        d4 = rootView.findViewById(R.id.dice_d4_image);
        d4Edit = rootView.findViewById(R.id.dice_d4_amount);
        d4RollEdit = rootView.findViewById(R.id.dice_d4_rolls);
        d4GoButton = rootView.findViewById(R.id.button_roll_d4);
        d6 = rootView.findViewById(R.id.dice_d6_image);
        d6Edit = rootView.findViewById(R.id.dice_d6_amount);
        d6RollEdit = rootView.findViewById(R.id.dice_d6_rolls);
        d6GoButton = rootView.findViewById(R.id.button_roll_d6);
        d8 = rootView.findViewById(R.id.dice_d8_image);
        d8Edit = rootView.findViewById(R.id.dice_d8_amount);
        d8RollEdit = rootView.findViewById(R.id.dice_d8_rolls);
        d8GoButton = rootView.findViewById(R.id.button_roll_d8);
        d10 = rootView.findViewById(R.id.dice_d10_image);
        d10Edit = rootView.findViewById(R.id.dice_d10_amount);
        d10RollEdit = rootView.findViewById(R.id.dice_d10_rolls);
        d10GoButton = rootView.findViewById(R.id.button_roll_d10);
        d12 = rootView.findViewById(R.id.dice_d12_image);
        d12Edit = rootView.findViewById(R.id.dice_d12_amount);
        d12RollEdit = rootView.findViewById(R.id.dice_d12_rolls);
        d12GoButton = rootView.findViewById(R.id.button_roll_d12);
        d20 = rootView.findViewById(R.id.dice_d20_image);
        d20Edit = rootView.findViewById(R.id.dice_d20_amount);
        d20RollEdit = rootView.findViewById(R.id.dice_d20_rolls);
        d20GoButton = rootView.findViewById(R.id.button_roll_d20);
        d100 = rootView.findViewById(R.id.dice_d100_image);
        d100Edit = rootView.findViewById(R.id.dice_d100_amount);
        d100RollEdit = rootView.findViewById(R.id.dice_d100_rolls);
        d100GoButton = rootView.findViewById(R.id.button_roll_d100);
        totalSumTextView = rootView.findViewById(R.id.dice_total);
    }

    Dice.OnCheckedChangeListener onCheckedChangeListener = new Dice.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.dice_d4_image:
                    d4Edit.setEnabled(isChecked);
                    d4RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d6_image:
                    d6Edit.setEnabled(isChecked);
                    d6RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d8_image:
                    d8Edit.setEnabled(isChecked);
                    d8RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d10_image:
                    d10Edit.setEnabled(isChecked);
                    d10RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d12_image:
                    d12Edit.setEnabled(isChecked);
                    d12RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d20_image:
                    d20Edit.setEnabled(isChecked);
                    d20RollEdit.setEnabled(isChecked);
                    break;
                case R.id.dice_d100_image:
                    d100Edit.setEnabled(isChecked);
                    d100RollEdit.setEnabled(isChecked);
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

    Button.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_roll_d4:
                    if (!d4Edit.getText().toString().contentEquals("") && !d4RollEdit.toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d4RollEdit.getText().toString()), Integer.valueOf(d4Edit.getText().toString()), 4)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d6:
                    if (!d6Edit.getText().toString().contentEquals("") && !d6RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d6RollEdit.getText().toString()), Integer.valueOf(d6Edit.getText().toString()), 6)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d8:
                    if (!d8Edit.getText().toString().contentEquals("") && !d8RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d8RollEdit.getText().toString()), Integer.valueOf(d8Edit.getText().toString()), 8)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d10:
                    if (!d10Edit.getText().toString().contentEquals("") && !d10RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d10RollEdit.getText().toString()), Integer.valueOf(d10Edit.getText().toString()), 10)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d12:
                    if (!d12Edit.getText().toString().contentEquals("") && !d12RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d12RollEdit.getText().toString()), Integer.valueOf(d12Edit.getText().toString()), 12)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d20:
                    if (!d20Edit.getText().toString().contentEquals("") && !d20RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d20RollEdit.getText().toString()), Integer.valueOf(d20Edit.getText().toString()), 20)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                case R.id.button_roll_d100:
                    if (!d100Edit.getText().toString().contentEquals("") && d100RollEdit.getText().toString().contentEquals("")) {
                        totalSumTextView.setText(String.valueOf(getSumForRolls(Integer.valueOf(d100RollEdit.getText().toString()), Integer.valueOf(d100Edit.getText().toString()), 100)));
                    } else {
                        Toast.makeText(getContext(), "You must fill in both # and Roll: I Love ZUZANKA!", Toast.LENGTH_LONG).show();
                    }
                    break;
                default:
                    break;
            }
        }
    };


    private int generateRandomNumber(int topRoll) {
        Random random = new Random();
        int randomNumber;
        randomNumber = random.nextInt(topRoll) + 1;
        return randomNumber;
    }

    private int getSumForRolls(int rolls, int numberOfDice, int topRoll) {
        int totalSum = 0;
        for (int i = 0; i < rolls; i++) {
            for (int j = 0; j < numberOfDice; j++) {
                totalSum += generateRandomNumber(topRoll);
            }
        }
        return totalSum;
    }
}
