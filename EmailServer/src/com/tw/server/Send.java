package com.tw.server;
import java.util.*;
import java.awt.Component;
import java.security.Security;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.JOptionPane;

class Send {
	protected static DataSource fds = null;
	protected static void sendmail() throws AddressException, MessagingException {
		Properties props = System.getProperties();
		ProfileDialog pd = new ProfileDialog();
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		final String username = pd.jTextFieldUser.getText();
		final String password = pd.jPasswordField.getText();
		final String smtphost = pd.jTextFieldSmtpHost.getText();
		final String smtpport = pd.jTextFieldSmtpPort.getText();
		final String recipient = EmailClient.jTextFieldReceiver.getText();
		final String From = username + "@gmail.com";
		final String sendMsg = EmailClient.jTextArea.getText(); //內文

		
		// Get a Properties object
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		props.setProperty("mail.mime.charset", "big5");// 設定字元編碼為BIG5
		props.setProperty("mail.smtp.host", smtphost);
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", smtpport);
		props.setProperty("mail.smtp.socketFactory.port", smtpport);
		props.put("mail.smtp.auth", "true");

		try {
			//Session session = Session.getDefaultInstance(props,
			Session session = Session.getInstance(props,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
			});
			// -- Create a new message --
			Message msg = new MimeMessage(session);
			
			// -- Set the FROM and TO fields --
			msg.setFrom(new InternetAddress(From));// jTextFieldSender.getText()
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
					recipient, false));
			msg.setSubject(EmailClient.jTextFieldSubject.getText());
			msg.setSentDate(new Date());
		
			//建立多內容 Multpart 郵件物件
			Multipart multipart = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
		
			mbp.setContent(sendMsg,"text/html;charset=big5");//建立html格式內容
			multipart.addBodyPart(mbp);//將內容加入 Multpart 郵件物件
		
			//附加檔案
			mbp = new MimeBodyPart();
			
			if(fds!=null){
			mbp.setDataHandler(new DataHandler(fds));
			mbp.setFileName(MimeUtility.encodeText(fds.getName(), "Big5", "B"));  
			multipart.addBodyPart(mbp);//將附加檔案內容加入 Multpart 郵件物件
			}
			msg.setContent(multipart);//對 Multpart 郵件物件設定訊息
		
			Transport.send(msg);
			JOptionPane.showMessageDialog((Component) null, "郵件傳送完成！", "訊息",
					JOptionPane.WARNING_MESSAGE);
			EmailClient.jLabelStatus.setText("郵件傳送完成");	
			SoundEffects se = new SoundEffects();
			se.SoundEffects();
			Clear();//清除郵件內容
			fds = null;//清除附加檔案			
		} catch(Exception e) {
			JOptionPane.showMessageDialog((Component) null, "郵件無法傳送！", "訊息", 
				JOptionPane.WARNING_MESSAGE);	
		}
}
	
	protected static void Clear() {
		EmailClient.jTextFieldReceiver.setText("");
		EmailClient.jTextFieldSubject.setText("");
		EmailClient.jTextArea.setText("");
	}
}