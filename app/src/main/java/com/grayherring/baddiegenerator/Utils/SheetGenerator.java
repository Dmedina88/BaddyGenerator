package com.grayherring.baddiegenerator.Utils;

import android.content.Context;

import com.grayherring.baddiegenerator.Models.CardModel;

import java.util.Random;

/**
 * Created by David on 11/22/2014.
 */
public class SheetGenerator {


    private static String[] AtcTypes = {"burn", "cor", "cr", "cut", "fat", "imp", "pi", "pi-", "pi+", "pi++"};


    static private Random rand = new Random();

    static public CardModel GeneratorSheet(Context context) {
        PreferenceManager pref = new PreferenceManager(context);
        CardModel cardModel = new CardModel();

        cardModel.setStr(NumberInRange(pref.getMinStr(), pref.getMaxStr()));
        cardModel.setDx(NumberInRange(pref.getMinDx(), pref.getMaxDx()));
        cardModel.setIq(NumberInRange(pref.getMinIq(), pref.getMaxIq()));
        cardModel.setHt(NumberInRange(pref.getMinHt(), pref.getMaxHt()));
        cardModel.setHp(NumberInRange(pref.getMinHp(), pref.getMaxHp()));
        cardModel.setDr(NumberInRange(pref.getMinDr(), pref.getMaxDr()));
        cardModel.setWill(NumberInRange(pref.getMinWill(), pref.getMaxWill()));
        cardModel.setPer(NumberInRange(pref.getMinPer(), pref.getMaxPer()));
        cardModel.setFp(NumberInRange(pref.getMinFp(), pref.getMaxFp()));
        cardModel.setSpeed(NumberInRange(pref.getMinSpeed(), pref.getMaxSpeed()));
        cardModel.setMove(NumberInRange(pref.getMinMove(), pref.getMaxMove()));
        cardModel.setDodge(NumberInRange(pref.getMinDodge(), pref.getMaxDodge()));
        cardModel.setSm(NumberInRange(pref.getMinSm(), pref.getMaxSm()));
        cardModel.setAtcSkill(NumberInRange(pref.getMinAtcSkill(), pref.getMaxAtcSkill()));
        cardModel.setAtcDice(NumberInRange(pref.getMinAtcDice(), pref.getMaxAtcDice()));
        cardModel.setAtcPartDice(NumberInRange(pref.getMinAtcPartDice(), pref.getMaxAtcPartDice()));
        cardModel.setParry(NumberInRange(pref.getMinParry(), pref.getMaxParry()));
        cardModel.setAtcType(AtcTypes[rand.nextInt(AtcTypes.length)]);
//add atc type


        return cardModel;

    }


    static public String NumberInRange(String minS, String maxS) {
        int min = Integer.parseInt(minS);
        int max = Integer.parseInt(maxS);

        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        return String.valueOf(rand.nextInt((max - min) + 1) + min);
    }

    static public int rolld6(int dieNumber) {
        int maxOutCome = dieNumber * 6;
        return rand.nextInt((maxOutCome - dieNumber) + 1) + dieNumber;
    }


}
