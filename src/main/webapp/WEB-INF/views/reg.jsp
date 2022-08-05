<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Accident</title>
</head>
<body>
<div class="container pt-3" style="width: 30%">
    <div class="card">
        <c:if test="${not empty message}">
            <div style="color:red; font-weight: bold; margin: 30px 0px;">
                    ${message}
            </div>
        </c:if>
        <div class="card-body">
            <form name='login' action="<c:url value='/reg'/>" method='POST'>
                <div class="form-group">
                    <label>UserName:
                        <input type='text' name='username'>
                    </label>
                </div>
                <div class="form-group">
                    <label>Password:
                        <input type='password' name='password'/>
                    </label>
                </div>
                <input name="submit" type="submit" value="submit"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>