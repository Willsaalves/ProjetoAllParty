package EnviarGmail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.mail.Session;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import Conexao.Conexao;

public class EnviarEmailSenha {

	public static void enviarGmail(JTextField tfId, JTextField tfEmail, JTextField tfUsuario) {
		
		
		
		 String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

		 String senha="";


		 for (int x=0; x<10; x++){
		     int j = (int) (Math.random()*carct.length);
		     senha += carct[j];
		     }
		     
		String host = "smtp.gmail.com";
		String from = "will.saalves@gmail.com";
		String pass = "60304828w";

		String Destinatario = tfEmail.getText();
		
		String Dest = tfUsuario.getText();
		
		String id = tfId.getText();

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(host); // o servidor SMTP para envio do e-mail
		email.setSslSmtpPort("587");

		email.setStartTLSRequired(true);
		email.setStartTLSRequired(true);
		email.setSSLOnConnect(true);
		
		

		email.setAuthenticator(new DefaultAuthenticator(from, pass));
		
	
		     
		try {

			
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

			email.addTo(Destinatario); // destinatario
			email.setFrom(from); // remetente
			email.setSubject(Dest+" Senha Nova!"); // Assunto
			email.setMsg(Dest+ " Aqui está a sua nova senha: "+ senha); // conteudo do e-mail
			
			email.send();// envia o e-mail
			

			Connection conec = Conexao.conexao();

			String sql = "update dados_senhas set senha='"+senha+"' where id= '"+id+"' and email='" + Destinatario + "'";
			

			PreparedStatement stmt = conec.prepareStatement(sql);


	
			//stmt.execute();
			stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "alterou senha, verifique seu e-mail");
			

			stmt.close();

			conec.close();
			
		
     

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
