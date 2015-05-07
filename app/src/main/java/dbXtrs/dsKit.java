package dbXtrs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ftpha.sqltake2.MainActivity;

import model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Created by Fernando on 2015-05-04.
 * Originally created as part of: SQLTake2
 * You will love this code and be awed by it's magnificence
 *
 */
public class dsKit {

    private SQLiteOpenHelper dbH;
    private SQLiteDatabase db;

    private static final String LOGTAG = "ftpha - sca c r ";

    private static final String[] allUTCs = {
            ftDB.U_C_ID,
            ftDB.U_C_NAME,
            ftDB.U_C_PHONE,
            ftDB.U_C_EMAIL
    };

    private static final String[] allCTCs = {
            ftDB.C_C_ID,
            ftDB.C_C_NAME,
            ftDB.C_C_FROM,
            ftDB.C_C_TO,
            ftDB.C_C_UNIT,
            ftDB.C_C_SMS,
            ftDB.C_C_EMAIL,
            ftDB.C_C_JUST_MF,
            ftDB.C_C_ACTIVE,
            ftDB.C_C_FK_USER
    };

    private static final String[] allLTCs = {
            ftDB.L_C_ID,
            ftDB.L_C_NAME,
            ftDB.L_C_TEXT,
            ftDB.L_C_FK_USER,
            ftDB.L_C_FK_CAT
    };



    public dsKit(Context context){

        dbH = new ftDB(context);
    }

    public void Open(){


        db = dbH.getWritableDatabase();
        Log.i(LOGTAG," The db has opened");

    }


    public void Close(){

        dbH.close();
        Log.i(LOGTAG, " The db has closed");

    }

    public User createUser(User user){

        ContentValues values = new ContentValues();

        values.put(ftDB.U_C_NAME, user.getUName());
        values.put(ftDB.U_C_PHONE, user.getUPhone());
        values.put(ftDB.U_C_EMAIL, user.getUEmail());

        long insertUId = db.insert(ftDB.T_USERS, null,values );
        user.setUId(insertUId);

        return user;
    }

//    public User findUsers(){
//
//
//    }

