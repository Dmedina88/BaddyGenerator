package com.grayherring.baddiegenerator.Models;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Created by David on 11/26/2014.
 */
public class CardModel implements Parcelable {

    public static final Parcelable.Creator<CardModel> CREATOR
            = new Parcelable.Creator<CardModel>() {
        public CardModel createFromParcel(Parcel in) {
            return new CardModel(in);
        }

        public CardModel[] newArray(int size) {
            return new CardModel[size];
        }
    };
    private static final String Serial_Map_Key = "Serial_Map_Key";
    private HashMap<Attribute, String> attributes = new HashMap<Attribute, String>();
    private boolean saved = true;
    private long id = 0;

    public CardModel() {
        for (Attribute attribute : Attribute.values()) {
            attributes.put(attribute, "");
        }
    }

    private CardModel(Parcel in) {
        id = in.readInt();
        saved = in.readByte() != 0;
        attributes = (HashMap<Attribute, String>) in.readBundle().getSerializable(Serial_Map_Key);
    }

    public void setAttribute(Attribute attribute, String string) {
        attributes.put(attribute, string);
    }

    public String getAttribute(Attribute attribute) {
        return attributes.get(attribute);
    }

    public String getName() {
        return attributes.get(Attribute.NAME);
    }

    public void setName(String name) {
        attributes.put(Attribute.NAME, name);
    }

    public String getStr() {
        return attributes.get(Attribute.ST);
    }

    public void setStr(String st) {
        attributes.put(Attribute.ST, st);
    }

    public String getDx() {
        return attributes.get(Attribute.DX);
    }

    public void setDx(String dx) {
        attributes.put(Attribute.DX, dx);
    }

    public String getIq() {
        return attributes.get(Attribute.IQ);
    }

    public void setIq(String iq) {
        attributes.put(Attribute.IQ, iq);
    }

    public String getHt() {
        return attributes.get(Attribute.HT);
    }

    public void setHt(String ht) {
        attributes.put(Attribute.HT, ht);
    }

    public String getHp() {
        return attributes.get(Attribute.HP);
    }

    public void setHp(String hp) {
        attributes.put(Attribute.HP, hp);
    }

    public String getWill() {
        return attributes.get(Attribute.WILL);
    }

    public void setWill(String will) {
        attributes.put(Attribute.WILL, will);
    }

    public String getPer() {
        return attributes.get(Attribute.PER);
    }

    public void setPer(String per) {
        attributes.put(Attribute.PER, per);
    }

    public String getFp() {
        return attributes.get(Attribute.FP);
    }

    public void setFp(String fp) {
        attributes.put(Attribute.FP, fp);
    }

    public String getSpeed() {
        return attributes.get(Attribute.SPEED);
    }

    public void setSpeed(String speed) {
        attributes.put(Attribute.SPEED, speed);
    }

    public String getMove() {
        return attributes.get(Attribute.MOVE);
    }

    public void setMove(String move) {
        attributes.put(Attribute.MOVE, move);
    }

    public String getDodge() {
        return attributes.get(Attribute.DODGE);
    }

    public void setDodge(String dodge) {
        attributes.put(Attribute.DODGE, dodge);
    }

    public String getSm() {
        return attributes.get(Attribute.SM);
    }

    public void setSm(String sm) {
        attributes.put(Attribute.SM, sm);
    }

    public String getAtcSkill() {
        return attributes.get(Attribute.ATC_SKILL);
    }

    public void setAtcSkill(String skill) {
        attributes.put(Attribute.ATC_SKILL, skill);
    }

    public String getAtcDice() {
        return attributes.get(Attribute.ATC_DICE);
    }

    public void setAtcDice(String atcDice) {
        attributes.put(Attribute.ATC_DICE, atcDice);
    }

    public String getAtcPartDice() {
        return attributes.get(Attribute.ATC_PART_DICE);
    }

    public void setAtcPartDice(String atcPartDice) {
        attributes.put(Attribute.ATC_PART_DICE, atcPartDice);
    }

    public String getAtcType() {
        return attributes.get(Attribute.ATC_TYPE);
    }

    public void setAtcType(String atcType) {
        attributes.put(Attribute.ATC_TYPE, atcType);
    }

    public String getParry() {
        return attributes.get(Attribute.PARRY);
    }

    public void setParry(String parry) {
        attributes.put(Attribute.PARRY, parry);
    }

    public String getDr() {
        return attributes.get(Attribute.DR);
    }

    public void setDr(String dr) {
        attributes.put(Attribute.DR, dr);
    }

    public String getNotes() {
        return attributes.get(Attribute.NOTES);
    }

    public void setNotes(String notes) {
        attributes.put(Attribute.NOTES, notes);
    }


  @Override
  public String toString() {

      String cardToString ="CardModel [id=" + id;
      for(Attribute attribute:Attribute.values()){
          cardToString =cardToString +" "+ attribute + " " +attributes.get(attribute);
      }
      cardToString = cardToString +  "]";
      return  cardToString;
  }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    //Parcelable stuff
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeByte((byte) (saved ? 1 : 0));
        Bundle bundle = new Bundle();
        bundle.putSerializable(Serial_Map_Key, attributes);

    }

    public enum Attribute {
        NAME, ST, DX, IQ, HT, HP, DR, WILL, PER, FP, SPEED, MOVE, DODGE, SM, PARRY, ATC_SKILL, ATC_DICE, ATC_PART_DICE, ATC_TYPE, NOTES
    }
}
