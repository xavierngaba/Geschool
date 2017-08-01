<%-- 
    Document   : lockscreen
    Created on : 4 juil. 2017, 23:20:39
    Author     : Ines.G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 2 | Lockscreen</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="css/AdminLTE.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition lockscreen">
        <!-- Automatic element centering -->
        <div class="lockscreen-wrapper">
            <div class="lockscreen-logo">
                <a href="index.html"><b>Geschool</b></a>
            </div>
            <!-- User name -->
            <div class="lockscreen-name">Admin</div>

            <!-- START LOCK SCREEN ITEM -->
            <div class="lockscreen-item">
                <!-- lockscreen image -->
                <div class="lockscreen-image">
                    <img src="img/avatar.png" alt="User Image">
                </div>
                <!-- /.lockscreen-image -->

                <!-- lockscreen credentials (contains the form) -->
                <form class="lockscreen-credentials" action="<c:url value="/UtilisateurServlet"/>">
                    <input type="hidden" class="form-control" name="action" value="unlock">
                    <div class="input-group">
                        <input type="password" class="form-control" placeholder="password">

                        <div class="input-group-btn">
                            <button type="button" class="btn"><i class="fa fa-arrow-right text-muted"></i></button>
                        </div>
                    </div>
                </form>
                <!-- /.lockscreen credentials -->

            </div>
            <!-- /.lockscreen-item -->
            <div class="help-block text-center">
                Enter your password to retrieve your session
            </div>
            <div class="text-center">
                <a href="<c:url value="/UtilisateurServlet?action=login"/>">Or sign in as a different user</a>
            </div>
            <div class="lockscreen-footer text-center">
                <strong>Copyright &copy; 2017 Geschool</strong> All rights reserved.
            </div>
        </div>
        <!-- /.center -->

        <!-- jQuery 2.2.3 -->
        <script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="../../bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>
