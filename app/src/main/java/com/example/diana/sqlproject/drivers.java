package com.example.diana.sqlproject;

/**
 * Created by DIANA on 23/10/2017.
 */

public class drivers {
    //private variables
    int driver_id;
    String driver_name;



    //empty construcotr
    public drivers(){}

    public drivers (int driver_id, String driver_name){
        this.driver_id = driver_id;
        this. driver_name = driver_name;

    }
    public drivers(String driver_name){
        this.driver_name = driver_name;

    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }



    public String getDriver_name() {
        return this.driver_name;
    }


    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }


}


