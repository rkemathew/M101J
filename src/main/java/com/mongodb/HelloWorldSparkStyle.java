package com.mongodb;

import static spark.Spark.get;

public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}
