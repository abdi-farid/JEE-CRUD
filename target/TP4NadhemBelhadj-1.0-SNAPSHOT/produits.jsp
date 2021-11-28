<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Produits</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Recherche de produits
            <c:if test="${!empty produit}">
                <div class="bg-info">
                    <p class="text-center">
                        Produit (${produit.idProduit} - ${produit.nomProduit} - ${produit.prix}) est supprimé !
                    </p>
                </div>
            </c:if>
        </div>
        <div class="card-body">
            <form action="chercher.do" method="get">
                <label>Mot clé</label>
                <label>
                    <input type="text" name="mc" value="${model.mc}" class="input-group" placeholder="Key word ...">
                </label>
                <input type="submit" value="Search" class="btn btn-primary">
            </form>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Nom produit</th>
                    <th>Prix</th>
                    <th colspan="2">Actions</th>
                </tr>
                <c:if test="${!empty model}">
                    <c:forEach items="${model.prods}" var="p">
                        <tr>
                            <td>${p.idProduit}</td>
                            <td>${p.nomProduit}</td>
                            <td>${p.prix}</td>
                            <td><a href="editer.do?id=${p.idProduit}" class="btn btn-warning">Editer</a></td>
                            <td><a onclick="return confirm('êtes-vous sûr de vouloir supprimer ?')" href="delete.do?id=${p.idProduit}" class="btn btn-danger">Supprimer</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>

        </div>
    </div>
</div>
</body>
</html>
