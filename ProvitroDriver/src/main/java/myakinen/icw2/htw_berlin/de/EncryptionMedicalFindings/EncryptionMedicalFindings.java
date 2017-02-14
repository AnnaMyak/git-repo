package myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;

public class EncryptionMedicalFindings implements EncryptionMedicalFindingsInterface
{
	
	
public EncryptionMedicalDataInterface encryptionType;

public static  String[] constants ={"FallNummer:", "Dr.", "OA.", "OÄ","Name:", "Vorname:" };

	
	public String Encrypt(String text, int key, int encryption) throws Exception {
		
		// TODO Auto-generated method stub
        int iterator =constants.length; 
        //Wählen eine Verschlüssung
        switch(encryption){
        case 1:
        	encryptionType = new EncryptionNexus();
            break;
        case 2:
        	encryptionType = new EncryptionDes();
            break;
            
        case 3:
        	encryptionType = new EncryptionRC4();
        	break;
        
        default:
            System.out.println("Verschlüssung ist nicht gewählt");
        }
         String result="";
         String[] spl=text.split(" +");
        for (int i=0; i<spl.length; i++)
        {
        	for (int j=0; j<constants.length; j++)
        	{
        		if (new String(constants[j]).equals(spl[i]))
        				{
        					spl[i+1]=encryptionType.EncryptData(spl[i+1], key);
        					spl[i+2]=encryptionType.EncryptData(spl[i+1], key);
        				}
        	}
        }
        
        for (int i=0; i<spl.length; i++)
        {
        	result= result +spl[i]+" ";
        }	
        	
        
		return result;
	}


	public String Decrypt(String text, int key, int encryption) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> properties = getProperties();
		//int iterator =constants.length;
		int iterator = properties.size();
        //Wählen eine Verschlüssung
        switch(encryption){
        case 1:
        	encryptionType = new EncryptionNexus();
            break;
        case 2:
        	encryptionType = new EncryptionDes();
            break;
            
        case 3:
        	encryptionType = new EncryptionRC4();
        	break;
        
        default:
            System.out.println("Verschlüssung ist nicht gewählt");
        }
         String result="";
         String[] spl=text.split(" +");
        
         for (int i=0; i<spl.length; i++)
         {
         	for (int j=0; j<iterator; j++)
         	{
         		if (properties.get(j).equals(spl[i]))
         				{
         					spl[i+1]=encryptionType.DecryptData(spl[i+1], key);
         				}
         	}
         }
         
         for (int i=0; i<spl.length; i++)
         {
         	result= result +spl[i]+" ";
         }	
 		return result;
	}
	
	public ArrayList<String> getProperties () 
	{
		String fileName = "properties.txt";
		ArrayList<String> properties = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			properties = (ArrayList<String>) br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		properties.forEach(System.out::println);
		return properties;
	}

}
