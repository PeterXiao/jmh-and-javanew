/**
 * 
 */
package luozix.start.action.net;


/**
 * @author xiaoy
 *
 */
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendQEmail {

	public static void main(String[] args) {

		final String username = "username@gmail.com";
		final String password = "password";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getDefaultInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("to_username_a@gmail.com, to_username_b@yahoo.com"));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Mail Crawler," + "\n\n Please do not spam my email!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}