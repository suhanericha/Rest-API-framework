package com.api.test.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    String propertyFileName;
   // String env = "environment";
   // String propertyFileName = env + ".properties";


    public void setPropertyFile(String propertyFileName) {
        this.propertyFileName = propertyFileName;
        System.out.println(propertyFileName);
    }

    public String getPropertyValue(String property) throws Exception {
        Properties prop = new Properties();
        InputStream input = null;
        String requiredPropertyValue = null;
        try {

            input = new FileInputStream(this.propertyFileName);
            prop.load(input);
            requiredPropertyValue = prop.getProperty(property);
        } catch (Exception var9) {
            var9.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
        return requiredPropertyValue;
    }
}
