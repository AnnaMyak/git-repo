package myakinen.icw2.htw_berlin.de.ProvitroAPI;

import java.util.ArrayList;

public interface ConfigurationInterface {
	
	public ArrayList<String> getConfigurations(String  configFile);
	public String[] getProperties();

}
