package com.wildlab.travelerstavern.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wildlab.travelerstavern.DnDActivity;
import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.db.DatabaseHelper;

import java.util.ArrayList;

/**
 * Created by Owner on 9/23/2017.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder>{

    private ArrayList<Character> data = new ArrayList<>();


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView characterName;
        public TextView characterLevel;
        public TextView characterClass;
        public Button selectButton;
        private ArrayList<Character> localArrayListCharacters = new ArrayList<Character>();
        private DatabaseHelper dbHelper;
        private Context ctx;


        public ViewHolder(View itemView, Context context, ArrayList<Character> charactersArray) {
            super(itemView);
            dbHelper = new DatabaseHelper(getContext(), DatabaseHelper.DB_NAME, null, 1);

            this.localArrayListCharacters = charactersArray;
            this.ctx = context;
            characterName = (TextView) itemView.findViewById(R.id.character_name);
            characterLevel = (TextView) itemView.findViewById(R.id.character_level);
            characterClass = (TextView) itemView.findViewById(R.id.character_class);
            selectButton = (Button) itemView.findViewById(R.id.selectButton);
            selectButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            //TODO I CAN GET DATA NOW FROM INDIVIDUAL VIEWS
            //TODO PASS DATA TO VIEWS NOW?
            int position = getAdapterPosition();
            Character character = this.localArrayListCharacters.get(position);
//            Intent intentCI = new Intent(getContext(), CharacterInfoActivity.class);
//            view.getContext().startActivity(intentCI);


            Intent intentDD = new Intent(getContext(), DnDActivity.class);
            intentDD.putExtra("name", character.getName());
            intentDD.putExtra("className", character.getClassName());
            intentDD.putExtra("level", character.getLevel());
            intentDD.putExtra("str", dbHelper.getSelectedCharactersStr(character));
            intentDD.putExtra("dex", dbHelper.getSelectedCharactersDex(character));
            intentDD.putExtra("con", dbHelper.getSelectedCharactersCon(character));
            intentDD.putExtra("int", dbHelper.getSelectedCharactersInt(character));
            intentDD.putExtra("wis", dbHelper.getSelectedCharactersWis(character));
            intentDD.putExtra("cha", dbHelper.getSelectedCharactersCha(character));
            intentDD.putExtra("health", dbHelper.getSelectedCharactersHealth(character));
            intentDD.putExtra("ac", dbHelper.getSelectedCharactersAC(character));
            intentDD.putExtra("speed", dbHelper.getSelectedCharactersSpeed(character));
            intentDD.putExtra("id", character.getID());
            view.getContext().startActivity(intentDD);


        }
    }


    private Context contextLocal;

    public CharacterAdapter(Context context, ArrayList<Character> characters) {
        contextLocal = context;
        this.data = characters;
    }

    private Context getContext(){
        return contextLocal;
    }

    @Override
    public CharacterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View characterView = layoutInflater.inflate(R.layout.character, parent, false);
        ViewHolder viewHolder = new ViewHolder(characterView, contextLocal, data);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterAdapter.ViewHolder holder, int position) {
        Character currentData = data.get(position);
        holder.characterName.setText(currentData.getName());
        holder.characterClass.setText(currentData.getClassName());
        holder.characterLevel.setText(currentData.getLevel().toString());

    }

    public void updateList(ArrayList<Character> characters){
        this.data = characters;
        notifyDataSetChanged();
    }

    public int getItemCount(){
        return data.size();
    }

    public void deleteItem(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(Character c, int position){
        data.add(c);
        notifyItemInserted(position);
    }


    public interface IUpdateButtonClicks{
        void onClickButton();
    }

}
