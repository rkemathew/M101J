package com.mongodb;

import static spark.Spark.get;
import static spark.Spark.halt;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class HelloWorldSparkFreemarkerStyle {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreemarkerStyle.class, "/");
        StringWriter writer = new StringWriter();
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Freemarker");

            helloTemplate.process(helloMap, writer);
        } catch (Exception e) {
            halt(500);
            e.printStackTrace();
        }

        get("/helloSparkFreeMarker", (req, res) -> writer);
    }


}
