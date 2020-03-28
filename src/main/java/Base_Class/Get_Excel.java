package Base_Class;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Get_Excel {
	
	public  String[][] testdata=new String[2][2];
	
	public  String[][] get_Excel(String sheetname,int n1,int n2)
	
	{
		//String[][] s=new String[n1][n2];
		try {
			File f1=new File("src\\test\\resources\\TEST_DATA\\Login _data.xlsx");
			FileInputStream fI=new FileInputStream(f1);
			XSSFWorkbook wb=new XSSFWorkbook(fI);
			XSSFSheet sh=wb.getSheet(sheetname);
			
			for(int i=0;i<=n2;i++)
			{
				//int i=n1;
				XSSFRow R1=sh.getRow(i);
				for(int j=0;j<=1;j++)
				{

			XSSFCell c1=R1.getCell(j);
			
			testdata[i][j]=c1.getStringCellValue();
			System.out.println(testdata[i][j]);
			}
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return testdata;
		
		
		
		
	}
	

}
