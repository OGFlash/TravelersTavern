package com.wildlab.travelerstavern.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.wildlab.travelerstavern.R;
import com.wildlab.travelerstavern.utils.Classes;
import com.wildlab.travelerstavern.utils.Utils;
import com.yalantis.flipviewpager.adapter.BaseFlipAdapter;
import com.yalantis.flipviewpager.utils.FlipSettings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class CharacterFragment extends Fragment {
    private static final String TAG = "CharacterFragment";
    private View rootView = null;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_content, container, false);
        init();
        return rootView;
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
    }

    public void init() {

        final ListView classes = (ListView) rootView.findViewById(R.id.classes);

        FlipSettings settings = new FlipSettings.Builder().defaultPage(1).build();
        Log.d(TAG, "ANDREW: {}");
        classes.setAdapter(new ClassAdapter(getContext(), Utils.classes, settings));
        classes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //CLICKING THE INDIVIDUAL VIEW

                Classes c = (Classes) classes.getAdapter().getItem(position);

                Toast.makeText(getContext(), c.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    class ClassAdapter extends BaseFlipAdapter {

        private final int PAGES = 3;
        private int[] IDS_INTEREST = {R.id.interest_1, R.id.interest_2, R.id.interest_3, R.id.interest_4, R.id.interest_5};

        public ClassAdapter(Context context, List<Classes> items, FlipSettings settings) {
            super(context, items, settings);
        }


        @Override
        public View getPage(int position, View convertView, ViewGroup parent, Object class1, Object class2) {
            final ClassesHolder holder;
            LayoutInflater inflater = LayoutInflater.from(getContext());

            if (convertView == null) {
                holder = new ClassesHolder();
                convertView = inflater.inflate(R.layout.classes_merge_page, parent, false);
                holder.leftAvatar = (ImageView) convertView.findViewById(R.id.first);
                holder.rightAvatar = (ImageView) convertView.findViewById(R.id.second);
                holder.infoPage = inflater.inflate(R.layout.classes_info, parent, false);
                holder.nickName = (TextView) holder.infoPage.findViewById(R.id.nickname);

                for (int id : IDS_INTEREST) {
                    holder.interests.add((TextView) holder.infoPage.findViewById(id));
                }
                convertView.setTag(holder);
            } else {
                holder = (ClassesHolder) convertView.getTag();
            }

            switch (position) {
                // Merged page with 2 classes
                case 1:
                    holder.leftAvatar.setImageResource(((Classes) class1).getAvatar());
                    if (class2 != null)
                        holder.rightAvatar.setImageResource(((Classes) class2).getAvatar());
                    break;
                default:
                    fillHolder(holder, position == 0 ? (Classes) class1 : (Classes) class2);
                    holder.infoPage.setTag(holder);
                    return holder.infoPage;
            }
            return convertView;
        }


        @Override
        public int getPagesCount() {
            return PAGES;
        }

        private void fillHolder(ClassesHolder holder, Classes classes) {
            if (classes == null)
                return;
            Iterator<TextView> iViews = holder.interests.iterator();
            Iterator<String> iInterests = classes.getInterests().iterator();
            while (iViews.hasNext() && iInterests.hasNext()) {
                iViews.next().setText(iInterests.next());
            }
            holder.infoPage.setBackgroundColor(getResources().getColor(classes.getBackground()));
            holder.nickName.setText(classes.getNickname());
        }

        class ClassesHolder {
            ImageView leftAvatar;
            ImageView rightAvatar;
            View infoPage;

            List<TextView> interests = new ArrayList<>();
            TextView nickName;
        }
    }

}
