package com.wildlab.travelerstavern.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.utils.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Prad Ejner
 * @since 9/30/2017.
 */

public class EquipmentFragment extends Fragment{
    private static final String TAG = "EquipmentFragment";
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listHeaderData;
    private HashMap<String, List<String>> listHash;
    private View rootView = null;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView =inflater.inflate(R.layout.fragment_equipment_content, container, false);
        init();
        return rootView;
    }

    private void init() {
        listView = (ExpandableListView) rootView.findViewById(R.id.expandable_list_view);
        initData();
        listAdapter = new ExpandableListAdapter(getContext(), listHeaderData, listHash);
        listView.setAdapter(listAdapter);
        rootView.invalidate();
    }

    private void initData() {
        listHeaderData = new ArrayList<>();
        listHash = new HashMap<>();


        listHeaderData.add("Head");
        listHeaderData.add("Chest");
        listHeaderData.add("Legs");
        listHeaderData.add("Arms");
        listHeaderData.add("Weapons");


        List<String> headList = new ArrayList<>();
        headList.add("Helmet");
        headList.add("Cap");
        headList.add("Knights Hood");
        headList.add("Power Helmet");
        headList.add("Gods Helmet");

        List<String> chestList = new ArrayList<>();
        chestList.add("Chest Piece");
        chestList.add("Chest Cover");
        chestList.add("Armored Chest");
        chestList.add("Power Armored Chest");
        chestList.add("Gods Chest Piece");

        List<String> legsList = new ArrayList<>();
        legsList.add("Legs");
        legsList.add("Leg Cover");
        legsList.add("Armored Legs");
        legsList.add("Power Armored Legs");
        legsList.add("God's Legs");

        List<String> armList = new ArrayList<>();
        armList.add("Arm");
        armList.add("Arm Cover");
        armList.add("Armored Arms");
        armList.add("Power Armored Arms");
        armList.add("God's Arms");

        List<String> weaponList = new ArrayList<>();
        weaponList.add("Blade");
        weaponList.add("Bow");
        weaponList.add("2hand Power Blade");
        weaponList.add("God's Wrath");

        listHash.put(listHeaderData.get(0), headList);
        listHash.put(listHeaderData.get(1), chestList);
        listHash.put(listHeaderData.get(2), legsList);
        listHash.put(listHeaderData.get(3), armList);
        listHash.put(listHeaderData.get(4), weaponList);
    }
}
