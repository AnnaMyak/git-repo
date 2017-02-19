package myakinen.icw2.htw_berlin.de.ProvitroTestDriver;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionXOR;

public class XOREncryptionTest {
public EncryptionXOR xor;

public void encryptionXor(String path) throws Exception
	{
	xor = new EncryptionXOR();
	String line = "";
	
	try (BufferedReader br = new BufferedReader(new FileReader(path))) 
	 {
		 while ((line = br.readLine()) != null)
		 {
			 String[] finding = line.split(";");
			 String encodedData1=xor.EncryptData(finding[0], "123");
			 String encodedData2=xor.EncryptData(finding[1], "123");
			 String decodedData1=xor.DecryptData(encodedData1, "123");
			 String decodedData2=xor.DecryptData(encodedData2, "123");
			 //System.out.println( finding[0]+" "+ decodedData1);
			 assertEquals(finding[0], decodedData1);
			 assertEquals(finding[1], decodedData2);
		 }
		 
	 }
	}
@Test
public void EncryptionXORTest() throws Exception
	{
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test1.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test2.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test3.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test4.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test5.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test6.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test7.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test8.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test9.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test10.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test11.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test12.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test13.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test14.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test15.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test16.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test17.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test18.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test19.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test20.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test21.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test22.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test23.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test24.csv");
		encryptionXor("C:/Users/AnnaToshiba2/Desktop/testDriver/test25.csv");
	}
}
