package myakinen.icw2.htw_berlin.de.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.TablesOperationsInterface;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.CSVOperations;
import myakinen.icw2.htw_berlin.de.ProvitroDriver.TableOperations.ExcelOperations;

public class GUIFinal extends JFrame implements ActionListener {
	private int encryption;
	private TablesOperationsInterface table;
	
	//Pseudonym
	private JButton inputFilePseu;
	private JButton executionPseu;
	private JLabel labelSelectedFilePseu;
	private JTextField keyPseu;
	private JLabel resultPseu;
	
	//Depseudonym
	private JButton inputFileDepseu;
	private JButton executionDepseu;
	private JLabel labelSelectedFileDepseu;
	private JTextField keyDepseu;
	private JLabel resultDepseu;
	
	public GUIFinal()
	{
		setTitle("Provitro Pseudonyminisierungstool");
		setSize(800, 500);
		
		
		JTabbedPane tappedPanel = new JTabbedPane();
		tappedPanel.setTabPlacement(JTabbedPane.TOP);
	    getContentPane().add(tappedPanel);
	    JPanel pseudonym = new JPanel();
	    //pseudonym.setLayout(null);
	    JPanel depseudonym = new JPanel();
	    // tappedPanel.setLayout(null);
	    
	    resultPseu= new JLabel();
	    
	    //Pseudonym
	    
	   
	    
	    
	    //ButtonGroup wird erstellt
	    
	    //labelKeyPseu.setVerticalAlignment(alignment);
	    ButtonGroup gruppeEncryptionPseu = new ButtonGroup();
	    JRadioButton nexusPseu = new JRadioButton("Nexus");
	    JRadioButton desPseu = new JRadioButton("DES");
	    JRadioButton rc4Pseu = new JRadioButton("RC4",true);
	    JRadioButton xorPseu = new JRadioButton("XOR");
	    JRadioButton dcPseu = new JRadioButton("DC-Pathos");
	     
	    gruppeEncryptionPseu.add(nexusPseu);
	    gruppeEncryptionPseu.add(desPseu);
	    gruppeEncryptionPseu.add(rc4Pseu);
	    gruppeEncryptionPseu.add(xorPseu);
	    gruppeEncryptionPseu.add(dcPseu);
	     
	    if(nexusPseu.isSelected())
	      	encryption=1;
	    if (desPseu.isSelected())
	      	encryption=2;
	    if (rc4Pseu.isSelected())
	      	encryption=3;
	    if (xorPseu.isSelected())
		    encryption=4;
	    if (dcPseu.isSelected())
		    encryption=0;
	    JLabel labelKeyPseu = new JLabel("Schlüssel");  
	    labelSelectedFilePseu = new JLabel("Noch keine Datei geladen");
	    inputFilePseu = new JButton("Datei Laden");
	    keyPseu = new JTextField("1111111111", 15);
	    keyPseu.setSize(100,20);
	    
	    executionPseu = new JButton ("Ausführen");
	    
	    pseudonym.add(labelKeyPseu);
	    pseudonym.add(keyPseu);
	    
	    
	    //Add Buttons group Pseudonym
	    pseudonym.add(nexusPseu);
	    pseudonym.add(desPseu);
	    pseudonym.add(rc4Pseu);
	    pseudonym.add(xorPseu);
	    pseudonym.add(dcPseu);
	    
	  //Add Buttons group Depseudonym
	    
	   
	    pseudonym.add(labelSelectedFilePseu);
	    pseudonym.add(inputFilePseu);
	    pseudonym.add(executionPseu);
	    pseudonym.add(resultPseu); 
	    
	    
	    //Depseudonym
	    
	    labelSelectedFileDepseu = new JLabel("Noch keine Datei geladen");
	    inputFileDepseu = new JButton("Datei Laden");
	    keyDepseu = new JTextField("1111111111", 15);
	    resultDepseu = new JLabel();
	    JLabel labelKeyDepseu = new JLabel("Schlüssel");
	    
	    ButtonGroup gruppeEncryptionDepseu = new ButtonGroup();
	    JRadioButton nexusDepseu = new JRadioButton("Nexus");
	    JRadioButton desDepseu = new JRadioButton("DES");
	    JRadioButton rc4Depseu = new JRadioButton("RC4",true);
	    JRadioButton xorDepseu = new JRadioButton("XOR");
	    JRadioButton dcDepseu = new JRadioButton("DC-Pathos");
	     
	    gruppeEncryptionDepseu.add(nexusPseu);
	    gruppeEncryptionDepseu.add(desPseu);
	    gruppeEncryptionDepseu.add(rc4Pseu);
	    gruppeEncryptionDepseu.add(xorPseu);
	    gruppeEncryptionDepseu.add(dcPseu);
	    
	    
	     
	    if(nexusDepseu.isSelected())
	      	encryption=1;
	    if (desDepseu.isSelected())
	      	encryption=2;
	    if (rc4Depseu.isSelected())
	      	encryption=3;
	    if (xorDepseu.isSelected())
		    encryption=4;
	    if (dcDepseu.isSelected())
		    encryption=0;
	    
	    depseudonym.add(labelKeyDepseu);
	    depseudonym.add(keyDepseu);
	    
	    
	    depseudonym.add(nexusDepseu);
	    depseudonym.add(desDepseu);
	    depseudonym.add(rc4Depseu);
	    depseudonym.add(xorDepseu);
	    depseudonym.add(dcDepseu);
	    executionDepseu = new JButton ("Ausführen");
	    depseudonym.add(labelSelectedFileDepseu);
	    depseudonym.add(inputFileDepseu);
	    depseudonym.add(executionDepseu);
	    depseudonym.add(resultDepseu);
	    
	    
	    //ActionListeners
	    inputFileDepseu.addActionListener(this);
	    executionDepseu.addActionListener(this);
	    inputFilePseu.addActionListener(this);
	    executionPseu.addActionListener(this);
	    
	    
	    
	    
	    //build gui
	    tappedPanel.addTab("Pseudonymisieren", pseudonym);
	    tappedPanel.addTab("Depseudonymisieren", depseudonym);
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String rootDirectory=FileSystemView.getFileSystemView().getRoots()[0].toString().replace("\\", "/");
		
		if(e.getSource() == this.inputFilePseu)
		{
			FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate: xlsx und csv ", 
	                "xlsx", "csv"); 
	        JFileChooser chooser = new JFileChooser(rootDirectory);
	        chooser.addChoosableFileFilter(filter);
	        int rueckgabeWert = chooser.showOpenDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	        {
	        	
	        	labelSelectedFilePseu.setText(chooser.getSelectedFile().getPath().replace("\\", "/"));
	        	resultPseu.setText("");
		        
	        }
		}
		
