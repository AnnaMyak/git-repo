package myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import myakinen.icw2.htw_berlin.de.Config.Configuration;
import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncryptionMedicalFindings;
import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncyptionMedicalFindingsSecond;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.Encryption;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionXOR;



public class ExcelOperations implements TablesOperationsInterface  {

	private EncryptionMedicalDataInterface encryptionInstance;
	private EncryptionMedicalFindingsInterface encrMedFind;
	private ConfigurationInterface config;
	
	

	public void managerEncryptor(String path, int encryption, String key) throws Exception
	{
		boolean testDataStructure=true;
		config = new Configuration();
		ArrayList<String> configurations = config.getConfigurations("Config2");
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList <String> finding = new ArrayList<String>();
		XSSFWorkbook wb;
		encrMedFind = new EncryptionMedicalFindings ();
		//encrMedFind = new EncyptionMedicalFindingsSecond ();
		encryptionInstance= new Encryption ().getEncryption(encryption);
		
		try {
			wb = new XSSFWorkbook(new File(path));
			XSSFSheet sheet = wb.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			
			if (testDataStructure){
			for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
				
				//Test Data structure
				if (list.size()==1)
				{
					if (list.get(0).equals(configurations))
					{
						System.out.println("Datei richtig ist richtig konfiguriert");
					}
					else
					{
						testDataStructure=false;
						System.out.println("Datei richtig wurde falsch konfiguriert");
						System.out.println("Weitere Bearbeitung ist nicht möglich");
						System.out.println("Kongigurieren Sie bitte die Datei neu");
					}
				}

				XSSFRow row = (XSSFRow) iterator.next();
			    //System.out.println("CELLS "+ row.getPhysicalNumberOfCells());
			    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) 
			    {
			    	finding.add(formatter.formatCellValue(row.getCell(i)));				    	
			    }
			            		
        		//Encrypt Data
        		
        		if (list.size() >0)
        		{
        			finding.set(1, encryptionInstance.EncryptData(finding.get(1), key));
        			finding.set(5, encrMedFind.Encrypt(finding.get(5), key, encryption));
        		}

        		list.add(finding);
        		finding= new ArrayList<String>();
        		

			}
			    
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testDataStructure){
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Encrypted Medical Data ");
        for (int i=0; i<list.size(); i++) 
        	{
        	   Row r = sheet.createRow(i);
        	   for (int j=0; j<list.get(1).size(); j++)
        	   {
        		   
        		   r.createCell(j).setCellValue( list.get(i).get(j) );   
        	   }
        	}
        try {
            FileOutputStream outputStream = new FileOutputStream("C:/Users/AnnaToshiba2/Desktop/ICW2/outputXLS/EncryptedData"+".xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		}
        

	
	
		
	
	

	@Override
	public void managerDecryptor(String path, int encryption, String key) throws IOException, Exception {
		// TODO Auto-generated method stub
		boolean testDataStructure=true;
		config = new Configuration();
		ArrayList<String> configurations = config.getConfigurations("Config2");;
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList <String> finding = new ArrayList<String>();
		XSSFWorkbook wb;
		encrMedFind = new EncryptionMedicalFindings ();
		//encrMedFind = new EncyptionMedicalFindingsSecond ();
		encryptionInstance= new Encryption().getEncryption(encryption);
		
		try {
			wb = new XSSFWorkbook(new File(path));
			XSSFSheet sheet = wb.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			
			if (testDataStructure){
			for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
				
				//Test Data structure
				if (list.size()==1)
				{
					if (list.get(0).equals(configurations))
					{
						System.out.println("Datei richtig ist richtig konfiguriert");
					}
					else
					{
						testDataStructure=false;
						System.out.println("Datei richtig wurde falsch konfiguriert");
						System.out.println("Weitere Bearbeitung ist nicht möglich");
						System.out.println("Kongigurieren Sie bitte die Datei neu");
					}
				}

				XSSFRow row = (XSSFRow) iterator.next();
			    //System.out.println("CELLS "+ row.getPhysicalNumberOfCells());
			    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) 
			    {
			    	finding.add(formatter.formatCellValue(row.getCell(i)));				    	
			    }
			    
        		
        		//Encrypt Data
        		
        		if (list.size() >0)
        		{
        			finding.set(1, encryptionInstance.DecryptData(finding.get(1), key));
        			finding.set(5, encrMedFind.Decrypt(finding.get(5), key, encryption));
        		}
			    
        		
        		
        		list.add(finding);
        		finding= new ArrayList<String>();
        		

			}
			    
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (testDataStructure){
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Decrypted Medical Data ");
        for (int i=0; i<list.size(); i++) 
        	{
        	   Row r = sheet.createRow(i);
        	   for (int j=0; j<list.get(1).size(); j++)
        	   {
        		   
        		   r.createCell(j).setCellValue( list.get(i).get(j) );   
        	   }
        	}
        try {
            FileOutputStream outputStream = new FileOutputStream("C:/Users/AnnaToshiba2/Desktop/ICW2/outputXLS/DecryptedData"+".xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		}
		
	}
	
	
	}
