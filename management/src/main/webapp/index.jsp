<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OTP | Landing Page</title>
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
      div {
        display: flex;
        flex-direction: column;
        height: 30vh;
        width: 30vw;
        border: none;
        box-shadow: 0px 0px 10px 5px aquamarine;
        margin: auto;
        margin-top: 30vh;
        align-items: center;
        justify-content: center;
        border-radius: 10px;
      }
      button {
        background-color: aqua;
        color: black;
        padding: 2px 20px;
        border-radius: 10px;
      }
      h1 {
        margin-bottom: 5vh;
      }
    </style>
</head>
<body>
<div>
      <h1>Captcha Application</h1>
      <a href="otp"
        ><button type="submit">Hit me for Captcha!</button></a
      >
      </div>


</body>
</html>