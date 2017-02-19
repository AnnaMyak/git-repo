package myakinen.icw2.htw_berlin.de.ProvitroAPI;

import java.io.IOException;



public interface TablesOperationsInterface {
	
	
	public void managerEncryptor(String path, int encryption, String key) throws IOException, Exception;
	public void managerDecryptor(String path, int encryption, String key) throws IOException, Exception;
}
