<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Contact List Management</title>
</head>
<body>
	<center>
		<h1>Contacts</h1>
        <h2>
        </form>
        	<a href="new">Add New Contact</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">ALL Contacts</a>
        <h2> <form action="search" method="post"> <input type="search" name="search_contact" placeholder="Search..."/>
        </form>
        		
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Contacts</h2></caption>
            <tr>
                <th>Contact ID</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Home Phone</th>
                <th>Cell Phone</th>
                <th>Home Address</th>
                <th>Home City</th>
                <th>Home State</th>
                <th>Home Zip</th>
                <th>Work Phone</th>
                <th>Work Address</th>
                <th>Work City</th>
                <th>Work State</th>
                <th>Work Zip</th>
                <th>Birth Date</th>
                
            </tr>
            <c:forEach var="contact" items="${listContact}">
                <tr>
                    <td><c:out value="${contact.contact_id}" /></td>
                    <td><c:out value="${contact.first_name}" /></td>
                    <td><c:out value="${contact.middle_name}" /></td>
                    <td><c:out value="${contact.last_name}" /></td>
                    <td><c:out value="${contact.home_phone}" /></td>
                    <td><c:out value="${contact.cell_phone}" /></td>
                    <td><c:out value="${contact.home_address}" /></td>
                    <td><c:out value="${contact.home_city}" /></td>
                    <td><c:out value="${contact.home_state}" /></td>
                    <td><c:out value="${contact.home_zip}" /></td>
                    <td><c:out value="${contact.work_phone}" /></td>
                    <td><c:out value="${contact.work_address}" /></td>
                    <td><c:out value="${contact.work_city}" /></td>
                    <td><c:out value="${contact.work_state}" /></td>
                    <td><c:out value="${contact.work_zip}" /></td>
                    <td><c:out value="${contact.birth_date}" /></td>
                    <td>
                    	<a href="edit?contact_id=<c:out value='${contact.contact_id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?contact_id=<c:out value='${contact.contact_id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>