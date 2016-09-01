<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Presents Web Service</title>
    </head> 

    <body>
        
        <h1>Presents Web Service</h1>
        <hr/>
        
        <c:if test="${not empty uploadMessage}">
            <h2>${uploadMessage}</h2>
            <hr/>
        </c:if>        
            
        <h3>Add Present:</h3>
        <form method="POST" action="<spring:url value="/presents"/>" enctype="multipart/form-data">
            <p>
                <input type="file" name="file" placeholder="Select Present XML File" />
                <input type="submit" value="Submit" />
            </p>            
        </form> 
        <hr/>
        
        <c:if test="${not empty presentsId}">                    
            <h3>Get Present By Id:</h3>
            <form method="GET" action="<spring:url value="/presents"/>">
                <p>
                    <select name="id">
                        <option value="0">Select Id</option>
                        <c:forEach items="${presentsId}" var="id">
                            <option value="${id}">${id}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Get Present Info" />
                </p>            
            </form>
            <hr/>
        </c:if> 
            
        <c:if test="${not empty present.name}">  
            <hr/>
            <h3><u>"${present.name}" Present</u></h3>
            
            <c:if test="${not empty present.candies}">
                
                <c:set var="weight" value="0" scope="page" />
                <c:set var="price" value="0" scope="page" />
                
                <p>Present candies:</p>
                <table cellspacing="0" cellpadding="10" rules="groups" border="1">
                    <thead>
                        <tr>
                            <td><b>Name</b></td>
                            <td><b>Weight</b></td>
                            <td><b>Price</b></td>
                        </tr>
                    </thead>
                    <tbody>                        
                        <c:forEach items="${present.candies}" var="candy">
                            <c:set var="weight" value="${weight + candy.weight}" scope="page" />
                            <c:set var="price" value="${price + candy.price}" scope="page" />
                            
                            <tr>
                                <td>${candy.name}</td>
                                <td>${candy.weight}</td>
                                <td>${candy.price}</td>
                            </tr>
                        </c:forEach>                        
                    </tbody> 
                </table>
                <p><b>Total weight:</b> ${weight}</p>
                <p><b>Total price:</b> ${price}</p>
                
            </c:if> 
            
            <hr/>
        </c:if> 
        
    </body>
</html>