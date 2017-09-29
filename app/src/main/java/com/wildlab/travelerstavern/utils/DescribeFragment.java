package com.wildlab.travelerstavern.utils;


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

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class DescribeFragment extends Fragment {
    private static final String TAG = "DescribeFragment";
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


        buttonHealthTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHealthDialog();
                if(healthString != null) {
                    String buttonText = buttonHealthTotal.getText().toString();
                    buttonHealthTotal.setText(buttonText + "    " + healthString);
                    view.invalidate();
                    healthString = null;
                }
            }
        });

        acTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAcDialog();
                if(acString != null) {
                    String buttonText = acTotal.getText().toString();
                    acTotal.setText(buttonText + "          " + acString);
                    view.invalidate();
                    acString = null;
                }
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
                if(dexterityString != null) {
                    String buttonText = dexTotal.getText().toString();
                    dexTotal.setText(buttonText + "         " + dexterityString);
                    view.invalidate();
                    dexterityString = null;
                }
            }
        });

        conTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConDialog();
                if(constitutionString != null) {
                    String buttonText = conTotal.getText().toString();
                    conTotal.setText(buttonText + "         " + constitutionString);
                    constitutionString = null;
                }
            }
        });

        intTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIntDialog();
                if(intelligenceString != null) {
                    String buttonText = intTotal.getText().toString();
                    intTotal.setText(buttonText + "         " + intelligenceString);
                    view.invalidate();
                    intelligenceString = null;
                }
            }
        });

        wisTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWisDialog();
                if(wisdomString != null) {
                    String buttonText = wisTotal.getText().toString();
                    wisTotal.setText(buttonText + "         " + wisdomString);
                    view.invalidate();
                    wisdomString = null;
                }
            }
        });

        chaTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChaDialog();
                if(charismaString != null) {
                    String buttonText = chaTotal.getText().toString();
                    chaTotal.setText(buttonText + "         " + charismaString);
                    view.invalidate();
                    charismaString = null;
                }
            }
        });


        return rootView;
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
                    final String buttonText = strTotal.getText().toString();
                    strTotal.setText(buttonText + "\n" + strengthString);
                    Log.e(TAG, "onClick: " + strTotal.getText());

                    strengthString = null;
                }
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
