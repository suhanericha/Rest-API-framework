package com.api.test.util;

import org.testng.annotations.Listeners;

@Listeners(ExtentReportListener.class)
public class BaseClass extends ExtentReportListener {

    public static String dir = System.getProperty("user.dir");
    protected static PropertiesReader prop;
    public static String host;

    public static void initializeProperty() throws Exception {
        prop = new PropertiesReader();
        prop.setPropertyFile(dir + "/config/environment.properties");
        host = prop.getPropertyValue("host");

    }

}
