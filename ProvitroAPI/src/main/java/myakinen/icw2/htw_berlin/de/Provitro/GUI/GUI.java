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
	/*public JFrame mainFrame;
	public JPanel panel;
	public JLabel keyLabel;
	public JTextField tfKey;
	public JButton encryptButton;
	public JLabel test;*/
	JButton inputData;
    JButton encryptButton;
    JButton button3;
    JLabel testLabel;
    JPanel panel;
    JTextField tfKey;
    JLabel keyLabel;
	public GUI(){
	
	/*this.setTitle("Provitro-Tool");
    this.setSize(900, 700);
	
	test= new JLabel("Beispiel JLabel");
	panel = new JPanel();
    keyLabel = new JLabel("Schlüssel");
    panel = new JPanel();
    tfKey = new JTextField("", 15);
    encryptButton = new JButton("Daten pseudenonymisieren/depseudonymisieren");
 
    encryptButton.addActionListener(this);
    
	panel.add(test);
	panel.add(tfKey);
    panel.add(keyLabel);
    panel.add(tfKey);
    panel.add(encryptButton);
    panel.add(test);*/
		this.setTitle("Provitro-Tool");
        this.setSize(900, 700);
        panel = new JPanel();
 
        // Leeres JLabel-Objekt wird erzeugt
        testLabel = new JLabel();
 
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
		/*if(e.getSource() == this.encryptButton){
            test.setText(("Button 1 wurde betätigt"));
        }*/
		
		if(e.getSource() == this.inputData){
			
            testLabel.setText(("Button 1 wurde betätigt"));
            FileFilter filter = new FileNameExtensionFilter("Unterstüzte Formate:xlsx und csv ", 
                    "xlsx", "csv"); 
            JFileChooser chooser = new JFileChooser();
            chooser.addChoosableFileFilter(filter);
            int rueckgabeWert = chooser.showOpenDialog(null);
            if(rueckgabeWert == JFileChooser.APPROVE_OPTION)
            {
                testLabel.setText(pathModification(chooser.getSelectedFile().getPath()));
            }
        }
        else if(e.getSource() == this.encryptButton){
            testLabel.setText("Button 2 wurde betätigt");
        }
        
        
	}
	
	public String pathModification(String path) {
		// TODO Auto-generated method stub
		return path.replace("\\", "/");
		}

}
