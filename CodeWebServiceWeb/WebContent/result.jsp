<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<TITLE>results.jsp</TITLE>
</HEAD>
<BODY>
<P>
<jsp:useBean id="customerName" type="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="accountId" type="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="accountBalance" type="java.math.BigDecimal" scope="request"></jsp:useBean>
</P>
<TABLE border="1">
	<TBODY>
		<TR>
			<TD>Customer's Full Name</TD>
			<TD><%=customerName%></TD>
		</TR>
		<TR>
			<TD>First Account Id</TD>
			<TD><%=accountId%></TD>
		</TR>
		<TR>
			<TD>First Account Balance</TD>
			<TD><%=accountBalance%></TD>
		</TR>
	</TBODY>
</TABLE>
</BODY>
</HTML>
