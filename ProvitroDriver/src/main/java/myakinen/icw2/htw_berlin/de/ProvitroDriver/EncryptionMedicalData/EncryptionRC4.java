package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;

public class EncryptionRC4 implements EncryptionMedicalDataInterface  {
	private final static Logger LOGGER = Logger.getLogger(EncryptionRC4.class.getName());

	/*
	 * Verwendete Verschlüsselung: RC4
	 * Wird auch von OpenSSL unterstützt: openssl enc -RC4-40 -nosalt
	 * ACHTUNG: Wenn Schlüssel länger als 40Bit(5Byte) ist die 
	 * Kompatibilität zu OpenSSl nicht mehr gegeben.
	 */
	private static String CIPHER_TRANSFORMATION = "RC4";
	
	private Cipher cip_enc;
	private Cipher cip_dec;
	
	
	public EncryptionRC4(){}
	
	public EncryptionRC4(String hexPassword) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
	{
		this(DatatypeConverter.parseHexBinary(hexPassword));
	}
	
	
	public EncryptionRC4(byte[] key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException
{

		Key secretKey = new SecretKeySpec(key, "RC4");
	
		// Cipher-Initialisierung
		this.cip_enc 							= Cipher.getInstance(CIPHER_TRANSFORMATION);
		this.cip_enc.init(Cipher.ENCRYPT_MODE, secretKey);
		
		this.cip_dec 							= Cipher.getInstance(CIPHER_TRANSFORMATION);
		this.cip_dec.init(Cipher.DECRYPT_MODE, secretKey);
	}
	
	
	public String pseudonym(String pid) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException

	{
		return DatatypeConverter.printHexBinary(crypt(this.cip_enc, pid.getBytes("UTF-8")));
	}
	
	public String depseudonym(String pseudonym) throws ShortBufferException, BadPaddingException, IllegalBlockSizeException
	{
		return new String(crypt(this.cip_dec, DatatypeConverter.parseHexBinary(pseudonym) ));
	}
	
	
	private byte[] crypt(Cipher cipher, byte[] message) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException
	 {
	
		byte[] out= new byte[cipher.getOutputSize(message.length)];

		//Ver- Entschlüsselung
		int out_len = cipher.update(message, 0, message.length, out, 0);
		out_len += cipher.doFinal(out, out_len);
		
		return out;
	}


	public String EncryptData(String patientData, int key) throws Exception {
		// TODO Auto-generated method stub
				StringBuilder provitKeyInt = new StringBuilder();
				provitKeyInt.append("");
				provitKeyInt.append(key);
				String provitKey = provitKeyInt.toString();
				EncryptionRC4 pseudGen = new EncryptionRC4(provitKey);
				return pseudGen.pseudonym(patientData);
	}


	public String DecryptData(String patientData, int key) throws Exception {
		// TODO Auto-generated method stub
				StringBuilder provitKeyInt = new StringBuilder();
				provitKeyInt.append("");
				provitKeyInt.append(key);
				String provitKey = provitKeyInt.toString();
				EncryptionRC4 pseudGen = new EncryptionRC4(provitKey);
				return pseudGen.depseudonym(patientData);
	}

}
