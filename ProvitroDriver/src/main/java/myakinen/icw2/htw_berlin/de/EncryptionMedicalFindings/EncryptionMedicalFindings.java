package myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionAES;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;

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
        	encryptionType = new EncryptionAES();
            break;
        case 2:
        	encryptionType = new EncryptionNexus();
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
		int iterator =constants.length; 
        //Wählen eine Verschlüssung
        switch(encryption){
        case 1:
        	encryptionType = new EncryptionAES();
            break;
        case 2:
        	encryptionType = new EncryptionNexus();
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

}
