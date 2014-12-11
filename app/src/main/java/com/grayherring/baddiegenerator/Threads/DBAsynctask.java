package com.grayherring.baddiegenerator.Threads;

import android.content.Context;
import android.os.AsyncTask;

import com.grayherring.baddiegenerator.Interfaces.DBThreadInterface;
import com.grayherring.baddiegenerator.Models.CardModel;
import com.grayherring.baddiegenerator.Utils.DatabaseManager;

import java.util.ArrayList;

/**
 * Created by David on 12/6/2014.
 */
public class DBAsynctask extends AsyncTask<String, Integer, ArrayList<CardModel>> {

    //DatabaseManager mdatabaseManager;

    Context mContext;
    DBThreadInterface mDBThreadInterface;

    public DBAsynctask(Context context, DBThreadInterface dbThreadInterface) {
        mContext = context;
        mDBThreadInterface = dbThreadInterface;
    }

    @Override
    protected void onPreExecute() {


    }

    //if string is null return whoel db  other wise serch db
    protected ArrayList<CardModel> doInBackground(String... params) {
        String search =params[0];
        if ( search == null||search.equals("")) {
            return DatabaseManager.getInstance(mContext).getAllCards();
        } else {
            return DatabaseManager.getInstance(mContext).search(search);
        }

    }

    @Override
    protected void onPostExecute(ArrayList<CardModel> cardModels) {
        super.onPostExecute(cardModels);
        mDBThreadInterface.onResult(cardModels);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
