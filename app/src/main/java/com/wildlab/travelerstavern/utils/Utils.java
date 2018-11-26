package com.wildlab.travelerstavern.utils;

import com.wildlab.travelerstavern.R;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final List<Classes> classes = new ArrayList<>();

    static {
        classes.add(new Classes(R.drawable.ic_fire, "Barbarian", R.color.sienna, "Rage", "Melee", "Tank", "Damage", "Equipment"));
        classes.add(new Classes(R.drawable.ic_fire, "Bard", R.color.saffron, "Range", "Magic", "Vocal", "Damage", "Healer"));
        classes.add(new Classes(R.drawable.ic_fire, "Cleric", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
        classes.add(new Classes(R.drawable.ic_fire, "Druid", R.color.pink, "Android", "Development", "Design", "Wearables", "Pets"));
        classes.add(new Classes(R.drawable.ic_fire, "Fighter", R.color.orange, "Design", "Fitness", "Healthcare", "UI/UX", "Chatting"));
        classes.add(new Classes(R.drawable.ic_fire, "Monk", R.color.saffron, "Development", "Android", "Healthcare", "Sport", "Rock Music"));
        classes.add(new Classes(R.drawable.ic_fire, "Paladin", R.color.green, "Cinema", "Music", "Tatoo", "Animals", "Management"));
        classes.add(new Classes(R.drawable.ic_fire, "Ranger", R.color.purple, "Android", "IOS", "Application", "Development", "Company"));
        classes.add(new Classes(R.drawable.ic_fire, "Rogue", R.color.green, "Cinema", "Music", "Tatoo", "Animals", "Management"));
        classes.add(new Classes(R.drawable.ic_fire, "Sorcerer", R.color.saffron, "Android", "IOS", "Application", "Development", "Company"));
        classes.add(new Classes(R.drawable.ic_fire, "Warlock", R.color.pink, "Android", "IOS", "Application", "Development", "Company"));
        classes.add(new Classes(R.drawable.ic_fire, "Wizard", R.color.sienna, "Android", "IOS", "Application", "Development", "Company"));
    }
}