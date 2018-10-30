<%@page import="com.al.model.Vendor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo jsp</title>
</head>
<body>

<%
session=request.getSession(true);

Object listobj=request.getAttribute("allVendors");
List <Vendor> allVendorList=(List <Vendor>)listobj;
%>

<form method="get" action="Demo2">
    <table border="2">

 </tr>

       <%
for(Vendor vendor:allVendorList)
{
%>
            <tr>
                <td><%=vendor.getVendorId() %></td>
				<td><%=vendor.getVendorName() %></td>
				
                <th> <input type="checkbox" name="checkbox" class="radio" value="<%=vendor.getVendorId() %> "/> </th>
            </tr>
        <% } %>
    </table>
    <input type="submit" value="submit"/>
</form>   




</body>
</html>