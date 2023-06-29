package util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.Loggers;

public class GetExcelData {
	
	public Object[][] read_excel_sheet1() throws InvalidFormatException, IOException{
		File myfile=new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources"  + File.separator + "invalid login data.xlsx");
		Loggers.logger.info("reading excel file");
		XSSFWorkbook wb=new XSSFWorkbook(myfile);
		//identify required sheet
			XSSFSheet mysheet=wb.getSheet("Sheet1");
			Loggers.logger.info("getting sheet1");
		//get number of rows
			int number_of_rows= mysheet.getPhysicalNumberOfRows();
			Loggers.logger.info("getting number of rows");
			System.out.println(number_of_rows);
			//get number of columns
			int number_of_columns= mysheet.getRow(0).getLastCellNum();
			Loggers.logger.info("getting number of columns");
			System.out.println(number_of_columns);
		//create multidimensional array
			String[][] myarray=new String[number_of_rows-1][number_of_columns];

			//create for loop over rows and inner for loop over columns
			for(int i=1;i<number_of_rows;i++){
				for(int a=0;a<number_of_columns;a++){
		//define row number with the variable in for loop
					XSSFRow row=mysheet.getRow(i);
					Loggers.logger.info("get row"+String.valueOf(i));
		//define cell 
					 if (row != null && row.getCell(a) != null) {
			                if (row.getCell(a).getCellType() == CellType.NUMERIC) {
			                    myarray[i - 1][a] = String.valueOf(row.getCell(a).getNumericCellValue());
			                    Loggers.logger.info("add numeric value to array");
			                   
			                } else if (row.getCell(a).getCellType() == CellType.STRING) {
			                    myarray[i - 1][a] = row.getCell(a).getStringCellValue();
			                    Loggers.logger.info("add string value to array");
			      
			                } else if (row.getCell(a).getCellType() == CellType.BOOLEAN) {
			                    myarray[i - 1][a] = String.valueOf(row.getCell(a).getBooleanCellValue());
			                    Loggers.logger.info("add boolean value to array");
			                } else {
			                    myarray[i - 1][a] = "";
			                }
			            } else {
			                myarray[i - 1][a] = "";
			            }
			        }
			    }
			    wb.close();
			    Loggers.logger.info("close workbook");
			    return myarray;

}

}
