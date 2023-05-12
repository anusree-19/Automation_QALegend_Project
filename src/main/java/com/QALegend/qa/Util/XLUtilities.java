package com.QALegend.qa.Util;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	public class XLUtilities {
		public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook workbook;
		public XSSFSheet sheet;
		public XSSFRow row;
		public XSSFCell cell;
		public CellStyle style;   
		String path;
		
		public XLUtilities(String path)
		{
			this.path=path;
		}
			
		public int getRowCount(String sheetName) throws IOException 
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			int rowcount=sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;		
		}
		

		public int getCellCount(String sheetName,int rownum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			int cellcount=row.getLastCellNum();
			workbook.close();
			fi.close();
			return cellcount;
		}
		
		
		public String getCellData(String sheetName,int rownum,int colnum) throws IOException
		{
			fi=new FileInputStream(path);
			workbook=new XSSFWorkbook(fi);
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rownum);
			cell=row.getCell(colnum);
			
			DataFormatter formatter = new DataFormatter();
			String data;
			try{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
			}
			catch(Exception e)
			{
				data="";
			}
			workbook.close();
			fi.close();
			return data;
		}	
		

		// FOR simpledemopage.java and datadrivenutility
		
		public static String[][] tdata() throws IOException{
			String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\QALegend\\qa\\Testdata\\users.xlsx";
			XLUtilities xlutil=new XLUtilities(path);
			
			int totalrows=xlutil.getRowCount("Sheet1");
			int totalcols=xlutil.getCellCount("Sheet1",1);	
					
			String loginData[][]=new String[totalrows][totalcols];
				
			
			for(int i=1;i<=totalrows;i++) //1
			{
				for(int j=0;j<totalcols;j++) //0
				{
					loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				}
					
			}
			
			return loginData;
			
			
			
		}

		
	}

	

