package myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import myakinen.icw2.htw_berlin.de.Config.Configuration;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;

public class CSVOperations implements TablesOperationsInterface {

	private ConfigurationInterface config;

	@Override
	public void managerEncryptor(String path, int encryption, int key) throws IOException, Exception {
		// TODO Auto-generated method stub
		
		String line = "";
		boolean testDataStructure= true;
		config = new Configuration();
		ArrayList<String> configurations = config.getConfigurations("Config");
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		if (testDataStructure)
		{
		 try (BufferedReader br = new BufferedReader(new FileReader(path))) 
		 {
			 while ((line = br.readLine()) != null)
			 {
				 String[] finding = line.split(",");
				 
				 //test Configuration
				 if (list.size()==0)
				 {


                   if (configurations.equals(new ArrayList<String>(Arrays.asList(finding))))
                   {
                	   System.out.println("Datei richtig wurde richtig konfiguriert");
                	   list.add(new ArrayList<String>(Arrays.asList(finding)));
                   }
                   else 
                   {
                	   	testDataStructure=false;
						System.out.println("Datei richtig wurde falsch konfiguriert");
						System.out.println("Weitere Bearbeitung ist nicht möglich");
						System.out.println("Kongigurieren Sie bitte die Datei neu");
                   }


				 }
				 
			 }
		 }
		 catch (IOException e)
		 {
			 e.printStackTrace();
		 }
		}
	}

	@Override
	public void managerDecryptor(String path, int encryption, int key) throws IOException, Exception {
		// TODO Auto-generated method stub
		
	}

}
