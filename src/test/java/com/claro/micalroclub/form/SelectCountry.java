package com.claro.micalroclub.form;

import javax.swing.*;
import java.awt.event.*;

public class SelectCountry extends JFrame implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo1;
    public SelectCountry() {
        
    	setLayout(null);
        combo1=new JComboBox<String>();
        combo1.setBounds(10,10,80,20);
        add(combo1)	;
        combo1.addItem(new ComboItem("NI",".xml/Mobile/NI").toString());	
        combo1.addItemListener(this);
    }
    
    
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource()==combo1) {
            Object item=combo1.getSelectedItem();
            setTitle(((ComboItem)item).getValue());
        }
		
	}
	
}
