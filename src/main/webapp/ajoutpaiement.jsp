<%-- 
    Document   : ajoutinscription
    Created on : 5 août 2017, 01:27:28
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
        <title>Geschool | Paiement inscription </title>
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
                        <li><a href="<c:url value="/AutoServlet?action=listinscription&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>Liste des inscriptions</a></li>
                        <li class="active">Inscription élève</li>
                    </ol>
                </section>
                <br/>
                <!-- Main content -->
                <section class="content">
                    <!-- SELECT2 EXAMPLE -->
                    <div class="box box-default">
                        <div class="box-header with-border">
                            <h3 class="box-title">Formulaire de paiement</h3>
                        </div>
                        <c:if test="${!empty requestScope.eleve and requestScope.eleve.status == 'Inscrit'}">
                            <form action="<c:url value="/InscriptionServlet"/>" method="post">
                                <input type="hidden"  name="action" value="ajoutpaiement"/>
                                <input type="hidden"  name="idAnnee" value="<c:out value="${requestScope.Annee.id}"/>"/>
                                <input type="hidden"  name="idInscrit" value="<c:out value="${requestScope.Inscrit.idInscrit}"/>"/>
                                <input type="hidden"  name="idEleve" value="<c:out value="${requestScope.eleve.idEleve}"/>"/>
                                <input type="hidden"  name="idClasse" value="<c:out value="${requestScope.Inscrit.idClasse.idClasse}"/>"/>
                                <input type="hidden"  name="session" value="${sessionScope.sessionUtilisateur.idUtilisateur}"/>
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Paiement de la scolarit&eacute; pour l'année scolaire <c:out value="${requestScope.Annee.libelle}"/></h3>
                                    </div>
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Nom & Pr&eacute;nom de l'élève : </label>
                                                            <label><c:out value="${eleve.nom}"/> <c:out value="${eleve.prenom}"/></label>
                                                        </div>
                                                        <div class="form-group" id="messageMontant">
                                                            <c:if test="${Inscrit.getIdEleve().dette == 0}">
                                                                <p id="message" class="text-red" style="font-size: 16px;">Les Frais d'insciption pour cette classe s'élève à <c:out value="${Inscrit.idClasse.getMontant()}"/> Frs CFA</p>
                                                            </c:if>
                                                            <c:if test="${Inscrit.getIdEleve().dette != 0}">
                                                                <p id="message" class="text-red" style="font-size: 16px;">Cet élève a d&eacute;j&agrave; pay&eacute; <c:out value="${scolarite}"/> Frs CFA</p>
                                                            </c:if>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Commenatire</label>
                                                            <textarea class="form-control" name="commentaire" rows="5" placeholder="Commentaire..."></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Salle de Classe : </label> 
                                                            <label><c:out value="${Inscrit.idClasse.libelle}"/></label> 
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Frais d'inscription</label>
                                                            <c:if test="${Inscrit.getIdEleve().dette == 0}">
                                                                <input type="text" class="form-control pull-right" id="montant2" name="montant"/>
                                                               <input type="hidden" class="form-control pull-right" id="montantinitial" value="<c:out value="${Inscrit.idClasse.getMontant()}"/>"/> 
                                                            </c:if>
                                                            <c:if test="${Inscrit.getIdEleve().dette != 0}">
                                                                <input type="text" class="form-control pull-right" id="montant2" name="montant"/>
                                                                <input type="hidden" class="form-control pull-right" name="" id="montantinitial" value="${Inscrit.getIdEleve().dette}"/>  
                                                            </c:if>
                                                            <input type="hidden" class="form-control pull-right" id="reste" name="reste"/>
                                                            <p id="calcul"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Type réglement</label>                                          
                                                            <select name="typeReglement" class="form-control select2" style="width: 80%;">
                                                                <c:if test="${listetypereglement.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listetypereglement }" var="typereglement" varStatus="i">
                                                                        <option value="<c:out value="${typereglement.getLibelle()}"/>"><c:out value="${typereglement.getLibelle()}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.form-group -->
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
                        </c:if>
                        <c:if test="${!empty requestScope.eleve and requestScope.eleve.status == 'Préinscrit'}">
                            <form action="<c:url value="/InscriptionServlet"/>" method="post">
                                <input type="hidden"  name="action" value="ajoutpaiement"/>
                                <input type="hidden"  name="idAnnee" value="<c:out value="${requestScope.Annee.id}"/>"/>
                                <input type="hidden"  name="idEleve" value="<c:out value="${requestScope.eleve.idEleve}"/>"/>
                                <input type="hidden"  name="session" value="${sessionScope.sessionUtilisateur.idUtilisateur}"/>
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Paiement de la scolarit&eacute; pour l'année scolaire <c:out value="${requestScope.Annee.libelle}"/></h3>
                                    </div>
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Nom & Pr&eacute;nom de l'élève : </label>
                                                            <label><c:out value="${eleve.nom}"/> <c:out value="${eleve.prenom}"/></label>
                                                        </div>
                                                        <div class="form-group" id="messageMontant">
                                                            <p id="message" class="lead" style="font-size: 16px;"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Commenatire</label>
                                                            <textarea class="form-control" name="commentaire" rows="5" placeholder="Commentaire..."></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Salle de Classe</label>
                                                            <select name="idClasse" id="idClasse" class="form-control select2" style="width: 80%;">
                                                                <option value="null"></option>
                                                                <c:if test="${listclasse.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listclasse }" var="classe" varStatus="boucle">
                                                                        <option value="<c:out value="${classe.idClasse}"/>"><c:out value="${classe.libelle}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Frais d'inscription</label>                                          
                                                            <input type="text" class="form-control pull-right" id="montant" name="montant"/>
                                                            <input type="hidden" class="form-control pull-right" id="reste" name="reste"/>
                                                            <p id="calcul" class="lead" style="font-size: 16px;"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Type réglement</label>                                          
                                                            <select name="typeReglement" class="form-control select2" style="width: 80%;">
                                                                <c:if test="${listetypereglement.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listetypereglement }" var="typereglement" varStatus="i">
                                                                        <option value="<c:out value="${typereglement.getLibelle()}"/>"><c:out value="${typereglement.getLibelle()}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.form-group -->
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
                        </c:if>
                        <c:if test="${empty requestScope.eleve}">
                            <form action="<c:url value="/InscriptionServlet"/>" method="post">
                                <input type="hidden"  name="action" value="ajoutpaiement"/>
                                <input type="hidden"  name="idAnnee" value="<c:out value="${requestScope.Annee.id}"/>"/>
                                <input type="hidden"  name="idInscrit" value="<c:out value="${requestScope.Inscrit.id}"/>"/>
                                <input type="hidden"  name="session" value="${sessionScope.sessionUtilisateur.idUtilisateur}"/>
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">Inscription pour l'année scolaire <c:out value="${requestScope.Annee.libelle}"/></h3>
                                    </div>
                                    <div class="box-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Nom de l'élève</label>
                                                            <select name="idEleve" class="form-control select2" style="width: 100%;">
                                                                <option value="null"></option>
                                                                <c:if test="${listeleve.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listeleve }" var="eleve" varStatus="boucle">
                                                                        <option value="<c:out value="${eleve.idEleve}"/>"><c:out value="${eleve.nom}"/> <c:out value="${eleve.prenom}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                        <div class="form-group" id="messageMontant">
                                                            <p id="message" class="lead" style="font-size: 16px;"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Commenatire</label>
                                                            <textarea class="form-control" name="commentaire" rows="5" placeholder="Commentaire..."></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="col-md-4"></div>
                                                    <div class="col-md-6">
                                                        <div class="form-group">
                                                            <label>Salle de Classe</label>
                                                            <select name="idClasse" id="idClasse" class="form-control select2" style="width: 80%;">
                                                                <option value="null"></option>
                                                                <c:if test="${listclasse.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listclasse }" var="classe" varStatus="boucle">
                                                                        <option value="<c:out value="${classe.idClasse}"/>"><c:out value="${classe.libelle}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Frais d'inscription</label>                                          
                                                            <input type="text" class="form-control pull-right" id="montant" name="montant"/>
                                                            <input type="hidden" class="form-control pull-right" id="reste" name="reste"/>
                                                            <p id="calcul" class="lead" style="font-size: 16px;"></p>
                                                        </div>
                                                        <div class="form-group">
                                                            <label>Type réglement</label>                                          
                                                            <select name="typeReglement" class="form-control select2" style="width: 80%;">
                                                                <c:if test="${listetypereglement.size() != 0}">
                                                                    <c:forEach items="${ requestScope.listetypereglement }" var="typereglement" varStatus="i">
                                                                        <option value="<c:out value="${typereglement.getLibelle()}"/>"><c:out value="${typereglement.getLibelle()}"/></option>
                                                                    </c:forEach>
                                                                </c:if>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- /.form-group -->
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
                        </c:if>
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
        <!-- Script Ajax -->
        <script src="js/ajaxScript.js"></script>
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
            });
        </script>
    </body>
</html>
