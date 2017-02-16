package myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
public class EncyptionMedicalFindingsSecond implements  EncryptionMedicalFindingsInterface{

	@Override
	public String Encrypt(String text, int key, int encryption) throws Exception {
		// TODO Auto-generated method stub
		String [] properties = getProperties();
		
       
         String result="";
         String[] spl=text.split(" +");
        for (int i=0; i<spl.length; i++)
        {
        	
        		for (int j=0; j<properties.length; j++)
        		{
        			if (properties[j].equals(spl[i]))
        			{
        				spl[i+1]="***";
        				spl[i+2]="***";
        				
        			}
        		}
				
        		
        	
        }
        
        for (int i=0; i<spl.length; i++)
        {
        	result= result +spl[i]+" ";
        }	
        
        
		return result;
	}

	@Override
	public String Decrypt(String text, int key, int encryption) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Depseudonymisierung ist nicht möglich");
		return "Depseudonymisierung ist nicht möglich";
	}
	
	public String[] getProperties () 
	{
		String fileName = "properties";
		ArrayList<String> properties = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			properties = (ArrayList<String>) br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] stockArr = new String[properties.size()];
		stockArr = properties.toArray(stockArr);
		return stockArr;
	}

}
