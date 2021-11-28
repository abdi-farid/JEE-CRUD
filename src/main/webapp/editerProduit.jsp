<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Editer produit</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
<p></p>
<div class="container">
    <c:if test="${!empty p}">
        <div class="card">
            <div class="card-header">
                Editer Produit
            </div>
            <div class="card-body">
                <form method="post" action="update.do">
                    <table>
                        <tr hidden>
                            <td>
                                <label>
                                    <input type="text" name="action" value="update" class="form-control">
                                </label>
                            </td>
                        </tr>
                        <tr hidden>
                            <td><label class="col-form-label">ID</label></td>
                            <td>
                                <label>
                                    <input type="text" class="input-group" name="id" value="${p.idProduit}">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-form-label">Nom produit</label></td>
                            <td>
                                <label>
                                    <input type="text" class="input-group" name="nomProduit" value="${p.nomProduit}">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><label class="col-form-label">Prix</label></td>
                            <td>
                                <label>
                                    <input type="text" class="input-group" name="prix" value="${p.prix}">
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="submit" class="btn btn-success" value="Update"></td>
                            <td><a href="chercher.do?mc=" class="btn btn-warning">Cancel</a></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>
