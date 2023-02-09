package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {

	public static String[][] data() throws IOException
	  {
		  File f=new File("C:\\Users\\ctvla\\Downloads\\Selenium training\\Excel sheets\\Sample.xlsx");
			FileInputStream fis=new FileInputStream(f);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			
			int totalrows=sheet.getPhysicalNumberOfRows();
			Row rowcell=sheet.getRow(0);
			int totalcolumn=rowcell.getPhysicalNumberOfCells();
			DataFormatter format=new DataFormatter();
		  
		  
		  String [][] arr=new String[totalrows][totalcolumn];

		  for(int i=0;i<totalrows;i++)
		  {     

		     for(int j=0;j<totalcolumn;j++)
		     {
		  	   arr[i][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
		  	  // System.out.print(arr[i][j]+" ");
		  		
		  	}
		    // System.out.println();
		  }
	 return arr;
	  }
	}
