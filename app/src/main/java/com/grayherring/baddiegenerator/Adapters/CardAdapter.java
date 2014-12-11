package com.grayherring.baddiegenerator.Adapters;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.grayherring.baddiegenerator.Models.CardModel;
import com.grayherring.baddiegenerator.Models.CardModel.Attribute;
import com.grayherring.baddiegenerator.R;
import com.grayherring.baddiegenerator.Utils.DatabaseManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by David on 11/26/2014.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private ArrayList<CardModel> mCardModels;
    private ArrayList<ViewHolder> mViewHolders;
    private boolean mSettingScreen = false;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardAdapter(ArrayList<CardModel> cardModles) {
        mCardModels = cardModles;
        mViewHolders = new ArrayList<ViewHolder>();
    }

    public CardAdapter(ArrayList<CardModel> cardModles, boolean settingScreen) {
        mCardModels = cardModles;
        mViewHolders = new ArrayList<ViewHolder>();
        mSettingScreen = settingScreen;
    }


    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stat_block_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        if (mSettingScreen) {
            vh.usedInSettings();
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCardAdapter = this;
        holder.mCardModel = mCardModels.get(position);
        holder.loadModel();
        holder.addListeners();
        holder.adjustButton(holder.itemView);
        mViewHolders.add(holder);


    }

    public ViewHolder getVeiwHolderAtPosition(int position) {
        return mViewHolders.get(position);
    }

    @Override
    public int getItemCount() {
        return mCardModels.size();
    }


    //ViewHodlder Stuff
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CardAdapter mCardAdapter;
        public CardModel mCardModel;

        public HashMap<Attribute, EditText> textEditeMap = new HashMap<Attribute, EditText>();
        public Button actionButton;

        public ViewHolder(View v) {
            super(v);

            textEditeMap.put(Attribute.NAME, (EditText) v.findViewById(R.id.name_textedit));
            textEditeMap.put(Attribute.ST, (EditText) v.findViewById(R.id.st_textedit));
            textEditeMap.put(Attribute.DX, (EditText) v.findViewById(R.id.dx_textedit));
            textEditeMap.put(Attribute.IQ, (EditText) v.findViewById(R.id.iq_textedit));
            textEditeMap.put(Attribute.HT, (EditText) v.findViewById(R.id.ht_textedit));
            textEditeMap.put(Attribute.HP, (EditText) v.findViewById(R.id.hp_textedit));
            textEditeMap.put(Attribute.WILL, (EditText) v.findViewById(R.id.will_textedit));
            textEditeMap.put(Attribute.PER, (EditText) v.findViewById(R.id.per_textedit));
            textEditeMap.put(Attribute.FP, (EditText) v.findViewById(R.id.fp_textedit));
            textEditeMap.put(Attribute.SPEED, (EditText) v.findViewById(R.id.speed_textedit));
            textEditeMap.put(Attribute.MOVE, (EditText) v.findViewById(R.id.move_textedit));
            textEditeMap.put(Attribute.DODGE, (EditText) v.findViewById(R.id.dodge_textedit));
            textEditeMap.put(Attribute.SM, (EditText) v.findViewById(R.id.sm_textedit));
            textEditeMap.put(Attribute.ATC_SKILL, (EditText) v.findViewById(R.id.skill_textedit));
            textEditeMap.put(Attribute.ATC_DICE, (EditText) v.findViewById(R.id.dice_textedit));
            textEditeMap.put(Attribute.ATC_PART_DICE, (EditText) v.findViewById(R.id.part_dice_textedit));
            textEditeMap.put(Attribute.DR, (EditText) v.findViewById(R.id.dr_textedit));
            textEditeMap.put(Attribute.ATC_TYPE, (EditText) v.findViewById(R.id.atc_type_textedit));
            textEditeMap.put(Attribute.PARRY, (EditText) v.findViewById(R.id.parry_textedit));
            textEditeMap.put(Attribute.NOTES, (EditText) v.findViewById(R.id.flavor_textedit));

            actionButton = (Button) v.findViewById(R.id.card_action);


            actionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mCardModel.isSaved()) {
                        new AlertDialog.Builder(v.getContext()).setTitle(v.getContext().getString(R.string.Delete))
                                .setMessage(v.getContext().getString(R.string.deleteDialog))
                                .setNegativeButton(v.getContext().getString(R.string.no), null)
                                .setPositiveButton(v.getContext().getString(R.string.yes), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        DatabaseManager.getInstance(null).deleteCard(mCardModel);
                                        mCardAdapter.mCardModels.remove(mCardModel);
                                        mCardAdapter.notifyDataSetChanged();
                                    }
                                }).show();

                    } else {
                        new AlertDialog.Builder(v.getContext()).setTitle(v.getContext().getString(R.string.save))
                                .setMessage(v.getContext().getString(R.string.saveDialog))
                                .setNegativeButton(v.getContext().getString(R.string.no), null).setPositiveButton(v.getContext().getString(R.string.yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DatabaseManager.getInstance(null).updateEntry(mCardModel);
                                setSaved();
                            }
                        }).show();
                    }


                }
            });

        }

        public void adjustButton(View v) {
            if (mCardModel.isSaved()) {
                actionButton.setText(v.getContext().getString(R.string.Delete));
            } else {
                actionButton.setText(v.getContext().getString(R.string.Delete));
            }
        }


        public void usedInSettings() {

            actionButton.setVisibility(View.GONE);
            textEditeMap.get(Attribute.ATC_TYPE).setVisibility(View.GONE);
            textEditeMap.get(Attribute.NOTES).setVisibility(View.GONE);
            textEditeMap.get(Attribute.NAME).setEnabled(false);
        }

        public void loadModel() {
            for (Attribute attribute : Attribute.values()) {
                textEditeMap.get(attribute).setText(mCardModel.getAttribute(attribute));
            }
        }


        public void setSaved() {
            actionButton.setText("DELETE");
            mCardModel.setSaved(true);
        }

        public void setUnsaved() {
            mCardModel.setSaved(false);
            actionButton.setText("SAVE");
        }


        public void addListeners() {
            for (final Attribute attribute : Attribute.values()) {
                textEditeMap.get(attribute).addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        if (!mCardModel.getAttribute(attribute).equals(textEditeMap.get(attribute).getText().toString())) {
                            setUnsaved();
                            mCardModel.setAttribute(attribute, textEditeMap.get(attribute).getText().toString());
                        }

                    }
                });

            }
        }
    }


}
