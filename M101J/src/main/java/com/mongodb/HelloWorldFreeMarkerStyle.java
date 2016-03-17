package com.mongodb;


import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vinod on 3/15/2016.
 */
public class HelloWorldFreeMarkerStyle {
    public static void main(String[] args){
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(HelloWorldFreeMarkerStyle.class,"/");
        try{
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "FreeMarker");

            helloTemplate.process(helloMap, writer);
            System.out.println(writer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
