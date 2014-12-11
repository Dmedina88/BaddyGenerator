package com.grayherring.baddiegenerator.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.grayherring.baddiegenerator.Models.CardModel;

import java.util.ArrayList;

/**
 * Created by David on 12:03 AM.
 */
public class DatabaseManager extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "GurpsSheets";
    // Contacts table name
    private static final String TABLE_CARDS = "cards";
    // Contacts Table Columns names
    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String STR_KEY = "ST";
    private static final String DX_KEY = "DX";
    private static final String IQ_KEY = "IQ";
    private static final String HT_KEY = "HT";
    private static final String HP_KEY = "HP";
    private static final String WILL_KEY = "WILL";
    private static final String PER_KEY = "PER";
    private static final String FP_KEY = "FP";
    private static final String SPEED_KEY = "SPEED";
    private static final String MOVE_KEY = "MOVE";
    private static final String DODGE_KEY = "DODGE";
    private static final String DR_KEY = "DR";
    private static final String SM_KEY = "SM";
    private static final String ATC_SKILL_KEY = "ATC_SKILL";
    private static final String ATC_DICE = "ATC_DICE";
    private static final String ATC_PDICE = "ATC_PDICE";
    private static final String ATC_TYPE = "ATC_TYPE";
    private static final String PARRY_KEY = "PARRY";
    private static final String NOTES_KEY = "NOTES";

    private String[] allColumns = {ID_KEY, NAME_KEY, STR_KEY, DX_KEY, IQ_KEY,
            HT_KEY, HP_KEY, WILL_KEY, PER_KEY, FP_KEY, SPEED_KEY, MOVE_KEY, DODGE_KEY,
            DR_KEY, SM_KEY, ATC_SKILL_KEY, ATC_DICE, ATC_PDICE, ATC_TYPE, PARRY_KEY,
            NOTES_KEY,};
    private static DatabaseManager mInstance;
    private Context mContext;

    private DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    public static DatabaseManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseManager(context.getApplicationContext());
        }
        return mInstance;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CARDS + "("
                + ID_KEY + " INTEGER PRIMARY KEY,"
                + NAME_KEY + " TEXT,"
                + STR_KEY + " TEXT,"
                + DX_KEY + " TEXT,"
                + IQ_KEY + " TEXT,"
                + HT_KEY + " TEXT,"
                + HP_KEY + " TEXT,"
                + WILL_KEY + " TEXT,"
                + PER_KEY + " TEXT,"
                + FP_KEY + " TEXT,"
                + SPEED_KEY + " TEXT,"
                + MOVE_KEY + " TEXT,"
                + DODGE_KEY + " TEXT,"
                + DR_KEY + " TEXT,"
                + SM_KEY + " TEXT,"
                + ATC_SKILL_KEY + " TEXT,"
                + ATC_DICE + " TEXT,"
                + ATC_PDICE + " TEXT,"
                + ATC_TYPE + " TEXT,"
                + PARRY_KEY + " TEXT,"
                + NOTES_KEY + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARDS);
        onCreate(db);
    }

    public long addSheet(CardModel cardModel) {
        long id;
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        putValues(values, cardModel);

        id = db.insert(TABLE_CARDS, null, values);
        cardModel.setId(id);
        db.close(); // Closing database connection
        return id;
    }

    public CardModel getSheet(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        CardModel cardModel =  new CardModel();
        Cursor cursor = db.query(TABLE_CARDS, allColumns, ID_KEY + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            cardModel = populateCard(cursor);
            cursor.close();
        }
        return cardModel;
    }

    public ArrayList<CardModel> search(String name) {
        ArrayList<CardModel> Cards = new ArrayList<CardModel>();
        SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.query(TABLE_CARDS, allColumns, NAME_KEY + " LIKE ?",
              new String[]{"%"+name+"%"}, null, "", "id DESC");


        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Cards.add(populateCard(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return Cards;
    }

    public ArrayList<CardModel> getAllCards() {
        ArrayList<CardModel> Sheets = new ArrayList<CardModel>();
        Cursor cursor = this.getReadableDatabase().query(TABLE_CARDS,
                allColumns, null, null, null, "", "id DESC");
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Sheets.add(populateCard(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        return Sheets;
    }

    public int getCardCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CARDS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

    public int getCardCount(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CARDS, allColumns, NAME_KEY + " LIKE ?",
                new String[]{"%" + name + "%"}, null, null, "id DESC", null);

        return cursor.getCount();
    }

    // Updating single contact
    public int updateEntry(CardModel cardModel) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        putValues(values, cardModel);

        return db.update(TABLE_CARDS, values, ID_KEY + " = ?",
                new String[]{String.valueOf(cardModel.getId())});
    }


    public void deleteCard(CardModel cardModel) {

        long id = cardModel.getId();
        this.getReadableDatabase().delete(TABLE_CARDS,
                ID_KEY + " = " + id, null);

    }

    public CardModel populateCard(Cursor cursor) {
        CardModel cardModel = new CardModel();

        cardModel.setId(cursor.getInt(0));
        cardModel.setName(cursor.getString(1));
        cardModel.setStr(cursor.getString(2));
        cardModel.setDx(cursor.getString(3));
        cardModel.setIq(cursor.getString(4));
        cardModel.setHt(cursor.getString(5));
        cardModel.setHp(cursor.getString(6));
        cardModel.setWill(cursor.getString(7));
        cardModel.setPer(cursor.getString(8));
        cardModel.setFp(cursor.getString(9));//is wromng
        cardModel.setSpeed(cursor.getString(10));
        cardModel.setMove(cursor.getString(11));
        cardModel.setDodge(cursor.getString(12));
        cardModel.setDr(cursor.getString(13));
        cardModel.setSm(cursor.getString(14));
        cardModel.setAtcSkill(cursor.getString(15));
        cardModel.setAtcDice(cursor.getString(16));
        cardModel.setAtcPartDice(cursor.getString(17));
        cardModel.setAtcType(cursor.getString(18));
        cardModel.setParry(cursor.getString(19));
        cardModel.setNotes(cursor.getString(20) );


        return cardModel;
    }

    public ContentValues putValues(ContentValues values, CardModel cardModel) {

        values.put(NAME_KEY, cardModel.getName());
        values.put(STR_KEY, cardModel.getStr());
        values.put(DX_KEY, cardModel.getDx());
        values.put(IQ_KEY, cardModel.getIq());
        values.put(HT_KEY, cardModel.getHt());
        values.put(HP_KEY, cardModel.getHp());
        values.put(WILL_KEY, cardModel.getWill());
        values.put(PER_KEY, cardModel.getPer());
        values.put(FP_KEY, cardModel.getFp());
        values.put(SPEED_KEY, cardModel.getSpeed());
        values.put(MOVE_KEY, cardModel.getMove());
        values.put(DODGE_KEY, cardModel.getDodge());
        values.put(DR_KEY, cardModel.getDr());
        values.put(SM_KEY, cardModel.getSm());
        values.put(ATC_SKILL_KEY, cardModel.getAtcSkill());
        values.put(ATC_DICE, cardModel.getAtcDice());
        values.put(ATC_PDICE, cardModel.getAtcPartDice());
        values.put(ATC_TYPE, cardModel.getAtcType());
        values.put(PARRY_KEY, cardModel.getParry());
        values.put(NOTES_KEY, cardModel.getNotes());


        return values;
    }
}
