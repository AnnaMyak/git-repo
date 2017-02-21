package myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import myakinen.icw2.htw_berlin.de.Config.Configuration;
import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncryptionMedicalFindings;
import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncyptionMedicalFindingsSecond;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.Encryption;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionXOR;

public class CSVOperations implements TablesOperationsInterface {

	private ConfigurationInterface config;
	private EncryptionMedicalDataInterface encryptionInstance;
	private EncryptionMedicalFindingsInterface encrMedFind;
	
	
	@Override
	public void managerEncryptor(String path, int encryption, String key) throws IOException, Exception {
		// TODO Auto-generated method stub
		String provitroDirectory=FileSystemView.getFileSystemView().getRoots()[0].toString().replace("\\", "/")+"/ProvitroToolOutputs/Encrypted/";
		File provitroDir= new File(provitroDirectory);
		boolean makeDir=false;
		
		
		
		
		
		
		
		encryptionInstance = new Encryption().getEncryption(encryption);
		String line = "";
		//encrMedFind = new EncyptionMedicalFindingsSecond ();
		
		encrMedFind = new EncryptionMedicalFindings ();
		boolean testDataStructure= true;
		
		config = new Configuration();
		ArrayList<String> configurations = config.getConfigurations("Config");
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> fullFinding;
		
		
		if (testDataStructure)
		{
		 try (BufferedReader br = new BufferedReader(new InputStreamReader(
			     new FileInputStream(path), "UTF-8"))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 //System.out.println(line);
				 String[] finding = line.split(";");
				 
				 //test Configuration
				 if (list.size()==0)
				 {


                   if (configurations.equals(new ArrayList<String>(Arrays.asList(finding))))
                   {
                	   System.out.println("Datei richtig wurde richtig konfiguriert");
                	   
                   }
                   else 
                   {
                	   	testDataStructure=false;
						System.out.println("Datei richtig wurde falsch konfiguriert");
						System.out.println("Weitere Bearbeitung ist nicht möglich");
						System.out.println("Kongigurieren Sie bitte die Datei neu");
                   }
                 }
                 	fullFinding=convertToList(finding);
                 	if (list.size()>0)
                   {
                	   fullFinding.set(1, encryptionInstance.EncryptData(fullFinding.get(1), key));
                	   fullFinding.set(5, encrMedFind.Encrypt(fullFinding.get(5), key, encryption));
                	   //System.out.println(fullFinding.get(5));
                   }
                   list.add(fullFinding);
                   

				 }
			//System.out.println("Size " + list.size());
			//Make Directory
			 if(!provitroDir.exists())
		    	{
					makeDir = provitroDir.mkdirs();
		    	}
			 	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
		    	Date date = new Date();
				String filePath=provitroDirectory+"--EncryptedDataCSV--"+dateFormat.format(date).toString()+".csv";
			 
			FileWriter writer = new FileWriter(filePath,false);
		 	for(ArrayList<String> finding: list)
		 	{
		 		for (String str :finding)
		 		{
		 			writer.append(str+";");
		 		}
		 		writer.append('\n');
		 	}	
			writer.flush();
		 	writer.close();
		 	}	
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }
		}
	}

	@Override
	public void managerDecryptor(String path, int encryption, String key) throws IOException, Exception {
		// TODO Auto-generated method stub
		String provitroDirectory=FileSystemView.getFileSystemView().getRoots()[0].toString().replace("\\", "/")+"/ProvitroToolOutputs/Decrypted/";
		File provitroDir= new File(provitroDirectory);
		boolean makeDir=false;
		String line = "";
		//encrMedFind = new EncyptionMedicalFindingsSecond ();
		encrMedFind = new EncryptionMedicalFindings ();
		boolean testDataStructure= true;
		config = new Configuration();
		ArrayList<String> configurations = config.getConfigurations("Config");
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> fullFinding;
		encryptionInstance= new Encryption().getEncryption(encryption);
		
		
		if (testDataStructure)
		{
		 try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 String[] finding = line.split(";");
				 
				 //test Configuration
				 if (list.size()==0)
				 {

                   if (configurations.equals(new ArrayList<String>(Arrays.asList(finding))))
                   {
                	   System.out.println("Datei richtig wurde richtig konfiguriert");
                	   
                   }
                   else 
                   {
                	   	testDataStructure=false;
						System.out.println("Datei richtig wurde falsch konfiguriert");
						System.out.println("Weitere Bearbeitung ist nicht möglich");
						System.out.println("Kongigurieren Sie bitte die Datei neu");
                   }
                 }
                 	fullFinding=convertToList(finding);
                 	if (list.size()>0)
                   {
                	   fullFinding.set(1, encryptionInstance.DecryptData(fullFinding.get(1), key));
                	   fullFinding.set(5, encrMedFind.Decrypt(fullFinding.get(5), key, encryption));
                	   //System.out.println(fullFinding.get(5));
                   }
                   list.add(fullFinding);
				 }
			 
			//Make Directory
			 if(!provitroDir.exists())
		    	{
					makeDir = provitroDir.mkdirs();
		    	}
			 	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd--HH-mm-ss");
		    	Date date = new Date();
				String filePath=provitroDirectory+"--DecryptedDataCSV--"+dateFormat.format(date).toString()+".csv";
			  
			//System.out.println("Size " + list.size());
			FileWriter writer = new FileWriter(filePath,false);
		 	for(ArrayList<String> finding: list)
		 	{
		 		for (String str :finding)
		 		{
		 			writer.append(str+";");
		 		}
		 		writer.append('\n');
		 	}	
			writer.flush();
		 	writer.close();
		 	}	
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }
		}
		
	}
	
	public ArrayList<String> convertToList(String[] arr)
	{
		ArrayList<String> list= new ArrayList<String>();
		for(int i=0; i<arr.length; i++)
		{
			list.add(arr[i]);
		}
		return list;
	}

}
