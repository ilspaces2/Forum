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
    <title>Форум job4j</title>
</head>
<body>
<div class="container mt-3">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Hi, ${user.username}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="nav">
                <a class="nav-link" href="<c:url value='/'/>">Назад</a>
                <a class="nav-link" href="<c:url value='/logout'/>">Выход</a>
            </div>
        </div>
    </nav>
</div>
<div class="container" style="width: 50%">
    <div class="card">
        <div class="card-header">
            Добавить новый пост.
        </div>
        <div class="card-body">
            <form action="<c:url value='/save'/>" method='POST'>
                <input type="hidden" name="username" value="${user.username}">
                <div class="form-group">
                    <label>Имя
                        <input type="text" class="form-control" name="name" required>
                    </label>
                </div>
                <div class="form-group">
                    <label>Описание
                        <input type="text" class="form-control" name="description" required>
                    </label>
                </div>
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>