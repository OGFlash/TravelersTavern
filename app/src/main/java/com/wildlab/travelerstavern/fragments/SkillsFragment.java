package com.wildlab.travelerstavern.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.db.DatabaseHelper;
import com.wildlab.travelerstavern.utils.Character;

import java.util.ArrayList;

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class SkillsFragment extends Fragment {
    private static final String TAG = "SkillsFragment";
    private static final String STR = "STR";
    private static final String DEX = "DEX";
    private static final String CON = "CON";
    private static final String INT = "INT";
    private static final String WIS = "WIS";
    private static final String CHA = "CHA";
    private static final String HEALTH = "Health";
    private static final String HEALTHCURRENT = "Current";
    private static final String ACCURRENT = "Current";
    private static final String AC = "AC";
    private static final String SPEED = "Speed";

    private Button buttonHealthTotal = null;
    private Button buttonHealthCurrent = null;
    private Button buttonHealthDamageTaken = null;
    private Button buttonHealthWalkSpeed = null;

    private Button acTotal = null;
    private Button acCurrent = null;
    private Button acBonus = null;

    private Button strTotal = null;
    private Button strModifier = null;
    private Button strTemp = null;

    private Button dexTotal = null;
    private Button dexModifier = null;
    private Button dexTemp = null;

    private Button conTotal = null;
    private Button conModifier = null;
    private Button conTemp = null;

    private Button intTotal = null;
    private Button intModifier = null;
    private Button intTemp = null;

    private Button wisTotal = null;
    private Button wisModifier = null;
    private Button wisTemp = null;

    private Button chaTotal = null;
    private Button chaModifier = null;
    private Button chaTemp = null;

    private int health;
    private int ac;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligece;
    private int wisdom;
    private int charisma;

    private String healthString;
    private String acString;
    private String strengthString;
    private String dexterityString;
    private String constitutionString;
    private String intelligenceString;
    private String wisdomString;
    private String charismaString;
    private String speedString;
    private DatabaseHelper dbHelper;
    private ArrayList<Character> characters;


    public SkillsFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View rootView =inflater.inflate(R.layout.fragment_describe_content, container, false);
        buttonHealthTotal = (Button) rootView.findViewById(R.id.health_info_rec);
        buttonHealthCurrent = (Button) rootView.findViewById(R.id.health_info_rec_current_health);
        buttonHealthDamageTaken = (Button) rootView.findViewById(R.id.health_info_rec_damage_taken);
        buttonHealthWalkSpeed = (Button) rootView.findViewById(R.id.health_info_rec_walk_speed);
        acTotal = (Button) rootView.findViewById(R.id.ac_info_rec);
        acCurrent = (Button) rootView.findViewById(R.id.ac_info_rec_current);
        acBonus = (Button) rootView.findViewById(R.id.ac_info_rec_bonus);
        strTotal = (Button) rootView.findViewById(R.id.str_info_rec);
        strModifier = (Button) rootView.findViewById(R.id.str_info_rec_modifier);
        strTemp = (Button) rootView.findViewById(R.id.str_info_rec_temp);
        dexTotal = (Button) rootView.findViewById(R.id.dex_info_rec);
        dexModifier = (Button) rootView.findViewById(R.id.dex_info_rec_modifier);
        dexTemp = (Button) rootView.findViewById(R.id.dex_info_rec_temp);
        conTotal = (Button) rootView.findViewById(R.id.con_info_rec);
        conModifier = (Button) rootView.findViewById(R.id.con_info_rec_modifier);
        conTemp = (Button) rootView.findViewById(R.id.con_info_rec_temp);
        intTotal = (Button) rootView.findViewById(R.id.int_info_rec);
        intModifier = (Button) rootView.findViewById(R.id.int_info_rec_modifier);
        intTemp = (Button) rootView.findViewById(R.id.int_info_rec_temp);
        wisTotal = (Button) rootView.findViewById(R.id.wis_info_rec);
        wisModifier = (Button) rootView.findViewById(R.id.wis_info_rec_modifier);
        wisTemp = (Button) rootView.findViewById(R.id.wis_info_rec_temp);
        chaTotal = (Button) rootView.findViewById(R.id.cha_info_rec);
        chaModifier = (Button) rootView.findViewById(R.id.cha_info_rec_modifier);
        chaTemp = (Button) rootView.findViewById(R.id.cha_info_rec_temp);

        dbHelper = new DatabaseHelper(getContext(), DatabaseHelper.DB_NAME, null, 1);
        characters = dbHelper.getAllCharacterRecords();


        buttonHealthTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHealthDialog();
            }
        });

        acTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAcDialog();
            }
        });

        strTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStrDialog();
            }
        });

        dexTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDexDialog();
            }
        });

        conTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConDialog();
            }
        });

        intTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIntDialog();
            }
        });

        wisTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWisDialog();
            }
        });

        chaTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChaDialog();
            }
        });

        buttonHealthWalkSpeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSpeedDialog();
            }
        });

        return rootView;
    }

    private void updateSpeed(String speed, Button button){
        button.setText(SPEED + "\n" + speed);
    }

    private void updateAC(String acString, Button button){
        button.setText(ACCURRENT + "\n" + acString);
    }

    private void updateHealth(String healthString, Button button){
        button.setText(HEALTHCURRENT + "\n" + healthString);
    }

    private void updateModifier(String updatedString, Button button) {
        String modifier = null;
        int modifierInt;
        modifierInt = Integer.parseInt(updatedString);
        if(modifierInt == 1){
           modifier = "-5";
        }
        else if(modifierInt > 1 && modifierInt <= 3){
            modifier = "-4";
        }
        else if(modifierInt > 3 && modifierInt <= 5){
            modifier = "-3";
        }
        else if(modifierInt > 5 && modifierInt <= 7){
            modifier = "-2";
        }
        else if(modifierInt > 7 && modifierInt <= 9){
            modifier = "-1";
        }
        else if(modifierInt > 9 && modifierInt <= 11){
            modifier = "+0";
        }
        else if(modifierInt > 11 && modifierInt <= 13){
            modifier = "+1";
        }
        else if(modifierInt > 13 && modifierInt <= 15){
            modifier = "+2";
        }
        else if(modifierInt > 15 && modifierInt <= 17){
            modifier = "+3";
        }
        else if(modifierInt > 17 && modifierInt <= 19){
            modifier = "+4";
        }
        else if(modifierInt > 19 && modifierInt <= 21){
            modifier = "+5";
        }
        else if(modifierInt > 21 && modifierInt <= 23){
            modifier = "+6";
        }
        else if(modifierInt > 23 && modifierInt <= 25){
            modifier = "+7";
        }
        else if(modifierInt > 25 && modifierInt <= 27){
            modifier = "+8";
        }
        else if(modifierInt > 27 && modifierInt <= 28){
            modifier = "+9";
        }
        else if(modifierInt == 30){
            modifier = "+10";
        }
        else{
            modifier = "Error";
        }
        button.setText("\n" + modifier);
    }


    public void showStrDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_str, null);
        dialogBuilder.setView(dialogView);

        final EditText edtStr = (EditText) dialogView.findViewById(R.id.character_str);


        dialogBuilder.setTitle("Update Strength");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                strengthString = edtStr.getText().toString();
                if(strengthString != null) {
                    Log.e(TAG, "onClick: " + strengthString);
                    strTotal.setText(STR + "\n" + strengthString);
                }
                updateModifier(strengthString, strModifier);
                strengthString = null;

            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showDexDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_dex, null);
        dialogBuilder.setView(dialogView);

        final EditText edtDexterity = (EditText) dialogView.findViewById(R.id.character_dex);


        dialogBuilder.setTitle("Update Dexterity");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dexterityString = edtDexterity.getText().toString();
                if(dexterityString != null) {
                    dexTotal.setText(DEX + "\n" + dexterityString);
                }
                updateModifier(dexterityString, dexModifier);
                dexterityString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showConDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_con, null);
        dialogBuilder.setView(dialogView);

        final EditText edtCon = (EditText) dialogView.findViewById(R.id.character_con);


        dialogBuilder.setTitle("Update Constitution");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                constitutionString = edtCon.getText().toString();
                if(constitutionString != null) {
                    conTotal.setText(CON + "\n" + constitutionString);
                }
                updateModifier(constitutionString, conModifier);
                constitutionString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showIntDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_intelligence, null);
        dialogBuilder.setView(dialogView);

        final EditText edtInt = (EditText) dialogView.findViewById(R.id.character_int);


        dialogBuilder.setTitle("Update Intelligence");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                intelligenceString = edtInt.getText().toString();
                if(intelligenceString != null) {
                    intTotal.setText(INT + "\n" + intelligenceString);
                }
                updateModifier(intelligenceString, intModifier);
                intelligenceString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showWisDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_wisdom, null);
        dialogBuilder.setView(dialogView);

        final EditText edtWis = (EditText) dialogView.findViewById(R.id.character_wis);


        dialogBuilder.setTitle("Update Wisdom");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                wisdomString = edtWis.getText().toString();
                if(wisdomString != null) {
                    wisTotal.setText(WIS + "\n" + wisdomString);
                }
                updateModifier(wisdomString, wisModifier);
                wisdomString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showChaDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_charisma, null);
        dialogBuilder.setView(dialogView);

        final EditText edtCha = (EditText) dialogView.findViewById(R.id.character_cha);


        dialogBuilder.setTitle("Update Charisma");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                charismaString = edtCha.getText().toString();
                if(charismaString != null) {
                    chaTotal.setText(CHA + "\n" + charismaString);
                }
                updateModifier(charismaString, chaModifier);
                charismaString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showHealthDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_health, null);
        dialogBuilder.setView(dialogView);

        final EditText edtHealth = (EditText) dialogView.findViewById(R.id.character_health);


        dialogBuilder.setTitle("Update Health");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                healthString = edtHealth.getText().toString();
                if(healthString != null) {
                    buttonHealthTotal.setText(HEALTH + "\n" + healthString);
                }
                updateHealth(healthString, buttonHealthCurrent);
                healthString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showAcDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_ac, null);
        dialogBuilder.setView(dialogView);

        final EditText edtAc = (EditText) dialogView.findViewById(R.id.character_ac);


        dialogBuilder.setTitle("Update AC");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                acString = edtAc.getText().toString();
                if(acString != null) {
                    acTotal.setText(AC + "\n" + acString);
                }
                updateAC(acString, acCurrent);
                acString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    public void showSpeedDialog() {
        //TODO BETTER DIALOG :_)!
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View dialogView = inflater.inflate(R.layout.custom_dialog_speed, null);
        dialogBuilder.setView(dialogView);

        final EditText edtSpeed = (EditText) dialogView.findViewById(R.id.character_speed);

        dialogBuilder.setTitle("Update Speed");
        dialogBuilder.setMessage("Update Below");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                speedString = edtSpeed.getText().toString();
                if(speedString != null) {
                    buttonHealthWalkSpeed.setText(SPEED + "\n" + speedString);
                }
                updateSpeed(speedString, buttonHealthWalkSpeed);
                speedString = null;
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

}
