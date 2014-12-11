package com.grayherring.baddiegenerator.Interfaces;

import com.grayherring.baddiegenerator.Models.CardModel;

import java.util.ArrayList;

/**
 * Created by David on 12/6/2014.
 */
public interface DBThreadInterface {
    public void onResult(ArrayList<CardModel> results);
}
