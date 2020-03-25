package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	
	public static int getRowCount(String path,String sheet) throws EncryptedDocumentException, IOException
	{
		int rc=0;
		
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		 rc=wb.getSheet(sheet).getLastRowNum();
		 return rc;
	}
	
	public static String getCellValue(String path,String sheet,int r,int c) throws EncryptedDocumentException, IOException
	{
		String v="";
		FileInputStream fis=new FileInputStream(path);
		Workbook wb=WorkbookFactory.create(fis);
		v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		return v;
				
		
	}

}
