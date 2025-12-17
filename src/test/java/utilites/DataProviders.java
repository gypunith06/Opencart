package utilites;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
@DataProvider(name = "LoginData")
public String [][] getdata() throws IOException
{
	String path=".\\testdata\\myfile.xlsx";
	
	Excelutility xlutil = new Excelutility(path);
	int totalrows = xlutil.getRowcount("data");
	int totalcolum = xlutil.getcellcount("data", 1);
	String[][] logindata = new String[totalrows][totalcolum];
	for(int i=1;i<=totalrows;i++)
	{
		for(int j=0;j<totalcolum;j++)
		{
			 logindata[i-1][j] = xlutil.getcelldaat("data", i, j);
		}
	}
	return logindata;
	
}
}
