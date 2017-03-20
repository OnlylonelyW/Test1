<%@ page language="java" import="java.util.*,com.JD.utill.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String message = request.getParameter("info");
	String answer = RobotUtil.getResult(message);
	//System.out.println(message);
	out.print(answer);
%>