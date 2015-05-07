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
    private static final int DB_V = 6;

    public static final String T_USERS = "users";
    public static final String U_C_ID = "uId";
    public static final String U_C_NAME = "uName";
    public static final String U_C_PHONE = "uPhone";
    public static final String U_C_EMAIL = "uEmail";
    public static final String U_C_ACTIVE = "uActive";

    public static final String T_CATS = "categories";
    public static final String C_C_ID = "cId";
    public static final String C_C_NAME = "cName";
    public static final String C_C_FROM = "cFrom";
    public static final String C_C_TO = "cTo";
    public static final String C_C_UNIT = "cUnit";
    public static final String C_C_SMS = "cSMS";
    public static final String C_C_EMAIL = "cEmail";
    public static final String C_C_JUST_MF = "cJustMF";
    public static final String C_C_ACTIVE = "cActive";
    public static final String C_C_FK_USER = "uId";

    public static final String T_LISTS = "lists";
    public static final String L_C_ID = "lId";
    public static final String L_C_NAME = "lName";
    public static final String L_C_TEXT = "lText";
    public static final String L_C_FK_USER = "uId";
    public static final String L_C_FK_CAT = "cId";

    // Creations
    private static final String CREATE_USER =
            "CREATE TABLE " + T_USERS + " (" +
                    U_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    U_C_NAME +  " TEXT, " +
                    U_C_PHONE + " TEXT, " +
                    U_C_EMAIL + " TEXT " +
                    ")";

    // Creations
    private static final String CREATE_CAT =
            "CREATE TABLE " + T_CATS + " (" +
                    C_C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    C_C_NAME +  " TEXT, " +
                    C_C_FROM + " TEXT, " +
                    C_C_TO + " TEXT, " +
                    C_C_UNIT + " TEXT, " +
                    C_C_SMS + " TEXT, " +
                    C_C_EMAIL + " TEXT, " +
                    C_C_JUST_MF + " TEXT, " +
                    C_C_ACTIVE + " TEXT, " +
                    C_C_FK_USER + " INTEGER " +
                    ")";

    // Creations
    private static final String CREATE_LIST =
            "CREATE TABLE " + T_LISTS + " (" +
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

        db.execSQL("drop table if exists " + T_USERS);
        db.execSQL("drop table if exists " + T_CATS);
        db.execSQL("drop table if exists " + T_LISTS);


        Log.i(LOGTAG, T_USERS + "  Droped");
        Log.i(LOGTAG, T_CATS + "  Droped");
        Log.i(LOGTAG, T_LISTS + "  Droped");

        onCreate(db);

    }
}
