package com.example.diana.sqlproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DIANA on 23/10/2017.
 */

public class Databasehandler extends SQLiteOpenHelper {

    //All static varibales
    private static final int DATABASE_VERSION = 1;

    //Database name
    private static final String DATABASE_NAME = "contactsManager";

    private static final String TABLE_ROUTES = "routes";
    private static final String TABLE_CONTACTS = " contacts ";
    private static final String TABLE_DRIVERS = "drivers";

    //Contacts tablename
    private static final String KEY_ID = " id" ;
    private static final String KEY_NAME = " name ";
    private static final String KEY_PH_NO = " phone_number ";

    //Routes tablename

    private static final String R_ID = " routeid" ;
    private static final String R_NAME = " routename ";

    //Drivers tablename

    private static final String D_ID = "driverid";
    private static final String D_NAME = "drivername";


    public Databasehandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Databasehandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = " CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAME + " TEXT ,"
                + KEY_PH_NO + " TEXT )";
        db.execSQL(CREATE_CONTACTS_TABLE);


        String CREATE_ROUTES_TABLE = " CREATE TABLE " + TABLE_ROUTES + "("
                + R_ID + " INTEGER PRIMARY KEY, " + R_NAME + " TEXT )";

        db.execSQL(CREATE_ROUTES_TABLE);


        String CREATE_DRIVERS_TABLE = " CREATE TABLE " + TABLE_DRIVERS + "("
                + D_ID + " INTEGER PRIMARY KEY, " + D_NAME + " TEXT )";

        db.execSQL(CREATE_DRIVERS_TABLE);
    }


    //UPGRADING DATABASE

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_ROUTES);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_DRIVERS);
        onCreate(db);


    }

    //addidng new contact
    public void addContact(contacts contact) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, contact.get_name()); //contact Name
        values.put(KEY_PH_NO, contact.get_phone_number()); //contact Phone number

        //inserting row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); //closing dtabase connection


    }
        //adding a new route
    public void addRoute(routes route) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(R_ID, route.getRoute_id()); //route Name
        values.put(R_NAME, route.getRoute_name()); //get route name

        //inserting row
        db.insert(TABLE_ROUTES, null, values);
        db.close(); //closing dtabase connection

    }

    public void addDriver(drivers driver) {


        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(D_ID, driver.getDriver_id()); //route Name
        values.put(D_NAME, driver.getDriver_name()); //get route name

        //inserting row
        db.insert(TABLE_DRIVERS, null, values);
        db.close(); //closing dtabase connection


    }

    //getting single route
    public routes getroutes(int r_id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ROUTES, new String[]{R_ID, R_NAME,}, R_ID + "=?",
                new String[]{String.valueOf(r_id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        routes routes = new routes(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        //return contact
        return routes;
    }
    //getting single contact
    public contacts getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_NO}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        contacts contacts = new contacts(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        //return contact
        return contacts;


    }

    public drivers getdrivers(int d_id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_DRIVERS, new String[]{D_ID, D_NAME,}, D_ID + "=?",
                new String[]{String.valueOf(d_id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        drivers drivers = new drivers(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1));

        //return contact
        return drivers;
    }






    //getting all contacts
    public List<contacts> getAllContacts() {
        List<contacts> contactsList = new ArrayList<contacts>();
        //select All Query
        String selectQuery = " SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows adding to the list
        if (cursor.moveToFirst()) {
            do {
                contacts contacts = new contacts();
                contacts.set_id(Integer.parseInt(cursor.getString(0)));
                contacts.set_name(cursor.getString(1));
                contacts.set_phone_number(cursor.getString(2));

                //adding contact to the list
                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        //return contact list
        return contactsList;

    }
    //getting all routes
    public List<routes> getAllRoutes() {
        List<routes> routesList = new ArrayList<routes>();
        //select All Query
        String selectQuery = " SELECT * FROM " + TABLE_ROUTES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows adding to the list
        if (cursor.moveToFirst()) {
            do {
                routes routes = new routes();
                routes.setRoute_id(Integer.parseInt(cursor.getString(0)));
                routes.setRoute_name(cursor.getString(1));


                //adding contact to the list
                routesList.add(routes);
            } while (cursor.moveToNext());
        }
        //return contact list
        return routesList;

    }
    //getting all drivers
    public List<drivers> getAllDrivers() {
        List<drivers> driversList = new ArrayList<drivers>();
        //select All Query
        String selectQuery = " SELECT * FROM " + TABLE_DRIVERS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all rows adding to the list
        if (cursor.moveToFirst()) {
            do {
                drivers drivers = new drivers();
                drivers.setDriver_id(Integer.parseInt(cursor.getString(0)));
                drivers.setDriver_name(cursor.getString(1));


                //adding contact to the list
                driversList.add(drivers);
            } while (cursor.moveToNext());
        }
        //return contact list
        return driversList;

    }






    //Getting Contacts count
    public int getcontactsCount() {
        String countQuery = " SELECT * FROM "+ TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }
    public int getroutesCount() {
        String countQuery = " SELECT * FROM "+ TABLE_ROUTES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }
    public int getdriversCount() {
        String countQuery = " SELECT * FROM "+ TABLE_DRIVERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //return count
        return cursor.getCount();

    }







    //updating single contact
    public int updateContact (contacts contacts){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values= new ContentValues();
        values.put(KEY_NAME, contacts.get_name());
        values.put(KEY_PH_NO, contacts.get_phone_number());

        //updating row
        return db.update(TABLE_CONTACTS,values , KEY_ID + "= ?",
                new String[]{String.valueOf(contacts.get_id())});
    }


    public int updateRoute (routes routes){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values= new ContentValues();
        values.put(R_ID, routes.getRoute_id());
        values.put(R_NAME, routes.getRoute_name());

        //updating row
        return db.update(TABLE_ROUTES,values , R_ID + "= ?",
                new String[]{String.valueOf(routes.getRoute_id())});
    }


    public int updateDriver (drivers drivers){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values= new ContentValues();
        values.put(D_ID, drivers.getDriver_id());
        values.put(D_NAME, drivers.getDriver_name());

        //updating row
        return db.update(TABLE_DRIVERS,values , D_ID + "= ?",
                new String[]{String.valueOf(drivers.getDriver_id())});
    }




    //deleting single contact
    public void deleteContact (contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "= ? ",
                new String[]{ String.valueOf(contacts.get_id()) });
        db.close();

    }
    public void deleteRoute (routes routes) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ROUTES, R_ID + "= ? ",
                new String[]{ String.valueOf(routes.getRoute_id()) });
        db.close();

    }

    public void deleteDrivers (drivers drivers) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DRIVERS, D_ID + "= ? ",
                new String[]{ String.valueOf(drivers.getDriver_id()) });
        db.close();

    }


}

