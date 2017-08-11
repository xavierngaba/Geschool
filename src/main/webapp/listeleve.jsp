<%-- 
    Document   : listeleve
    Created on : 5 août 2017, 01:27:09
    Author     : ines gnaly
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
        <title>Geschool | Liste des élèves </title>
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

            <c:import url="vue/header.jsp"/>
            <!-- Left side column. contains the logo and sidebar -->
            <c:import url="vue/navbar.jsp"/>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <ol class="breadcrumb">
                        <li><a href="<c:url value="/AutoServlet?action=home&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="<c:url value="/AutoServlet?action=listeleve&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>Liste classes</a></li>
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
                                    <h3 class="box-title">Tableau des élèves enregistrés</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Matricule</th>
                                                <th>Nom & Prénom</th>
                                                <th>Date de naissance</th>
                                                <th>Nationalité</th>
                                                <th>Sexe</th>
                                                <th>Date inscription</th>
                                                <th>Détails</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:if test="${listeleve.size() != 0}">
                                                <c:forEach items="${ requestScope.listeleve }" var="eleve" varStatus="boucle">
                                                    <tr>
                                                        <td><c:out value="${eleve.matricule}"/></td>
                                                        <td><c:out value="${eleve.nom}"/> <c:out value="${eleve.prenom}"/></td>
                                                        <td><fmt:formatDate value="${eleve.dateNaiss}" pattern="dd-MM-yyyy" /></td>
                                                        <td><c:out value="${eleve.nationalite}"/></td>
                                                        <td data-skin="skin-blue" class="btn btn-primary btn-xs">
                                                            <c:if test="${eleve.sexe == 'Masculin'}">
                                                                <i class="fa fa-male"></i>
                                                            </c:if>
                                                            <c:if test="${eleve.sexe == 'Féminin'}">
                                                                <i class="fa fa-female"></i>
                                                            </c:if>
                                                        </td>
                                                        <td><fmt:formatDate value="${eleve.dateinscription}" pattern="dd-MM-yyyy" /></td>
                                                        <td><a href="<c:url value="/AutoServlet?action=detaileleve&ideleve=${eleve.idEleve}&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>">détail <i class="fa fa-eye"></i></a></td>
                                                        <td><a href="<c:url value="/AutoServlet?action=modifeleve&ideleve=${eleve.idEleve}&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>">Modifier <i class="fa fa-edit"></i></a></td>
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
            <c:import url="vue/footer.jsp"/>
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

                $('#action').on("click", function (event) {
                    if (this.checked) {
                        var action = $('#action').val();
                        var session = $('#session').val();
                        $.ajax({
                            url: '/SessionServlet',
                            data: {
                                action: action,
                                session: session
                            },
                            success: function (responseText) {
                                $('#ajaxGetUserServletResponse').text(responseText);
                            }
                        });
                    }
                });
            });
        </script>
    </body>
</html>
