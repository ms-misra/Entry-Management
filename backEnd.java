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

public class backEnd extends HttpServlet
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

     		try
		{
         
         		MimeMessage message = new MimeMessage(session);
         		message.setFrom(new InternetAddress(Email));
         		message.addRecipient(Message.RecipientType.TO, new InternetAddress(H_Email));
         
         		message.setSubject("Scheduled meeting");
         		message.setText("You have a meeting with"+Name);
         
         		Transport.send(message);
         		out.println("<script type=\"text/javascript\">");
			out.println("alert('Host notified successfully');");
			out.println("location='checkout.html';");
			out.println("</script>");
			}
		catch (MessagingException mex) 
		{
         		mex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		// TODO Auto-generated method stub
		System.out.println("dopost is working");
		Name=request.getParameter("Name");
        	Phone = request.getParameter("Phone");
		Email = request.getParameter("Mail");
		In=request.getParameter("In");
		Out=request.getParameter("Out");
		H_name=request.getParameter("H_name");
        	H_Phone = request.getParameter("H_Phone");
		H_Email = request.getParameter("H_mail");
		
		HttpSession mySession= request.getSession();
		if (mySession== request.getSession(false)) 
		{
			DB.currentUserId=res;
			Cookie ck=new Cookie("Name",Name);
			Cookie ck2=new Cookie("Phone",Phone);
			Cookie ck3=new Cookie("In",In);
			Cookie ck4=new Cookie("Out",Out);
			Cookie ck5=new Cookie("Host",H_name);
			Cookie ck6=new Cookie("Host_mail",H_Email);
			Cookie ck7=new Cookie("Mail",Email);
			response.addCookie(ck);
			response.addCookie(ck2);
			response.addCookie(ck3);
			response.addCookie(ck4);
			response.addCookie(ck5);
			response.addCookie(ck6);
			response.addCookie(ck7);
		}
		doGet(request,response);
	}
}




