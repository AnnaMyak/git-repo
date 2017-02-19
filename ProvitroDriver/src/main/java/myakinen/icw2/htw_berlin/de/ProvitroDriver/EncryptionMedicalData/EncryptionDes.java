package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.DESKeySpec;
import javax.xml.bind.DatatypeConverter;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;

public class EncryptionDes implements EncryptionMedicalDataInterface {
	private final static Logger LOGGER = Logger.getLogger(EncryptionDes.class.getName());

	/*
	 * Verwendete Verschlüsselung: DES im ElectronicCodeBook-Modus (ECB)
	 * mit PKCS5-Padding. Padding ist nötig, da sowohl RootPatient als 
	 * auch USCHL nicht in einen DES-Block (64Bit, 8Byte) passen.
	 * PKCS5Padding wird auch von OpenSSL verwendet: openssl enc -DES-ECB -nosalt
	 */
	private static String CIPHER_TRANSFORMATION = "DES/ECB/PKCS5Padding";
	
	private Cipher cip_enc;
	private Cipher cip_dec;
	
	public EncryptionDes(){}
	
	public EncryptionDes(String password)
	throws UnsupportedEncodingException,InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
		this(password.getBytes("UTF-8"));
	}
	
	
	public EncryptionDes(byte[] key)
	throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException{

		// Schlüsselerzeugung: Es werden die rohen Schlüsselbytes verwendet, ggf aufgefüllt mit 0Bytes oder gekürzt
		KeySpec desKeySec 					= new DESKeySpec(key);
		SecretKeyFactory secretKeyFactory 	= SecretKeyFactory.getInstance("DES");
		SecretKey secretKey 				= secretKeyFactory.generateSecret(desKeySec);

		// Cipher-Initialisierung
		this.cip_enc 							= Cipher.getInstance(CIPHER_TRANSFORMATION);
		this.cip_enc.init(Cipher.ENCRYPT_MODE, secretKey);
		
		this.cip_dec 							= Cipher.getInstance(CIPHER_TRANSFORMATION);
		this.cip_dec.init(Cipher.DECRYPT_MODE, secretKey);
	}
	
	
	public String pseudonym(String pid)
	throws UnsupportedEncodingException, ShortBufferException, BadPaddingException, IllegalBlockSizeException
	{
		return DatatypeConverter.printHexBinary(crypt(this.cip_enc, pid.getBytes("UTF-8")));
	}
	
	private byte[] crypt(Cipher cipher, byte[] message)
	throws ShortBufferException, BadPaddingException, IllegalBlockSizeException {
	
		byte[] out= new byte[cipher.getOutputSize(message.length)];

		//Ver- Entschlüsselung
		int out_len = cipher.update(message, 0, message.length, out, 0);
		out_len += cipher.doFinal(out, out_len);
		
		// Säubern des Outputs. ZB 0-Bytes des Paddings entfernen.
		byte[] out_clean;
		if (out_len == out.length){
			out_clean = out;
		}else {
			out_clean = new byte[out_len];
			System.arraycopy(out, 0, out_clean, 0, out_len);
		}
		
		return out_clean;
	}

	
	public String depseudonym(String pseudonym)
	throws UnsupportedEncodingException,InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
	IllegalBlockSizeException, BadPaddingException,ShortBufferException{
		return new String(crypt(this.cip_dec, DatatypeConverter.parseHexBinary(pseudonym) ));
	}


	public String EncryptData(String patientData, String key) throws Exception {
		// TODO Auto-generated method stub
		
		EncryptionDes pseudGen = new EncryptionDes(key);
		return pseudGen.pseudonym(patientData);
	}


	public String DecryptData(String patientData, String key) throws Exception {
		// TODO Auto-generated method stub
		EncryptionDes pseudGen = new EncryptionDes(key);
		return pseudGen.depseudonym(patientData);
		
	}

}
