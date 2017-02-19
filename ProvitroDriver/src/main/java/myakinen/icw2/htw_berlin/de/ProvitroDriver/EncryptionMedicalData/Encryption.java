package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;

public class Encryption implements EncryptionInterface {

	@Override
	public EncryptionMedicalDataInterface getEncryption(int encryption) {
		
		// TODO Auto-generated method stub
		switch(encryption){
        case 1:
        	return  new EncryptionNexus();
            
        case 2:
        	return  new EncryptionDes();           
            
        case 3:
        	return  new EncryptionRC4();
        	
        case 4:
        	return  new EncryptionXOR();
        	
        case 0:	
        	return new EncryptionDCPathos();
        	
        default:
            System.out.println("Verschlüssung ist nicht gewählt");
        }
		return null;
	}

}
