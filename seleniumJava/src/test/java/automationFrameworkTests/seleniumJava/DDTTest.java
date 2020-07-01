package automationFrameworkTests.seleniumJava;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import resources.DDT;

public class DDTTest {
	
	@Test
	public void dataTestCase() throws IOException
	{
		System.out.println("GUCCI GANG");
		DDT excel = new DDT();
		ArrayList x = excel.getData("Smoke");
		//System.out.println(x.get(0));
		System.out.println(x.get(1));
		//System.out.println(x.get(2));
		//System.out.println(x.get(3));
	}

}
