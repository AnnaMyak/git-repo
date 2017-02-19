package myakinen.icw2.htw_berlin.de.ProvitroAPI;

public interface EncryptionMedicalFindingsInterface {
	
	public String Encrypt(String text, String key, int encryption)throws Exception;
	public String Decrypt (String text, String key, int encryption)throws Exception;

}
