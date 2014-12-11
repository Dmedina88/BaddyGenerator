package com.grayherring.baddiegenerator.Activitys;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.grayherring.baddiegenerator.Adapters.CardAdapter;
import com.grayherring.baddiegenerator.Models.CardModel;
import com.grayherring.baddiegenerator.R;

import java.util.ArrayList;


public class CardVeiwerActivity extends BaseActivity {


    private static final String ARRAY_LIST = "ARRAY_LIST";
    protected RecyclerView mRecyclerView;
    protected ArrayList<CardModel> mCardModels;
    protected GridLayoutManager mGridLayoutManager;
    protected CardAdapter mCardAdapter;
    protected EditText mSearchTextEdit;
    protected Button mSearchButton;
    protected LinearLayout mLineLayout;
    private InterstitialAd mInterstitial;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_veiwer);
        mRecyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        mSearchTextEdit = (EditText) findViewById(R.id.searchEditText);
        mSearchButton = (Button) findViewById(R.id.searchbutton);
        mLineLayout = (LinearLayout) findViewById(R.id.line);

        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        float screenDp = dm.widthPixels / dm.density;
        int colNum = (int) screenDp / 290;
        if (screenDp > 290) {
            mGridLayoutManager = new GridLayoutManager(this, colNum);
        } else {
            mGridLayoutManager = new GridLayoutManager(this, 1);
        }
        mCardModels = new ArrayList<CardModel>();


        mAdView = (AdView) this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
       // mAdView.loadAd(adRequest);
        mAdView.setVisibility(View.GONE);
        mAdView.setAdListener(new AdListener() {

            public void onAdClosed() {
                mAdView.setVisibility(View.GONE);
                super.onAdClosed();
            }

            public void onAdFailedToLoad(int errorCode) {
                mAdView.setVisibility(View.GONE);
                super.onAdFailedToLoad(errorCode);
            }

            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            public void onAdOpened() {
                super.onAdOpened();
            }

            public void onAdLoaded() {
                mAdView.setVisibility(View.VISIBLE);
                super.onAdLoaded();
            }
        });


    }




    protected void restoreViewerInstanceState(Bundle savedInstanceState) {
        mCardModels.clear();
        ArrayList<CardModel> parceList = savedInstanceState.getParcelableArrayList(ARRAY_LIST);
        mCardModels.addAll(parceList);
        mCardAdapter.notifyDataSetChanged();
    }

    protected void onSaveInstanceState(Bundle outState) {

        if (mCardModels != null) {
            outState.putParcelableArrayList(ARRAY_LIST, mCardModels);
        }
        super.onSaveInstanceState(outState);
    }



}
