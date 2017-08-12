<%-- 
    Document   : ajoutinscription
    Created on : 20 juil. 2017, 22:43:28
    Author     : ines gnali
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
        <title>Geschool | Modification Elève</title>
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
        <!-- daterange picker -->
        <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="plugins/datepicker/datepicker3.css">
        <!-- iCheck for checkboxes and radio inputs -->
        <link rel="stylesheet" href="plugins/iCheck/all.css">
        <!-- Select2 -->
        <link rel="stylesheet" href="plugins/select2/select2.min.css">

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
                        <li><a href="<c:url value="/AutoServlet?action=listeleve&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>Liste des élèves</a></li>
                        <li class="active">Modification d'un élève</li>
                    </ol>
                </section>
                <br/>
                <!-- Main content -->
                <section class="content">
                    <!-- SELECT2 EXAMPLE -->
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">Formulaire de modification d'un élève</h3>
                        </div>
                        <form action="<c:url value="/InscriptionServlet"/>" method="post">
                            <input type="hidden"  name="action" value="modifeleve"/>
                            <input type="hidden" name="session" value="${sessionScope.sessionUtilisateur.idUtilisateur}"/>
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">les informations de l'élève</h3>
                                </div>
                                <div class="box-body">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label class="lead">Matricule : <c:out value="${eleve.matricule}"/></label>
                                            </div>
                                            <div class="form-group">
                                                <label>Nom de l'élève</label>
                                                <input type="text" class="form-control" id="nom" name="Nom" value="<c:out value="${eleve.nom}"/>" placeholder="Saisisser le nom">&nbsp;<i class="fa fa-warning"></i>
                                            </div>
                                            <div class="form-group">
                                                <label><i class="fa fa-warning"></i>Date de Naissance</label>
                                                <div class="input-group">
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-calendar"></i>
                                                    </div>
                                                    <input type="text" name="Date_Naiss" class="form-control" data-inputmask="'alias': 'dd/mm/yyyy'" data-mask value="<c:out value="${eleve.dateNaiss}"/>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label><i class="fa fa-warning"></i>Sexe</label>
                                                <select class="form-control" style="width: 50%;" name="sexe">
                                                    <option value="<c:out value="${eleve.sexe}"/>" selected="selected"><c:out value="${eleve.sexe}"/></option>
                                                    <option value="Masculin">Masculin</option>
                                                    <option value="Féminin">Féminin</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label></label>
                                            </div>
                                            <div class="form-group">
                                                <label>Prénom de l'élève</label>
                                                <input type="text" class="form-control" id="prenom" name="Prenom" placeholder="Saisisser le prénom" value="<c:out value="${eleve.prenom}"/>">&nbsp;<i class="fa fa-warning"></i>
                                            </div>
                                            <div class="form-group">
                                                <label>Nationalité </label>
                                                <div class="input-group">
                                                    <div class="input-group-addon">
                                                        <i class="fa fa-map"></i>
                                                    </div>
                                                    <input type="text" class="form-control" name="nationalite" id="nationalite" placeholder="Saisisser la nationalité" value="<c:out value="${eleve.nationalite}"/>">
                                                </div>
                                            </div>
                                        </div>
                                    </div> 
                                </div>
                            </div>
                            <div class="box box-success">
                                <div class="box-header with-border">
                                    <h3 class="box-title">les informations du tuteur</h3>
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Nom du tuteur</label>
                                                    <input type="text" class="form-control" id="nom" name="NomTuteur" placeholder="Saisisser le nom du tuteur" value="<c:out value="${eleve.idTuteur.nomPrenom}"/>">&nbsp;<i class="fa fa-warning"></i>
                                                </div>
                                                <div class="form-group">
                                                    <label>Prénom du tuteur</label>
                                                    <input type="text" class="form-control" id="nom" name="PrenomTuteur" placeholder="Saisisser le prénom du tuteur">&nbsp;<i class="fa fa-warning"></i>
                                                </div>
                                                <div class="form-group"></div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Telephone </label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-phone"></i>
                                                        </div>
                                                        <input type="text" name="telephone" class="form-control" value="<c:out value="${eleve.idTuteur.telephone}"/>" data-inputmask="'mask': ['+99 99 999 9999']" data-mask>
                                                    </div>
                                                </div>   
                                                <div class="form-group">
                                                    <label>Adresse </label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-map-marker"></i>
                                                        </div>
                                                        <input type="text" name="Adresse" class="form-control" id="lieu" placeholder="Adresse du tuteur" value="<c:out value="${eleve.idTuteur.adresse}"/>">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label>Relation </label>
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-map-marker"></i>
                                                        </div>
                                                        <input type="text" name="Relation" class="form-control" id="lieu" placeholder="Saisisser la relation du tuteur" value="<c:out value="${eleve.idTuteur.relation}"/>">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="reset" class="btn btn-default">Cancel</button>
                                <button type="submit" class="btn btn-info pull-right">valider</button>
                            </div>
                        </form>
                    </div>
                    <!-- /.box -->
                    <div class="row">
                        <div class="col-md-12">
                            <c:if test="${message == 'error'}">
                                <div class="alert alert-danger alert-dismissible">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <h4><i class="icon fa fa-ban"></i> Alert!</h4>
                                    <c:out value="${form.erreurs}"/>
                                </div>
                            </c:if>
                            <c:if test="${message == 'success'}">
                                <div class="alert alert-success alert-dismissible">
                                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <h4><i class="icon fa fa-check"></i> Success!</h4>
                                    <c:out value="${form.resultat}"/>
                                </div>
                            </c:if>
                        </div>
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
        <!-- Select2 -->
        <script src="plugins/select2/select2.full.min.js"></script>
        <!-- InputMask -->
        <script src="plugins/input-mask/jquery.inputmask.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
        <script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>
        <!-- date-range-picker -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <!-- bootstrap datepicker -->
        <script src="plugins/datepicker/bootstrap-datepicker.js"></script>
        <!-- SlimScroll 1.3.0 -->
        <script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
        <!-- iCheck 1.0.1 -->
        <script src="plugins/iCheck/icheck.min.js"></script>
        <!-- FastClick -->
        <script src="plugins/fastclick/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="js/app.min.js"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/demo.js"></script>
        <!-- Page script -->
        <script>
            $(function () {
                //Initialize Select2 Elements
                $(".select2").select2();

                //Datemask dd/mm/yyyy
                $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
                //Datemask2 mm/dd/yyyy
                $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
                //Money Euro
                $("[data-mask]").inputmask();

                //Date range picker
                $('#reservation').daterangepicker();
                //Date range picker with time picker
                $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
                //Date range as a button
                $('#daterange-btn').daterangepicker(
                        {
                            ranges: {
                                'Today': [moment(), moment()],
                                'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                                'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                                'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                                'This Month': [moment().startOf('month'), moment().endOf('month')],
                                'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                            },
                            startDate: moment().subtract(29, 'days'),
                            endDate: moment()
                        },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
                );

                //Date picker
                $('#datepicker').datepicker({
                    autoclose: true
                });

                //iCheck for checkbox and radio inputs
                $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                    radioClass: 'iradio_minimal-blue'
                });
                //Red color scheme for iCheck
                $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                    checkboxClass: 'icheckbox_minimal-red',
                    radioClass: 'iradio_minimal-red'
                });
                //Flat red color scheme for iCheck
                $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                    checkboxClass: 'icheckbox_flat-green',
                    radioClass: 'iradio_flat-green'
                });
            });
        </script>
    </body>
</html>
