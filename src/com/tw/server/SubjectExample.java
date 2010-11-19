package com.tw.server;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.awt.Insets;

public class SubjectExample extends JFrame{
	private JPanel jContentPane = null;

	private JPanel jPanel = null;

	private JTextField jTextFieldSample1 = null;

	private JTextField jTextFieldSample2 = null;

	private JTextField jTextFieldSample3 = null;

	private JTextField jTextFieldSample4 = null;

	private JTextField jTextFieldSample5 = null;

	private JTextField jTextFieldSample6 = null;

	private JButton jButtonPlus1 = null;

	private JButton jButtonPlus2 = null;

	private JButton jButtonPlus3 = null;

	private JButton jButtonPlus4 = null;

	private JButton jButtonPlus5 = null;

	private JButton jButtonPlus6 = null;

	private JButton jButtonSave = null;

	private JPanel jPanel1 = null;

	private JButton jButtonCancel = null;

	/**
	 * This is the default constructor
	 */
	public SubjectExample() {
		super();
		initialize();
		loadSubjectExample();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(299, 282);
		this.setContentPane(getJContentPane());
		this.setTitle("常用主旨");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(1);
			jContentPane = new JPanel();
			jContentPane.setLayout(gridLayout);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints81 = new GridBagConstraints();
			gridBagConstraints81.gridx = 0;
			gridBagConstraints81.anchor = GridBagConstraints.EAST;
			gridBagConstraints81.gridy = 6;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints61.gridy = 5;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.gridx = 1;
			gridBagConstraints51.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints51.gridy = 4;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints41.gridy = 3;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints31.gridy = 2;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints21.gridy = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints6.insets = new Insets(0, 5, 5, 5);
			gridBagConstraints6.gridy = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 5;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 3;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.insets = new Insets(0, 2, 5, 0);
			gridBagConstraints.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJTextFieldSample1(), gridBagConstraints);
			jPanel.add(getJTextFieldSample2(), gridBagConstraints1);
			jPanel.add(getJTextFieldSample3(), gridBagConstraints2);
			jPanel.add(getJTextFieldSample4(), gridBagConstraints3);
			jPanel.add(getJTextFieldSample5(), gridBagConstraints4);
			jPanel.add(getJTextFieldSample6(), gridBagConstraints5);
			jPanel.add(getJButtonPlus1(), gridBagConstraints6);
			jPanel.add(getJButtonPlus2(), gridBagConstraints21);
			jPanel.add(getJButtonPlus3(), gridBagConstraints31);
			jPanel.add(getJButtonPlus4(), gridBagConstraints41);
			jPanel.add(getJButtonPlus5(), gridBagConstraints51);
			jPanel.add(getJButtonPlus6(), gridBagConstraints61);
			jPanel.add(getJPanel1(), gridBagConstraints81);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextFieldSample1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample1() {
		if (jTextFieldSample1 == null) {
			jTextFieldSample1 = new JTextField();
		}
		return jTextFieldSample1;
	}

