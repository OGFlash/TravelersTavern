package com.wildlab.travelerstavern.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wildlab.travelerstavern.R;

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
        private CreateFragment createFragment;
        private ArrayList<Character> localArrayListCharacters = new ArrayList<Character>();
        private Context ctx;


        public ViewHolder(View itemView, Context context, ArrayList<Character> charactersArray) {
            super(itemView);
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
