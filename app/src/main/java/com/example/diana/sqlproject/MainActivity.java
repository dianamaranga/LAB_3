package com.example.diana.sqlproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   class AndroidSQLiteTutorialActivity extends Activity{
        //    @Override
        //  public void onCreate(Bundle savedInstanceState) {
        //    super.onCreate(savedInstanceState);
        //  setContentView (R.layout.activity_main);

        Databasehandler db = new Databasehandler(this);

        //inserting Contacts
        Log.d("Insert: ", "Inserting .. ");
        db.addContact(new contacts("Ravi", "9100000000"));
        db.addContact(new contacts("Srinivas", "9199999999"));
        db.addContact(new contacts("Tommy", "9522222222"));
        db.addContact(new contacts("Karthnik", "9533333333"));


        //inserting Contacts
        Log.d(" Insert: ", " Inserting .. ");
        db.addRoute(new routes(" Nairobi"));

        //inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addDriver(new drivers(" Jack "));


        //Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<contacts> contacts = db.getAllContacts();

        for (contacts cn : contacts) {
            String log = "id: " + cn.get_id() + " ,Name: " + cn.get_name() + " ,Phone: " + cn.get_phone_number();
            Log.d("Name: ", log);
        }


            Log.d("Reading: ", "Reading all drivers..");
            List<drivers> drivers = db.getAllDrivers();

            for (drivers dr : drivers) {
                String log = "driver_id: " + dr.getDriver_id() + " ,driver_name: " + dr.getDriver_name();
                Log.d("driver_name: ", log);
            }


                Log.d("Reading: ", "Reading all Routes..");
                List<routes> routes = db.getAllRoutes();

                for (routes rt : routes) {
                    String log = "route_id: " + rt.getRoute_id() + " ,route_name: " + rt.getRoute_name();
                    Log.d("route_name: ", log);


                }
    }
}
