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

import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.ExcelOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.PatientData;

public class ExcelOperations implements ExcelOperationsInterface  {

	public static final String HEADER1= "MedCase";
	public static final String HEADER2="Verschlüsselte Patientdaten";
	public static final String HEADER3="Originale Patientdaten";
	
	public void readExcel() {
		// TODO Auto-generated method stub
		try
        {
            String excelPath = "C:/Users/AnnaToshiba2/Desktop/ICW2/APACHE/FirstTest.xlsx";
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
            FileOutputStream outputStream = new FileOutputStream("C:/Users/AnnaToshiba2/Desktop/ICW2/APACHE/FirstTest"+".xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

	}

	public void excelManagerEncryptor()
	{
		try {
		// TODO Auto-generated method stub
		//XSSFWorkbook resultWorkbook = new XSSFWorkbook();
		List<PatientData> data = new ArrayList<PatientData>();
       // XSSFSheet sheet = resultWorkbook.createSheet("Verschlüsselte Daten");
        String excelPath = "C:/Users/AnnaToshiba2/Desktop/ICW2/APACHE/FirstTest.xlsx";
        FileInputStream fileInputStream = new FileInputStream(new File(excelPath));

        // Create Workbook instance holding .xls file
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // Get the first worksheet
        XSSFSheet sheetRead = workbook.getSheetAt(0);

        // Iterate through each rows
        Iterator<Row> rowIterator = sheetRead.iterator();

        while (rowIterator.hasNext())
        {
            // Get Each Row
            Row row = rowIterator.next();

            // Iterating through Each column of Each Row
            Iterator<Cell> cellIterator = row.cellIterator();
            String medc="";
            String pid ="";
            System.out.println("Row: " + row.getRowNum());
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                 if (cell.getColumnIndex()==0)
                 {
                	 medc=cell.getStringCellValue();
                 }
                 if (cell.getColumnIndex()==1)
                 {
                	 pid= cell.getStringCellValue();
                 }
                 PatientData patient = new PatientData();
                 patient.setMedCase(medc);
                 patient.setRootPatientData(pid);
                 data.add(patient);
                 
            }
            for (PatientData p : data)
            {
            	System.out.println(p.getMedCase());
            }
            
            System.out.println("Size "+ data.size());
            
                // Checking the cell format
                /*switch (cell.getCellType())
                {
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t");
                    break;
                
                }*/
            
           /* int rowNum = 0;
            for(PatientData pat : data)
            {
            	Row rowWrite = sheet.createRow(rowNum++);
            	Cell cellMedCase = row.createCell(0);
            	Cell cellPid = row.createCell(1);
            	cellMedCase.setCellValue(pat.getMedCase());
            	cellPid.setCellValue(pat.getRootPatientData());
                
            }
            try {
                FileOutputStream outputStream = new FileOutputStream("C:/Users/AnnaToshiba2/Desktop/ICW2/APACHE/CopyTest"+".xlsx");
                resultWorkbook.write(outputStream);
                resultWorkbook.close();
                System.out.println("Success!!");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

	*/
	}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	

	}}
