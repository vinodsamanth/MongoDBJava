package com.mongodb;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import static spark.Spark.*;

/**
 * Created by Vinod on 3/15/2016.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args){
        get("/", (req, res) -> {
            return "hello world";
        });
    }
}
