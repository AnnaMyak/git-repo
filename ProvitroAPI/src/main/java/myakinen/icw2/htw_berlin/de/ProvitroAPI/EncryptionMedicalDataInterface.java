package myakinen.icw2.htw_berlin.de.ProvitroAPI;

public interface EncryptionMedicalDataInterface {
	
	public String EncryptData(String patientData, String key)throws Exception;
	public String DecryptData(String patientData, String key)throws Exception;

}
