package myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;

public class EncryptionXOR implements EncryptionMedicalDataInterface {

	private byte[] key;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	private final static Charset ENCODING = StandardCharsets.ISO_8859_1; 
	
	public EncryptionXOR(String password) throws UnsupportedEncodingException {
		this(password.getBytes(ENCODING));
	}
	
	public EncryptionXOR(byte[] key){
		this.key = key;
	}
	public EncryptionXOR()
	{
		
	}
	
	
	
	private byte[] Xor(byte[] input) 
			throws IOException{
				//Streams für input, key und ergebnis
				ByteArrayInputStream keyBIS = new ByteArrayInputStream(this.key);
				ByteArrayInputStream inputBIS = new ByteArrayInputStream(input);
				ByteArrayOutputStream resultBOS = new ByteArrayOutputStream(input.length); //Ausgabe ist =lang wie eingabe
				
				// puffer für je ein byte input, key und ergebnis
				byte[] inbuff = new byte[1];
				byte[] keybuff = new byte[1];
				byte[] resBuff = new byte[1];
				while (inputBIS.read(inbuff) != -1) {
					//wenn key kürzer als eingabe, dann resete den stream
					if (keyBIS.read(keybuff) == -1 ){
						keyBIS.reset();
						keyBIS.read(keybuff);
					}
					
					//XOR auf dem 0Byte der Puffer 
					resBuff[0] = (byte)(inbuff[0] ^ keybuff[0]);
					resultBOS.write(resBuff);
				}
				
				return resultBOS.toByteArray();
			}
	public String pseudonym(String pid) 
			throws UnsupportedEncodingException, IOException
	{
				
				//pid ist string. wird in byte[] konvertiert
				byte[] pseudonym = Xor(pid.getBytes(ENCODING));
				return DatatypeConverter.printHexBinary(pseudonym);
			}
			

	public String depseudonym(String pidHexPseudonym) throws IOException
	{
				
				//pidHexPseudonym ist hex. wird in byte[] konvertiert.
				byte[] pid = Xor(DatatypeConverter.parseHexBinary(pidHexPseudonym));
				return new String(pid, ENCODING);
				
	}
	
	public String EncryptData(String patientData, String key) throws Exception {
		// TODO Auto-generated method stub
		EncryptionXOR xorInstance = new EncryptionXOR(key); 
		return xorInstance.pseudonym(patientData);
	}

	
	public String DecryptData(String patientData, String key) throws Exception {
		// TODO Auto-generated method stub
		EncryptionXOR xorInstance = new EncryptionXOR(key); 
		return xorInstance.depseudonym(patientData);
	}

}
