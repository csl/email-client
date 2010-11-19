package com.tw.server;

import java.io.*;//引入相關物件
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
 
public class MyCalendar extends javax.swing.JFrame //建立一視窗物件
{
  private JDesktopPane jDesktopPane1;//相關物件宣告
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
 
  public static void main(String[] args) throws IOException//主程式開始
  {
    MyCalendar inst = new MyCalendar();
    inst.setVisible(true);
  }//主程式結束
  
  public MyCalendar()//建立視窗開始
  {
    super();
    initGUI();//呼叫GUI函數
  }//建立視窗結束
  
  public int[] getdate()//取得系統日期函數開始
  {
    int[] date_array = new int[3];
    Calendar ca = new GregorianCalendar();  
    date_array[0] = ca.get(Calendar.YEAR);//年
    date_array[1] = ca.get(Calendar.MONTH)+1;//月
    date_array[2] = ca.get(Calendar.DAY_OF_MONTH);//日
    return date_array;//回傳自訂日期陣列
  }//取得系統日期函數結束
 
  public void new_btn()//重新產生日期按鈕函數開始
  {
    jTextArea1.setText("");//清空記事
    int year,month;
    year = Integer.parseInt(jLabel5.getText().substring(0,4));//設定為已選擇的年
    month = Integer.parseInt(jLabel5.getText().substring(7,9));//設定為已選擇的月
    date_btn_create(year,month);//呼叫產生日期按鈕函數
  }//重新產生日期按鈕函數結束
  