    public List<User> findAllUsers(){
        List<User> users = new ArrayList<User>();

        Cursor cursor = db.query(ftDB.T_USERS, allUTCs,null,null,null,null,null);

        Log.i(LOGTAG, "Found " + cursor.getCount() + " rows in " + ftDB.T_USERS);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                User user = new User();
                user.setUId(cursor.getLong(cursor.getColumnIndex(ftDB.U_C_ID)));
                user.setUName(cursor.getString(cursor.getColumnIndex(ftDB.U_C_NAME)));
                user.setUPhone(cursor.getString(cursor.getColumnIndex(ftDB.U_C_PHONE)));
                user.setUEmail(cursor.getString(cursor.getColumnIndex(ftDB.U_C_EMAIL)));
                users.add(user);
            }
        }

        return users;
    }


    public Cat createCat(Cat cat){

        ContentValues values = new ContentValues();

        values.put(ftDB.C_C_NAME, cat.getCName());
        values.put(ftDB.C_C_FROM, cat.getCFrom());
        values.put(ftDB.C_C_TO, cat.getCTo());
        values.put(ftDB.C_C_UNIT, cat.getCUnit());
        values.put(ftDB.C_C_SMS, cat.getCSMS());
        values.put(ftDB.C_C_EMAIL, cat.getCEmail());
        values.put(ftDB.C_C_JUST_MF, cat.getCJustMF());
        values.put(ftDB.C_C_ACTIVE, cat.getCActive());
        values.put(ftDB.C_C_FK_USER, cat.getUId());

        long insertCId = db.insert(ftDB.T_CATS, null, values);
        cat.setCId(insertCId);

        return cat;

    }


    public List<Cat> findAllCats(){
        List<Cat> cats = new ArrayList<Cat>();

        Cursor cursor = db.query(ftDB.T_CATS, allCTCs, null, null, null, null, null);

        Log.i(LOGTAG, "Found " + cursor.getCount() + " rows in " + ftDB.T_CATS);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Cat cat = new Cat();
                cat.setCId(cursor.getLong(cursor.getColumnIndex(ftDB.C_C_ID)));
                cat.setCName(cursor.getString(cursor.getColumnIndex(ftDB.C_C_NAME)));
                cat.setCFrom(cursor.getString(cursor.getColumnIndex(ftDB.C_C_FROM)));
                cat.setCTo(cursor.getString(cursor.getColumnIndex(ftDB.C_C_TO)));
                cat.setCUnit(cursor.getString(cursor.getColumnIndex(ftDB.C_C_UNIT)));
                cat.setCSMS(cursor.getString(cursor.getColumnIndex(ftDB.C_C_SMS)));
                cat.setCEmail(cursor.getString(cursor.getColumnIndex(ftDB.C_C_EMAIL)));
                cat.setCJustMF(cursor.getString(cursor.getColumnIndex(ftDB.C_C_JUST_MF)));
                cat.setCActive(cursor.getString(cursor.getColumnIndex(ftDB.C_C_ACTIVE)));
                cat.setUId(cursor.getLong(cursor.getColumnIndex(ftDB.C_C_FK_USER)));
                cats.add(cat);
            }
        }

        return cats;
    }

    public ftList createList(ftList fTList){

        ContentValues values = new ContentValues();

        values.put(ftDB.L_C_NAME, fTList.getLName());
        values.put(ftDB.L_C_TEXT, fTList.getLText());
        values.put(ftDB.L_C_FK_CAT , fTList.getCId()   );

        long insertLId = db.insert(ftDB.T_LISTS, null, values);
        fTList.setLId(insertLId);

        return fTList;

    }

    public List<ftList> findAllLists(){
        List<ftList> ftlists = new ArrayList<ftList>();

        Cursor cursor = db.query(ftDB.T_USERS, allUTCs, null, null, null, null, null);

        Log.i(LOGTAG, "Found " + cursor.getCount() + " rows in " + ftDB.T_USERS);

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                ftList list = new ftList();
                list.setLId(cursor.getLong(cursor.getColumnIndex(ftDB.L_C_ID)));
                list.setLName(cursor.getString(cursor.getColumnIndex(ftDB.L_C_NAME)));
                list.setLText(cursor.getString(cursor.getColumnIndex(ftDB.L_C_TEXT)));
                list.setCId(cursor.getLong(cursor.getColumnIndex(ftDB.L_C_FK_CAT)));
                ftlists.add(list);
            }
        }

        return ftlists;
    }


    public void createUser(String nom,
                           String phone,
                           String email){
        User user = new User();
        user.setUName(nom);
        user.setUPhone(phone);
        user.setUEmail(email);
        user = createUser(user);
        Log.i(LOGTAG, "User created with Id: " + user.getUId());
    }



    public void createList(
            String nom,
            String lText,
            long cId){

        ftList fTList = new ftList();
        fTList.setLName(nom);
        fTList.setLText(lText);
        fTList.setCId(cId);
        fTList = createList(fTList);
        Log.i(LOGTAG, "List created with Id: " + fTList.getLId());
    }

    public void createCat(String nom,
                          String cFrom,
                          String cTo,
                          String cUnit,
                          String cSMS,
                          String cEmail,
                          String cJustMF,
                          String cActive,
                          long uId){
        Cat cat = new Cat();
        cat.setCName(nom);
        cat.setCFrom(cFrom);
        cat.setCTo(cTo);
        cat.setCUnit(cUnit);
        cat.setCSMS(cSMS);
        cat.setCEmail(cEmail);
        cat.setCJustMF(cJustMF);
        cat.setCActive(cActive);
        cat.setUId(uId);
        cat = createCat(cat);
        Log.i(LOGTAG, "Category created with Id: " + cat.getCId());
    }
}
