package myakinen.icw2.htw_berlin.de.Provitro.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import myakinen.icw2.htw_berlin.de.ProvitroAPI.ConfigurationInterface;

public class GUI extends JFrame implements ActionListener {

	JButton inputData;
    JButton encryptButton;
    JButton button3;
    JLabel testLabel;
    JPanel panel;
    JTextField tfKey;
    JLabel keyLabel;
    String path;
    int encryption;
    int key;
    boolean encryptionType;
    
	public GUI()
	{
		path="";
		encryptionType=true;
		this.setTitle("Provitro-Tool");
        this.setSize(900, 700);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        testLabel = new JLabel("Keine Datei gewählt");
 
        //Drei Buttons werden erstellt
        inputData = new JButton("Datei Laden");
        encryptButton = new JButton ("Ausführen");
        keyLabel = new JLabel("Schlüssel");
        tfKey = new JTextField("", 15);
 
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
        panel.add(nexus);
        panel.add(DES);
        panel.add(RC4);
        
        
        //JRadioButtons Pseudo/Depseudo 
        JRadioButton pseudo = new JRadioButton("pseudonymisieren",true);
        JRadioButton depseudo = new JRadioButton("depseudonymisieren");
 
        //ButtonGroup wird erstellt
        ButtonGroup typeEncryption = new ButtonGroup();
 
        //JRadioButtons werden zur ButtonGroup hinzugefügt
        typeEncryption.add(pseudo);
        typeEncryption.add(depseudo);
        if (pseudo.isSelected())
        	encryptionType=true;
        if (depseudo.isSelected())
        	encryptionType=false;
        	
        //JRadioButtons werden Panel hinzugefügt
        panel.add(pseudo);
        panel.add(depseudo);
        
        panel.add(keyLabel);
        panel.add(tfKey);
        
        //Buttons werden dem JPanel hinzugefügt
        panel.add(inputData);
        panel.add(encryptButton);
        
 
        //JLabel wird dem Panel hinzugefügt
        panel.add(testLabel);
        this.add(panel);

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == this.inputData){
			
            testLabel.setText((""));
            FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate:xlsx und csv ", 
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
            }
            else 
            {
            	System.out.println("EXCEL");
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

}
