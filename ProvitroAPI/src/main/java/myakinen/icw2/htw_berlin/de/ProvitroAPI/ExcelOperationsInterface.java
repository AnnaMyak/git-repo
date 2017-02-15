package myakinen.icw2.htw_berlin.de.ProvitroAPI;

import java.io.IOException;



public interface ExcelOperationsInterface {
	
	public void readExcel(String path)throws  IOException;
	public void writeExcel();
	public void excelManagerEncryptor(String path) throws IOException;
}
