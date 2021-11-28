<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Confirmation</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp"%>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header bg-success">
            <!-- Option est une variable qui définit si c'est un ajout ou une MAJ -->
            Confirmation ${option} produit
        </div>
        <div class="card-body">
            <div class="form-group">
                <label class="custom-control-label">ID</label>
                <label>
                    <input type="text" name="idProduit" class="form-control" value="${produit.idProduit}">
                </label>

                <label class="custom-control-label">Nom produit</label>
                <label>
                    <input type="text" name="nomProduit" class="form-control" value="${produit.nomProduit}">
                </label>

                <label class="custom-control-label">Prix</label>
                <label>
                    <input type="text" name="prixProduit" class="form-control" value="${produit.prix}">
                </label>
                <span>
                    <a href="chercher.do?mc=" class="btn btn-link"> Produits </a>
                </span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
