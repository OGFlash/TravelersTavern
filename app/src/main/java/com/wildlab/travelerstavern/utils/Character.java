package com.wildlab.travelerstavern.utils;

import java.util.ArrayList;

/**
 * Created by Owner on 9/23/2017.
 */

public class Character {
    private String localname;
    private String localclassType;
    private Integer locallevel;
    private String idLocal;
    private ArrayList<Character> characters = new ArrayList<Character>();

    public String getName(){
        return localname;}

    public String getClassName(){
        return localclassType;
    }

    public Integer getLevel(){return locallevel;
    }

    public String getID() {
        return idLocal;
    }

    public void setCharacterName(String name){
        this.localname = name;
    }

    public void setCharacterClass(String classType){
        this.localclassType = classType;
    }

    public void setCharacterLevel(Integer level){
        this.locallevel = level;
    }

    public void setID(String ID) {
        this.idLocal = ID;
    }


    private static int lastCharacterId = 0;

    public ArrayList<Character> getCharactersList(){
        return this.characters;
    }

    public void addItem(Character character, int position){
        characters.add(position, character);
    }
}
