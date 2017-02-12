package myakinen.icw2.htw_berlin.de.ProvitroDriver;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncryptionMedicalFindings;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ExcelOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.WordOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.DOC.ExcelOperations;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.DOC.WordOperations;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionAES;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/*
    	//AES
    	EncryptionMedicalDataInterface pD2 = new EncryptionAES();
    	System.out.println(pD2.EncryptData("OÄ Rudolph", 1234567));
    	System.out.println(pD2.DecryptData("GdvMKozX0Zn03VNst7cYkw==", 1234567));
    	
    	//Original Kirstein
    	EncryptionMedicalDataInterface pD = new EncryptionDCPathos();
    	System.out.println(pD.EncryptData("O123-03", 1234567));
    	System.out.println(pD.DecryptData("9146870", 1234567));
    	
    	
    	//Modifizierter
    	EncryptionMedicalDataInterface pD1 = new EncryptionNexus();
    	System.out.println(pD1.EncryptData("opao#paopaFFF/#FF+", 1234567));
    	System.out.println(pD1.DecryptData("212214200215140218204212214200174175176154136172173147", 1234567));
    	
    	
    	//Befunde
    	EncryptionMedicalFindings eF= new EncryptionMedicalFindings();
    	String s1 = "Patient Name: Schmidt  und sein super-puper Doctor Dr. HojhojHoj und in the blue corner super OA. MasterYoda unter dem FallNummer: A12335-03  ";
    	System.out.println("Nexus: "+eF.Encrypt(s1, 1674911, 2));
    	System.out.println("AES: "+eF.Encrypt(s1, 1674911, 1));
    	String s2 = "Patient Name: 184205211213214201217 und sein super-puper Doctor Dr. 173217213208220207173212212 und in the blue corner super OA. 178203222220210215190212206204 unter dem FallNummer: 166155157155160154146149157";
    	String s3 ="Patient Name: ItXORv9ueGiaTgyKB+GcwQ== und sein super-puper Doctor Dr. nNyISw2tIKlzPs8UVnR4UA== und in the blue corner super OA. EN8WY9ZqK4ipfRSJD/23Cg== unter dem FallNummer: lIpIbl3euc+ws8PmkxEGCw==";
    	System.out.println("Nexus: "+eF.Decrypt(s2, 1674911, 2));
    	System.out.println("AES: "+eF.Decrypt(s3, 1674911, 1));
    	
    	
    	*/
    	
    	//DOCInterface dI = new DOC();
    	//dI.createNewDoc("apacheDoc", "some text");
    	 /*JFrame meinJFrame = new JFrame();
         meinJFrame.setTitle("JButton Beispiel");
         JPanel panel = new JPanel();
  
         // JButton mit Text "Drück mich" wird erstellt
         JButton button = new JButton("Drück mich");
         JTextArea area = new JTextArea(5, 10);
         JPanel upperPanel = new JPanel();
         upperPanel.add(button);
         upperPanel.add(area);
         // JButton wird dem Panel hinzugefügt
         
  
         //meinJFrame.add(area);
         meinJFrame.add(upperPanel);
  
         // Fenstergröße wird so angepasst, dass 
         // der Inhalt reinpasst    
         meinJFrame.pack();
  
         meinJFrame.setVisible(true);
    	
    	*/
    	
    	//Word Operations
		//System.out.println("Test"+test);
		//Word-Datei zeilenweise einlesen 
		//WordOperationsInterface read = new WordOperations();
		//read.readWord("C:/Users/AnnaToshiba2/Desktop/ICW2/testaten.docx");
		//read.wordManagerEncyptor();
    	
    	//Excel Operations
    	ExcelOperationsInterface iE = new ExcelOperations();
    	//iE.writeExcel();
    	//iE.readExcel();
    	iE.excelManagerEncryptor();

			    }
	}

    

