package myakinen.icw2.htw_berlin.de.ProvitroAPI;

public interface WordOperationsInterface {
	public String readWord(String path);
	public void createWord(String path, String fileName, String content);
	public void wordManagerEncyptor();

}
