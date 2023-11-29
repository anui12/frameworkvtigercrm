package Basic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelread {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//to read data from external resources
		FileInputStream file=new FileInputStream("src\\test\\resources\\skillrary.xlsx");
		
		//to read the data from excel
		Workbook wb=WorkbookFactory.create(file);

		//to get control of the sheet
		Sheet sh=wb.getSheet("sheet1");
		
		//to get control of the row
		Row rw = sh.getRow(0);
		
		//to get the control of column
		Cell cl = rw.getCell(1);
		
		//to get the value of the cell
		String data = cl.getStringCellValue();
		System.out.println(data);
		
		Row rw1 = sh.getRow(1);
		
		Cell cl1 = rw1.getCell(1);
		
		String data1 = cl1.getStringCellValue();
		System.out.println(data1);
		
		Row rw2 = sh.getRow(2);
		
		Cell cl2 = rw2.getCell(2);
		
		String data2 = cl2.getStringCellValue();
		System.out.println(data2);
		
	}
}
