package com.wildlab.travelerstavern.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author ogflash
 * @since 9/15/2017.
 */

class RetrieveFeedTask extends AsyncTask<String, Void, String> {

    SpellsFragment spellsFragment;
    private static final String API_URL = "http://dnd5eapi.co/api/";

    public RetrieveFeedTask(SpellsFragment fragment){
        this.spellsFragment = fragment;
    }

    protected void onPreExecute() {
        spellsFragment.showProgressBar();
    }

    protected String doInBackground(String... urls) {
        String query = spellsFragment.getEditApiText();
        // Do some validation here

        try {
            URL url = new URL(API_URL + query);
            Log.e("** CURRENT QUERY: {}", API_URL + query);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        spellsFragment.hideProgressBar();
        spellsFragment.populateResults(response);
        this.spellsFragment = null;
    }
}

