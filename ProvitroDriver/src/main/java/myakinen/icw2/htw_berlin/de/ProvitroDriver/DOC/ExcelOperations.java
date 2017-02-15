package myakinen.icw2.htw_berlin.de.ProvitroDriver.DOC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
	
	public void readExcel() {
		// TODO Auto-generated method stub
		try
        {
            String excelPath = "C:/Users/AnnaToshiba2/Desktop/ICW2/provitro.xlsx";
            FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

            // Create Workbook instance holding .xls file
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            // Get the first worksheet
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext())
            {
                // Get Each Row
                Row row = rowIterator.next();

                // Iterating through Each column of Each Row
                Iterator<Cell> cellIterator = row.cellIterator();
                
                System.out.println("Row: " + row.getRowNum());
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    System.out.println("Cell: "+cell.getColumnIndex());
                    // Checking the cell format
                    switch (cell.getCellType())
                    {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue() + "\t");
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t");
                        break;
                    
                    }
                }

            }

        } catch (IOException ie)
        {
            ie.printStackTrace();
        }
	}
	
	public void writeExcel() {
		// TODO Auto-generated method stub

		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        Object[][] datatypes = {
                {"Datatype", "Type"},
                {"int", "Primitive"},
                {"float", "Primitive"},
                {"double", "Primitive"},
                {"char", "Primitive"},
                {"String", "Non-Primitive"}
        };
        int rowNum = 0;
       

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                    cell.setCellValue((String) field);
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

        System.out.println("Done");

	}

	public void excelManagerEncryptor(String path, int encryption, int key) throws Exception
	{
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
			for (Iterator iterator = sheet.rowIterator(); iterator.hasNext();) {
			    XSSFRow row = (XSSFRow) iterator.next();
			    System.out.println("CELLS "+ row.getPhysicalNumberOfCells());
			    for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) 
			    {
			    	finding.add(formatter.formatCellValue(row.getCell(i)));				    	
			    }
			    list.add(finding);
        		finding= new ArrayList<String>();

			    
			    
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Encrypted Medical Data ");
        for (int i=0; i<list.size(); i++) 
        	{
        	   Row r = sheet.createRow(i);
        	   for (int j=0; j<list.get(1).size(); j++)
        	   {
        		   if (j==1)
        		   {
        			  
						r.createCell(j).setCellValue( encryptionType.EncryptData(list.get(i).get(j), key));
					
        		   }
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
	
	
	}
