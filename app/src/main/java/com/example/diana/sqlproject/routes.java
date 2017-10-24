package com.example.diana.sqlproject;

/**
 * Created by DIANA on 23/10/2017.
 */

public class routes {
    //private variables
    int route_id;
    String route_name;



    //empty construcotr
    public routes(){}

    public routes (int route_id, String route_name){
        this.route_id = route_id;
        this. route_name = route_name;

    }
    public routes(String route_name){
        this.route_name = route_name;

    }

    public int getRoute_id() {
        return route_id;
    }

    public void setRoute_id(int route_id) {
        this.route_id = route_id;
    }



    public String getRoute_name() {
        return this.route_name;
    }


    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }


}

