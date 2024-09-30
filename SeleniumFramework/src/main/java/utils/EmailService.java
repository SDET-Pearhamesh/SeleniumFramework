package utils;

import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

public class EmailService {
	
	public void emailReport() {
		
		
		//If you want to send extent report as email. It has to be @gmail.com. 
		
		/* try {
			
			URL reportUrl = new URL("file:/"+"user.dir" + "/Reports/ExtentReport.html");
			
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver (new DataSourceUrlResolver (reportUrl));
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setStartTLSEnabled(true);
			email.setAuthenticator (new DefaultAuthenticator("your_email@gmail.com", "Your_passowrd"));
			email.setSSLOnConnect(true);
			email.setFrom("sender@gmail.com"); //Sender
			email.setSubject("Test Results");
			email.setMsg("Please find Attached Report....");
			email.addTo("receiver@gmail.com"); //Receiver. To add multiple proper use Distribution list
			email.attach(reportUrl, "extent report", "please check report...");
			email.send(); // send the email
			}
			
			
			catch (Exception e) {
				
			e.printStackTrace(); 
			System.out.println("Failed to send email");	
			} */

		}
		
		
	}


