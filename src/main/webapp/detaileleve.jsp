<%-- 
    Document   : detaileleve
    Created on : 5 août 2017, 03:09:07
    Author     : ines gnaly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Geschool | Détail élève</title>
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
                    <h1>
                        Détails de l'élève
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="<c:url value="/AutoServlet?action=home&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li><a href="<c:url value="/AutoServlet?action=listeleve&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>Liste classes</a></li>
                        <li class="active">Détails Élève</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">

                    <div class="row">
                        <div class="col-md-3">

                            <!-- Profile Image -->
                            <div class="box box-primary">
                                <div class="box-body box-profile">
                                    <c:if test="${eleve.sexe == 'Masculin'}">
                                        <img class="profile-user-img img-responsive img-circle" src="img/User_100.png" alt="User profile picture"/>
                                    </c:if>
                                    <c:if test="${eleve.sexe == 'Féminin'}">
                                        <img class="profile-user-img img-responsive img-circle" src="img/avatar.png" alt="User profile picture"/>
                                    </c:if>
                                    

                                    <h3 class="profile-username text-center"><c:out value="eleve.Nom"/> <c:out value="eleve.Prenom"/></h3>

                                    <p class="text-muted text-center"><c:out value=""/> Salle de classe</p>

                                    <ul class="list-group list-group-unbordered">
                                        <li class="list-group-item">
                                            <b>Moyenne Année en cours</b> <a class="pull-right">1,322</a>
                                        </li>
                                        <li class="list-group-item">
                                            <b>Moyenne année précédente</b> <a class="pull-right">543</a>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->

                            <!-- About Me Box -->
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Information de l'élève</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <strong><i class="fa fa-calendar"></i> Date de naissance</strong>

                                    <p class="text-muted">
                                        <fmt:formatDate value="" pattern="dd-MM-yyyy" />
                                    </p>

                                    <hr>

                                    <strong><i class="fa fa-map-marker margin-r-5"></i> Adresse</strong>

                                    <p class="text-muted"><c:out value=""/></p>
                                </div>
                                <!-- /.box-body -->
                            </div>
                            <!-- /.box -->
                        </div>
                        <!-- /.col -->
                        <div class="col-md-9">
                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#activity" data-toggle="tab"><i class="fa fa-archive"></i>Bulletin Classe en cours</a></li>
                                    <li><a href="#timeline" data-toggle="tab"><i class="fa fa-archive"></i>Bulletin Classe précédente</a></li>
                                    <li><a href="#settings" data-toggle="tab"><i class="fa fa-cog"></i>Modifications</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="active tab-pane" id="activity">
                                        <div class="box-body">
                                            <div class="box-group" id="accordion">
                                                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                                                                Trimestre #1
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseOne" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-group" id="accordion2">
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOnesubOne">
                                                                                Sequence #1
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubOne" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">15,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOnesubTwo">
                                                                                Sequence #2
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubTwo" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2" href="#collapseOnesubThird">
                                                                                Sequence #3
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubThird" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="box-group">
                                                                <div class="col-md-6">
                                                                    <p class="text-muted">Moyenne Trimestre #1</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <p class="text-muted">10,00/20</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
                                                                Trimestre #2
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseTwo" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-group" id="accordion3">
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3" href="#collapseTwosubOne">
                                                                                Sequence #1
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubOne" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">15,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3" href="#collapseTwosubTwo">
                                                                                Sequence #2
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubTwo" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3" href="#collapseTwosubThird">
                                                                                Sequence #3
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubThird" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="box-group">
                                                                <div class="col-md-6">
                                                                    <p class="text-muted">Moyenne Trimestre #1</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <p class="text-muted">10,00/20</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
                                                                Trimestre #3
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseThree" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-body">
                                                                Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                                <div class="box-group" id="accordion4">
                                                                    <div class="panel box box-default">
                                                                        <div class="box-header with-border">
                                                                            <h5 class="box-title">
                                                                                <a data-toggle="collapse" data-parent="#accordion4" href="#collapseThreesubOne">
                                                                                    Sequence #1
                                                                                </a>
                                                                            </h5>
                                                                        </div>
                                                                    </div>
                                                                    <div id="collapseThreesubOne" class="panel-collapse collapse">
                                                                        <div class="box-body">
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #1_1</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">10,00/20</p>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #1_2</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">15,00/20</p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="panel box box-default">
                                                                        <div class="box-header with-border">
                                                                            <h5 class="box-title">
                                                                                <a data-toggle="collapse" data-parent="#accordion4" href="#collapseThreesubTwo">
                                                                                    Sequence #2
                                                                                </a>
                                                                            </h5>
                                                                        </div>
                                                                    </div>
                                                                    <div id="collapseThreesubTwo" class="panel-collapse collapse">
                                                                        <div class="box-body">
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #2_1</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">10,00/20</p>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #2_2</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">10,00/20</p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="panel box box-default">
                                                                        <div class="box-header with-border">
                                                                            <h5 class="box-title">
                                                                                <a data-toggle="collapse" data-parent="#accordion4" href="#collapseThreesubThird">
                                                                                    Sequence #3
                                                                                </a>
                                                                            </h5>
                                                                        </div>
                                                                    </div>
                                                                    <div id="collapseThreesubThird" class="panel-collapse collapse">
                                                                        <div class="box-body">
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #3_1</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">10,00/20</p>
                                                                            </div>
                                                                            <div class="col-md-6">
                                                                                <p class="text-muted">Matière #3_2</p>
                                                                            </div>
                                                                            <div class="col-md-3">
                                                                                <p class="text-muted">10,00/20</p>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="box-group">
                                                                    <div class="col-md-6">
                                                                        <p class="text-muted">Moyenne Trimestre #1</p>
                                                                    </div>
                                                                    <div class="col-md-3">
                                                                        <p class="text-muted">10,00/20</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-group">
                                                <div class="col-md-6">
                                                    <p class="lead">Moyenne Générale</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="lead">10,00/20</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->
                                    <div class="tab-pane" id="timeline">
                                        <!-- The timeline -->
                                        <div class="box-body">
                                            <div class="box-group" id="accordion_snde">
                                                <!-- we are adding the .panel class so bootstrap.js collapse plugin detects it -->
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion_snde" href="#collapseOne_snde">
                                                                Trimestre #1
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseOne_snde" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-group" id="accordion2_snde">
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2_snde" href="#collapseOnesubOne_snde">
                                                                                Sequence #1
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubOne_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">15,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2_snde" href="#collapseOnesubTwo_snde">
                                                                                Sequence #2
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubTwo_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion2_snde" href="#collapseOnesubThird_snde">
                                                                                Sequence #3
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseOnesubThird_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="box-group">
                                                                <div class="col-md-6">
                                                                    <p class="text-muted">Moyenne Trimestre #1</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <p class="text-muted">10,00/20</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion_snde" href="#collapseTwo_snde">
                                                                Trimestre #2
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseTwo_snde" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-group" id="accordion3_snde">
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3_snde" href="#collapseTwosubOne_snde">
                                                                                Sequence #1
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubOne_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">15,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3_snde" href="#collapseTwosubTwo_snde">
                                                                                Sequence #2
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubTwo_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion3_snde" href="#collapseTwosubThird_snde">
                                                                                Sequence #3
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseTwosubThird_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="box-group">
                                                                <div class="col-md-6">
                                                                    <p class="text-muted">Moyenne Trimestre #2</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <p class="text-muted">10,00/20</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel box box-primary">
                                                    <div class="box-header with-border">
                                                        <h4 class="box-title">
                                                            <a data-toggle="collapse" data-parent="#accordion_snde" href="#collapseThree_snde">
                                                                Trimestre #3
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="collapseThree_snde" class="panel-collapse collapse">
                                                        <div class="box-body">
                                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3
                                                            <div class="box-group" id="accordion4_snde">
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion4_snde" href="#collapseThreesubOne">
                                                                                Sequence #1
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseThreesubOne" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #1_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">15,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion4_snde" href="#collapseThreesubTwo_snde">
                                                                                Sequence #2
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseThreesubTwo_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #2_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel box box-default">
                                                                    <div class="box-header with-border">
                                                                        <h5 class="box-title">
                                                                            <a data-toggle="collapse" data-parent="#accordion4_snde" href="#collapseThreesubThird_snde">
                                                                                Sequence #3
                                                                            </a>
                                                                        </h5>
                                                                    </div>
                                                                </div>
                                                                <div id="collapseThreesubThird_snde" class="panel-collapse collapse">
                                                                    <div class="box-body">
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_1</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <p class="text-muted">Matière #3_2</p>
                                                                        </div>
                                                                        <div class="col-md-3">
                                                                            <p class="text-muted">10,00/20</p>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="box-group">
                                                                <div class="col-md-6">
                                                                    <p class="text-muted">Moyenne Trimestre #3</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <p class="text-muted">10,00/20</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="box-group">
                                                <div class="col-md-6">
                                                    <p class="lead">Moyenne Générale</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="lead">10,00/20</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->

                                    <!--
                                    <div class="tab-pane" id="settings">
                                        <form class="form-horizontal">
                                            <div class="form-group">
                                                <label for="inputName" class="col-sm-2 control-label">Nom</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputName" placeholder="Nom">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputEmail" class="col-sm-2 control-label">Prénom</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputEmail" placeholder="Prénom">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputName" class="col-sm-2 control-label">Date naissance</label>

                                                <div class="col-sm-10">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input type="text" class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask>
                                                    </div>
                                                </div> 
                                            </div>
                                            <div class="form-group">
                                                <label for="inputExperience" class="col-sm-2 control-label">Adresse</label>

                                                <div class="col-sm-10">
                                                    <textarea class="form-control" id="inputExperience" placeholder="Experience"></textarea>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="inputSkills" class="col-sm-2 control-label">Skills</label>

                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputSkills" placeholder="Skills">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <button type="submit" class="btn btn-danger">Modifier</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div> 
                                    -->
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.nav-tabs-custom -->
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
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/demo.js"></script>
    </body>
</html>