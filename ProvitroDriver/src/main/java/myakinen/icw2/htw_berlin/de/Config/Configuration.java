package myakinen.icw2.htw_berlin.de.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;

public class Configuration implements  ConfigurationInterface {

	@Override
	public ArrayList<String> getConfigurations(String configFile) {
		
		// TODO Auto-generated method stub
		
		ArrayList<String> config = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(configFile))) {
			config = (ArrayList<String>) br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
		
	}

	@Override
	public String[] getProperties() {
		
		// TODO Auto-generated method stub
		
		String fileName = "properties";
		ArrayList<String> properties = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			properties = (ArrayList<String>) br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] stockArr = new String[properties.size()];
		stockArr = properties.toArray(stockArr);
		return stockArr;
	}

	

}
