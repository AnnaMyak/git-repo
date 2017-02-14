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

import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDCPathos;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionDes;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionNexus;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.EncryptionMedicalData.EncryptionRC4;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/*
    	
    	
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
    	//ExcelOperationsInterface iE = new ExcelOperations();
    	//iE.writeExcel();
    	//iE.readExcel();
    	//iE.excelManagerEncryptor();
    	
    	//RC4 Test
    	EncryptionMedicalDataInterface eM = new EncryptionRC4();
    	System.out.println("RC4 Pseudonym Encrypt " + eM.EncryptData("//+JuHuuu##uu\\", 1111111111));
    	System.out.println("RC4 Depseudonym  Decrypt" + eM.DecryptData("A3A4245D09BEF3365479D57C0563", 1111111111));
    	
    	//RC4 Original Test
    	EncryptionRC4 rc4 = new EncryptionRC4("1111111111");
    	System.out.println("RC4 Pseud original "+ rc4.pseudonym("//+JuHuuu##uu\\"));
    	System.out.println("RC4 Depseud original "+ rc4.depseudonym("A3A4245D09BEF3365479D57C0563"));

    	//Des Test
    	EncryptionMedicalDataInterface eM2 = new EncryptionDes();
    	System.out.println( "Des Pseudonym  Encrypt "+eM2.EncryptData("//SpongeBob++", 11111111));
    	System.out.println( "Des Pseudonym  Encrypt "+eM2.DecryptData("FF23176056771FC8A4D2F9219F89D1BB", 11111111));
    	
    	// Des Original Test
    	EncryptionDes des = new EncryptionDes("11111111");
    	System.out.println("Des pseud original "+ des.pseudonym("//SpongeBob++"));
    	System.out.println("Des pseud original "+ des.depseudonym("FF23176056771FC8A4D2F9219F89D1BB"));
    	
    	//test Med Data
    	EncryptionMedicalFindings md = new EncryptionMedicalFindings();
    	String text1="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Makroskopie   Zyste Hypopharynx Seitenwand links).     Im vorliegenden Material kein Anhalt für Malignität oder Spezifität.                Prof. Dr. Homer Simpson        Prof. Dr. Capitan America ";
    	String text2 ="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Makroskopie   vasiven Wachstums, zum, Sie erhalten einen Zusatzbericht.    liegt nicht vor.                  Prof. Dr. Patrik. Star        Prof. Dr. Bart Simpson      ";
    	String text3 ="  PATHOHISTOLOGISCHE BEGUTACHTUNG  1. Zusatzbericht  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Mikroskopie   Es zeigen sich keine neuen Aspekte.   Kein invasiver Tumor.        Neoplasie, fokal high grade. (gibt es klinische Restbefunde?).                    Prof. Dr. Peter. Griffin        Prof. Dr. King Lion      ";
    	String text4="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Makroskopie   BWK 12: fragmentierter Knochenstanzzylinder von zus. gelegt 15 mm Länge.   Anhalt für Malignität. Die beschriebenen Keratin-positiven Zellfragmente lassen .                   Prof. Dr. Alladin. Apu        Dr. Z. Cinderella      ";
    	String text5="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Klinische Angaben   V.a. follikuläres Lymphom Wange rechts.     Makroskopie   1. Wange rechts  9x2 mm.  2. Wange dorsal rechts: zahlreiche.    Färbungen  1. HE, Giemsa, CD20, CD3, CD21, CD30, CD10, Ki-67.   2. HE, CD20, CD21, CD3, CD30, Ki-67.    Mikroskopie   In der Probe 1 kommen in der tiefen Subkutis tiefe lymphatische Infiltrate zur Darstellung, die breite Keimzentrumsstrukturen aufweisen, die Sternhimmelmakrophagen beherbergen. Sie konfluieren untereinander, die Mantelzone ist dabei nicht abgrenzbar. In der Probe 2 sind die Keimzentrumsstrukturen kleiner, aber auch hier lassen sich Makrophagen nachweisen.     In den immunhistologischen Färbungen lässt sich prinzipiell eine zonale Gliederung erkennen. Die B-und T-Zell-Kompartimente sind gut erhalten. Die unregelmäßig großen teils konfluierenden Keimzentren werden von BCL-2 ausgespart und kommen über BCL-6 und CD10 gut zur Darstellung. Die proliferative Aktivität ist in den Keimzentren hoch. Außerhalb liegt sie bei 5-10%. Das Maschenwerk der follikulär dendritischen Zellen ist von Innen fragmentiert.     Diagnose    1.und 2. Haut und Subkutisexsisat mit einem gemischtzelligen Infiltrat mit follikelartigen Strukturen.    Kommentar  Die follikelartigen Strukturen zeigen einen regelhaften immunhistologischen Phänotyp und weisen aktivierte Keimzentren auf. Diese Fakten lassen differentialdiagnostisch an ein Pseudolymphom sprechen, ungewöhnlich hierfür ist das stark fragmentierte Maschenwerk.  ES erfolgt daher zur Dignitätsklärung eine molekulare Aufarbeitung.   Sie erhalten einen 2. Bericht                          Prof. Dr. B. Bunny        PD Dr. D. Duck      "; 
    	String text6="  PATHOHISTOLOGISCHE BEGUTACHTUNG  1. Zusatzbericht  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Makroskopie  Gewebe mit der Einsendungsnummer E30003-16, Block 1.     und IGL-PCR-Analysen zugeführt. Alle  analysiert. Zusätzlich wurde eine PCR zur Überprüfung der Qualität der  der extrahierten Gewebs-DNA.    Die IGH-PCR wurde mit drei verschiedenen Primerkombinationen mehrfach durchgeführt (BioMed-2 FR1, FR2 und FR3).  Dabei zeigen sich mit allen eingesetzten Primerkombinationen der IGH-PCR weitgehend polyklonale B-Zellumlagerungsmuster, in denen sich ein dominantes Aarstellen lässt.  Die IGL-PCR wurde mit drei verschiedenen Primerkombinationen mehrfach durchgeführt   (BioMed-2 IG-Kappa A, IG-Kappa B und IG-Lambda).  Dabei zeigen sich mit allen eingesetzten Primerkombinationen der IGL-PCR weitgehend polyklonale B-Zellumlagerungsmuster, in denen sich ein dominantes Amplifikationsprodukt nicht bzw. nicht reproduzierbar darstellen lässt.    Molekularpathologische Beurteilung  Mit Hilfe der durchgeführten PCR-Analysen lässt sich in der Einsendung eine klonale B-Zellpopulation nicht nachweisen.    Histologische und molekularpathologische Zusammenhangsdiagnose  1.und 2. Haut und Subkutisexsisat mit einem gemischtzelligen Infiltrat mit follikelartigen Strukturen entsptechend einem Pseudolymphom.      Kommentar  Letztlich lässt sich weder konventionell-histologisch noch immunhistologisch oder molekukarpathologisch ein Lymphom diagnostizieren. Sollten gleichartige Veränderungen erneut auftreten oder vorhandene an Größe zunehmen, sollte eine Wiederholung der Untersuchung erwogen werden.                        Prof. Dr. Mein Pupchen        PD Dr. Tomand. Jerry      Dr. D. Masteryoda      ";
    	String text7="  PATHOHISTOLOGISCHE BEGUTACHTUNG  2. Zusatzbericht  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Mikroskopie   Uns wurde nachträglich mitgeteilt, dass der Patient eine CLL hat. Daraufhin erfolgten weitere immunhistologische Untersuchungen. Es wurde eine CD5- und CD23-Färbung angeschlossen.   Hierbei zeigt sich, dass zwischen den stark aktivierten die zusätzlich CD5 und CD23 exprimiert.     Diagnose   Manifestation einer chronischen lymphatischen B-Zell-Leukämie in der Interfollikulärregion wachsend in einem Kutis-/Subkutisexzisat     Kommentar  Bei ischen Phänotyp der B-Zellen und bekannter CLL hier von einer subkutanen.                   Prof. Dr. Master. Flomaster        PD Dr. K. Öäüöqqqq      ";
    	String text8="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Makroskopie   1. Endometrium: mehrere grau-gelbliche Gewebsfragmente von max. 8 mm.   2. Zahlreiche bräunliche Gewebsflusen, separierten, regelhaft gestalteten Drüsen in zytogenem Stroma. Darüber hinaus gequetschte glattmuskuläre Faseranteile mit kleinen Gefäßknospen sowie gequetschten, angedeutet tubulären Komplexen, die in erster Linie auf Gefäßproliferate zurückzuführen sind.   2. Einerseits endometriale, dysplasiefreie Schleimhaut, daneben oberflächlich abgeschilferte, plattenepithelialevix entsprechend. Keine atypischen Zellproliferate.      Diagnose   1. Einerseits dysplasiefreie endometriale Schleimhaut, daneben glattmuskuläre Faseranteile mit Kapillareinsprossungen und lokal gequetschten Zellverbänden, die in erster Linie gequetschten Gefäßstrukturen entsprechen dürften.   2. Tumorfreies endometriales Schleimhautgewebe mit miterfasster endo- und ektozervikaler Schleimhaut.       Kommentar   Im vorliegenden Material konventionell-lichtmikroskopisch kein Anhalt für Remanifestation eines Endometriumkarzinoms, bei lokalen Queteschartefakten in der Position 1 werden wir zum sicheren Ausschluss weitergehender Befunde Immunhistologie durchführen. Sie erhalten einen Zusatzbericht.                  Prof. Dr. Major. Zhuzhu        Prof. Dr. Minor. Foo-foo        ";
    	String text9="  PATHOHISTOLOGISCHE BEGUTACHTUNG  1. Zusatzbericht  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)        Wie angekündigt, ergeht nach Durchführung einer immunhistologischen Zusatzuntersuchung ein zweiter Bericht.  Hierbei erkennt  zum Teil 1. In Ergänzung zum Vorbefund dysplasiefreie endometriale Schleimhaut mit miterfassten, glattmuskulären Faseranteilen.  2. Vgl. Erstbericht.     Kommentar   Kein Nachweis von Malignität in den hier vorliegenden Biopsiepartikeln.                  Prof. Dr. J. Bond-ond-ond        Prof. Dr. H. Yoda      ";
    	String text10="  PATHOHISTOLOGISCHE BEGUTACHTUNG  (Verwendung zu wissenschaftlichen oder gutachterlichen Zwecken nur mit ausdrücklicher Zustimmung des Institutsdirektors)      Klinische Angaben   V.a. Marginalzonenlymphom.    Makroskopie   1. Rechte vordere Orbita: zwei grau-bräunliche GS von max. 6 mm.   2. Linke vordere Orbita: drei grau-braunnd im Bereich der Tränendrüse ausbreitet. Die Zellen sind klein bis mittelgroß und haben einen breiteren Zytoplasmasaum. Das Kernchromatin ist leicht aufgelockert.   In den immunhistologischen Färbungen lassen sich diese Zellen über CD20 der B-Zellpopulation zuordnen. Sie exprimieren der follikulär dendritischen Zellen isg der Immunglobulin-Leichtketten zeigt keine eindeutige Immunglobulin-Leichtkettenrestriktion. Es sind recht wenige T-Zellen dem B-Zellinfiltrat beigemengt. Die proliferativeis zu 40%.    Diagnose   1. + 2. Teils höher proliferierendes B-Zelllymphom.    Kommentar   Zur weiteren Subtypisierung sind immunhistologische Untersuchungen notwendig. Sie erhalten einen weiteren Bericht.                  Prof. Dr. M. Schneewitchen        PD Dr. K. Mustermann      ";
    	System.out.println ("Test Befund 1 " +md.Encrypt(text1, 1111111111, 2));
    	System.out.println ("Test Befund 2 " +md.Encrypt(text2, 1111111111, 2));
    	System.out.println ("Test Befund 3 " +md.Encrypt(text3, 1111111111, 3));
    	System.out.println ("Test Befund 4 " +md.Encrypt(text4, 1111111111, 3));
    	System.out.println ("Test Befund 5 " +md.Encrypt(text5, 1111111111, 3));
    	System.out.println ("Test Befund 6 " +md.Encrypt(text6, 1111111111, 3));
    	System.out.println ("Test Befund 7 " +md.Encrypt(text7, 1111111111, 3));
    	System.out.println ("Test Befund 8 " +md.Encrypt(text8, 1111111111, 3));
    	System.out.println ("Test Befund 9 " +md.Encrypt(text9, 1111111111, 1));
    	System.out.println ("Test Befund 10 " +md.Encrypt(text10, 1111111111, 1));
    	

    	
    	}
	}

    