  public void date_btn_create(int year,int month)//產生日期按鈕
  {
    int y=0,x=0,x_add=0,y_add=0,week_add=0,date_acc=0,week_of_day=0;
    String syear,smonth,sday,filename;
    syear = String.valueOf(year);
    smonth = String.valueOf(month);
    if (smonth.length() == 1)//若小於10月(一位數)就在前面加0
      smonth = "0"+smonth;
    
    jDesktopPane1.remove(jDesktopPane2);//移除桌面2(日期按鈕附著，也就是把日期按鈕移除)
    jDesktopPane2 = new JDesktopPane();//產生一個新的桌面
    jDesktopPane1.add(jDesktopPane2);
    jDesktopPane2.setBounds(0, 30, 252, 196);//設定大小及位置
    jDesktopPane2.setBackground(new java.awt.Color(148,205,176));//設定顏色
      
    switch(month)//設定月份天數
    {
      case 1://大月31天
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        date_acc = 31;
        break;
        
      case 4://小月30天
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
    
    week_of_day = dow(year,month,1);//呼叫星期函數(取得當月第一天為星期幾)
    
    switch(week_of_day)//設定當月1日位置(像素)
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
    JButton btn[] = new JButton[date_acc];//建立日期按鈕陣列
    for (int i=0;i<date_acc;i++)//建立日期按鈕陣列迴圈
    {
      btn[i] = new JButton();//建立對應日期按鈕
      jDesktopPane2.add(btn[i]);//加到桌面2上
      btn[i].setText(String.valueOf(i+1));//設定按鈕文字為日期
      if ((i-week_of_day>0 && (i+week_of_day)%7==0) || ((i+week_of_day)%7==0 && i != 0))
      {//設定當月第一天日期按鈕位置
        x=0;//X軸座標
        x_add=0;//下一個按鈕座標(X軸)加值
        y++;//Y軸座標
        y_add+=10;//換行座標(Y軸)加值
        week_add=0;//當月第一日按鈕座標加值
      }//下面設定按鈕大小及加值(X為起始10+第幾個按鈕*橫向寬度25+間隔+當月第一天星期幾加值)
      btn[i].setBounds(10+x*25+x_add+week_add, y*20+y_add, 25, 20);//(Y為第幾個按鈕*高度20+換行加值)按鈕寬為25高為20
      btn[i].setFont(new java.awt.Font("Arial",1,12));//設定字體大小及樣式
      btn[i].setBorder(BorderFactory.createTitledBorder(""));//設定按鈕文字不自動調整大小
      int[] now = new int[3];
      now = getdate();//取得當天日期
      if (year == now[0] && month == now[1] && i+1 == now[2])
        btn[i].setBackground(new java.awt.Color(233,238,164));//若為當天則設定按鈕為黃色
      else
        btn[i].setBackground(new java.awt.Color(148,205,176));//若不是當天則設定按鈕為綠色
        
      sday = String.valueOf(i+1);
      filename = syear+smonth+sday;//記事檔案名稱(年+月+日.txt)
      File file=new File(filename+".txt");//建立檔案物件
      if (file.exists())//若當天有記事檔案則設定按鈕字體顏色為藍色
        btn[i].setForeground(new java.awt.Color(0,0,255));
      
      btn[i].addActionListener(new ActionListener() {//設定按鈕監聽(觸發事件函數)
        public void actionPerformed(ActionEvent evt) {
          btnActionPerformed(evt);
        }
      });
      x++;//下一個按鈕X座標加權
      x_add+=9;//下一個按鈕間隔X座標加權
    }
  }
  
  public boolean leap_year(int year)//判斷閏年函數開始
  {
    boolean leap_year;//4的倍數，若為100的倍數則必須為4的倍數才是閏年
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
  }//判斷閏年函數結束
  
  public int dow(int y,int m,int d)//判斷星期幾
  {
    int[] ww={6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};//天文星體運行值
    int w;
    w=ww[m-1]+y+(y/4)-(y/100)+(y/400);//閏年設定
    if( ((y%4)==0) && (m<3) )//公式
    {
      w--;
      if((y%100)==0) w++;
      if((y%400)==0) w--;
    }
    return (w+d)%7;//回傳星期幾(0為星期日，1為星期一以此類推)
  }
  
  private void initGUI()//產生視覺化物件函數(Graph User Interface，圖形化使用者介面)
  {
    try
    {
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//設定外框視窗主要功能列為標準(縮到最小，放到最大，關閉)
      {
        this.setTitle("萬年行事曆");//設定視窗抬頭 
        jDesktopPane1 = new JDesktopPane();//建立一桌面
        getContentPane().add(jDesktopPane1, BorderLayout.CENTER);
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(464, 267));//設定桌面大小
        jDesktopPane1.setBackground(new java.awt.Color(148,205,176));//設定桌面顏色
        {//建立桌面2開始(放日期按鈕的桌面)
          jDesktopPane2 = new JDesktopPane();
          jDesktopPane1.add(jDesktopPane2);
          jDesktopPane2.setBounds(0, 30, 252, 196);
          jDesktopPane2.setBackground(new java.awt.Color(148,205,176));
        }//建立桌面2結束
        {//建立星期日標籤開始
          jLabel1 = new JLabel();
          jDesktopPane1.add(jLabel1);
          jLabel1.setText("Sun");
          jLabel1.setBounds(14, 7, 21, 21);
          jLabel1.setFont(new java.awt.Font("Arial",0,11));
          jLabel1.setForeground(new java.awt.Color(255,0,0));
        }//建立星期日標籤結束
        {//建立記事框開始
          jTextArea1 = new JTextArea(252, 35);
          jDesktopPane1.add(jTextArea1);
          jTextArea1.setText("");//預設內容清空
          jTextArea1.setBounds(252, 42, 175, 182);//設定大小
          jTextArea1.setFont(new java.awt.Font("新細明體",0,11));//設定字體樣式大小
          jTextArea1.setLineWrap(true);//文字過長自動換行
          jTextArea1.setWrapStyleWord(true);//文字過長自動換行
          JScrollPane scrollPane = new JScrollPane(jTextArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          jDesktopPane1.add(scrollPane);//上面為建立scorollpane(視窗旁邊的移動棒);將記事框建立在scrollpane上
          scrollPane.setBounds(252, 42, 175, 182);//設定大小及位置
        }//建立記事框結束
        {//建立清除按鈕開始
          jButton1 = new JButton();
          jDesktopPane1.add(jButton1);
          jButton1.setText("清除");
          jButton1.setBounds(252, 231, 63, 21);
          jButton1.setFont(new java.awt.Font("新細明體",0,11));
          jButton1.setBorder(BorderFactory.createTitledBorder(""));
          jButton1.addActionListener(new ActionListener() {//設定清除按鈕監聽函數
            public void actionPerformed(ActionEvent evt) {
              jButton1ActionPerformed(evt);
            }
          });
        }//建立清除按鈕結束
        {//建立儲存按鈕開始
          jButton2 = new JButton();
          jDesktopPane1.add(jButton2);
          jButton2.setText("儲存");
          jButton2.setBounds(364, 231, 63, 21);
          jButton2.setFont(new java.awt.Font("新細明體",0,11));
          jButton2.setBorder(BorderFactory.createTitledBorder(""));
          jButton2.addActionListener(new ActionListener() {//設定儲存按鈕監聽函數
            public void actionPerformed(ActionEvent evt) {
              jButton2ActionPerformed(evt);
            }
          });
        }//建立儲存按鈕結束
        {//建立星期一~星期六標籤開始
          jLabel2 = new JLabel();
          jDesktopPane1.add(jLabel2);
          jLabel2.setText("Mon    Tue     Wed     Thu      Fri      Sat");
          jLabel2.setBounds(49, 7, 189, 21);
          jLabel2.setFont(new java.awt.Font("Arial",0,11));
        }//建立星期一~星期六標籤結束
        {//建立查詢年份輸入框開始
          jTextField1 = new JTextField();
          jDesktopPane1.add(jTextField1);
          jTextField1.setText("");
          jTextField1.setBounds(14, 231, 63, 21);
          jTextField1.setFont(new java.awt.Font("Arial",0,12));
        }//建立查詢年份輸入框結束
        {//建立狀態標籤開始
          jLabel6 = new JLabel();
          jDesktopPane1.add(jLabel6);
          jLabel6.setText("TEST");
          jLabel6.setBounds(357, 7, 70, 21);
          jLabel6.setFont(new java.awt.Font("新細明體",0,11));
          jLabel6.setForeground(new java.awt.Color(0,0,255));
        }//建立狀態標籤開始
        {//建立隱藏日期按鈕暫存標籤開始
          jLabel7 = new JLabel();
          jDesktopPane1.add(jLabel7);
          jLabel7.setText("");
          jLabel7.setBounds(0, 0, 0, 0);//設定大小為0
        }//建立隱藏日期按鈕暫存標籤結束
        {//建立目前選擇日期標籤開始
          jLabel8 = new JLabel();
          jDesktopPane1.add(jLabel8);
          jLabel8.setText("目前無選擇日期");
          jLabel8.setBounds(252, 28, 175, 14);
          jLabel8.setFont(new java.awt.Font("新細明體",0,11));
        }//建立目前選擇日期標籤結束
        {//建立月份下拉選單開始
          ComboBoxModel jComboBox1Model = new DefaultComboBoxModel
          (new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" });//內容設定1~12
          jComboBox1 = new JComboBox();
          jDesktopPane1.add(jComboBox1);
          jComboBox1.setModel(jComboBox1Model);
          jComboBox1.setBounds(105, 231, 40, 21);
          jComboBox1.setFont(new java.awt.Font("Arial",0,11));
        }//建立月份下拉選單結束
        {//建立"月"標籤開始
          jLabel3 = new JLabel();
          jDesktopPane1.add(jLabel3);
          jLabel3.setText("月");
          jLabel3.setBounds(155, 231, 14, 21);
          jLabel3.setFont(new java.awt.Font("新細明體",0,12));
        }//建立"月"標籤結束
        {//建立"年"標籤開始
          jLabel4 = new JLabel();
          jDesktopPane1.add(jLabel4);
          jLabel4.setText("年");
          jLabel4.setFont(new java.awt.Font("新細明體", 0, 12));
          jLabel4.setBounds(84, 231, 14, 21);
        }//建立"年"標籤結束
        {//建立查詢按鈕開始
          jButton3 = new JButton();
          jDesktopPane1.add(jButton3);
          jButton3.setText("查詢");
          jButton3.setBounds(180, 231, 35, 21);
          jButton3.setBorder(BorderFactory.createTitledBorder(""));
          jButton3.setFont(new java.awt.Font("新細明體",0,11));
          jButton3.addActionListener(new ActionListener() {//查詢按鈕監聽函數
            public void actionPerformed(ActionEvent evt) {
              jButton3ActionPerformed(evt);
            }
          });
        }//建立查詢按鈕結束
        {//建立目前年月位置標籤開始
          int[] now = new int[3];
          now = getdate();//預設為當年當月
          String year5,smonth;
          year5 = String.valueOf(now[0]);
          smonth = String.valueOf(now[1]);
          if (smonth.length() == 1)
            smonth = "0"+smonth;
          
          jLabel5 = new JLabel();
          jDesktopPane1.add(jLabel5);
          jLabel5.setText(year5+" 年 "+smonth+" 月");
          jLabel5.setBounds(252, 7, 120, 21);
          jLabel5.setForeground(new java.awt.Color(255,255,255));//設定字體為白色
        }//建立目前年月位置標籤結束
        {//預設為當年當月日期按鈕產生開始
          int[] now = new int[3];
          now = getdate();
          date_btn_create(now[0],now[1]);//產生日期按鈕
        }//預設為當年當月日期按鈕產生結束
      }
      pack();
      this.setSize(444, 296);
    } catch (Exception e) {//例外處理
      e.printStackTrace();
    }
  }
  
  private void jButton1ActionPerformed(ActionEvent evt)//清除按鈕按下觸發事件
  {
    jTextArea1.setText("");//清除記事內容
    String year,month,day,filename,insert_str;
    year = jLabel5.getText().substring(0,4);
    month = jLabel5.getText().substring(7,9);
    day = jLabel7.getText();
    filename = year+month+day;
    File file=new File(filename+".txt");//刪除當日記事檔案
    file.delete();
    new_btn();//重新產生按鈕
    jLabel6.setText("行事曆已清除");//設定相關訊息
    jLabel7.setText("");
    jLabel8.setText("目前無選擇日期");
  }
  
  private void jButton2ActionPerformed(ActionEvent evt)//儲存按鈕按下觸發事件開始
  {
    String year,month,day,filename,insert_str;
    year = jLabel5.getText().substring(0,4);
    month = jLabel5.getText().substring(7,9);
    day = jLabel7.getText();
    filename = year+month+day;
    insert_str = jTextArea1.getText();//記事內容
    if (insert_str.length() != 0 && day.length() != 0)//若記事框內有文字且有選擇日期則儲存記事檔案
    {
      try
      {
        FileWriter fw=new FileWriter(filename+".txt");//啟用檔案寫入
        BufferedWriter bfw=new BufferedWriter(fw);//啟用緩衝區寫入
        bfw.write(insert_str); //將Textarea內容寫入緩衝區裡
        bfw.flush();//將緩衝區資料寫到檔案
        fw.close();//關閉檔案
        jLabel6.setText("行事曆已記錄");//設定相關訊息
        jLabel7.setText("");
        jLabel8.setText("目前無選擇日期");
        new_btn();
      }catch(IOException e)
      {
        e.printStackTrace();
      }
    }
    else//若無記事內容或無選擇日期
    {
      if (day.length() == 0)
        jLabel6.setText("日期未選擇");//設定相關訊息
      else
        jLabel6.setText("行事曆無內容");
    }
  }//儲存按鈕按下觸發事件結束
  
  private void jButton3ActionPerformed(ActionEvent evt)//查詢按鈕按下觸發事件開始
  {
    String syear,smonth;
    try
    {
      jTextArea1.setText("");
      jLabel6.setText("查詢日期");
      syear = jTextField1.getText();
      smonth = String.valueOf(jComboBox1.getSelectedIndex() + 1);
      if (smonth.length() == 1)
            smonth = "0"+smonth;
      if (syear == "" || Integer.parseInt(syear)<1582)//若未輸入年份就觸發例外(1582年以前曾經改曆過，結果會不準確)
      {
        int[] now = new int[3];
        now = getdate();
        syear = String.valueOf(now[0]);//若選擇年份小於1582年則預設為當年
        jLabel6.setText("請選1582以上");
      }
      jLabel5.setText(syear+" 年 "+smonth+" 月");
      date_btn_create(Integer.parseInt(syear),Integer.parseInt(smonth));
      jLabel7.setText("");
      jLabel8.setText("目前無選擇日期");
    }catch(NumberFormatException e)//例外處理設定為當年及選擇的月份
    {
      int[] now = new int[3];
      now = getdate();
      syear = String.valueOf(now[0]);
      smonth = String.valueOf(jComboBox1.getSelectedIndex() + 1);
      if (smonth.length() == 1)
            smonth = "0"+smonth;
      jLabel5.setText(syear+" 年 "+smonth+" 月");
      jLabel6.setText("請選1582以上");
      date_btn_create(Integer.parseInt(syear),Integer.parseInt(smonth));
      jLabel7.setText("");
      jLabel8.setText("目前無選擇日期");
    }
  }//查詢按鈕按下觸發事件結束
  
  private void btnActionPerformed(ActionEvent evt)//日期按鈕按下觸發事件開始
  {
    jTextArea1.setText("");
    String year,month,btn_date,filename,read_str;
    year = jLabel5.getText().substring(0,4);//取得年
    month = jLabel5.getText().substring(7,9);//取得月
    btn_date = evt.getActionCommand();//取得按下按鈕文字(日)
    filename = year+month+btn_date;
    jLabel7.setText(btn_date);
    try
    {
      FileReader fr = new FileReader(filename+".txt");//讀取選擇日期記事檔案
      BufferedReader bfr = new BufferedReader(fr);//將檔案讀到緩衝區
      boolean flag=false;//旗標
      while((read_str = bfr.readLine())!=null) // 每次讀取一行，直到檔案結束
      {
        if (flag)//從第二行開始每一行第一個位置加入斷行
          jTextArea1.append("\n");
        jTextArea1.append(read_str);//加入該行訊息
        flag=true;
        
      }
      jLabel6.setText("當天記事");
      jLabel8.setText("已選擇"+year+"年"+month+"月"+btn_date+"日");
      fr.close();
    }catch(FileNotFoundException e)//如果沒有指定的記事檔案就印出當日無行事曆(例外處理)
    {
      jLabel6.setText("當日無行事曆");
      jLabel8.setText("已選擇"+year+"年"+month+"月"+btn_date+"日");
    }catch(IOException e)//例外處理
    {
      e.printStackTrace();
    }
  }//日期按鈕按下觸發事件結束
}
