import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*; 

public class Out extends HttpServlet
{
	String Name,Phone,Email,H_name,H_Phone,H_Email,In,Out;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String host = "localhost";
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		response.setContentType("text/html");
      		PrintWriter out = response.getWriter();
		Cookie ck[]=request.getCookies();  
		Name=ck[0].getValue();
		Phone=ck2[0].getValue();
		In=ck3[0].getValue();
		Out=ck4[0].getValue();
		H_name=ck5[0].getValue();
		H_Email=ck6[0].getValue();
		Email=ck7[0].getValue();
		try
		{
         
         		MimeMessage message = new MimeMessage(session);
         		message.setFrom(new InternetAddress(H_Email));
         		message.addRecipient(Message.RecipientType.TO, new InternetAddress(Email));
         
         		message.setSubject("Scheduled meeting");
         		message.setText("You had a meeting with"+H_Name +"\n"+
					"In time:"+In+"\n"+
					"Out time:"
         
         		Transport.send(message);
         		response.sendRedirect("login.html");
			}
		catch (MessagingException mex) 
		{
         		mex.printStackTrace();
		}
	}
		
}  
