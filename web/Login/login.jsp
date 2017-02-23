<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="resource/ico.ico">
    <title>实验室器材管理系统-Java</title>

    <link rel="stylesheet" type="text/css" href="css/loginCss.css" />
    <link href="../Common/Css/messenger.css" rel="stylesheet">   <!-- Alert Message -->
    <link href="../Common/Css/messenger-theme-future.css" rel="stylesheet">
    <link href="../Common/Css/messenger-theme-air.css" rel="stylesheet">

    <script type="text/javascript" src="js/jquery-3.0.0.js"></script>
    <script type="text/javascript" src="../Common/Js/messenger.min.js"></script>   <!-- Alert Message -->
    <script type="text/javascript" src="../Common/Js/messenger-theme-future.js"></script>
    <script type="text/javascript" src="js/loginJs.js"></script>
</head>

<body>
<div class="container">
    <section id="content">
        <form id="loginForm">
            <h1>请登录</h1>
            <input type="text" placeholder="Username" required="" id="username" name="username"/>
            <input type="password" placeholder="Password" required="" id="password" name="password"/>
            <button type="button" value="submit">登录</button>
        </form>
        <div class="tips">
            <p>Tip:初始用户名和密码为校园卡上的工作证号或学号 进入系统后请立即修改密码</p>
        </div>
    </section>
</div>
</body>
</html>