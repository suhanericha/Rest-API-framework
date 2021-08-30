package com.api.test;

import com.airtel.helper.report.ReportHelper;
import com.api.test.mappings.response.Book;
import com.api.test.mappings.response.getAllBooksResponse;
import com.api.test.util.BaseClass;
import com.api.test.util.ExtentReportListener;
import com.api.test.util.GenericHelper;
import com.api.test.util.RestAssuredUtil;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static com.api.test.Constants.APIContants.GET_URL;

public class GetBooksManager extends ExtentReportListener {

    static GenericHelper genericHelper = new GenericHelper();


    public static Boolean validateGetRequest(){
        SoftAssert softAssert = new SoftAssert();
        String url = BaseClass.host + GET_URL;;
        Response res = RestAssuredUtil.getResponse(null, null,url);
        getAllBooksResponse response = (getAllBooksResponse) genericHelper.convertFromJson(res.asString(), getAllBooksResponse.class);
        String jsonResponse = genericHelper.convertToJson(response);
        test.log(LogStatus.PASS,
                "Test response is:: " + jsonResponse);
        System.out.println(jsonResponse);
        softAssert.assertTrue(responseCodeValiddation(res,200));
        softAssert.assertTrue(responseTimeValidation(res));
        softAssert.assertTrue(validateKeyValue(response));
        try {
            softAssert.assertAll();
            test.log(LogStatus.PASS,
                    "All cases of GET have been validated");
        } catch (AssertionError assertionError) {
            test.log(LogStatus.FAIL, assertionError.fillInStackTrace());
            return false;
        }
        return true;

    }

    public static boolean validateKeyValue(getAllBooksResponse response) {
        SoftAssert softAssert = new SoftAssert();
        List<Book> books = response.getBooks();
        for(int i=0;i<books.size();i++){
            Book book = books.get(i);
            softAssert.assertNotNull(book.getAuthor());
            softAssert.assertNotNull(book.getIsbn());
        }

        try {
            softAssert.assertAll();
            test.log(LogStatus.PASS,
                    "Key value pairs validated");
        } catch (AssertionError assertionError) {
            test.log(LogStatus.FAIL, assertionError.fillInStackTrace());
            return false;
        }
        return true;
    }


    public static boolean responseCodeValiddation(Response response, int statusCode) {
        try {
            Assert.assertEquals(statusCode, response.getStatusCode());
            test.log(LogStatus.PASS,
                    "Successfully validdated status code, status code is :: " + response.getStatusCode());
        } catch (AssertionError e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
            test.log(LogStatus.FAIL,
                    "Expected status code is :: " + statusCode + " , insted of getting :: " + response.getStatusCode());
            return false;
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
            return false;
        }
        return true;
    }

    public static boolean responseTimeValidation(Response response) {
        try {
            long time=response.time();
            test.log(LogStatus.INFO, "Api response time is :: " + time);
        } catch (Exception e) {
            test.log(LogStatus.FAIL, e.fillInStackTrace());
            return false;
        }
        return true;
    }
}
