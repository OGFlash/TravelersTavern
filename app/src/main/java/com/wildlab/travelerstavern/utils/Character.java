package com.wildlab.travelerstavern.utils;

import java.util.ArrayList;

/**
 * Created by Owner on 9/23/2017.
 */

public class Character {
    private String localname;
    private String localclassType;
    private String locallevel;
    private ArrayList<Character> characters = new ArrayList<Character>();

    public Character(String name, String classType, String level){
        localname = name;
        locallevel = level;
        localclassType = classType;
    }

    public String getName(){
        return localname;
    }

    public String getClassName(){
        return localclassType;
    }


    public String getLevel(){
        return locallevel;
    }

    private static int lastCharacterId = 0;

    public ArrayList<Character> getCharactersList(){
        return this.characters;
    }

    public void addItem(Character character, int position){
        characters.add(position, character);
    }
}
