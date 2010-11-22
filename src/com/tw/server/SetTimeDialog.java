package com.tw.server;

import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SetTimeDialog extends JFrame 
{
	private JPanel jPanelTime = null;
	private JPanel jPanel2 = null;
	private JPanel jPanelButton = null;
	private JPanel jContentPane = null;
	private JPanel jPanelUserInfo = null;

	private JLabel jLabelTime = null;
	
	protected static JComboBox jComboBoxTime = null;
	
	private JButton jButtonOK = null;
	private JButton jButtonCancel = null;

	//save other configure
	String smtpp;
	String smtph;
	String poph;
	String popp;
	String user;
	String password;

	public SetTimeDialog() {
		initialize();
		loadProperties();
	}

	public void initialize() {
		this.setSize(200, 150);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("設定時間");
	}

	public JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getJPanel2(), null);
		}
		return jContentPane;
	}

	public JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints15.gridy = 2;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridy = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.fill = GridBagConstraints.NONE;
			gridBagConstraints9.insets = new Insets(5, 0, 0, 0);
			gridBagConstraints9.gridwidth = 1;
			gridBagConstraints9.ipadx = 0;
			gridBagConstraints9.ipady = 0;
			gridBagConstraints9.weightx = 0.0;
			gridBagConstraints9.anchor = GridBagConstraints.CENTER;
			gridBagConstraints9.gridy = 4;
			
			//add layout
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJPanelInfo(), gridBagConstraints15);
			jPanel2.add(getJPanelButton(), gridBagConstraints9);			
		}
		return jPanel2;
	}

	public JPanel getJPanelInfo() {
		if (jPanelUserInfo == null) 
		{
			jLabelTime = new JLabel();
			jLabelTime.setText("時間(單位分鐘):");
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 4;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(0, 0, 2, 4);
			
			jPanelUserInfo = new JPanel();
			TitledBorder titledBorderUserInfo = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 142)),"User Information");
			jPanelUserInfo.setBorder(titledBorderUserInfo);
			jPanelUserInfo.setLayout(new GridBagLayout());
			jPanelUserInfo.add(jLabelTime, gridBagConstraints4);
			jPanelUserInfo.add(getJTextFieldUser(), gridBagConstraints5);
		}
		return jPanelUserInfo;
	}
	
	public JComboBox getJTextFieldUser() 
	{
		if (jComboBoxTime == null) {
			jComboBoxTime = new JComboBox();
		}
		return jComboBoxTime;
	}

	public JPanel getJPanelButton() {
		if (jPanelButton == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setRows(1);
			gridLayout2.setVgap(0);
			gridLayout2.setHgap(10);
			jPanelButton = new JPanel();
			jPanelButton.setLayout(gridLayout2);
			jPanelButton.add(getJButtonOK(), null);
			jPanelButton.add(getJButtonCancel(), null);
		}
		return jPanelButton;
	}

	public JButton getJButtonOK() {
		if (jButtonOK == null) {
			jButtonOK = new JButton();
			jButtonOK.setText("儲存(S)");
			jButtonOK.setMnemonic(java.awt.event.KeyEvent.VK_S);
			jButtonOK.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveProperties();
					dispose();
				}
			});
		}
		return jButtonOK;
	}

	public JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("放棄");
			jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cancel();
				}
			});
		}
		return jButtonCancel;
	}
	
	public void saveProperties() {
		try {
			Properties p = new Properties();

			FileOutputStream os = new FileOutputStream("profile.properties");

			//save configure
			p.setProperty("smtp.host", smtpp) ;
            p.setProperty("smtp.port", smtph) ;
            p.setProperty("pop.host", poph) ;
            p.setProperty("pop.port", popp) ;
            p.setProperty("username", user) ;

            //save time
			String item= (String) jComboBoxTime.getSelectedItem();
			if (item.equals("不使用"))
			{
				p.setProperty("recievetimer", "0");			
			}
			else
			{
				p.setProperty("recievetimer", item);	
				//EmailClient.setAutoRecievemail();
			}
			
			p.store(os, null);
			os.close();
			
        } catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void loadProperties() {
		try {
			Properties p = new Properties();
			FileInputStream in = new FileInputStream("profile.properties");
			p.load(in);

			//if exist, load configure
			smtpp = p.getProperty("smtp.host");
			smtph = p.getProperty("smtp.port");
			poph = p.getProperty("pop.host");
			popp = p.getProperty("pop.port");
			user = p.getProperty("username");
			password = p.getProperty("password");
			            
            String default_time = null;
            default_time = p.getProperty("recievetimer");
            
			//add item
			jComboBoxTime.addItem("不使用");
			jComboBoxTime.addItem("1");
			jComboBoxTime.addItem("5");
			jComboBoxTime.addItem("10");
			jComboBoxTime.addItem("30");
			jComboBoxTime.addItem("60");
			jComboBoxTime.addItem("120");
			jComboBoxTime.addItem("180");

            if (default_time.equals("0"))
            	jComboBoxTime.setSelectedItem(0);
            else
            {
            	if (default_time.equals("1"))
            	{
                	jComboBoxTime.setSelectedItem(1);
            	}
            	else if (default_time.equals("5"))
            	{
                	jComboBoxTime.setSelectedItem(2);
            	}
            	else if (default_time.equals("10"))
            	{
                	jComboBoxTime.setSelectedItem(3);
            	}
            	else if (default_time.equals("30"))
            	{
                	jComboBoxTime.setSelectedItem(4);
            	}
            	else if (default_time.equals("60"))
            	{
                	jComboBoxTime.setSelectedItem(5);
            	}
            	else if (default_time.equals("120"))
            	{
                	jComboBoxTime.setSelectedItem(6);
            	}
            	else if (default_time.equals("180"))
            	{
                	jComboBoxTime.setSelectedItem(7);
            	}
            }
			

			in.close() ;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
    public void actionPerformed(java.awt.event.ActionEvent evt) {
		if (evt.getSource() == jButtonOK) {
            saveProperties();
        }
        else if (evt.getSource() == jButtonCancel) {
            cancel();
        }
    }
	
	public void cancel() {
        dispose();
    }
}
