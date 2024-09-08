package management;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/otp")
//@WebServlet(loadOnStartup = 1)
public class PreOTPGeneration extends HttpServlet
{
	public static int randomNumGeneration()
	{
		//Generating the random number
		double n=Math.random();
		//Resolving to the length of 4 numbers			
		int num=(int)Math.floor(n*10000);
//		Used to count how many numbers exist out
		int count=0;
		int temp=num;
		// Used to count the individual elements in total ex:1234: total numbers in count=4
		while(temp>0)
		{
			temp/=10;
			count++;
		}
		//used this to check whether the generated value is of 4 digits
		if(count==4)
			return num;
		else
			randomNumGeneration();
		
		return -1;//Y am i getting -1 what is wrong in the logic
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int rand=randomNumGeneration();
		
		System.out.println(rand);
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/otp", "root", "root");
			ps=con.prepareStatement("insert into otp values(?) ");
			ps.setInt(1,rand);
			ps.execute();
			ps=con.prepareStatement("select * from otp where otpc=?");
			ps.setInt(1, rand);
			ps.execute();
			rs=ps.getResultSet();
			req.setAttribute("rs",rs);
			RequestDispatcher rd=req.getRequestDispatcher("otp.jsp");
			rd.forward(req, resp);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		req.setAttribute("rs", rand);
		
		
	}
}
