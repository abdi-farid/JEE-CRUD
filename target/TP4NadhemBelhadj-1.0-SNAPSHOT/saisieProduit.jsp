<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Saisie produit</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
    <div class="card">
        <div class="card-header">
            Saisie des produits
        </div>
        <div class="card-body">
            <form action="save.do" method="post">
                <table>
                    <tr hidden>
                        <td>
                            <label>
                                <input type="text" name="action" value="save" class="form-control">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td><label class="custom-control-label">Nom produit </label></td>
                            <td>
                                <label>
                                    <input type="text" name="nomProduit" class="form-control">
                                </label>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form-group">
                            <td><label class="custom-control-label">Prix </label></td>
                            <td>
                                <label>
                                    <input type="text" name="prixProduit" class="form-control">
                                </label>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" class="btn btn-primary" value="Ajouter"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
