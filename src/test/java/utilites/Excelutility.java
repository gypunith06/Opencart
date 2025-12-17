
package utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility{
	public  FileInputStream fi;
	public  FileOutputStream fo;
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	public  XSSFRow row;
	 public XSSFCell cell;
 String path;

public Excelutility(String path)
{
	this.path=path;
}
public int getRowcount(String sheetname) throws IOException
{
	 fi = new FileInputStream(path);
	  book = new XSSFWorkbook(fi);
	    sheet = book.getSheet(sheetname);
	    int rowcount = sheet.getLastRowNum();
	    book.close();
	    fi.close();
	    return rowcount;
	    
}
public int getcellcount(String sheetname,int rownum) throws IOException
{
	  fi = new FileInputStream(path);
	   book = new XSSFWorkbook(fi);
	   sheet = book.getSheet(sheetname);
	     row = sheet.getRow(rownum);
	    int celcount = row.getLastCellNum();
	    book.close();
	    fi.close();
	    return celcount;
}
public String getcelldaat(String sheetname,int rownum,int colum) throws IOException
{
	  fi = new FileInputStream(path);
	   book = new XSSFWorkbook(fi);
	   sheet = book.getSheet(sheetname);
	     row = sheet.getRow(rownum);
	     cell = row.getCell(colum);
	     
	     String data;
	     try {
			 data=cell.toString();
		} catch (Exception e) {
			data="";
		}
	    book.close();
	    fi.close();
	   return data;
}
public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException

{
File xlfile=new File(path);
if(!xlfile.exists())
{

book=new XSSFWorkbook();

fo=new FileOutputStream(path);

book.write(fo);

}

fi=new FileInputStream(path);

book=new XSSFWorkbook(fi);

if(book.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
book.createSheet(sheetName);
sheet =book.getSheet(sheetName);

if(sheet.getRow(rownum)==null) // If row not exists then create new Row

sheet.createRow(rownum);

row=sheet.getRow(rownum);
cell=row.createCell(colnum);

cell.setCellValue(data);

fo=new FileOutputStream(path);

book.write(fo);

book.close();

fi.close();

fo.close();

}

}
