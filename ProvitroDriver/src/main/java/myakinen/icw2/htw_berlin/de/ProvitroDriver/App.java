package myakinen.icw2.htw_berlin.de.ProvitroDriver;


import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import myakinen.icw2.htw_berlin.de.Config.Configuration;
import myakinen.icw2.htw_berlin.de.Provitro.GUI.GUI;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalDataInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.CSVOperations;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.ExcelOperations;

public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
    	//ConfigurationInterface config= new Configuration();
    	
    	
    	/*
    	//Original Kirstein
    	EncryptionMedicalDataInterface pD = new EncryptionDCPathos();
    	System.out.println(pD.EncryptData("O123-03", 1234567));
    	System.out.println(pD.DecryptData("9146870", 1234567));
    	
    	
    	//Modifizierter
    	EncryptionMedicalDataInterface pD1 = new EncryptionNexus();
    	System.out.println(pD1.EncryptData("uuööö", 1234567));
    	System.out.println(pD1.DecryptData("218219349350351", 1234567));
    	
    	*/
    	
    	//TablesOperationsInterface eo= new ExcelOperations();
    	//TablesOperationsInterface ecsv= new CSVOperations ();
    	
    	//eo.managerEncryptor("C:/Users/AnnaToshiba2/Desktop/ICW2/provitro.xlsx",1,1111111111);
    	//eo.excelManagerDecryptor("C:/Users/AnnaToshiba2/Desktop/ICW2/outputXLS/EncryptedData.xlsx",1,1111111111);
    	
    	//ecsv.managerEncryptor("C:/Users/AnnaToshiba2/Desktop/ICW2/CVVV.csv", 2, 1111111111);
    	//ecsv.managerDecryptor("C:/Users/AnnaToshiba2/Desktop/ICW2/outputXLS/EncryptedDataCVS.csv", 2, 1111111111);
    	
        
        /*
        
        //vot etu bajdu pod knopku
        FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate: ", 
                "xlsx", "csv"); 
        JFileChooser chooser = new JFileChooser();
        // Dialog zum Oeffnen von Dateien anzeigen
        chooser.addChoosableFileFilter(filter);
        int rueckgabeWert = chooser.showOpenDialog(null);
        */
        /* Abfrage, ob auf "Öffnen" geklickt wurde */
        
        /*
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
             // Ausgabe der ausgewaehlten Datei
            System.out.println("Die zu öffnende Datei ist: " +
                 config.pathModification(chooser.getSelectedFile().getPath()));
        }
        */
    	GUI gui= new GUI();
    	gui.setVisible(true);
    	}
    
   
	}

    

