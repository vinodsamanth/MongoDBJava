package com.mongodb;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by Vinod on 3/15/2016.
 */
public class HelloWorldSparkFreemarker {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldSparkFreemarker.class,"/");
        get("/", (req, res) -> {
            StringWriter writer = new StringWriter();
            try{
                Template helloTemplate = configuration.getTemplate("hello.ftl");

                Map<String, Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "FreeMarker");

                helloTemplate.process(helloMap, writer);
                System.out.println(writer);
            }catch (Exception e){
                halt(500);
                e.printStackTrace();
            }
            return writer;
        });
    }
}
