package com.grayherring.baddiegenerator.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by David on 11/29/2014.
 */
public class PreferenceManager {
    private SharedPreferences pref;
    private Editor editor;

    public PreferenceManager(Context context) {
        pref = context.getSharedPreferences(Constants.SHARED_PREF, Activity.MODE_PRIVATE);

    }

    public void startEdit() {
        editor = pref.edit();
    }

    public void stopEdit() {
        editor.commit();
        editor = null;

    }


    public String getMinStr() {

        return pref.getString(Constants.STR_MIN, Constants.MIN_DEF_VAL);
    }

    //converting from string since input failds are strings
    public void setMinStr(String value) {

        editor.putString(Constants.STR_MIN, value);
    }

    public String getMaxStr() {
        return pref.getString(Constants.STR_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxStr(String value) {
        editor.putString(Constants.STR_MAX, value);
    }

    public String getMinDx() {
        return pref.getString(Constants.DX_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinDx(String value) {
        editor.putString(Constants.DX_MIN, value);
    }

    public String getMaxDx() {
        return pref.getString(Constants.DX_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxDx(String value) {
        editor.putString(Constants.DX_MAX, value);
    }

    public String getMinIq() {
        return pref.getString(Constants.IQ_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinIq(String value) {
        editor.putString(Constants.IQ_MIN, value);
    }

    public String getMaxIq() {
        return pref.getString(Constants.IQ_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxIq(String value) {
        editor.putString(Constants.IQ_MAX, value);
    }

    public String getMinHt() {
        return pref.getString(Constants.HT_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinHt(String value) {
        editor.putString(Constants.HT_MIN, value);
    }

    public String getMaxHt() {
        return pref.getString(Constants.HT_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxHt(String value) {
        editor.putString(Constants.HT_MAX, value);
    }

    public String getMinHp() {
        return pref.getString(Constants.HP_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinHp(String value) {
        editor.putString(Constants.HP_MIN, value);
    }

    public String getMaxHp() {
        return pref.getString(Constants.HP_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxHp(String value) {
        editor.putString(Constants.HP_MAX, value);
    }

    public String getMinWill() {
        return pref.getString(Constants.WILL_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinWill(String value) {
        editor.putString(Constants.WILL_MIN, value);
    }

    public String getMaxWill() {
        return pref.getString(Constants.WILL_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxWill(String value) {
        editor.putString(Constants.WILL_MAX, value);
    }

    public String getMinPer() {
        return pref.getString(Constants.PER_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinPer(String value) {
        editor.putString(Constants.PER_MIN, value);
    }

    public String getMaxPer() {
        return pref.getString(Constants.PER_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxPer(String value) {
        editor.putString(Constants.PER_MAX, value);
    }

    public String getMinFp() {
        return pref.getString(Constants.FP_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinFp(String value) {
        editor.putString(Constants.FP_MIN, value);
    }

    public String getMaxFp() {
        return pref.getString(Constants.FP_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxFp(String value) {
        editor.putString(Constants.FP_MAX, value);
    }

    public String getMinSpeed() {
        return pref.getString(Constants.SPEED_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinSpeed(String value) {
        editor.putString(Constants.SPEED_MIN, value);
    }

    public String getMaxSpeed() {
        return pref.getString(Constants.SPEED_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxSpeed(String value) {
        editor.putString(Constants.SPEED_MAX, value);
    }

    public String getMinMove() {
        return pref.getString(Constants.MOVE_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinMove(String value) {
        editor.putString(Constants.MOVE_MIN, value);
    }

    public String getMaxMove() {
        return pref.getString(Constants.MOVE_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxMove(String value) {
        editor.putString(Constants.MOVE_MAX, value);
    }

    public String getMinDodge() {
        return pref.getString(Constants.DODGE_MIN, Constants.MIN_DEF_VAL);
    }

    public void setMinDodge(String value) {
        editor.putString(Constants.DODGE_MIN, value);
    }

    public String getMaxDodge() {
        return pref.getString(Constants.DODGE_MAX, Constants.MAX_DEF_VAL);
    }

    public void setMaxDodge(String value) {
        editor.putString(Constants.DODGE_MAX, value);
    }

    public String getMinSm() {
        return pref.getString(Constants.SM_MIN, Constants.SM_MIN_DEF_VAL);
    }

    public void setMinSm(String value) {
        editor.putString(Constants.SM_MIN, value);
    }

    public String getMaxSm() {
        return pref.getString(Constants.SM_MAX, Constants.SM_MAX_DEF_VAL);
    }

    public void setMaxSm(String value) {
        editor.putString(Constants.SM_MAX, value);
    }

    public String getMinAtcSkill() {
        return pref.getString(Constants.ATC_SKILL_MIN, Constants.SKILL_MIN_DEF_VAL);
    }

    public void setMinAtcSkill(String value) {
        editor.putString(Constants.ATC_SKILL_MIN, value);
    }

    public String getMaxAtcSkill() {
        return pref.getString(Constants.ATC_SKILL_MAX, Constants.SKILL_MAX_DEF_VAL);
    }

    public void setMaxAtcSkill(String value) {
        editor.putString(Constants.ATC_SKILL_MAX, value);
    }

    public String getMinAtcDice() {
        return pref.getString(Constants.ATC_DICE_MIN, Constants.ATC_MIN_DEF_VAL);
    }

    public void setMinAtcDice(String value) {
        editor.putString(Constants.ATC_DICE_MIN, value);
    }

    public String getMaxAtcDice() {
        return pref.getString(Constants.ATC_DICE_MAX, Constants.ATC_MAX_DEF_VAL);
    }

    public void setMaxAtcDice(String value) {
        editor.putString(Constants.ATC_DICE_MAX, value);
    }

    public String getMinAtcPartDice() {
        return pref.getString(Constants.ATC_PDICE_MIN, Constants.ATC_PDICE_MIN_DEF_VAL);
    }

    public void setMinAtcPartDice(String value) {
        editor.putString(Constants.ATC_PDICE_MIN, value);
    }

    public String getMaxAtcPartDice() {
        return pref.getString(Constants.ATC_PDICE_MAX, Constants.ATC_PDICE_MAX_DEF_VAL);
    }

    public void setMaxAtcPartDice(String value) {
        editor.putString(Constants.ATC_PDICE_MAX, value);
    }

    public String getMinParry() {
        return pref.getString(Constants.PARRY_NUM_MIN, Constants.SKILL_MIN_DEF_VAL);
    }

    public void setMinParry(String value) {
        editor.putString(Constants.PARRY_NUM_MIN, value);
    }

    public String getMaxParry() {
        return pref.getString(Constants.PARRY_NUM_MAX, Constants.SKILL_MAX_DEF_VAL);

    }

    public void setMaxParry(String value) {
        editor.putString(Constants.PARRY_NUM_MAX, value);

    }

    public String getMaxDr() {

        return pref.getString(Constants.DR_MAX, Constants.DR_MIN_DEF_VAL);
    }

    public void setMaxDr(String value) {
        editor.putString(Constants.DR_MAX, value);
    }

    public String getMinDr() {

        return pref.getString(Constants.DR_MIN, Constants.DR_MAX_DEF_VAL);
    }

    public void setMinDr(String value) {
        editor.putString(Constants.ATC_NUM_MIN, value);
    }
}
