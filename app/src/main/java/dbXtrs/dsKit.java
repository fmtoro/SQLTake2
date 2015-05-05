package dbXtrs;

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

    public User createUser(){

    }


}
