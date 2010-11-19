package com.tw.server;

import java.io.*;//�ޤJ��������
import java.util.*;
import java.lang.Thread;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
 
public class MyCalendar extends javax.swing.JFrame //�إߤ@��������
{
  private JDesktopPane jDesktopPane1;//��������ŧi
  private JDesktopPane jDesktopPane2;
  private JButton jButton1;
  private JButton jButton2;
  private JLabel jLabel2;
  private JLabel jLabel4;
  private JLabel jLabel3;
  private JLabel jLabel5;
  private JLabel jLabel6;
  private JLabel jLabel7;
  private JLabel jLabel8;
  private JComboBox jComboBox1;
  private JTextField jTextField1;
  private JButton jButton3;
  private JTextArea jTextArea1;
  private JLabel jLabel1;
 
  public static void main(String[] args) throws IOException//�D�{���}�l
  {
    MyCalendar inst = new MyCalendar();
    inst.setVisible(true);
  }//�D�{������
  
  public MyCalendar()//�إߵ����}�l
  {
    super();
    initGUI();//�I�sGUI���
  }//�إߵ�������
  
  public int[] getdate()//���o�t�Τ����ƶ}�l
  {
    int[] date_array = new int[3];
    Calendar ca = new GregorianCalendar();  
    date_array[0] = ca.get(Calendar.YEAR);//�~
    date_array[1] = ca.get(Calendar.MONTH)+1;//��
    date_array[2] = ca.get(Calendar.DAY_OF_MONTH);//��
    return date_array;//�^�Ǧۭq����}�C
  }//���o�t�Τ����Ƶ���
 
  public void new_btn()//���s���ͤ�����s��ƶ}�l
  {
    jTextArea1.setText("");//�M�ŰO��
    int year,month;
    year = Integer.parseInt(jLabel5.getText().substring(0,4));//�]�w���w��ܪ��~
    month = Integer.parseInt(jLabel5.getText().substring(7,9));//�]�w���w��ܪ���
    date_btn_create(year,month);//�I�s���ͤ�����s���
  }//���s���ͤ�����s��Ƶ���
  
  public void date_btn_create(int year,int month)//���ͤ�����s
  {
    int y=0,x=0,x_add=0,y_add=0,week_add=0,date_acc=0,week_of_day=0;
    String syear,smonth,sday,filename;
    syear = String.valueOf(year);
    smonth = String.valueOf(month);
    if (smonth.length() == 1)//�Y�p��10��(�@���)�N�b�e���[0
      smonth = "0"+smonth;
    
    jDesktopPane1.remove(jDesktopPane2);//�����ୱ2(������s���ۡA�]�N�O�������s����)
    jDesktopPane2 = new JDesktopPane();//���ͤ@�ӷs���ୱ
    jDesktopPane1.add(jDesktopPane2);
    jDesktopPane2.setBounds(0, 30, 252, 196);//�]�w�j�p�Φ�m
    jDesktopPane2.setBackground(new java.awt.Color(148,205,176));//�]�w�C��
      
    switch(month)//�]�w����Ѽ�
    {
      case 1://�j��31��
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        date_acc = 31;
        break;
        
      case 4://�p��30��
      case 6:
      case 9:
      case 11:
        date_acc = 30;
        break;
        
      case 2:
        if (leap_year(year))
          date_acc = 29;
        else
          date_acc = 28;
    }
    
    week_of_day = dow(year,month,1);//�I�s�P�����(���o���Ĥ@�Ѭ��P���X)
    
    switch(week_of_day)//�]�w���1���m(����)
    {
      case 0:
        week_add = 0;
        break;
      case 1:
        week_add = 34;
        break;
      case 2:
        week_add = 68;
        break;
      case 3:
        week_add = 102;
        break;
      case 4:
        week_add = 136;
        break;
      case 5:
        week_add = 170;
        break;
      case 6:
        week_add = 204;
        break;
    }
    JButton btn[] = new JButton[date_acc];//�إߤ�����s�}�C
    for (int i=0;i<date_acc;i++)//�إߤ�����s�}�C�j��
    {
      btn[i] = new JButton();//�إ߹���������s
      jDesktopPane2.add(btn[i]);//�[��ୱ2�W
      btn[i].setText(String.valueOf(i+1));//�]�w���s��r�����
      if ((i-week_of_day>0 && (i+week_of_day)%7==0) || ((i+week_of_day)%7==0 && i != 0))
      {//�]�w���Ĥ@�Ѥ�����s��m
        x=0;//X�b�y��
        x_add=0;//�U�@�ӫ��s�y��(X�b)�[��
        y++;//Y�b�y��
        y_add+=10;//����y��(Y�b)�[��
        week_add=0;//���Ĥ@����s�y�Х[��
      }//�U���]�w���s�j�p�Υ[��(X���_�l10+�ĴX�ӫ��s*��V�e��25+���j+���Ĥ@�ѬP���X�[��)
      btn[i].setBounds(10+x*25+x_add+week_add, y*20+y_add, 25, 20);//(Y���ĴX�ӫ��s*����20+����[��)���s�e��25����20
      btn[i].setFont(new java.awt.Font("Arial",1,12));//�]�w�r��j�p�μ˦�
      btn[i].setBorder(BorderFactory.createTitledBorder(""));//�]�w���s��r���۰ʽվ�j�p
      int[] now = new int[3];
      now = getdate();//���o��Ѥ��
      if (year == now[0] && month == now[1] && i+1 == now[2])
        btn[i].setBackground(new java.awt.Color(233,238,164));//�Y����ѫh�]�w���s������
      else
        btn[i].setBackground(new java.awt.Color(148,205,176));//�Y���O��ѫh�]�w���s�����
        
      sday = String.valueOf(i+1);
      filename = syear+smonth+sday;//�O���ɮצW��(�~+��+��.txt)
      File file=new File(filename+".txt");//�إ��ɮת���
      if (file.exists())//�Y��Ѧ��O���ɮ׫h�]�w���s�r���C�⬰�Ŧ�
        btn[i].setForeground(new java.awt.Color(0,0,255));
      
      btn[i].addActionListener(new ActionListener() {//�]�w���s��ť(Ĳ�o�ƥ���)
        public void actionPerformed(ActionEvent evt) {
          btnActionPerformed(evt);
        }
      });
      x++;//�U�@�ӫ��sX�y�Х[�v
      x_add+=9;//�U�@�ӫ��s���jX�y�Х[�v
    }
  }
  
