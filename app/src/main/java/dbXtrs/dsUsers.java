package dbXtrs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fernando on 2015-05-04.
 */
public class dsUsers {

    private static final String LOGTAG = "ftpha - sca c r ";

    SQLiteOpenHelper dbH;
    SQLiteDatabase db;


    public dsUsers(Context context){

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

}
