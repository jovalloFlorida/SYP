package es.florida.ET05;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Ejercicio3_EmailAnexosDest {
	
	public static void envioMail(String mensaje, String asunto, String email_remitente, String email_remitente_pass,
			String host_email, String port_email, String[] email_destino, String[] anexo)
			throws UnsupportedEncodingException, MessagingException {

		System.out.println("Envio de correo");
		System.out.println(" > Remitente: " + email_remitente);
		// VARIOS DESTINATARIOS:
		for (int i = 0; i < email_destino.length; i++) {
			System.out.println(" > Destino " + (i + 1) + ": " + email_destino[i]);
		}
		System.out.println(" > Asunto: " + asunto);
		System.out.println(" > Mensaje: " + mensaje);
		// VARIOS ANEXOS:
		for (int i = 0; i < anexo.length; i++) {
			System.out.println(" > Anexo " + (i + 1) + ": " + anexo[i]);
		}
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host_email);
		props.put("mail.smtp.user", email_remitente);
		props.put("mail.smtp.clave", email_remitente_pass);
		props.put("mail.smtp.auth", "true");
		// TLS --> puerto 587
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port_email);

		Session session = Session.getDefaultInstance(props);

		// lo imprescindible son .setFrom .addRecipients y .setSubject
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email_remitente));
		for (int i = 0; i < email_destino.length; i++) {
			message.addRecipients(Message.RecipientType.TO, email_destino[i]);
		}
		message.setSubject(asunto);
		
		//para agregar m�s complementos al email, por ejemplo texto (.setText) y anexo, creo una multipart
		
		Multipart multipart = new MimeMultipart();
		
		BodyPart messageBodyPartTexto = new MimeBodyPart();
		messageBodyPartTexto.setText(mensaje);
		multipart.addBodyPart(messageBodyPartTexto);
		
		for (int i = 0; i < anexo.length; i++) {
			BodyPart messageBodyPartAnexo = new MimeBodyPart();
			DataSource src = new FileDataSource(anexo[i]);
			messageBodyPartAnexo.setDataHandler(new DataHandler(src));
			messageBodyPartAnexo.setFileName(anexo[i]);
			multipart.addBodyPart(messageBodyPartAnexo);
		}		

		// ->A�adir el objeto Multipart al mensaje
		message.setContent(multipart);

		// ->Env�o del mensaje mediante un objeto de tipo Transport soble la sesi�n creada
		Transport transport = session.getTransport("smtp");
		transport.connect(host_email, email_remitente, email_remitente_pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	public static void main(String[] args) {

		System.out.println("PruebaEmail.java");

		String strMensaje = "a ver a quien le llega. varios destinatarios";
		String strAsunto = "Tema 5 - Ejercicio3";
		String emailRemitente = "dam.syp.laflorida@gmail.com";
		//Pedimos contrase�a mediante ventana emergente
		JPasswordField pwd = new JPasswordField(15);
		JOptionPane.showConfirmDialog(null, pwd, "Introducir contrase�a" , JOptionPane.OK_CANCEL_OPTION);
		String emailRemitentePass = new String(pwd.getPassword());
		// Scanner teclado = new Scanner(System.in);
		//System.out.println("Comprobando contrase�a...");
		//String emailRemitentePass = "Wodu504550";
		String hostEmail = "smtp.gmail.com";
		String portEmail = "587";
		String emailDestino[] = { "jovallo@gmail.com", "jovall@floridauniversitaria.es" };
		String anexo[] = { "C:\\homer.jpg", "C:\\devlist.txt" };

		try {
			envioMail(strMensaje, strAsunto, emailRemitente, emailRemitentePass, hostEmail, portEmail, emailDestino,
					anexo);
			System.out.println("Email enviado correctamente.");
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// teclado.close();

	}
}
