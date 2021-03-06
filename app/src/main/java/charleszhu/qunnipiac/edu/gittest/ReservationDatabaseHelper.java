package charleszhu.qunnipiac.edu.gittest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charles on 4/24/2017.
 * Edited by Prof. Ruby on 4/27
 * Database helper creates acts to create the database tables to store customer and reservation
 * information
 */

public class ReservationDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "reservations"; //database name
    private static final int DB_VERSION = 2; //database version

    //--------------Customer Table -------------------------------------
    public static final String CUSTOMER_TABLE = "customer_table";
    public static final String CUSTOMER_ID = "id";
    public static final String CUSTOMER_NAME = "name";
    public static final String CUSTOMER_PHONE = "phone";

    private static final String CUSTOMER_TABLE_CREATE = "create table " + CUSTOMER_TABLE +
            "(" + CUSTOMER_ID + " integer primary key autoincrement, " + CUSTOMER_NAME + " text not null, " +
            CUSTOMER_PHONE + " text not null);";
    //Reservation Table --------------------------------------------
    public static final String RESERVATION_TABLE = "reservations_table";
    public static final String RESERVATION_KEY = "_id";
    public static final String RESERVATION_CUSTOMER_ID = "customerId";
    public static final String RESERVATION_DATE = "date";
    public static final String RESERVATION_TIME = "time";
    public static final String RESERVATION_PARTYSIZE = "party";
//String to be executed to create reservation table. Foreign key link to customer table
private static final String DB_CREATE = "create table "
        + RESERVATION_TABLE + " (" + RESERVATION_KEY + " integer primary key autoincrement, "
        + RESERVATION_DATE + " text not null, "
        + RESERVATION_TIME + " text not null, "
        + RESERVATION_PARTYSIZE + " text not null, "
        + RESERVATION_CUSTOMER_ID + " integer,"
        + " FOREIGN KEY (" + RESERVATION_CUSTOMER_ID + ") REFERENCES "+  CUSTOMER_TABLE + "(" +  CUSTOMER_ID +"));";
    // --------------------------------------------------------------
	/* Here is a sample query
	   SELECT CUSTOMER_NAME, CUSTOMER_PHONE, RESERVATION_DATE, RESERVATION_TIME
	   FROM   CUSTOMER_TABLE, RESERVATION_TABLE
	   WHERE CUSTOMER_ID =  RESERVATION_CUSTOMER_ID;
	*/
    public ReservationDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CUSTOMER_TABLE_CREATE);
        sqLiteDatabase.execSQL(DB_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //Check for current version of database, if old, replace with new version
        if (oldVersion < newVersion) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CUSTOMER_TABLE);
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RESERVATION_TABLE);
            onCreate(sqLiteDatabase);
        }
    }



}
