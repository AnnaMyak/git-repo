package myakinen.icw2.htw_berlin.de.ProvitroDriver.DOC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import myakinen.icw2.htw_berlin.de.EncryptionMedicalFindings.EncryptionMedicalFindings;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.EncryptionMedicalFindingsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroAPI.WordOperationsInterface;

public class WordOperations implements WordOperationsInterface {
	private EncryptionMedicalFindingsInterface mF;
	final String newline = System.getProperty("line.separator");
	public String readWord(String path) {
		// TODO Auto-generated method stub
		
		try {
			   FileInputStream fis = new FileInputStream(path);
			   XWPFDocument xdoc=new XWPFDocument(OPCPackage.open(fis));
			   List<XWPFParagraph> paragraphList =  xdoc.getParagraphs();
			   for (XWPFParagraph paragraph: paragraphList){
				   String[] s= paragraph.getText().split("/n");
				   for ( int i=0; s.length>i; i++)
				   {
					   System.out.println("New Line: "+ s[i]);
				   }
			   }
			} catch(Exception ex) {
			    ex.printStackTrace();
			} 
		return null;
	}

	public void createWord(String path, String fileName, String content) {
		try
		   {
			   XWPFDocument document = new XWPFDocument();   
		       XWPFParagraph tmpParagraph = document.createParagraph();   
		       XWPFRun tmpRun = tmpParagraph.createRun();   
		       tmpRun.setText("Set test content");   
		       tmpRun.setFontSize(18);   
		       FileOutputStream fos = new FileOutputStream(new File(path + "/"+fileName + ".docx"));   
		       document.write(fos);   
		       fos.close();
		       //C:/Users/AnnaToshiba2/Desktop/ICW2/TEST/testCreateTTT"
		       System.out.println("created successfully");
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		// TODO Auto-generated method stub
		
	}
	
	public void wordManagerEncyptor()
	{
		mF = new EncryptionMedicalFindings();
		try
		{
			FileInputStream fis = new FileInputStream("C:/Users/AnnaToshiba2/Desktop/ICW2/testaten.docx");
			//Read   
			XWPFDocument xdoc=new XWPFDocument(OPCPackage.open(fis));
			   List<XWPFParagraph> paragraphList =  xdoc.getParagraphs();
			  //Create new File
			   XWPFDocument document = new XWPFDocument();   
		       XWPFParagraph tmpParagraph = document.createParagraph();   
		       //XWPFRun tmpRun = tmpParagraph.createRun();
			   
		       for (XWPFParagraph paragraph: paragraphList)
			   {
		    	   XWPFRun tmpRun = tmpParagraph.createRun();
		    	   String result="";
				   String[] s= paragraph.getText().split("\n");
				   for ( int i=0; s.length>i; i++)
				   {
					   s[i]=mF.Encrypt(s[i], 123456, 1);
					   //System.out.println("New Line: "+ s[i]);
					   result= result+s[i]+newline;
				   }
				   tmpRun.setText(result);
				   tmpRun.setFontSize(14);
			   }
		       FileOutputStream fos = new FileOutputStream(new File("C:/Users/AnnaToshiba2/Desktop/ICW2/AAA.docx" +".docx"));   
		       document.write(fos);   
		       fos.close();
		       System.out.println("Erfolg!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
