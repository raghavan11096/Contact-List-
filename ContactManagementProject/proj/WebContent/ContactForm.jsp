<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Contacts</title>
</head>
<body>
	<center>
		<h1>Contacts Management</h1>
        <h2>
        	<a href="new">Add New Contact</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Contacts</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${contact != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${contact == null}">
			<form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${contact != null}">
            			Edit Contact
            		</c:if>
            		<c:if test="${contact == null}">
            			Add New Contact
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${contact != null}">
        			<input type="hidden" name="contact_id" value="<c:out value='${contact.contact_id}' />" />
        		</c:if>            
            <tr>
                <th>First Name: </th>
                <td>
                	<input type="text" name="first_name" size="45"
                			value="<c:out value='${contact.first_name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Middle Name: </th>
                <td>
                	<input type="text" name="middle_name" size="45"
                			value="<c:out value='${contact.middle_name}' />"
                		/>
                </td>
            </tr>
            <tr>
             <tr>
                <th>Last Name: </th>
                <td>
                	<input type="text" name="last_name" size="45"
                			value="<c:out value='${contact.last_name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Home phone </th>
                <td>
                	<input type="text" name="home_phone" size="45"
                			value="<c:out value='${contact.home_phone}' />"
                	/>
                </td>
            </tr>
            <tr>
              <tr>
                <th>Cell phone </th>
                <td>
                	<input type="text" name="cell_phone" size="45"
                			value="<c:out value='${contact.cell_phone}' />"
                	/>
                </td>
            </tr>
            
            <tr>
                <th>Home address </th>
                <td>
                	<input type="text" name="home_address" size="45"
                			value="<c:out value='${contact.home_address}' />"
                	/>
                </td>
            </tr>
                <th>Home state </th>
                <td>
                	<input type="text" name="home_city" size="5"
                			value="<c:out value='${contact.home_city}' />"
                	/>
                </td>
            </tr>
            
                  <tr>
                <th>Home city </th>
                <td>
                	<input type="text" name="home_state" size="45"
                			value="<c:out value='${contact.home_state}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Home zip </th>
                <td>
                	<input type="number" name="home_zip" size="5"
                			value="<c:out value='${contact.home_zip}' />"
                	/>
                </td>
            </tr>
            
            <tr>
                <th>Work phone </th>
                <td>
                	<input type="text" name="work_phone" size="45"
                			value="<c:out value='${contact.work_phone}' />"
                	/>
                </td>
            </tr>
            
            <tr>
                <th>Work address </th>
                <td>
                	<input type="text" name="work_address" size="45"
                			value="<c:out value='${contact.work_address}' />"
                	/>
                </td>
            </tr>
                <th>Work state </th>
                <td>
                	<input type="text" name="work_city" size="5"
                			value="<c:out value='${contact.work_city}' />"
                	/>
                </td>
            </tr>
            
                  <tr>
                <th>Home city </th>
                <td>
                	<input type="text" name="work_state" size="45"
                			value="<c:out value='${contact.work_state}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Work zip </th>
                <td>
                	<input type="number" name="work_zip" size="5"
                			value="<c:out value='${contact.work_zip}' />"
                	/>
                </td>
            </tr>
            
             <tr>
                <th>Birth date </th>
                <td>
                	<input type="date" name="birth_date" size="5"
                			value="<c:out value='${contact.birth_date}' />"
                	/>
                </td>
            </tr>
            
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
      
      
    </div>	
</body>
</html>
