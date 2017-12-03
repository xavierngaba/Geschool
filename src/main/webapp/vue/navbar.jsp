<%-- 
    Document   : navbar
    Created on : 20 juil. 2017, 22:06:43
    Author     : ines gnaly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <a href="<c:url value="/AutoServlet?action=listeleve&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                            <span>Liste des élèves</span>
                            <span class="pull-right-container">
                                <span class="label label-primary pull-right"><c:out value="${nblisteleve}"/></span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/AutoServlet?action=listinscription&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                            <span>Liste des inscriptions</span>
                            <span class="pull-right-container">
                                <span class="label label-primary pull-right"><c:out value="${nblistinscrit}"/></span>
                            </span>
                        </a>
                    </li>
                    <li><a href="<c:url value="/AutoServlet?action=ajouteleve&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-user-plus"></i> Nouv. Eleve</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="glyphicon glyphicon-education"></i>
                    <span>Paiement</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="<c:url value="/AutoServlet?action=listefacture&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i> Liste Paiement</a></li>
                    <li><a href="<c:url value="/AutoServlet?action=ajoutfacture&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-plus-square"></i> Nouv. Paiement</a></li>
                    <li><a href="<c:url value="/AutoServlet?action=ajoutinscription&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-plus-square"></i> Nouv. Inscription</a></li>
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
                                <span class="label label-primary pull-right"><c:out value="${nblistclasse}"/></span>
                            </span>
                        </a>
                    </li>
                    <li><a href="<c:url value="/AutoServlet?action=ajoutclasse&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-plus-square"></i> Nouv. Classes</a></li>
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
                    <span>Professeur</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    
                    <li>
                    <li><a href="<c:url value="/AutoServlet?action=listeprofesseur&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                            <span>Liste des Professeurs</span>
                            <span class="pull-right-container">
                                 <span class="label label-primary pull-right"><c:out value="${nblistprofesseur}"/></span>
                            </span>
                        </a>
                    </li>
                    <li><a href="<c:url value="/AutoServlet?action=ajoutprofesseur&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>">
                        <i class="fa fa-user-plus"></i> Nouv. Professeur</a></li>
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
                        <a href="<c:url value="/AutoServlet?action=listematiere&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-table"></i>
                            <span>Liste des Mati&egrave;res</span>
                            <span class="pull-right-container">
                                <span class="label label-primary pull-right"><c:out value="${nblistmatiere}"/></span>
                            </span>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/AutoServlet?action=ajoutmatiere&session=${sessionScope.sessionUtilisateur.idUtilisateur}"/>"><i class="fa fa-plus-square"></i>Nouv. Mati&egrave;re</a></li>
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
                    <li><a href="#"><i class="fa fa-plus-square"></i> Nouv. Note</a></li>
                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
