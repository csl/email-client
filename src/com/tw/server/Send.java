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
		final String sendMsg = EmailClient.jTextArea.getText(); //����

		
		// Get a Properties object
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		props.setProperty("mail.mime.charset", "big5");// �]�w�r���s�X��BIG5
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
		
			//�إߦh���e Multpart �l�󪫥�
			Multipart multipart = new MimeMultipart();
			MimeBodyPart mbp = new MimeBodyPart();
		
			mbp.setContent(sendMsg,"text/html;charset=big5");//�إ�html�榡���e
			multipart.addBodyPart(mbp);//�N���e�[�J Multpart �l�󪫥�
		
			//���[�ɮ�
			mbp = new MimeBodyPart();
			
			if(fds!=null){
			mbp.setDataHandler(new DataHandler(fds));
			mbp.setFileName(MimeUtility.encodeText(fds.getName(), "Big5", "B"));  
			multipart.addBodyPart(mbp);//�N���[�ɮפ��e�[�J Multpart �l�󪫥�
			}
			msg.setContent(multipart);//�� Multpart �l�󪫥�]�w�T��
		
			Transport.send(msg);
			JOptionPane.showMessageDialog((Component) null, "�l��ǰe�����I", "�T��",
					JOptionPane.WARNING_MESSAGE);
			EmailClient.jLabelStatus.setText("�l��ǰe����");	
			SoundEffects se = new SoundEffects();
			se.SoundEffects();
			Clear();//�M���l�󤺮e
			fds = null;//�M�����[�ɮ�			
		} catch(Exception e) {
			JOptionPane.showMessageDialog((Component) null, "�l��L�k�ǰe�I", "�T��", 
				JOptionPane.WARNING_MESSAGE);	
		}
}
	
	protected static void Clear() {
		EmailClient.jTextFieldReceiver.setText("");
		EmailClient.jTextFieldSubject.setText("");
		EmailClient.jTextArea.setText("");
	}
}