<%-- 
    Document   : header
    Created on : 20 juil. 2017, 22:06:27
    Author     : Ines.G
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="main-header">
    <!-- Logo -->
    <a href="<c:url value="/AutoServlet?action=home&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>" class="logo">
       <!-- mini logo for sidebar mini 50x50 pixels -->
       <span class="logo-mini"><b>G</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Geschool</b></span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- Messages: style can be found in dropdown.less-->

                <!-- Notifications: style can be found in dropdown.less -->

                <!-- Tasks: style can be found in dropdown.less -->

                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="img/avatar.png" class="user-image" alt="User Image">
                        <span class="hidden-xs"><c:out value="${sessionScope.sessionUtilisateur.login}"/></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="img/avatar.png" class="img-circle" alt="User Image">
                            <p>
                        <c:out value="${sessionScope.sessionUtilisateur.login}"/>
                        </p>
                </li>
                <!-- Menu Body -->

                <!-- Menu Footer-->
                <li class="user-footer">
                    <div class="pull-left">
                        <a href="<c:url value="/UtilisateurServlet?action=logout"/>" class="btn btn-default btn-flat">Sign out</a>
                    </div>
                </li>
            </ul>
            </li>
            <!-- Control Sidebar Toggle Button -->

            </ul>
        </div>
    </nav>
</header>