package com.tw.server;
import java.io.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class ProfileDialog extends JFrame {
	private JPanel jPanelSmtpSet = null;
	private JPanel jPanelPopSet = null;
	private JPanel jPanel2 = null;
	private JPanel jPanelButton = null;
	private JPanel jContentPane = null;
	private JPanel jPanelUserInfo = null;

	private JLabel jLabelPopHost = null;
	private JLabel jLabelPopPort = null;
	private JLabel jLabelPwd = null;
	private JLabel jLabelUser = null;	
	private JLabel jLabelSmtpPort = null;
	private JLabel jLabelSmtpHost = null;
	
	protected JTextField jTextFieldPopPort = null;
	protected JTextField jTextFieldPopHost = null;
	protected static JTextField jTextFieldUser = null;
	protected static JTextField jTextFieldSmtpHost = null;
	protected static JTextField jTextFieldSmtpPort = null;	
	protected static JPasswordField jPasswordField = null;
	
	private JButton jButtonOK = null;
	private JButton jButtonCancel = null;

	public ProfileDialog() {
		initialize();
		loadProperties();
	}

	public void initialize() {
		this.setSize(396, 354);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("設定");
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
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints8.gridy = 3;
			gridBagConstraints8.ipadx = 241;
			gridBagConstraints8.ipady = 14;
			gridBagConstraints8.anchor = GridBagConstraints.WEST;
			gridBagConstraints8.weightx = 0.0;
			gridBagConstraints8.gridwidth = 1;
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.gridheight = 1;
			gridBagConstraints8.gridx = 0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(getJPanelUserInfo(), gridBagConstraints8);
			jPanel2.add(getJPanelButton(), gridBagConstraints9);
			jPanel2.add(getJPanelSmtpSet(), gridBagConstraints10);
			jPanel2.add(getJPanelPopSet(), gridBagConstraints15);
		}
		return jPanel2;
	}

	public JPanel getJPanelUserInfo() {
		if (jPanelUserInfo == null) {
			jLabelPopPort = new JLabel();
			jLabelPopPort.setText("POP3 PORT:");
			jLabelPopHost = new JLabel();
			jLabelPopHost.setText("POP3 HOST:");
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 5;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 5;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.insets = new Insets(0, 0, 2, 4);
			jLabelPwd = new JLabel();
			jLabelPwd.setText("PASSWORD:");
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
			jLabelUser = new JLabel();
			jLabelUser.setText("USERNAME:");
			jLabelSmtpPort = new JLabel();
			jLabelSmtpPort.setText("SMTP PORT:");
			jLabelSmtpHost = new JLabel();
			jLabelSmtpHost.setText("SMTP HOST:");
			jPanelUserInfo = new JPanel();
			TitledBorder titledBorderUserInfo = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 142)),"User Information");
			jPanelUserInfo.setBorder(titledBorderUserInfo);
			jPanelUserInfo.setLayout(new GridBagLayout());
			jPanelUserInfo.add(jLabelUser, gridBagConstraints4);
			jPanelUserInfo.add(getJTextFieldUser(), gridBagConstraints5);
			jPanelUserInfo.add(jLabelPwd, gridBagConstraints6);
			jPanelUserInfo.add(getjPasswordField(), gridBagConstraints7);
		}
		return jPanelUserInfo;
	}

	public JTextField getJTextFieldSmtpHost() {
		if (jTextFieldSmtpHost == null) {
			jTextFieldSmtpHost = new JTextField();
		}
		return jTextFieldSmtpHost;
	}

	public JTextField getJTextFieldSmtpPort() {
		if (jTextFieldSmtpPort == null) {
			jTextFieldSmtpPort = new JTextField();
		}
		return jTextFieldSmtpPort;
	}

	public JTextField getJTextFieldUser() {
		if (jTextFieldUser == null) {
			jTextFieldUser = new JTextField();
		}
		return jTextFieldUser;
	}

	public JPasswordField getjPasswordField() {
		if (jPasswordField == null) {
			jPasswordField = new JPasswordField();
		}
		return jPasswordField;
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

            p.setProperty("smtp.host", jTextFieldSmtpHost.getText()) ;
            p.setProperty("smtp.port", jTextFieldSmtpPort.getText()) ;
            p.setProperty("pop.host", jTextFieldPopHost.getText()) ;
            p.setProperty("pop.port", jTextFieldPopPort.getText()) ;
            p.setProperty("username", jTextFieldUser.getText()) ;
            p.setProperty("password", jPasswordField.getText()) ;
			
			EmailClient.jTextFieldSender.setText(jTextFieldUser.getText()+"@gmail.com");
			
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

			jTextFieldSmtpHost.setText(p.getProperty("smtp.host")) ;
			jTextFieldSmtpPort.setText(p.getProperty("smtp.port"));
			jTextFieldPopHost.setText(p.getProperty("pop.host"));
			jTextFieldPopPort.setText(p.getProperty("pop.port"));
			jTextFieldUser.setText(p.getProperty("username"));
			jPasswordField.setText(p.getProperty("password"));

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

	private JTextField getJTextFieldPopHost() {
		if (jTextFieldPopHost == null) {
			jTextFieldPopHost = new JTextField();
		}
		return jTextFieldPopHost;
	}

	private JTextField getJTextFieldPopPort() {
		if (jTextFieldPopPort == null) {
			jTextFieldPopPort = new JTextField();
		}
		return jTextFieldPopPort;
	}

	private JPanel getJPanelSmtpSet() {
		if (jPanelSmtpSet == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.anchor = GridBagConstraints.CENTER;
			gridBagConstraints2.insets = new Insets(0, 0, 2, 4);
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = 0;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(0, 0, 2, 4);
			jPanelSmtpSet = new JPanel();
			TitledBorder titledBorderSmtp = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 142)),"SMTP");
			jPanelSmtpSet.setBorder(titledBorderSmtp);
			jPanelSmtpSet.setLayout(new GridBagLayout());
			jPanelSmtpSet.add(jLabelSmtpHost, gridBagConstraints);
			jPanelSmtpSet.add(getJTextFieldSmtpHost(), gridBagConstraints1);
			jPanelSmtpSet.add(jLabelSmtpPort, gridBagConstraints2);
			jPanelSmtpSet.add(getJTextFieldSmtpPort(), gridBagConstraints3);
		}
		return jPanelSmtpSet;
	}

	/**
	 * This method initializes jPanelPopSet	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelPopSet() {
		if (jPanelPopSet == null) {
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints14.gridx = 1;
			gridBagConstraints14.gridy = 1;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.anchor = GridBagConstraints.WEST;
			gridBagConstraints13.insets = new Insets(0, 0, 2, 4);
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.gridy = 1;
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.gridy = 0;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.insets = new Insets(0, 0, 2, 0);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(0, 0, 2, 4);
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			jPanelPopSet = new JPanel();
			TitledBorder titledBorderPop = new TitledBorder(BorderFactory.createEtchedBorder(Color.white,new Color(142, 142, 142)),"POP3");
			jPanelPopSet.setBorder(titledBorderPop);
			jPanelPopSet.setLayout(new GridBagLayout());
			jPanelPopSet.add(jLabelPopHost, gridBagConstraints11);
			jPanelPopSet.add(getJTextFieldPopHost(), gridBagConstraints12);
			jPanelPopSet.add(jLabelPopPort, gridBagConstraints13);
			jPanelPopSet.add(getJTextFieldPopPort(), gridBagConstraints14);
		}
		return jPanelPopSet;
	}

}