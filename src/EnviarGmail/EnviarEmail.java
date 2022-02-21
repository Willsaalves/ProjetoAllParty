package EnviarGmail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import Conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EnviarEmail {

	public static void enviarGmail(JTextField tfEmail) {

		String host = "smtp.gmail.com";
		String from = "will.saalves@gmail.com";
		String pass = "60304828w";

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(host); // o servidor SMTP para envio do e-mail
		email.setSslSmtpPort("587");

		email.setStartTLSRequired(true);
		email.setStartTLSRequired(true);
		email.setSSLOnConnect(true);

		email.setAuthenticator(new DefaultAuthenticator(from, pass));
		try {

			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("C:\\QRCODE\\canva'21'.png"); // caminho da imagem
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Picture of John");
			attachment.setName("Qr Code");
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", pass);
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.protocols=TLSv1.2", "true");
			props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
			
			Session mailSession = Session.getInstance(props, new DefaultAuthenticator(from, pass));
			email.setMailSession(mailSession);
		
			// Cria a mensagem de e-mail.

			email.addTo("will.saalves@gmail.com"); // destinatario
			email.setFrom(from); // remetente
			email.setSubject("Mensagem de teste com anexo"); // Assunto
			email.setMsg("Aqui está o qrCode anexado ao e-mail"); // conteudo do e-mail
			email.attach(attachment); // adiciona o anexo à mensagem

			email.send();// envia o e-mail
			


		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
