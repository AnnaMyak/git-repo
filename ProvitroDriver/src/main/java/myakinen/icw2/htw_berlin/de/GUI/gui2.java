package myakinen.icw2.htw_berlin.de.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.CSVOperations;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.ExcelOperations;

public class gui2 extends JFrame implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
/*
	//Psedonymisieren
	JButton inputDataPseu;
    JButton encryptButtonPseu;
    JLabel testLabelPseu;
    
    JTextField tfKeyPseu;
    JLabel keyLabelPseu;
    String pathPseu;
    int encryptionPseu;
    int keyPseu;
    
    
//Depseudonymisieren
    JButton inputDataDepseu;
    JButton encryptButtonDepseu;
    JLabel testLabelDepseu;
    
    JTextField tfKeyDepseu;
    JLabel keyLabelDepseu;
    String pathDepseu;
    int encryptionDepseu;
    int keyDepseu;
	
public gui2()
{
	 setTitle("Tabbed Pane");
	 setSize(700, 700);
     JTabbedPane jtp = new JTabbedPane();
     getContentPane().add(jtp);
     
     JPanel pseudonym = new JPanel();
     JPanel depseudonym = new JPanel();
     JLabel label1 = new JLabel();
     label1.setText("Pseudonymisieren Daten");
     JLabel label2 = new JLabel();
     label2.setText("Depseudonymisieren Daten");
     pseudonym.add(label1);
     
     
     //Pseudonymisieren Tab
     testLabelPseu = new JLabel("Keine Datei gewählt");
     inputDataPseu = new JButton("Datei Laden");
     encryptButtonPseu = new JButton ("Pseudonymisieren");
     keyLabelPseu = new JLabel("Schlüssel");
     tfKeyPseu = new JTextField("1111111111", 15);
     
     inputDataPseu.addActionListener(this);
     encryptButtonPseu.addActionListener(this);
     
   //JRadioButtons wählen Verschlüssung
     JRadioButton nexusPseu = new JRadioButton("Nexus");
     JRadioButton DESPseu = new JRadioButton("DES");
     JRadioButton RC4Pseu = new JRadioButton("RC4",true);

     //ButtonGroup wird erstellt
     ButtonGroup gruppeEncryption = new ButtonGroup();
     gruppeEncryption.add(nexusPseu);
     gruppeEncryption.add(DESPseu);
     gruppeEncryption.add(RC4Pseu);
     
     if(nexusPseu.isSelected())
     	encryptionPseu=1;
     if (DESPseu.isSelected())
     	encryptionPseu=2;
     if (RC4Pseu.isSelected())
     	encryptionPseu=3;
     
     
   //JRadioButtons werden Panel hinzugefügt
     pseudonym.add(nexusPseu);
     pseudonym.add(DESPseu);
     pseudonym.add(RC4Pseu);
     
     pseudonym.add(keyLabelPseu);
     pseudonym.add(tfKeyPseu);
     
     //Buttons werden dem JPanel hinzugefügt
     pseudonym.add(inputDataPseu);
     pseudonym.add(encryptButtonPseu);
     

     //JLabel wird dem Panel hinzugefügt
     pseudonym.add(testLabelPseu);
     
     //Depseudonymisieren
     depseudonym.add(label2);
     
     testLabelDepseu = new JLabel("Keine Datei gewählt");
     inputDataDepseu = new JButton("Datei Laden");
     encryptButtonDepseu = new JButton ("Depseudonymisieren");
     keyLabelDepseu = new JLabel("Schlüssel");
     tfKeyDepseu = new JTextField("1111111111", 15);
     
     inputDataDepseu.addActionListener(this);
     encryptButtonDepseu.addActionListener(this);
     
     //JRadioButtons wählen Verschlüssung
     JRadioButton nexusDepseu = new JRadioButton("Nexus");
     JRadioButton DESDepseu = new JRadioButton("DES");
     JRadioButton RC4Depseu = new JRadioButton("RC4",true);

   //ButtonGroup wird erstellt
     ButtonGroup gruppeEncryptionDepseu = new ButtonGroup();
     gruppeEncryptionDepseu.add(nexusDepseu);
     gruppeEncryptionDepseu.add(DESDepseu);
     gruppeEncryptionDepseu.add(RC4Depseu);
     
     if(nexusPseu.isSelected())
     	encryptionPseu=1;
     if (DESPseu.isSelected())
     	encryptionPseu=2;
     if (RC4Pseu.isSelected())
     	encryptionPseu=3;
     
     
     
   //JRadioButtons werden Panel hinzugefügt
     depseudonym.add(nexusDepseu);
     depseudonym.add(DESDepseu);
     depseudonym.add(RC4Depseu);
     
     depseudonym.add(keyLabelDepseu);
     depseudonym.add(tfKeyDepseu);
     
     //Buttons werden dem JPanel hinzugefügt
     depseudonym.add(inputDataDepseu);
     depseudonym.add(encryptButtonDepseu);
     

     //JLabel wird dem Panel hinzugefügt
     depseudonym.add(testLabelDepseu);
     
     
     
     jtp.addTab("Pseudonymisieren", pseudonym);
     jtp.addTab("Depseudonymisieren", depseudonym);	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//Pseudonymisieren
	if(e.getSource() == this.inputDataPseu){
		
		testLabelPseu.setText((""));
        FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate: xlsx und csv ", 
                "xlsx", "csv"); 
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(filter);
        int rueckgabeWert = chooser.showOpenDialog(null);
        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
        {
        	pathPseu=pathModification(chooser.getSelectedFile().getPath());
        	testLabelPseu.setText(pathModification(chooser.getSelectedFile().getPath()));
            
        }
    }
	else if(e.getSource() == this.encryptButtonPseu)
	{
		//CSV psedonymisieren
		if (testDataFormat(testLabelPseu.getText()).equals("csv"))
        {
			TablesOperationsInterface tOp = new CSVOperations();
			try {
				tOp.managerEncryptor(testLabelPseu.getText(), encryptionPseu, Integer.parseInt(tfKeyPseu.getText()));
				testLabelPseu.setText("");
				tOp= null;
        	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
		else
		{
			//EXcel Pseudonymisieren
			TablesOperationsInterface tOp = new ExcelOperations();
			try {
				tOp.managerEncryptor(testLabelPseu.getText(), encryptionPseu, Integer.parseInt(tfKeyPseu.getText()));
				testLabelPseu.setText("");
				tOp= null;
        	} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//Depseudonymisieren
	
	else if(e.getSource() == this.inputDataDepseu){
			
			testLabelDepseu.setText((""));
	        FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate: xlsx und csv ", 
	                "xlsx", "csv"); 
	        JFileChooser chooser = new JFileChooser();
	        chooser.addChoosableFileFilter(filter);
	        int rueckgabeWert = chooser.showOpenDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	        {
	        	pathDepseu=pathModification(chooser.getSelectedFile().getPath());
	        	testLabelDepseu.setText(pathModification(chooser.getSelectedFile().getPath()));
	            
	        }
	    }
		else if(e.getSource() == this.encryptButtonDepseu)
		{
			//CSV depseudonymisieren
			if (testDataFormat(testLabelDepseu.getText()).equals("csv"))
	        {
				TablesOperationsInterface tOp = new CSVOperations();
				try {
					tOp.managerDecryptor(testLabelDepseu.getText(), encryptionDepseu, Integer.parseInt(tfKeyDepseu.getText()));
					testLabelPseu.setText("");
					
	        	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
			else
			{
				//EXcel dePseudonymisieren
				TablesOperationsInterface tOp = new ExcelOperations();
				try {
					tOp.managerDecryptor(testLabelDepseu.getText(), encryptionDepseu, Integer.parseInt(tfKeyDepseu.getText()));
					testLabelDepseu.setText("");
					tOp= null;
	        	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}


public String pathModification(String path) {
	// TODO Auto-generated method stub
	return path.replace("\\", "/");
	}
public String testDataFormat(String path) {
	// TODO Auto-generated method stub
	String substring = path.substring(Math.max(path.length() - 3, 0));
	return substring;
	}
*/
}
