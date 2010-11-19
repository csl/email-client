package com.tw.server;

import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.BoxLayout;

public class Calculator extends Frame {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JTextField jTextField = null;
	private JPanel jPanel1 = null;
	private JButton jButtonAdd = null;
	private JButton jButtonSub = null;
	private JButton jButtonMul = null;
	private JButton jButtonDiv = null;
	private JButton jButtonSum = null;
	private JPanel jPanel2 = null;
	private JButton jButtonNum0 = null;
	private JButton jButtonNum1 = null;
	private JButton jButtonNum2 = null;
	private JButton jButtonNum3 = null;
	private JButton jButtonNum4 = null;
	private JButton jButtonNum5 = null;
	private JButton jButtonNum6 = null;
	private JButton jButtonNum7 = null;
	private JButton jButtonNum8 = null;
	private JButton jButtonNum9 = null;
	private JButton jButtonDot = null;
	private JButton jButtonPM = null;
	protected double tmp;
	protected double sum;
	protected String opr;
	protected Boolean flg;
	private JButton jButtonClear = null;
	private JButton jButtonMod = null;
	private JButton jButtonFra = null;
	
	/**
	 * This is the default constructor
	 */
	public Calculator() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(3);
		borderLayout.setHgap(3);
		this.setLayout(borderLayout);
		this.setSize(300, 200);
		this.setTitle("Â²©ö­pºâ¾÷");

