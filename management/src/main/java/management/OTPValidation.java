package management;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/otpval")
public class OTPValidation extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer n1=Integer.parseInt(req.getParameter("usr-otp"));
		System.out.println("n1:"+n1);
		Integer n2=Integer.parseInt(req.getParameter("inp-otp"));
		System.out.println("n2:"+n2);
		if(n1.equals(n2))
		{
			String s="<h1>True<h1>";
			
//			RequestDispatcher rd= req.getRequestDispatcher("hii.jsp");
			PrintWriter pw=resp.getWriter();
			pw.print(s);
			
			
		}
		else
		{
			String s="<h1>False<h1>";
			PrintWriter pw=resp.getWriter();
			pw.print(s);
//			RequestDispatcher rd= req.getRequestDispatcher("hii.jsp");
			
		}
	
	}
}
