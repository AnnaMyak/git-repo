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

public class GUI extends JFrame implements ActionListener{
	JButton inputData;
    JButton encryptButton;
    JButton button3;
    JLabel testLabel;
    JPanel panelPseudo;
    JPanel panelDepseudo;
    JTextField tfKey;
    JLabel keyLabel;
    String path;
    int encryption;
    int key;
    int encryptionType;
    
    
	public GUI()
	{
		path="";
		//JTabbedPane jtp = new JTabbedPane();
		//getContentPane().add(jtp);
		this.setTitle("Provitro-Tool");
        this.setSize(900, 700);
        panelPseudo = new JPanel();
       // panelDepseudo = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        testLabel = new JLabel("Keine Datei gewählt");
 
        //Drei Buttons werden erstellt
        inputData = new JButton("Datei Laden");
        encryptButton = new JButton ("Ausführen");
        keyLabel = new JLabel("Schlüssel");
        tfKey = new JTextField("1111111111", 15);
 
        //Buttons werden dem Listener zugeordnet
        inputData.addActionListener(this);
        encryptButton.addActionListener(this);
        
        //JRadioButtons wählen Verschlüssung
        JRadioButton nexus = new JRadioButton("Nexus");
        JRadioButton DES = new JRadioButton("DES");
        JRadioButton RC4 = new JRadioButton("RC4",true);
 
        //ButtonGroup wird erstellt
        ButtonGroup gruppeEncryption = new ButtonGroup();
        gruppeEncryption.add(nexus);
        gruppeEncryption.add(DES);
        gruppeEncryption.add(RC4);
        
        if(nexus.isSelected())
        	encryption=1;
        if (DES.isSelected())
        	encryption=2;
        if (RC4.isSelected())
        	encryption=3;
        
 
        //JRadioButtons werden Panel hinzugefügt
        panelPseudo.add(nexus);
        panelPseudo.add(DES);
        panelPseudo.add(RC4);
        
        
        //JRadioButtons Pseudo/Depseudo 
        JRadioButton pseudo = new JRadioButton("pseudonymisieren",true);
        JRadioButton depseudo = new JRadioButton("depseudonymisieren");
 
        //ButtonGroup wird erstellt
        ButtonGroup typeEncryption = new ButtonGroup();
 
        //JRadioButtons werden zur ButtonGroup hinzugefügt
        typeEncryption.add(pseudo);
        typeEncryption.add(depseudo);
        if (pseudo.isSelected())
        	encryptionType=1;
        if (depseudo.isSelected())
        	encryptionType=2;
        	
        //JRadioButtons werden Panel hinzugefügt
        panelPseudo.add(pseudo);
        panelPseudo.add(depseudo);
        
        panelPseudo.add(keyLabel);
        panelPseudo.add(tfKey);
        
        //Buttons werden dem JPanel hinzugefügt
        panelPseudo.add(inputData);
        panelPseudo.add(encryptButton);
        
 
        //JLabel wird dem Panel hinzugefügt
        panelPseudo.add(testLabel);
        this.add(panelPseudo);
        //jtp.addTab("Pseudonymisierung", panelPseudo);
        //jtp.addTab("Depseudonymisierung", panelDepseudo);


	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.inputData){
			
            testLabel.setText((""));
            FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate: xlsx und csv ", 
                    "xlsx", "csv"); 
            JFileChooser chooser = new JFileChooser();
            chooser.addChoosableFileFilter(filter);
            int rueckgabeWert = chooser.showOpenDialog(null);
            if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
            {
            	path=pathModification(chooser.getSelectedFile().getPath());
            	testLabel.setText(pathModification(chooser.getSelectedFile().getPath()));
                
            }
        }
        else if(e.getSource() == this.encryptButton){
            //testLabel.setText("Button 2 wurde betätigt");
            if (testDataFormat(testLabel.getText()).equals("csv"))
            {
            	System.out.println("CSV");
            	TablesOperationsInterface tOp = new CSVOperations();
            	if (encryptionType==1){
            	try {
					tOp.managerEncryptor(testLabel.getText(), encryption, Integer.parseInt(tfKey.getText()));
					testLabel.setText("");
					tOp= null;
            	} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            	}
            	if (encryptionType==2){
            		TablesOperationsInterface  tOp2 = new CSVOperations();
            		try {
                		
    					tOp2.managerDecryptor(testLabel.getText(), encryption, Integer.parseInt(tfKey.getText()));
    					testLabel.setText("");
    					
            		} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
                	}
            }
            else 
            {
            	System.out.println("EXCEL");
            	if (encryptionType==1)
            	{
            		TablesOperationsInterface tOp = new ExcelOperations();
            		try {
    					tOp.managerEncryptor(testLabel.getText(), encryption, Integer.parseInt(tfKey.getText()));
    					testLabel.setText("");
    					tOp= null;
                	} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            	}
            	if (encryptionType==2)
            	{
            		TablesOperationsInterface  tOp2 = new ExcelOperations();
            		try {
                		
    					tOp2.managerDecryptor(testLabel.getText(), encryption, Integer.parseInt(tfKey.getText()));
    					testLabel.setText("");
    					
            		} catch (IOException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				} catch (Exception e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
            	}
            }
            path="";
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

}
