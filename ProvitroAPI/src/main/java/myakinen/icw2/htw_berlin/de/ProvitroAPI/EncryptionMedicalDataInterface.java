package myakinen.icw2.htw_berlin.de.ProvitroAPI;

public interface EncryptionMedicalDataInterface {
	
	public String EncryptData(String patientData, int key)throws Exception;
	public String DecryptData(String PatinetData, int key)throws Exception;

}
