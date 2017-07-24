<%-- 
    Document   : listSessesion
    Created on : 8 juil. 2017, 02:50:32
    Author     : xavier_ng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Geschool | Tableau Classe </title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.6 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="css/skins/_all-skins.min.css">
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

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
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="img/avatar.png" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p><c:out value="${sessionScope.sessionUtilisateur.login}"/></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <form action="#" method="get" class="sidebar-form">
                        <div class="input-group">
                            <input type="text" name="q" class="form-control" placeholder="Search...">
                            <span class="input-group-btn">
                                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="header">Menu Principal</li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-group"></i>
                                <span>Inscriptions</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="data.html"><i class="fa fa-table"></i>
                                        <span>Liste d'inscription</span>
                                        <span class="pull-right-container">
                                            <span class="label label-primary pull-right">4</span>
                                        </span>
                                    </a>
                                </li>
                                <li><a href="form.html"><i class="fa fa-user-plus"></i> Nouv. Inscription</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-building"></i>
                                <span>Salle de Classe</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="<c:url value="/AutoServlet?action=listeclasse&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                                        <span>Liste de classes</span>
                                        <span class="pull-right-container">
                                            <span class="label label-primary pull-right">0</span>
                                        </span>
                                    </a>
                                </li>
                                <li>
                                    <a href="<c:url value="/AutoServlet?action=classeSession&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                                        <span>Liste des Classes/Sessions</span>
                                        <span class="pull-right-container">
                                            <span class="label label-primary pull-right">0</span>
                                        </span>
                                    </a>
                                </li>
                                <li><a href="<c:url value="/ClasseServlet?action=ajoutclasse&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="glyphicon glyphicon-plus-sign"></i> Nouv. Classes</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-calendar-o"></i>
                                <span>Ann&eacute;e Scolaire</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="<c:url value="/AutoServlet?action=listesession&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-calendar"></i>
                                        <span>Liste</span>
                                    </a>
                                </li>
                                <li><a href="<c:url value="/AutoServlet?action=ajoutsession&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-calendar-plus-o"></i> Nouv. Ann&eacute;e scolaire</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-book"></i>
                                <span>Mati&egrave;re</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="#"><i class="fa fa-table"></i>
                                        <span>Liste des Mati&egrave;res</span>
                                        <span class="pull-right-container">
                                            <span class="label label-primary pull-right">4</span>
                                        </span>
                                    </a>
                                </li>
                                <li><a href="#"><i class="glyphicon glyphicon-plus-sign"></i> Nouv. Mati&egrave;re</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="glyphicon glyphicon-education"></i>
                                <span>Notes</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-search"></i> Recherche Notes</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-plus-sign"></i> Nouv. Note</a></li>
                            </ul>
                        </li>
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-archive"></i>
                                <span>Bulletin</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="#"><i class="fa fa-search"></i>Recherche Bulletin</a></li>
                            </ul>
                        </li>
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <ol class="breadcrumb">
                        <li><a href="<c:url value="/AutoServlet?action=home&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="<c:url value="/AutoServlet?action=listeclasse&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>Liste classes</a></li>
                    </ol>
                    <br/>
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xs-12">
                            <!-- /.box -->

                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">Tableau des Salles de classes</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Libelle</th>
                                                <th>Nombre Max élève</th>
                                                <th>Date création</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${listClasse.size() != 0}">
                                                <c:forEach items="${ requestScope.listClasse }" var="classe" varStatus="boucle">
                                                    <tr>
                                                        <td><c:out value="${classe.libelleClasse}"/></td>
                                                        <td><fmt:formatDate value="${classe.dateCreationClasse}" pattern="dd-MM-yyyy" /></td>
                                                        <td><c:out value="${classe.nombreEleveMax}"/></td>
                                                    </tr>
                                                </c:forEach>
                                            </c:if>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </section>
                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.0
                </div>
                <strong>Copyright &copy; 2017 Geschool</strong> All rights
                reserved.
            </footer>
            <!-- /.control-sidebar -->
            <!-- Add the sidebar's background. This div must be placed
                 immediately after the control sidebar -->
            <div class="control-sidebar-bg"></div>
        </div>
        <!-- ./wrapper -->

        <!-- jQuery 2.2.3 -->
        <script src="plugins/jQuery/jquery-2.2.3.min.js"></script>
        <!-- Bootstrap 3.3.6 -->
        <script src="js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="plugins/datatables/dataTables.bootstrap.min.js"></script>
        <!-- SlimScroll -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/demo.js"></script>
        <!-- page script -->
        <script>
            $(function () {
                $('#example1').DataTable();
                
                $('#action').on("click",function(event) {
                    if(this.checked){
                       var action = $('#action').val();
                       var session = $('#session').val();
                        $.ajax({
                                url : '/SessionServlet',
                                data : {
                                         action : action,
                                         session : session
                                },
                                success : function(responseText) {
                                        $('#ajaxGetUserServletResponse').text(responseText);
                                }
                        });
                    }    
                });
            });
        </script>
    </body>
</html>
