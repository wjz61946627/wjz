<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link href='<c:url value="/resource/css/bootstrap.css" />' rel="stylesheet">
    <link href='<c:url value="/resource/css/sign.css" />' rel="stylesheet">

    <script src='<c:url value="/resource/js/jquery-3.3.1.min.js" />'></script>
    <script src='<c:url value="/resource/js/login.js" />'></script>

    <title>login</title>
</head>
<body>

<div class="container">
    <form class="form-signin" method="post" id="loginForm">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="name" class="sr-only">Username</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Username" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>
        <div class="alert alert-danger" role="alert" id="errorInfo">
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button" id="login">Sign in</button>
    </form>

</div> <!-- /container -->
</body>
</html>