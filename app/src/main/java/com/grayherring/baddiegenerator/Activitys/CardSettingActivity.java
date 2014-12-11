package com.grayherring.baddiegenerator.Activitys;

import android.os.Bundle;
import android.view.View;

import com.grayherring.baddiegenerator.Adapters.CardAdapter;
import com.grayherring.baddiegenerator.Models.CardModel;
import com.grayherring.baddiegenerator.Utils.PreferenceManager;

import static com.grayherring.baddiegenerator.Adapters.CardAdapter.ViewHolder;

/**
 * Created by David on 12/4/2014.
 */
public class CardSettingActivity extends CardVeiwerActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        getSettings();
        mCardAdapter = new CardAdapter(mCardModels, true);
        mRecyclerView.setAdapter(mCardAdapter);
        mSearchTextEdit.setVisibility(View.GONE);
        mSearchButton.setVisibility(View.GONE);
        mLineLayout.setVisibility(View.GONE);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.restoreViewerInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void getSettings() {
        PreferenceManager pm = new PreferenceManager(this);
        CardModel minCard = new CardModel();
        minCard.setName("Set Min Stat");
        minCard.setStr(pm.getMinStr());
        minCard.setDx(pm.getMinDx());
        minCard.setIq(pm.getMinIq());
        minCard.setHt(pm.getMinHt());
        minCard.setHp(pm.getMinHp());
        minCard.setFp(pm.getMinFp());
        minCard.setWill(pm.getMinWill());
        minCard.setPer(pm.getMinPer());
        minCard.setSpeed(pm.getMinSpeed());
        minCard.setMove(pm.getMinMove());
        minCard.setAtcDice(pm.getMinAtcDice());
        minCard.setAtcSkill(pm.getMinAtcSkill());
        minCard.setAtcPartDice(pm.getMinAtcPartDice());
        minCard.setDodge(pm.getMinDodge());
        minCard.setParry(pm.getMinParry());
        minCard.setSm(pm.getMinSm());
        minCard.setDr(pm.getMinDr());
        mCardModels.add(minCard);
        CardModel maxCard = new CardModel();
        maxCard.setName("Set Max Stat");
        maxCard.setStr(pm.getMaxStr());
        maxCard.setDx(pm.getMaxDx());
        maxCard.setIq(pm.getMaxIq());
        maxCard.setHt(pm.getMaxHt());
        maxCard.setHp(pm.getMaxHp());
        maxCard.setFp(pm.getMaxFp());
        maxCard.setWill(pm.getMaxWill());
        maxCard.setPer(pm.getMaxPer());
        maxCard.setSpeed(pm.getMaxSpeed());
        maxCard.setMove(pm.getMaxMove());
        maxCard.setAtcDice(pm.getMaxAtcDice());
        maxCard.setAtcSkill(pm.getMaxAtcSkill());
        maxCard.setAtcPartDice(pm.getMaxAtcPartDice());
        maxCard.setDodge(pm.getMaxDodge());
        maxCard.setParry(pm.getMaxParry());
        maxCard.setSm(pm.getMaxSm());
        maxCard.setDr(pm.getMaxDr());
        mCardModels.add(maxCard);

    }

    private void saveSetting() {
        PreferenceManager pm = new PreferenceManager(this);
        pm.startEdit();
        ViewHolder vh = mCardAdapter.getVeiwHolderAtPosition(0);

        pm.setMinStr(vh.textEditeMap.get(CardModel.Attribute.ST).getText().toString());
        pm.setMinIq(vh.textEditeMap.get(CardModel.Attribute.IQ).getText().toString());
        pm.setMinHt(vh.textEditeMap.get(CardModel.Attribute.HT).getText().toString());
        pm.setMinHp(vh.textEditeMap.get(CardModel.Attribute.HP).getText().toString());
        pm.setMinWill(vh.textEditeMap.get(CardModel.Attribute.WILL).getText().toString());
        pm.setMinPer(vh.textEditeMap.get(CardModel.Attribute.PER).getText().toString());
        pm.setMinSpeed(vh.textEditeMap.get(CardModel.Attribute.SPEED).getText().toString());
        pm.setMinMove(vh.textEditeMap.get(CardModel.Attribute.MOVE).getText().toString());
        pm.setMinAtcDice(vh.textEditeMap.get(CardModel.Attribute.ATC_DICE).getText().toString());
        pm.setMinAtcSkill(vh.textEditeMap.get(CardModel.Attribute.ATC_SKILL).getText().toString());
        pm.setMinAtcPartDice(vh.textEditeMap.get(CardModel.Attribute.ATC_PART_DICE).getText().toString());
        pm.setMinDodge(vh.textEditeMap.get(CardModel.Attribute.DODGE).getText().toString());
        pm.setMinParry(vh.textEditeMap.get(CardModel.Attribute.PARRY).getText().toString());
        pm.setMinSm(vh.textEditeMap.get(CardModel.Attribute.SM).getText().toString());
        pm.setMinDr(vh.textEditeMap.get(CardModel.Attribute.DR).getText().toString());
        pm.setMinFp(vh.textEditeMap.get(CardModel.Attribute.FP).getText().toString());
        pm.setMinDx(vh.textEditeMap.get(CardModel.Attribute.DX).getText().toString());

        vh = mCardAdapter.getVeiwHolderAtPosition(1);
        pm.setMaxStr(vh.textEditeMap.get(CardModel.Attribute.ST).getText().toString());
        pm.setMaxIq(vh.textEditeMap.get(CardModel.Attribute.IQ).getText().toString());
        pm.setMaxHt(vh.textEditeMap.get(CardModel.Attribute.HT).getText().toString());
        pm.setMaxHp(vh.textEditeMap.get(CardModel.Attribute.HP).getText().toString());
        pm.setMaxWill(vh.textEditeMap.get(CardModel.Attribute.WILL).getText().toString());
        pm.setMaxPer(vh.textEditeMap.get(CardModel.Attribute.PER).getText().toString());
        pm.setMaxSpeed(vh.textEditeMap.get(CardModel.Attribute.SPEED).getText().toString());
        pm.setMaxMove(vh.textEditeMap.get(CardModel.Attribute.MOVE).getText().toString());
        pm.setMaxAtcDice(vh.textEditeMap.get(CardModel.Attribute.ATC_DICE).getText().toString());
        pm.setMaxAtcSkill(vh.textEditeMap.get(CardModel.Attribute.ATC_SKILL).getText().toString());
        pm.setMaxAtcPartDice(vh.textEditeMap.get(CardModel.Attribute.ATC_PART_DICE).getText().toString());
        pm.setMaxDodge(vh.textEditeMap.get(CardModel.Attribute.DODGE).getText().toString());
        pm.setMaxParry(vh.textEditeMap.get(CardModel.Attribute.PARRY).getText().toString());
        pm.setMaxSm(vh.textEditeMap.get(CardModel.Attribute.SM).getText().toString());
        pm.setMaxDr(vh.textEditeMap.get(CardModel.Attribute.DR).getText().toString());
        pm.setMaxFp(vh.textEditeMap.get(CardModel.Attribute.FP).getText().toString());
        pm.setMaxDx(vh.textEditeMap.get(CardModel.Attribute.DX).getText().toString());
        pm.stopEdit();
    }

    @Override
    public void onBackPressed() {
        saveSetting();
        super.onBackPressed();
    }


}