	/**
	 * This method initializes jTextFieldSample2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample2() {
		if (jTextFieldSample2 == null) {
			jTextFieldSample2 = new JTextField();
		}
		return jTextFieldSample2;
	}

	/**
	 * This method initializes jTextFieldSample3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample3() {
		if (jTextFieldSample3 == null) {
			jTextFieldSample3 = new JTextField();
		}
		return jTextFieldSample3;
	}

	/**
	 * This method initializes jTextFieldSample4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample4() {
		if (jTextFieldSample4 == null) {
			jTextFieldSample4 = new JTextField();
		}
		return jTextFieldSample4;
	}

	/**
	 * This method initializes jTextFieldSample5	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample5() {
		if (jTextFieldSample5 == null) {
			jTextFieldSample5 = new JTextField();
		}
		return jTextFieldSample5;
	}

	/**
	 * This method initializes jTextFieldSample6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextFieldSample6() {
		if (jTextFieldSample6 == null) {
			jTextFieldSample6 = new JTextField();
		}
		return jTextFieldSample6;
	}

	/**
	 * This method initializes jButtonPlus1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus1() {
		if (jButtonPlus1 == null) {
			jButtonPlus1 = new JButton();
			jButtonPlus1.setText("+");
			jButtonPlus1.setToolTipText("插入主旨");
			jButtonPlus1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample1.getText());
				}
			});
		}
		return jButtonPlus1;
	}
	
	public void saveSubjectExample() {
		try {
			Properties p = new Properties();

			FileOutputStream fos = new FileOutputStream("subex.properties");

			p.setProperty("subex.1", jTextFieldSample1.getText());
			p.setProperty("subex.2", jTextFieldSample2.getText());
			p.setProperty("subex.3", jTextFieldSample3.getText());
			p.setProperty("subex.4", jTextFieldSample4.getText());
			p.setProperty("subex.5", jTextFieldSample5.getText());
			p.setProperty("subex.6", jTextFieldSample6.getText());

			p.store(fos, null);
			fos.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void loadSubjectExample() {
		try {
			Properties p = new Properties();

			FileInputStream fin = new FileInputStream("subex.properties");

			p.load(fin);

			jTextFieldSample1.setText(p.getProperty("subex.1"));
			jTextFieldSample2.setText(p.getProperty("subex.2"));
			jTextFieldSample3.setText(p.getProperty("subex.3"));
			jTextFieldSample4.setText(p.getProperty("subex.4"));
			jTextFieldSample5.setText(p.getProperty("subex.5"));
			jTextFieldSample6.setText(p.getProperty("subex.6"));

			fin.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * This method initializes jButtonPlus2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus2() {
		if (jButtonPlus2 == null) {
			jButtonPlus2 = new JButton();
			jButtonPlus2.setText("+");
			jButtonPlus2.setToolTipText("插入主旨");
			jButtonPlus2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample2.getText());
				}
			});
		}
		return jButtonPlus2;
	}

	/**
	 * This method initializes jButtonPlus3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus3() {
		if (jButtonPlus3 == null) {
			jButtonPlus3 = new JButton();
			jButtonPlus3.setText("+");
			jButtonPlus3.setToolTipText("插入主旨");
			jButtonPlus3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample3.getText());
				}
			});
		}
		return jButtonPlus3;
	}

	/**
	 * This method initializes jButtonPlus4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus4() {
		if (jButtonPlus4 == null) {
			jButtonPlus4 = new JButton();
			jButtonPlus4.setText("+");
			jButtonPlus4.setToolTipText("插入主旨");
			jButtonPlus4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample4.getText());
				}
			});
		}
		return jButtonPlus4;
	}

	/**
	 * This method initializes jButtonPlus5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus5() {
		if (jButtonPlus5 == null) {
			jButtonPlus5 = new JButton();
			jButtonPlus5.setText("+");
			jButtonPlus5.setToolTipText("插入主旨");
			jButtonPlus5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample5.getText());
				}
			});
		}
		return jButtonPlus5;
	}

	/**
	 * This method initializes jButtonPlus6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPlus6() {
		if (jButtonPlus6 == null) {
			jButtonPlus6 = new JButton();
			jButtonPlus6.setText("+");
			jButtonPlus6.setToolTipText("插入主旨");
			jButtonPlus6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					EmailClient.jTextFieldSubject.setText(EmailClient.jTextFieldSubject.getText()+jTextFieldSample6.getText());
				}
			});
		}
		return jButtonPlus6;
	}

	/**
	 * This method initializes jButtonSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSave() {
		if (jButtonSave == null) {
			jButtonSave = new JButton();
			jButtonSave.setText("儲存");
			jButtonSave.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveSubjectExample();
					dispose();
				}
			});
		}
		return jButtonSave;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints8.gridy = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.NONE;
			gridBagConstraints7.gridwidth = 1;
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.gridy = 0;
			gridBagConstraints7.insets = new Insets(0, 0, 0, 0);
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.add(getJButtonSave(), gridBagConstraints7);
			jPanel1.add(getJButtonCancel(), gridBagConstraints8);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButtonCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonCancel() {
		if (jButtonCancel == null) {
			jButtonCancel = new JButton();
			jButtonCancel.setText("關閉");
			jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return jButtonCancel;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"