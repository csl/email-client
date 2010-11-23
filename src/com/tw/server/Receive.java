package com.tw.server;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.io.*;
import java.security.*;
import java.awt.Component;
import java.util.Properties;
import java.text.SimpleDateFormat;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class Receive {
	private static String[] mFrom = new String[255];
	private static String[] mDate = new String[255];
	private static String[] mBody = new String[255];
	private static String[] mSubject = new String[255];
	private static int total;
	protected static Message[] messages;
	public static void ReceiveMail() throws Exception 
	{
		
		ProfileDialog pd = new ProfileDialog();
		final String pophost = pd.jTextFieldPopHost.getText();
		final String popport = pd.jTextFieldPopPort.getText();
		final String username = pd.jTextFieldUser.getText();
		final String password = pd.jPasswordField.getText();
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		//Set Date style 
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.pop3.socketFactory.fallback", "false");
		props.setProperty("mail.pop3.port", popport);
		props.setProperty("mail.pop3.socketFactory.port", popport);	
		//Create session
		Session session = Session.getInstance(props, null);
		URLName urln = new URLName("pop3", pophost, 995, null, username, password);
		Store store = session.getStore(urln);
		Folder inbox = null;
		SoundEffects se = new SoundEffects();
		try {
			store.connect();
			inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			FetchProfile profile = new FetchProfile();
			profile.add(FetchProfile.Item.ENVELOPE);
			messages = inbox.getMessages();
			inbox.fetch(messages, profile);
			
			EmailClient.jLabelMailTotal.setText("郵件箱的郵件數：" + Receive.messages.length);
			for (int i = 0; i < messages.length; i++) {
				// 郵件發送者
				String from = decodeText(messages[i].getFrom()[0].toString());
				InternetAddress ia = new InternetAddress(from);			
				mFrom[i] = ia.getPersonal() + '('+ ia.getAddress() + ')';				
				// 郵件標題
				mSubject[i] = messages[i].getSubject();					
				// 郵件發送時間
				mDate[i] = sd.format(messages[i].getSentDate());							
				//郵件內容
				if(messages[i].isMimeType("text/*")) {
					mBody[i] = messages[i].getContent().toString();
				} else {
					String disposition;
					BodyPart part;   
					Multipart mp = (Multipart)messages[i].getContent(); 
					int mpCount = mp.getCount();
					for(int m = 0; m < mpCount; m++) {
						part = mp.getBodyPart(m);
						disposition = part.getDisposition(); 
						if(disposition != null && disposition.equals(Part.ATTACHMENT)) { 
							//saveAttach(part);
						} else { 
							mBody[i] = part.getContent().toString(); 
						} 
					} 
				}
			}
			if(messages.length == 0) {
				EmailClient.jLabelMailStatus.setText("目前郵件：" + (total) + " / " + 
					messages.length);
//				JOptionPane.showMessageDialog((Component) null, "沒有新郵件！", "訊息", 
	//				JOptionPane.WARNING_MESSAGE);
				EmailClient.jLabelStatus.setText("沒有新郵件！, 郵件接收完成");

			} else {
				EmailClient.jLabelMailStatus.setText("目前郵件：" + (total+1) + " / " + 
					messages.length);
				EmailClient.jTextFieldReceiveSender.setText(mFrom[total]);
				EmailClient.jTextFieldReceiveSubject.setText(mSubject[total]);
				EmailClient.jTextFieldReceiveDate.setText(mDate[total]);
				EmailClient.jTextArea1.setText(mBody[total]);
				if(messages.length == 1||messages.length == 0) {
					EmailClient.jButtonArrowRight.setEnabled(false);
				} else { EmailClient.jButtonArrowRight.setEnabled(true); }

				//PlaySound
				se.SoundEffects();
				
				//Play flash for tips
			    Display display = new Display();
			    Shell shell = new PlayFlash().open (display);
			    int i=0;
			    while (!shell.isDisposed()) 
			    {
			     if (i>400) break;
			       if (!display.readAndDispatch()) display.sleep ();
			       i++;
			    }
			      display.dispose();

				JOptionPane.showMessageDialog((Component) null, "郵件接收完成！", "訊息",
					JOptionPane.WARNING_MESSAGE);
				EmailClient.jLabelStatus.setText("郵件接收完成");
			}
		} finally {
			try { if(inbox!=null) inbox.close(false); if(store!=null) store.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
	}
	
	protected static void mailNext() {
		try {
			if(total < messages.length-1) {
				total = total+1;
				EmailClient.jTextFieldReceiveSender.setText(mFrom[total]);
				EmailClient.jTextFieldReceiveSubject.setText(mSubject[total]);
				EmailClient.jTextFieldReceiveDate.setText(mDate[total]);
				EmailClient.jTextArea1.setText(mBody[total]);
				EmailClient.jLabelMailStatus.setText("目前郵件：" + (total+1) + " / " + 
					messages.length);
			}
			if(total == messages.length-1) { EmailClient.jButtonArrowRight.setEnabled(false); }
			if(total != 0) { EmailClient.jButtonArrowLeft.setEnabled(true); }			
		} catch (Exception e) {}
	}
	
	protected static void mailPreview() {
		try {
			if(total != 0) {
				total = total-1;
				EmailClient.jTextFieldReceiveSender.setText(mFrom[total]);
				EmailClient.jTextFieldReceiveSubject.setText(mSubject[total]);
				EmailClient.jTextFieldReceiveDate.setText(mDate[total]);
				EmailClient.jTextArea1.setText(mBody[total]);
				EmailClient.jLabelMailStatus.setText("目前郵件：" + (total+1) + " / " + 
					messages.length);
			}
			if(total == 0) { EmailClient.jButtonArrowLeft.setEnabled(false); }
			if(total != messages.length-1) { EmailClient.jButtonArrowRight.setEnabled(true); }
		} catch (Exception e) {}
	}
	
	protected static String decodeText(String text)	throws UnsupportedEncodingException {
		if (text == null)
			return null;
		if (text.startsWith("=?GB") || text.startsWith("=?gb"))
			text = MimeUtility.decodeText(text);
		else
			text = new String(text.getBytes("ISO8859_1"));
		return text;
	}
	
	//base64解碼 
	private static String base64Decoder(String s) throws Exception { 
		sun.misc.BASE64Decoder decoder =  new sun.misc.BASE64Decoder(); 
		byte[] b=decoder.decodeBuffer(s); 
		return(new String(b)); 
	}
	
	private static void saveAttach(BodyPart part) throws Exception { 
		String temp=part.getFileName();//得到未經處理的附件名字 
		String s = temp.substring(11,temp.indexOf("?=")-1);//去到header和footer 	
		//文件名一般都經過了base64編碼,下面是解碼 
		String fileName = base64Decoder(s); 
		System.out.println("有附件:"+fileName); 
	
		InputStream in=part.getInputStream(); 
		FileOutputStream writer=
		new FileOutputStream(new File(fileName)); 
		byte[] content=new byte[255]; 
		int read=0; 
		while((read=in.read(content))!=-1) { 
			writer.write(content); 
		} 
		writer.close(); 
		in.close(); 
	} 
}
