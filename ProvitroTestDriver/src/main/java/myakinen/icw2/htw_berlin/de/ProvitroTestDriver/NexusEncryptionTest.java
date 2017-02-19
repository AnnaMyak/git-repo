package myakinen.icw2.htw_berlin.de.ProvitroTestDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.*;

import org.junit.Test;

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;

public class NexusEncryptionTest {
public EncryptionNexus nex;

public void ecryptionNexus (String path) throws Exception
	{
		nex = new EncryptionNexus();
		String line="";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 //System.out.println(line);
				 String[] finding = line.split(";");
				 String encodedData1=nex.EncryptData(finding[0], "12345678");
				 String encodedData2=nex.EncryptData(finding[1], "12345678");
				 String decodedData1=nex.DecryptData(encodedData1, "12345678");
				 String decodedData2=nex.DecryptData(encodedData2, "12345678");
				 assertEquals(finding[0],decodedData1);
				 assertEquals(finding[1],decodedData2);
			 }
		 }
	}
@Test
public void ecryptionNexusTest() throws Exception
	{
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test1.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test2.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test3.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test4.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test5.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test6.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test7.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test8.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test9.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test10.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test11.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test12.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test13.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test14.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test15.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test16.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test17.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test18.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test19.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test20.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test21.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test22.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test23.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test24.csv");
	ecryptionNexus("C:/Users/AnnaToshiba2/Desktop/testDriver/test25.csv");
	}

}
