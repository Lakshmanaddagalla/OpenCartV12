package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {


    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\testData\\Opencart_LoginData.xlsx"; //talking xl file from testData

        ExcelUtility xlUtil = new ExcelUtility(path); //creating an object for XLUtility

        int totalRows = xlUtil.getRowCount("Sheet1");
        int totalCells = xlUtil.cellCount("Sheet1", 1);


        String loginData[][] = new String[totalRows][totalCells];//created for two dimension array which can store

        for (int i = 1; i < totalRows; i++) { //read  the data from xl storing in two dimensional array

            for (int j = 0; j < totalCells; j++) {
                loginData[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
            }

        }
        return loginData;//returning two dimensional array
    }

    //Data Provider2


    //Data Provider3


    //Data Provider4
}