  public boolean leap_year(int year)//�P�_�|�~��ƶ}�l
  {
    boolean leap_year;//4�����ơA�Y��100�����ƫh������4�����Ƥ~�O�|�~
    if (year%4 == 0)
    {
      if (year%100 == 0)
      {
        if (year%400 == 0)
          leap_year = true;
        else
          leap_year = false;
      }
      else
        leap_year = true;
    }
    else
      leap_year = false;
    return leap_year;
  }//�P�_�|�~��Ƶ���
  
  public int dow(int y,int m,int d)//�P�_�P���X
  {
    int[] ww={6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};//�Ѥ�P��B���
    int w;
    w=ww[m-1]+y+(y/4)-(y/100)+(y/400);//�|�~�]�w
    if( ((y%4)==0) && (m<3) )//����
    {
      w--;
      if((y%100)==0) w++;
      if((y%400)==0) w--;
    }
    return (w+d)%7;//�^�ǬP���X(0���P����A1���P���@�H������)
  }
  
  private void initGUI()//���͵�ı�ƪ�����(Graph User Interface�A�ϧΤƨϥΪ̤���)
  {
    try
    {
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//�]�w�~�ص����D�n�\��C���з�(�Y��̤p�A���̤j�A����)
      {
        this.setTitle("�U�~��ƾ�");//�]�w�������Y 
        jDesktopPane1 = new JDesktopPane();//�إߤ@�ୱ
        getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(464, 267));//�]�w�ୱ�j�p
        jDesktopPane1.setBackground(new java.awt.Color(148,205,176));//�]�w�ୱ�C��
        {//�إ߮ୱ2�}�l(�������s���ୱ)
          jDesktopPane2 = new JDesktopPane();
          jDesktopPane1.add(jDesktopPane2);
          jDesktopPane2.setBounds(0, 30, 252, 196);
          jDesktopPane2.setBackground(new java.awt.Color(148,205,176));
        }//�إ߮ୱ2����
        {//�إ߬P������Ҷ}�l
          jLabel1 = new JLabel();
          jDesktopPane1.add(jLabel1);
          jLabel1.setText("Sun");
          jLabel1.setBounds(14, 7, 21, 21);
          jLabel1.setFont(new java.awt.Font("Arial",0,11));
          jLabel1.setForeground(new java.awt.Color(255,0,0));
        }//�إ߬P������ҵ���
        {//�إ߰O�Ʈض}�l
          jTextArea1 = new JTextArea(252, 35);
          jDesktopPane1.add(jTextArea1);
          jTextArea1.setText("");//�w�]���e�M��
          jTextArea1.setBounds(252, 42, 175, 182);//�]�w�j�p
          jTextArea1.setFont(new java.awt.Font("�s�ө���",0,11));//�]�w�r��˦��j�p
          jTextArea1.setLineWrap(true);//��r�L���۰ʴ���
          jTextArea1.setWrapStyleWord(true);//��r�L���۰ʴ���
          JScrollPane scrollPane = new JScrollPane(jTextArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          jDesktopPane1.add(scrollPane);//�W�����إ�scorollpane(�������䪺���ʴ�);�N�O�Ʈثإߦbscrollpane�W
          scrollPane.setBounds(252, 42, 175, 182);//�]�w�j�p�Φ�m
        }//�إ߰O�Ʈص���
        {//�إ߲M�����s�}�l
          jButton1 = new JButton();
          jDesktopPane1.add(jButton1);
          jButton1.setText("�M��");
          jButton1.setBounds(252, 231, 63, 21);
          jButton1.setFont(new java.awt.Font("�s�ө���",0,11));
          jButton1.setBorder(BorderFactory.createTitledBorder(""));
          jButton1.addActionListener(new ActionListener() {//�]�w�M�����s��ť���
            public void actionPerformed(ActionEvent evt) {
              jButton1ActionPerformed(evt);
            }
          });
        }//�إ߲M�����s����
        {//�إ��x�s���s�}�l
          jButton2 = new JButton();
          jDesktopPane1.add(jButton2);
          jButton2.setText("�x�s");
          jButton2.setBounds(364, 231, 63, 21);
          jButton2.setFont(new java.awt.Font("�s�ө���",0,11));
          jButton2.setBorder(BorderFactory.createTitledBorder(""));
          jButton2.addActionListener(new ActionListener() {//�]�w�x�s���s��ť���
            public void actionPerformed(ActionEvent evt) {
              jButton2ActionPerformed(evt);
            }
          });
        }//�إ��x�s���s����
        {//�إ߬P���@~�P�������Ҷ}�l
          jLabel2 = new JLabel();
          jDesktopPane1.add(jLabel2);
          jLabel2.setText("Mon    Tue     Wed     Thu      Fri      Sat");
          jLabel2.setBounds(49, 7, 189, 21);
          jLabel2.setFont(new java.awt.Font("Arial",0,11));
        }//�إ߬P���@~�P�������ҵ���
        {//�إ߬d�ߦ~����J�ض}�l
          jTextField1 = new JTextField();
          jDesktopPane1.add(jTextField1);
          jTextField1.setText("");
          jTextField1.setBounds(14, 231, 63, 21);
          jTextField1.setFont(new java.awt.Font("Arial",0,12));
        }//�إ߬d�ߦ~����J�ص���
        {//�إߪ��A���Ҷ}�l
          jLabel6 = new JLabel();
          jDesktopPane1.add(jLabel6);
          jLabel6.setText("TEST");
          jLabel6.setBounds(357, 7, 70, 21);
          jLabel6.setFont(new java.awt.Font("�s�ө���",0,11));
          jLabel6.setForeground(new java.awt.Color(0,0,255));
        }//�إߪ��A���Ҷ}�l
        {//�إ����ä�����s�Ȧs���Ҷ}�l
          jLabel7 = new JLabel();
          jDesktopPane1.add(jLabel7);
          jLabel7.setText("");
          jLabel7.setBounds(0, 0, 0, 0);//�]�w�j�p��0
        }//�إ����ä�����s�Ȧs���ҵ���
        {//�إߥثe��ܤ�����Ҷ}�l
          jLabel8 = new JLabel();
          jDesktopPane1.add(jLabel8);
          jLabel8.setText("�ثe�L��ܤ��");
          jLabel8.setBounds(252, 28, 175, 14);
          jLabel8.setFont(new java.awt.Font("�s�ө���",0,11));
        }//�إߥثe��ܤ�����ҵ���
        {//�إߤ���U�Կ��}�l
          ComboBoxModel jComboBox1Model = new DefaultComboBoxModel
          (new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" });//���e�]�w1~12
          jComboBox1 = new JComboBox();
          jDesktopPane1.add(jComboBox1);
          jComboBox1.setModel(jComboBox1Model);
          jComboBox1.setBounds(105, 231, 40, 21);
          jComboBox1.setFont(new java.awt.Font("Arial",0,11));
        }//�إߤ���U�Կ�浲��
        {//�إ�"��"���Ҷ}�l
          jLabel3 = new JLabel();
          jDesktopPane1.add(jLabel3);
          jLabel3.setText("��");
          jLabel3.setBounds(155, 231, 14, 21);
          jLabel3.setFont(new java.awt.Font("�s�ө���",0,12));
        }//�إ�"��"���ҵ���
        {//�إ�"�~"���Ҷ}�l
          jLabel4 = new JLabel();
          jDesktopPane1.add(jLabel4);
          jLabel4.setText("�~");
          jLabel4.setFont(new java.awt.Font("�s�ө���", 0, 12));
          jLabel4.setBounds(84, 231, 14, 21);
        }//�إ�"�~"���ҵ���
        {//�إ߬d�߫��s�}�l
          jButton3 = new JButton();
          jDesktopPane1.add(jButton3);
          jButton3.setText("�d��");
          jButton3.setBounds(180, 231, 35, 21);
          jButton3.setBorder(BorderFactory.createTitledBorder(""));
          jButton3.setFont(new java.awt.Font("�s�ө���",0,11));
          jButton3.addActionListener(new ActionListener() {//�d�߫��s��ť���
            public void actionPerformed(ActionEvent evt) {
              jButton3ActionPerformed(evt);
            }
          });
        }//�إ߬d�߫��s����
        {//�إߥثe�~���m���Ҷ}�l
          int[] now = new int[3];
          now = getdate();//�w�]����~���
          String year5,smonth;
          year5 = String.valueOf(now[0]);
          smonth = String.valueOf(now[1]);
          if (smonth.length() == 1)
            smonth = "0"+smonth;
          
          jLabel5 = new JLabel();
          jDesktopPane1.add(jLabel5);
          jLabel5.setText(year5+" �~ "+smonth+" ��");
          jLabel5.setBounds(252, 7, 120, 21);
          jLabel5.setForeground(new java.awt.Color(255,255,255));//�]�w�r�鬰�զ�
        }//�إߥثe�~���m���ҵ���
        {//�w�]����~��������s���Ͷ}�l
          int[] now = new int[3];
          now = getdate();
          date_btn_create(now[0],now[1]);//���ͤ�����s
        }//�w�]����~��������s���͵���
      }
      pack();
      this.setSize(444, 296);
    } catch (Exception e) {//�ҥ~�B�z
      e.printStackTrace();
    }
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)//�M�����s���UĲ�o�ƥ�
  {
    jTextArea1.setText("");//�M���O�Ƥ��e
    String year,month,day,filename,insert_str;
    year = jLabel5.getText().substring(0,4);
    month = jLabel5.getText().substring(7,9);
    day = jLabel7.getText();
    filename = year+month+day;
    File file=new File(filename+".txt");//�R�����O���ɮ�
    file.delete();
    new_btn();//���s���ͫ��s
    jLabel6.setText("��ƾ�w�M��");//�]�w�����T��
    jLabel7.setText("");
    jLabel8.setText("�ثe�L��ܤ��");
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)//�x�s���s���UĲ�o�ƥ�}�l
  {
    String year,month,day,filename,insert_str;
    year = jLabel5.getText().substring(0,4);
    month = jLabel5.getText().substring(7,9);
    day = jLabel7.getText();
    filename = year+month+day;
    insert_str = jTextArea1.getText();//�O�Ƥ��e
    if (insert_str.length() != 0 && day.length() != 0)//�Y�O�Ʈؤ�����r�B����ܤ���h�x�s�O���ɮ�
    {
      try
      {
        FileWriter fw=new FileWriter(filename+".txt");//�ҥ��ɮ׼g�J
        BufferedWriter bfw=new BufferedWriter(fw);//�ҥνw�İϼg�J
        bfw.write(insert_str); //�NTextarea���e�g�J�w�İϸ�
        bfw.flush();//�N�w�İϸ�Ƽg���ɮ�
        fw.close();//�����ɮ�
        jLabel6.setText("��ƾ�w�O��");//�]�w�����T��
        jLabel7.setText("");
        jLabel8.setText("�ثe�L��ܤ��");
        new_btn();
      }catch(IOException e)
      {
        e.printStackTrace();
      }
    }
    else//�Y�L�O�Ƥ��e�εL��ܤ��
    {
      if (day.length() == 0)
        jLabel6.setText("��������");//�]�w�����T��
      else
        jLabel6.setText("��ƾ�L���e");
    }
  }//�x�s���s���UĲ�o�ƥ󵲧�
  
  private void jButton3ActionPerformed(ActionEvent evt)//�d�߫��s���UĲ�o�ƥ�}�l
  {
    String syear,smonth;
    try
    {
      jTextArea1.setText("");
      jLabel6.setText("�d�ߤ��");
      syear = jTextField1.getText();
      smonth = String.valueOf(jComboBox1.getSelectedIndex() + 1);
      if (smonth.length() == 1)
            smonth = "0"+smonth;
      if (syear == "" || Integer.parseInt(syear)<1582)//�Y����J�~���NĲ�o�ҥ~(1582�~�H�e���g���L�A���G�|���ǽT)
      {
        int[] now = new int[3];
        now = getdate();
        syear = String.valueOf(now[0]);//�Y��ܦ~���p��1582�~�h�w�]����~
        jLabel6.setText("�п�1582�H�W");
      }
      jLabel5.setText(syear+" �~ "+smonth+" ��");
      date_btn_create(Integer.parseInt(syear),Integer.parseInt(smonth));
      jLabel7.setText("");
      jLabel8.setText("�ثe�L��ܤ��");
    }catch(NumberFormatException e)//�ҥ~�B�z�]�w����~�ο�ܪ����
    {
      int[] now = new int[3];
      now = getdate();
      syear = String.valueOf(now[0]);
      smonth = String.valueOf(jComboBox1.getSelectedIndex() + 1);
      if (smonth.length() == 1)
            smonth = "0"+smonth;
      jLabel5.setText(syear+" �~ "+smonth+" ��");
      jLabel6.setText("�п�1582�H�W");
      date_btn_create(Integer.parseInt(syear),Integer.parseInt(smonth));
      jLabel7.setText("");
      jLabel8.setText("�ثe�L��ܤ��");
    }
  }//�d�߫��s���UĲ�o�ƥ󵲧�
  
  private void btnActionPerformed(ActionEvent evt)//������s���UĲ�o�ƥ�}�l
  {
    jTextArea1.setText("");
    String year,month,btn_date,filename,read_str;
    year = jLabel5.getText().substring(0,4);//���o�~
    month = jLabel5.getText().substring(7,9);//���o��
    btn_date = evt.getActionCommand();//���o���U���s��r(��)
    filename = year+month+btn_date;
    jLabel7.setText(btn_date);
    try
    {
      FileReader fr = new FileReader(filename+".txt");//Ū����ܤ���O���ɮ�
      BufferedReader bfr = new BufferedReader(fr);//�N�ɮ�Ū��w�İ�
      boolean flag=false;//�X��
      while((read_str = bfr.readLine())!=null) // �C��Ū���@��A�����ɮ׵���
      {
        if (flag)//�q�ĤG��}�l�C�@��Ĥ@�Ӧ�m�[�J�_��
          jTextArea1.append("\n");
        jTextArea1.append(read_str);//�[�J�Ӧ�T��
        flag=true;
        
      }
      jLabel6.setText("��ѰO��");
      jLabel8.setText("�w���"+year+"�~"+month+"��"+btn_date+"��");
      fr.close();
    }catch(FileNotFoundException e)//�p�G�S�����w���O���ɮ״N�L�X���L��ƾ�(�ҥ~�B�z)
    {
      jLabel6.setText("���L��ƾ�");
      jLabel8.setText("�w���"+year+"�~"+month+"��"+btn_date+"��");
    }catch(IOException e)//�ҥ~�B�z
    {
      e.printStackTrace();
    }
  }//������s���UĲ�o�ƥ󵲧�
}
