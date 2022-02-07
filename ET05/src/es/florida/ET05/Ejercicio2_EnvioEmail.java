package es.florida.ET05;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Scanner;

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

public class Ejercicio2_EnvioEmail {

	public static void envioMail(String mensaje, String asunto, String email_remitente, String email_remitente_pass,
			String host_email, String port_email, String[] email_destino, String[] anexo)
			throws UnsupportedEncodingException, MessagingException {

		System.out.println("Envio de correo");
		System.out.println(" > Remitente: " + email_remitente);
		for (int i = 0; i < email_destino.length; i++) {
			System.out.println(" > Destino " + (i + 1) + ": " + email_destino[i]);
		}
		System.out.println(" > Asunto: " + asunto);
		System.out.println(" > Mensaje: " + mensaje);

		// -> añadir las propiedades necesarias para la conexión al servidor: servidor
		// de correo, puerto, e-mail remitente, pass remitente, tipo de autenticación y
		// tipo de cifrado.
		Properties props = System.getProperties();
		props.put("mail.smtp.host", host_email);
		props.put("mail.smtp.user", email_remitente);
		props.put("mail.smtp.clave", email_remitente_pass);
		props.put("mail.smtp.auth", "true");
		// TLS --> puerto 587
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port_email);

		// -> Crear una sesión
		Session session = Session.getDefaultInstance(props);

		// -> Crear mensaje y completarlo con los campos mínimos (remitente,
		// destinatario/s y asunto).
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(email_remitente));
		// se pueden añadir más destinatarios--> Recipients, con tantos .addRecipients
		// como haya
		message.addRecipients(Message.RecipientType.TO, email_destino[0]);
		message.setSubject(asunto);

		// ->añadir las partes que se quieran para el texto del mensaje y anexos:
		BodyPart messageBodyPart1 = new MimeBodyPart();
		// en .setText podemos darle formato html
		messageBodyPart1.setText(mensaje);

		BodyPart messageBodyPart2 = new MimeBodyPart();
		// OJO! AL IMPORTAR JAVAX.ACTIVATION ----------------------- !!!!!!!!!
//		import javax.activation.DataHandler;
//		import javax.activation.DataSource;
//		import javax.activation.FileDataSource;
		
		DataSource src = new FileDataSource(anexo[0]);
		messageBodyPart2.setDataHandler(new DataHandler(src));
		messageBodyPart2.setFileName(anexo[0]);

		// ->Agrupar las BodyPart en un objeto Multipart
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart1);
		multipart.addBodyPart(messageBodyPart2);

		// ->Añadir el objeto Multipart al mensaje
		message.setContent(multipart);

		// ->Envío del mensaje mediante un objeto de tipo Transport sobre la sesión
		// creada
		Transport transport = session.getTransport("smtp");
		transport.connect(host_email, email_remitente, email_remitente_pass);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}

	public static void main(String[] args) {

		System.out.println("PruebaEmail.java");

		String strMensaje = "Buenas tardes,\nEnvio un email a mi cuenta de florida.";
		String strAsunto = "Tema 5 - Ejercicio2";
		String emailRemitente = "mamphersan@gmail.com";
		//Scanner teclado = new Scanner(System.in);
		System.out.println("Comprobando contraseña...");
		String emailRemitentePass = "florida22*";
		String hostEmail = "smtp.gmail.com";
		String portEmail = "587";
		String[] emailDestino = { "mahesa@floridauniversitaria.es" };
		String[] anexo = { "C:\\Users\\mamph\\Pictures\\imagen_red.jpg" };

		try {
			envioMail(strMensaje, strAsunto, emailRemitente, emailRemitentePass, hostEmail, portEmail, emailDestino,
					anexo);
			System.out.println("Email enviado correctamente.");
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//teclado.close();

	}
}