		if (e.getSource()==this.executionPseu)
		{
			if (keyPseu.getText().length()==0)
			{
				JOptionPane.showMessageDialog(this, "Geben Sie bitte den Schlüssel ein");
			}
			if (testDataFormat(labelSelectedFilePseu.getText()).equals(".csv"))
			{
				table = new CSVOperations();
				try {
					table.managerEncryptor(labelSelectedFilePseu.getText(), encryption, keyPseu.getText());
					JOptionPane.showMessageDialog(this, "Die Daten sind verschlüsselt. Sie finden die Ergebnisse in "+ rootDirectory+"/ProvitroToolOutputs/Encrypted/");
					resultPseu.setText("Ihre Ergebnisse finden Sie unter "+rootDirectory+"/ProvitroToolOutputs/Encrypted/");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "Irgendwas schief gelaufen.. Versuchen Sie noch mal.");
				}
			}
			else if (testDataFormat(labelSelectedFilePseu.getText()).equals("xlsx"))
			{
				table = new ExcelOperations();
				try {
					table.managerEncryptor(labelSelectedFilePseu.getText(), encryption, keyPseu.getText());
					JOptionPane.showMessageDialog(this, "Die Daten sind verschlüsselt. Sie finden die Ergebnisse in "+ rootDirectory+"/ProvitroToolOutputs/Encrypted/");
					resultPseu.setText("Ihre Ergebnisse finden Sie unter "+rootDirectory+"/ProvitroToolOutputs/Encrypted/");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "Irgendwas schief gelaufen.. Versuchen Sie noch mal.");
					
				}
			}
			else 
				{
				System.out.println("Das Datenformat wird nicht unterstützt oder Sie haben keine Datei geladen");
				JOptionPane.showMessageDialog(this, "Sie haben keine Datei geladen oder das Datenformat wird nicht unterstützt. Gesuchte Formate sind :	.csv oder .xlsx");
				}
		}
		
		if (e.getSource()==this.inputFileDepseu)
		{
			FileFilter filter2 = new FileNameExtensionFilter("Unterstüzte Formate: xlsx und csv ", 
	                "xlsx", "csv"); 
	        JFileChooser chooser2 = new JFileChooser(rootDirectory);
	        chooser2.addChoosableFileFilter(filter2);
	        int rueckgabeWert = chooser2.showOpenDialog(null);
	        if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
	        {
	        	
	        	labelSelectedFileDepseu.setText(chooser2.getSelectedFile().getPath().replace("\\", "/"));
	            resultDepseu.setText("");
	        }
		}
		
		if (e.getSource()==this.executionDepseu)
		{
			if (keyDepseu.getText().length()==0)
			{
				JOptionPane.showMessageDialog(this, "Geben Sie bitte den Schlüssel ein");
			}
			if (testDataFormat(labelSelectedFileDepseu.getText()).equals(".csv"))
			{
				table = new CSVOperations();
				try {
					table.managerDecryptor(labelSelectedFileDepseu.getText(), encryption, keyDepseu.getText());
					JOptionPane.showMessageDialog(this, "Die Daten sind verschlüsselt. Sie finden die Ergebnisse in "+ rootDirectory+"/ProvitroToolOutputs/Decrypted/");
					resultDepseu.setText("Ihre Ergebnisse finden Sie unter "+rootDirectory+"/ProvitroToolOutputs/Decrypted/");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else if (testDataFormat(labelSelectedFileDepseu.getText()).equals("xlsx"))
			{
				table = new ExcelOperations();
				try {
					table.managerDecryptor(labelSelectedFileDepseu.getText(), encryption, keyDepseu.getText());
					JOptionPane.showMessageDialog(this, "Die Daten sind verschlüsselt. Sie finden die Ergebnisse in "+ rootDirectory+"/ProvitroToolOutputs/Decrypted/");
					resultDepseu.setText("Ihre Ergebnisse finden Sie unter "+rootDirectory+"/ProvitroToolOutputs/Decrypted/");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				System.out.println("Das Datenformat wird nicht unterstützt oder Sie haben keine Datei geladen");
				JOptionPane.showMessageDialog(this, "Sie haben keine Datei geladen oder das Datenformat wird nicht unterstützt. Gesuchte Formate sind : .csv oder .xlsx");
			}
		}
		
	}
	
	public String testDataFormat(String path) {
		// TODO Auto-generated method stub
		String substring = path.substring(Math.max(path.length() - 4, 0));
		return substring;
		}

}
