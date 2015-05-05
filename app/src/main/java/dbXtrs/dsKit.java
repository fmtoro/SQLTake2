package dbXtrs;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import model.*;

import java.util.Comparator;

/**
 *
 * Created by Fernando on 2015-05-04.
 * Originally created as part of: SQLTake2
 * You will love this code and be awed by it's magnificence
 *
 */
public class dsKit {

    private static final String LOGTAG = "ftpha - sca c r ";

    SQLiteOpenHelper dbH;
    SQLiteDatabase db;


    public dsKit(Context context){

        dbH = new ftDB(context);
    }

    public void Open(){


        db = dbH.getWritableDatabase();
        Log.i(LOGTAG," The db has opened");

    }


    public void Close(){

        dbH.close();
        Log.i(LOGTAG," The db has closed");

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


    public Cat createCat(Cat cat){

        ContentValues values = new ContentValues();

        values.put(ftDB.C_C_NAME, cat.getCName());
        values.put(ftDB.C_C_FROM, cat.getCFrom());
        values.put(ftDB.C_C_TO, cat.getCTo());
        values.put(ftDB.C_C_SMS, cat.getCSMS());
        values.put(ftDB.C_C_EMAIL, cat.getCEmail());
        values.put(ftDB.C_C_JUST_MF, cat.isCJustMF());
        values.put(ftDB.C_C_FK_USER, cat.getUId());

        long insertCId = db.insert(ftDB.T_CATS, null,values );
        cat.setUId(insertCId);

        return cat;

    }


    public ftList createList(ftList fTList){

        ContentValues values = new ContentValues();

        values.put(ftDB.L_C_NAME , fTList.getLName()   );
        values.put(ftDB.L_C_TEXT , fTList.getLText()   );
        values.put(ftDB.L_C_FK_CAT , fTList.getCId()   );

        long insertLId = db.insert(ftDB.T_LISTS, null,values );
        fTList.setLId(insertLId);

        return fTList;

    }

}
