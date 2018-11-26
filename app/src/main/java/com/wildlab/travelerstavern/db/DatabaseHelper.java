package com.wildlab.travelerstavern.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.wildlab.travelerstavern.utils.Character;

import java.util.ArrayList;

/**
 * Created by Owner on 9/29/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "mancave.db";
    private static final int DB_VERSION = 2;

    public static final String TABLE_NAME = "CHARACTER";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_RACE = "RACE";
    public static final String COLUMN_CLASS = "CLASS";
    public static final String COLUMN_LEVEL = "LEVEL";
    public static final String COLUMN_HEALTH = "HEALTH";
    public static final String COLUMN_AC = "AC";
    public static final String COLUMN_SPEED = "SPEED";
    public static final String COLUMN_STR = "STR";
    public static final String COLUMN_DEX = "DEX";
    public static final String COLUMN_CON = "CON";
    public static final String COLUMN_INT = "INT";
    public static final String COLUMN_WIS = "WIS";
    public static final String COLUMN_CHA = "CHA";

    private SQLiteDatabase dbLocal;

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbLocal = db;
        db.execSQL("CREATE TABLE CHARACTER ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "CLASS TEXT, "
                + "LEVEL INTEGER, "
                + "HEALTH INTEGER, "
                + "AC INTEGER, "
                + "SPEED INTEGER, "
                + "STR INTEGER, "
                + "DEX INTEGER, "
                + "CON INTEGER, "
                + "INT INTEGER, "
                + "WIS INTEGER, "
                + "CHA INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            if(i1 == 3) {
                sqLiteDatabase.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN " + COLUMN_RACE + " TEXT");
            }




    }

    public static void insertCharacterFull(SQLiteDatabase db, String name, String race, String className, int level, int health, int ac, int str, int dex, int con, int intel, int wis, int cha, int speed) {
        ContentValues characterValues = new ContentValues();
        characterValues.put(COLUMN_NAME, name);
        characterValues.put(COLUMN_CLASS, className);
        characterValues.put(COLUMN_RACE, race);
        characterValues.put(COLUMN_LEVEL, level);
        characterValues.put(COLUMN_HEALTH, health);
        characterValues.put(COLUMN_AC, ac);
        characterValues.put(COLUMN_SPEED, speed);
        characterValues.put(COLUMN_STR, str);
        characterValues.put(COLUMN_DEX, dex);
        characterValues.put(COLUMN_CON, con);
        characterValues.put(COLUMN_INT, intel);
        characterValues.put(COLUMN_WIS, wis);
        characterValues.put(COLUMN_CHA, cha);
        db.insert("CHARACTER", null, characterValues);
    }


    public void updateCharacterSimple(Character character) {
        dbLocal = this.getReadableDatabase();
        ContentValues basicCharacterValues = new ContentValues();
        basicCharacterValues.put(COLUMN_NAME, character.getName());
        basicCharacterValues.put(COLUMN_RACE, character.getRace());
        basicCharacterValues.put(COLUMN_CLASS, character.getClassName());
        basicCharacterValues.put(COLUMN_LEVEL, character.getLevel());
        dbLocal.update(TABLE_NAME, basicCharacterValues, COLUMN_ID + " = ?", new String[]{character.getID()});
        dbLocal.close();
    }

    public ArrayList<Character> getAllCharacterRecords() {
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<Character> characters = new ArrayList<Character>();
        Character characterModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                characterModel = new Character();
                characterModel.setID(cursor.getString(0));
                characterModel.setCharacterName(cursor.getString(1));
                characterModel.setCharacterRace(cursor.getString(13));
                characterModel.setCharacterClass(cursor.getString(2));
                characterModel.setCharacterLevel(cursor.getInt(5));
                characters.add(characterModel);
            }
        }
        cursor.close();
        dbLocal.close();
        return characters;
    }

    public Integer getSelectedCharactersStr(Character character) {
        Integer str = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_STR + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                str = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return str;
    }

    public void updateCharactersStrength(int id, Integer str) {
        dbLocal = this.getWritableDatabase();
        dbLocal.rawQuery("UPDATE " + TABLE_NAME + " SET " + COLUMN_STR + " ='" + str + "' " + "WHERE _id='"+id+"'", null);
        dbLocal.close();
    }

    public Integer getSelectedCharactersDex(Character character) {
        Integer dex = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_DEX + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                dex = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return dex;
    }

    public Integer getSelectedCharactersCon(Character character) {
        Integer con = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_CON + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                con = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return con;
    }

    public Integer getSelectedCharactersWis(Character character) {
        Integer wis = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_WIS + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                wis = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return wis;
    }

    public Integer getSelectedCharactersInt(Character character) {
        Integer Int = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_INT + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                Int = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return Int;
    }

    public Integer getSelectedCharactersCha(Character character) {
        Integer cha = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_CHA + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                cha = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return cha;
    }

    public Integer getSelectedCharactersHealth(Character character) {
        Integer heal = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_HEALTH + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                heal = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return heal;
    }

    public Integer getSelectedCharactersAC(Character character) {
        Integer ac = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_AC + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                ac = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return ac;
    }

    public Integer getSelectedCharactersSpeed(Character character) {
        Integer speed = null;
        dbLocal = this.getReadableDatabase();
        Cursor cursor = dbLocal.rawQuery("SELECT " + COLUMN_SPEED + " FROM " + TABLE_NAME + " WHERE _id='"+character.getID()+"'", null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                speed = cursor.getInt(i);
            }
        }
        cursor.close();
        dbLocal.close();
        return speed;
    }




    public void delete() {
        dbLocal = this.getWritableDatabase();
        dbLocal.execSQL("delete from " + TABLE_NAME);
        dbLocal.close();

    }

}
