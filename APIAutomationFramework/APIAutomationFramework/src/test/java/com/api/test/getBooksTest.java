package com.api.test;

import com.api.test.Constants.APIContants;
import com.api.test.util.BaseClass;
import com.api.test.util.ExtentReportListener;
import com.api.test.util.GenericHelper;
import com.api.test.util.PropertiesReader;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;


public class getBooksTest extends BaseClass implements APIContants {

    GenericHelper genericHelper = new GenericHelper();
    PropertiesReader propertyReader = new PropertiesReader();
    GetBooksManager getBooksManager = new GetBooksManager();


    @BeforeClass
    public void setUp() throws Exception {
        initializeProperty();
    }

    @Test
    public void getAllBooksData(){
        test.log(LogStatus.INFO, "Test is starting......");
        try {
            Assert.assertTrue(getBooksManager.validateGetRequest());
        } catch (Exception e) {
            Reporter.log("Testcase has failed with exception" + e, false);
            Assert.assertTrue(false);
        }

        test.log(LogStatus.INFO, "Test is ended......");

    }



}
