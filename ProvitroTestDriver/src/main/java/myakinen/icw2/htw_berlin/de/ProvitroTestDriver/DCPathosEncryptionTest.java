package myakinen.icw2.htw_berlin.de.ProvitroTestDriver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;

public class DCPathosEncryptionTest {
	public EncryptionDCPathos dc;
	
	public void encryptionDCPathosTest(String path) throws IOException, Exception
	{
		String line = "";
        EncryptionDCPathos dc = new EncryptionDCPathos();
    	try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 //System.out.println(line);
				 String[] finding = line.split(";");
				 String testEncodedData = new String( dc.EncryptData(finding[0], "0906585032"));
				 String testDecodedData = new String (dc.DecryptData(finding[1], "0906585032"));
				 if (finding[1].equals(testEncodedData)==false)
				 {
					 System.out.println("Original: " +finding[0]+ " "+ finding[1]+ " Verschl: " +testDecodedData +" "+testEncodedData);
				 }
				 assertTrue(finding[1].equals(testEncodedData));
				 assertTrue(finding[0].equals(testDecodedData));
			 }
			 }	
	}
	
	@Test
	public void EncryptionDCPathosTest() throws IOException, Exception
	{
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test1.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test2.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test3.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test4.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test5.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test6.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test7.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test8.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test9.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test10.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test11.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test12.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test13.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test14.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test15.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test16.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test17.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test18.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test19.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test20.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test21.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test22.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test23.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test24.csv");
		encryptionDCPathosTest("C:/Users/AnnaToshiba2/Desktop/testDriver/test25.csv");
	}
	
	
}
