package com.grayherring.baddiegenerator.Activitys;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.grayherring.baddiegenerator.Adapters.CardAdapter;
import com.grayherring.baddiegenerator.Interfaces.DBThreadInterface;
import com.grayherring.baddiegenerator.Models.CardModel;
import com.grayherring.baddiegenerator.R;
import com.grayherring.baddiegenerator.Threads.DBAsynctask;
import com.grayherring.baddiegenerator.Utils.DatabaseManager;
import com.grayherring.baddiegenerator.Utils.SheetGenerator;

import java.util.ArrayList;


public class BaddieViewer extends CardVeiwerActivity implements DBThreadInterface {

    private static final String SEARCH_STRING = "searchedList";
    ProgressDialog mProgressDialog;
    boolean searchedList=false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mCardModels = new ArrayList<CardModel>();
        mCardAdapter = new CardAdapter(mCardModels);
        mRecyclerView.setAdapter(mCardAdapter);

        if (savedInstanceState == null) {
            this.search("");
        } else {

            searchedList = savedInstanceState.getBoolean(SEARCH_STRING);
            restoreViewerInstanceState(savedInstanceState);
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bad_guy_viewer, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startSettings();
        }
        if (id == R.id.action_rollBadie) {
            addCard();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onResult(ArrayList<CardModel> results) {
        mCardModels.clear();
        if (results != null) {
            mCardModels.addAll(results);
            mCardAdapter.notifyDataSetChanged();
            mProgressDialog.dismiss();
        }

    }

    public void startSettings() {
        Intent i = new Intent(this, CardSettingActivity.class);
        this.startActivity(i);
    }

    public void addCard() {
        CardModel cardModel = SheetGenerator.GeneratorSheet(this);
        DatabaseManager.getInstance(this).addSheet(cardModel);
        mCardModels.add(0, cardModel);
        mCardAdapter.notifyDataSetChanged();
    }


    private void search(String searchString) {
        searchedList = false;
        if (searchString != null){
            if(!searchString.equals(""))
                searchedList = true;
        }


        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("Featching Baddies");
        mProgressDialog.setMessage("Featching in progress ...");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();
        DBAsynctask dbAsynctask = new DBAsynctask(this, this);
        dbAsynctask.execute(searchString);
    }

    public void search(View v) {
        this.search(mSearchTextEdit.getText().toString());
        mSearchTextEdit.clearFocus();
        InputMethodManager imm  = (InputMethodManager)getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mSearchTextEdit.getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        if (searchedList){
            search("");
            mSearchTextEdit.setText("");
            return;
        }
        super.onBackPressed();
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(SEARCH_STRING,searchedList);
        super.onSaveInstanceState(outState);
    }
}
