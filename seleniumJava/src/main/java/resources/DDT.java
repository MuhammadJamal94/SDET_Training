package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DDT {
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> testData=new ArrayList<String>();
		
		//System.out.println("Im here");
		//File Input stream argument to pass to workBook
		//FileInputStream fis=new FileInputStream("E://SeleniumCrossOver//MyBook.xlsx");
		String path=System.getProperty("user.dir")+"\\MyBook.xlsx";
		FileInputStream fis=new FileInputStream(path);
		//FileInputStream fis=new FileInputStream("C://Users//DELL//eclipse-workspace//seleniumJava//MyBook.xlsx");
		XSSFWorkbook myWorkBook =new XSSFWorkbook(fis);
		System.out.println("Sheets Name "+path);
		//To get the number in the sheet
		int sheetsCount = myWorkBook.getNumberOfSheets();
		System.out.println("# of sheets "+sheetsCount );
		//Loop until the desired sheet is found
		for(int i=0;i<sheetsCount;i++)
		{
			//System.out.println("Im here");
			if(myWorkBook.getSheetName(i).equalsIgnoreCase("Tests"))
			{
				XSSFSheet mySheet=myWorkBook.getSheetAt(i);
				
				//Identify Test Cases column by scanning the entire row
				Iterator<Row> rows = mySheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int j=0;
				int column=0;
				
				while(cells.hasNext())
				{
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
					
						//Desired column
						column=j;
						
						
					}
					j++;
					
				}
				System.out.println(column);
				
				//Once we got the correct row we will scan the whole data set
				while(rows.hasNext())
				{
					Row r =rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							Cell value =cv.next();
							
							//To check on the type of the value in the cell before processing the value
							if(value.getCellType()==CellType.STRING)
							{
								testData.add(value.getStringCellValue());
							}
							//Handle the numeric values
							else
								testData.add(NumberToTextConverter.toText(value.getNumericCellValue()));
						}
					}
					
				}
				
			}
		}
		
		myWorkBook.close();
		
		return testData;
	}

	public static void main(String[] args) {
		
		
		
	}

}
