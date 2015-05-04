package dbXtrs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Fernando on 2015-05-04.
 */
public class ftDB extends SQLiteOpenHelper {


    private static final String LOGTAG = "ftpha - sca c r ";

    private static final String DB_Name = "ftKIT.db";
    private static final int DB_V = 1;

    private static final String T_USERS = "users";
    private static final String U_C_ID = "uId";
    private static final String U_C_NAME = "uName";
    private static final String U_C_PHONE = "uPhone";
    private static final String U_C_EMAIL = "uEmail";
    private static final String U_C_ACTIVE = "uActive";

    private static final String T_CATS = "users";
    private static final String C_C_ID = "cId";
    private static final String C_C_NAME = "cName";
    private static final String C_C_FROM = "cFrom";
    private static final String C_C_TO = "cTo";
    private static final String C_C_SMS = "cSMS";
    private static final String C_C_EMAIL = "cEmail";
    private static final String C_C_JUST_MF = "cJustMF";
    private static final String C_C_ACTIVE = "cActive";
    private static final String C_C_FK_USER = "uId";

    private static final String T_LISTS = "users";
    private static final String L_C_ID = "lId";
    private static final String L_C_NAME = "lName";
    private static final String L_C_TEXT = "lText";
    private static final String L_C_FK_USER = "uId";
    private static final String L_C_FK_CAT = "cId";

    // Creations
    private static final String CREATE_USER =
            "CREATE_TABLE " + T_USERS + " (" +
                    U_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    U_C_NAME +  " TEXT, " +
                    U_C_PHONE + " TEXT, " +
                    U_C_EMAIL + " TEXT " +
                    ")";

    // Creations
    private static final String CREATE_CAT =
            "CREATE_TABLE " + T_CATS + " (" +
                    C_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    C_C_NAME +  " TEXT, " +
                    C_C_FROM + " TEXT, " +
                    C_C_TO + " TEXT, " +
                    C_C_SMS + " TEXT, " +
                    C_C_EMAIL + " TEXT, " +
                    C_C_JUST_MF + " TEXT, " +
                    C_C_ACTIVE + " TEXT " +
                    C_C_FK_USER + " INTEGER " +
                    ")";

    // Creations
    private static final String CREATE_LIST =
            "CREATE_TABLE " + T_LISTS + " (" +
                    L_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    L_C_NAME +  " TEXT, " +
                    L_C_TEXT + " TEXT, " +
                    L_C_FK_USER + " INTEGER, " +
                    L_C_FK_CAT + " INTEGER " +
                    ")";




    public ftDB(Context context) {
        super(context, DB_Name, null, DB_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_USER);
        db.execSQL(CREATE_CAT);
        db.execSQL(CREATE_LIST);

        Log.i(LOGTAG, T_USERS + "  Created");
        Log.i(LOGTAG, T_CATS + "  Created");
        Log.i(LOGTAG, T_LISTS + "  Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop if exists " + T_USERS);
        db.execSQL("drop if exists " + T_CATS);
        db.execSQL("drop if exists " + T_LISTS);


        Log.i(LOGTAG, T_USERS + "  Droped");
        Log.i(LOGTAG, T_CATS + "  Droped");
        Log.i(LOGTAG, T_LISTS + "  Droped");

        onCreate(db);

    }
}
