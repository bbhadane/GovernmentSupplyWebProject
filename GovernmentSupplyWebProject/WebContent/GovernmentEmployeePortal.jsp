<%@page import="java.util.List"%>
<%@page import="com.al.model.Product"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Government Employee portal</title>
</head>
<body>
<%
session=request.getSession(true);

Object listobj=request.getAttribute("AllProductList");
List <Product> allProductList=(List <Product>)listobj;
%>


<center>
<h1> Welcome Government Employee... </h1>


<form method="get" action="SelectedProducts">
    <table border="2">

       <%
for(Product product:allProductList)
{
%>
            <tr>
                <td><%=product.getProductId() %></td>
				<td><%=product.getProductName() %></td>
				<td><%=product.getSection().getSectionName() %> </td>
				<td><%=product.getSection().getDepartment().getDepartmentName()%> </td>
                <th> <input type="checkbox" name="checkboxGroup" value="<%=product%>"/> </th>
            </tr>
        <% } %>
    </table>
    <input type="submit" value="Give orders"/>
</form>   



</center>>




</body>
</html>