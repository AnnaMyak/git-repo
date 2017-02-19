package myakinen.icw2.htw_berlin.de.ProvitroTestDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;

public class RC4EncryptionTest {
	public EncryptionRC4 rc4;
	
	public void encryptionRC4(String path) throws Exception
	{
		rc4 = new EncryptionRC4();
		String line = "";
		int z=0;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 String[] finding = line.split(";");
				 String encodedData = rc4.EncryptData(line, "9111111111");
				 String decodedData = rc4.DecryptData(encodedData, "9111111111");
				 assertEquals(line, decodedData);
				
			 }
		}
	}
	
	@Test
	public void EncyptionRC4Test() throws Exception
	{
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test1.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test2.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test3.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test4.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test5.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test6.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test7.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test8.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test9.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test10.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test11.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test12.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test13.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test14.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test15.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test16.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test17.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test18.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test19.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test20.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test21.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test22.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test23.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test24.csv");
		encryptionRC4("C:/Users/AnnaToshiba2/Desktop/testDriver/test25.csv");
		
	}

}
