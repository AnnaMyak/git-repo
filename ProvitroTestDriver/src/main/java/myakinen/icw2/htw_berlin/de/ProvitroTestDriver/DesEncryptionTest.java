package myakinen.icw2.htw_berlin.de.ProvitroTestDriver;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;

public class DesEncryptionTest {
	public EncryptionDes des;
	
	
	public void encryptionDes(String path) throws Exception
	{
		des = new EncryptionDes();
		String line = "";
		int z=0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 //System.out.println(line);
				 //String[] finding = line.split(";");
				 z++;
				 String testEncodedData = new String( des.EncryptData(line, "9111111111"));
				 String testDecodedData = new String (des.DecryptData(testEncodedData, "9111111111"));
				assertEquals(line,testDecodedData);
				 
			 }
			 } 

	}
	@Test
	public void EncryptionDesTest() throws Exception
	{
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test1.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test2.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test3.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test4.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test5.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test6.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test7.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test8.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test9.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test10.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test11.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test12.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test13.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test14.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test15.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test16.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test17.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test18.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test19.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test20.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test21.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test22.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test23.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test24.csv");
		encryptionDes("C:/Users/AnnaToshiba2/Desktop/testDriver/test25.csv");
	}

}
