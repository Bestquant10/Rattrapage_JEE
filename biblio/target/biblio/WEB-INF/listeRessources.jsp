<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Liste des ressources</title>
</head>
<body>
	<nav class="navbar navbar-default">  
	<div class="container-fluid">
		<div class="navbar-header">
			      <a class="navbar-brand" href="#">Bibliothèque</a>    
		</div>
	</div>
	</nav>

	<div class="col-md-10">
		<form>
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Recherchez par ISBN ...">
				<div class="input-group-btn">
					<button class="btn btn-default" type="submit">
						<i class="glyphicon glyphicon-search"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<div class="row">
		<div class="col-md-10">
			<table class="table">
				<thead>
					<tr>
						<th>Titre</th>
						<th>Auteurs</th>
						<th>Catégories</th>
						<th>Date d'édition</th>
						<th>URL</th>
						<th>Nom de l'éditeur</th>
						<th>Type de la ressource</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ressources }" var="item">
						<tr id="${item.id }">
							<td>${item.titre }</td>
							<td>
								<ul>
									<c:forEach items="${item.auteurs }" var="auteur">
										<li><span>${auteur.prenom}</span>>
										<span>${auteur.nom }</span></li>
									</c:forEach>
								</ul>
							</td>
							<td>
								<ul>
									<c:forEach items="${item.categories }" var="categorie">
										<li>${categorie.nom}</li>
									</c:forEach>
								</ul>
							</td>
							<td>${item.dateEdition }</td>
							<td>${item.url }</td>
							<td>${item.edition.nom }</td>
							<td>${item.typeRessource.nom }</td>
							<td>
								<button type="button">Modifier</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>