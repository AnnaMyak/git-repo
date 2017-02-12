package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

//Symmetric AES
public class EncryptionAES implements EncryptionMedicalDataInterface {
	
	
	public String EncryptData(String patientData, int key)throws Exception {
        String keyStr = new Integer(key).toString();
        byte[] keyByteAr = (keyStr).getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        keyByteAr = sha.digest(keyByteAr);
        keyByteAr = Arrays.copyOf(keyByteAr, 16); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyByteAr, "AES"); 
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(patientData.getBytes());
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(encrypted);

	}
	
	
	
	//Original Kirstein-Algorithm decrypt root patient Data
	public String DecryptData(String patientData, int key)throws Exception {
		
		String keyStr = new Integer(key).toString();
        byte[] keyByteAr = (keyStr).getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        keyByteAr = sha.digest(keyByteAr);
        keyByteAr = Arrays.copyOf(keyByteAr, 16); 
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyByteAr, "AES"); 
		// BASE64 String zu Byte-Array konvertieren
        BASE64Decoder myDecoder2 = new BASE64Decoder();
        byte[] crypted = myDecoder2.decodeBuffer(patientData);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] cipherData = cipher.doFinal(crypted);
		return new String(cipherData);
		
	}

}