		this.add(getJPanel(), BorderLayout.NORTH);
		this.add(getJPanel1(), BorderLayout.WEST);
		this.add(getJPanel2(), BorderLayout.CENTER);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				dispose();
			}
		});
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.weightx = 1.0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setName("jPanel");
			jPanel.add(getJTextField(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		return jTextField;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(4);
			gridLayout.setVgap(3);
			gridLayout.setHgap(2);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = -1;
			gridBagConstraints2.gridy = -1;
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout);
			jPanel1.add(getJButtonAdd(), null);
			jPanel1.add(getJButtonSub(), null);
			jPanel1.add(getJButtonMul(), null);
			jPanel1.add(getJButtonDiv(), null);
			jPanel1.add(getJButtonMod(), null);
			jPanel1.add(getJButtonFra(), null);
			jPanel1.add(getJButtonClear(), null);
			jPanel1.add(getJButtonSum(), null);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jButtonAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setText("+");
			jButtonAdd.setName("jButtonAdd");
			jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = tmp;
					opr = "+";
				}
			});
		}
		return jButtonAdd;
	}

	/**
	 * This method initializes jButtonSub	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSub() {
		if (jButtonSub == null) {
			jButtonSub = new JButton();
			jButtonSub.setText("-");
			jButtonSub.setName("jButtonSub");
			jButtonSub.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = tmp;
					opr = "-";
				}
			});
		}
		return jButtonSub;
	}

	/**
	 * This method initializes jButtonMul	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMul() {
		if (jButtonMul == null) {
			jButtonMul = new JButton();
			jButtonMul.setText("*");
			jButtonMul.setName("jButtonMul");
			jButtonMul.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = tmp;
					opr = "*";
				}
			});
		}
		return jButtonMul;
	}

	/**
	 * This method initializes jButtonDiv	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDiv() {
		if (jButtonDiv == null) {
			jButtonDiv = new JButton();
			jButtonDiv.setText("/");
			jButtonDiv.setName("jButtonDiv");
			jButtonDiv.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = tmp;
					opr = "/";
				}
			});
		}
		return jButtonDiv;
	}

	/**
	 * This method initializes jButtonSum	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSum() {
		if (jButtonSum == null) {
			jButtonSum = new JButton();
			jButtonSum.setText("=");
			jButtonSum.setName("jButtonSum");
			jButtonSum.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (opr == "+"){
						sum = sum + tmp;
						jTextField.setText(Double.toString(sum));
					}
					else if(opr == "-"){
						sum = sum - tmp;
						jTextField.setText(Double.toString(sum));
					}
					else if(opr == "*"){
						sum = sum * tmp;
						jTextField.setText(Double.toString(sum));
					}
					else if(opr == "/"){
						sum = sum / tmp;
						jTextField.setText(Double.toString(sum));
					}
					else if(opr == "%"){
						sum = sum % tmp;
						jTextField.setText(Double.toString(sum));
					}
					else {}
				}
			});
		}
		return jButtonSum;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setVgap(3);
			gridLayout1.setHgap(3);
			jPanel2 = new JPanel();
			jPanel2.setLayout(gridLayout1);
			jPanel2.add(getJButtonNum7(), null);
			jPanel2.add(getJButtonNum8(), null);
			jPanel2.add(getJButtonNum9(), null);
			jPanel2.add(getJButtonNum4(), null);
			jPanel2.add(getJButtonNum5(), null);
			jPanel2.add(getJButtonNum6(), null);
			jPanel2.add(getJButtonNum1(), null);
			jPanel2.add(getJButtonNum2(), null);
			jPanel2.add(getJButtonNum3(), null);
			jPanel2.add(getJButtonNum0(), null);
			jPanel2.add(getJButtonDot(), null);
			jPanel2.add(getJButtonPM(), null);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jButtonNum0	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum0() {
		if (jButtonNum0 == null) {
			jButtonNum0 = new JButton();
			jButtonNum0.setText("0");
			jButtonNum0.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) { 
					jTextField.setText(jTextField.getText()+"0");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum0;
	}

	/**
	 * This method initializes jButtonNum1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum1() {
		if (jButtonNum1 == null) {
			jButtonNum1 = new JButton();
			jButtonNum1.setText("1");
			jButtonNum1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"1");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum1;
	}

	/**
	 * This method initializes jButtonNum2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum2() {
		if (jButtonNum2 == null) {
			jButtonNum2 = new JButton();
			jButtonNum2.setText("2");
			jButtonNum2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"2");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum2;
	}

	/**
	 * This method initializes jButtonNum3	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum3() {
		if (jButtonNum3 == null) {
			jButtonNum3 = new JButton();
			jButtonNum3.setText("3");
			jButtonNum3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"3");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum3;
	}

	/**
	 * This method initializes jButtonNum4	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum4() {
		if (jButtonNum4 == null) {
			jButtonNum4 = new JButton();
			jButtonNum4.setText("4");
			jButtonNum4.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"4");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum4;
	}

	/**
	 * This method initializes jButtonNum5	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum5() {
		if (jButtonNum5 == null) {
			jButtonNum5 = new JButton();
			jButtonNum5.setText("5");
			jButtonNum5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"5");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum5;
	}

	/**
	 * This method initializes jButtonNum6	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum6() {
		if (jButtonNum6 == null) {
			jButtonNum6 = new JButton();
			jButtonNum6.setText("6");
			jButtonNum6.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"6");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum6;
	}

	/**
	 * This method initializes jButtonNum7	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum7() {
		if (jButtonNum7 == null) {
			jButtonNum7 = new JButton();
			jButtonNum7.setText("7");
			jButtonNum7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"7");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum7;
	}

	/**
	 * This method initializes jButtonNum8	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum8() {
		if (jButtonNum8 == null) {
			jButtonNum8 = new JButton();
			jButtonNum8.setText("8");
			jButtonNum8.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"8");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum8;
	}

	/**
	 * This method initializes jButtonNum9	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNum9() {
		if (jButtonNum9 == null) {
			jButtonNum9 = new JButton();
			jButtonNum9.setText("9");
			jButtonNum9.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+"9");
					tmp = Double.parseDouble(jTextField.getText());
				}
			});
		}
		return jButtonNum9;
	}

	/**
	 * This method initializes jButtonDot	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonDot() {
		if (jButtonDot == null) {
			jButtonDot = new JButton();
			jButtonDot.setText(".");
			jButtonDot.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jTextField.setText(jTextField.getText()+".");
				}
			});
		}
		return jButtonDot;
	}

	/**
	 * This method initializes jButtonPM	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPM() {
		if (jButtonPM == null) {
			jButtonPM = new JButton();
			jButtonPM.setText("+/-");
			jButtonPM.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(tmp!=0) {
						jTextField.setText("-"+jTextField.getText());
					} else {}
				}
			});
		}
		return jButtonPM;
	}

	/**
	 * This method initializes jButtonClear	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonClear() {
		if (jButtonClear == null) {
			jButtonClear = new JButton();
			jButtonClear.setText("C");
			jButtonClear.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = 0; tmp = 0;
				}
			});
		}
		return jButtonClear;
	}
	
	private void Clear() {
		jTextField.setText("");
	}

	/**
	 * This method initializes jButtonMod	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMod() {
		if (jButtonMod == null) {
			jButtonMod = new JButton();
			jButtonMod.setText("%");
			jButtonMod.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = tmp;
					opr = "%";
				}
			});
		}
		return jButtonMod;
	}

	/**
	 * This method initializes jButtonFra	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonFra() {
		if (jButtonFra == null) {
			jButtonFra = new JButton();
			jButtonFra.setText("1/x");
			jButtonFra.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Clear();
					sum = 1/tmp;
					jTextField.setText(Double.toString(sum));
				}
			});
		}
		return jButtonFra;
	}

}
