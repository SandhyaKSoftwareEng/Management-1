<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
      * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        color: aqua;
        font-family: cursive;
        font-weight: bold;
        background-color: black;
      }
      form {
        margin: auto;
        margin-top: 30vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 30vw;
        height: 30vh;
        border-radius: 10px;
        box-shadow: 0px 0px 8px 2px aqua;
      }
      input {
        box-shadow: 0px 0px 8px 2px aqua;
        margin-bottom: 15px;
        width: 60%;
        text-align:center;
      }
      input,
      button {
        border-radius: 10px;
      }
      button {
        background-color: aqua;
        color: black;
        width: 50%;
      }
      input::placeholder {
        text-align: center;
        color: rgba(0, 255, 255, 0.477);
      }
    </style>
</head>
<body>
<%ResultSet rs=(ResultSet)request.getAttribute("rs");//We need to downcast because it returns Object type%>





<form action="otpval">
<%while(rs.next()) {%>
	<input type="text" name="usr-otp" value="<%=rs.getInt(1) %>"><%} %>
	<input type="text" name="inp-otp" placeholder="Enter the captcha">
	<button type="submit">Validate</button>
	</form>




	

</body>
</html>