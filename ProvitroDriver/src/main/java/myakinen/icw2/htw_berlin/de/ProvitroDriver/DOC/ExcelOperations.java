package myakinen.icw2.htw_berlin.de.ProvitroDriver.DOC;

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

import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncryptionMedicalFindings;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ExcelOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;



public class ExcelOperations implements ExcelOperationsInterface  {

	private EncryptionMedicalDataInterface encryptionType;
	
	
	public void writeExcel() {
		// TODO Auto-generated method stub
	}

	public void excelManagerEncryptor(String path, int encryption, int key) throws Exception
	{
		boolean testDataStructure=true;
		ArrayList<String> config = getConfiguration ();
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList <String> finding = new ArrayList<String>();
		XSSFWorkbook wb;
		EncryptionMedicalFindingsInterface encrMedFind = new EncryptionMedicalFindings ();
		
		switch(encryption){
        case 1:
        	encryptionType = new EncryptionNexus();
            break;
        case 2:
        	encryptionType = new EncryptionDes();
            break;
            
        case 3:
        	encryptionType = new EncryptionRC4();
        	break;
        
        default:
            System.out.println("Verschlüssung ist nicht gewählt");
        }
		
		try {
			wb = new XSSFWorkbook(new File(path));
			XSSFSheet sheet = wb.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			
			if (testDataStructure){
			for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
				
				//Test Data structure
				if (list.size()==1)
				{
					if (list.get(0).equals(config))
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
	public void readExcel(String path) throws  IOException  {
		// TODO Auto-generated method stub
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> finding= new ArrayList<String>();
		
		XSSFWorkbook wb;
		
		try {
			wb = new XSSFWorkbook(new File(path));
			XSSFSheet sheet = wb.getSheetAt(0);
			DataFormatter formatter = new DataFormatter();
			for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
			    XSSFRow row = (XSSFRow) iterator.next();
			    System.out.println("CELLS "+ row.getPhysicalNumberOfCells());
			    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) 
			    {
			    	finding.add(formatter.formatCellValue(row.getCell(i)));				    	
			    }
			    list.add(finding);
        		finding= new ArrayList<String>();

			    //for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {  
			    //}
			    
			}
			
	
			System.out.println("SIZE "+ list.size() );
			System.out.println("SI "+ finding.size() );
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getConfiguration () 
	{
		String fileName = "Config2";
		ArrayList<String> config = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
			config = (ArrayList<String>) br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}
	
	
	}
