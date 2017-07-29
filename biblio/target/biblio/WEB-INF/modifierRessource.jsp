<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Modifier la ressource</title>
</head>
<body>
	<h2>Modifier la ressource</h2>
	<div class="col-md-7">
		<form action="/biblio/ModifierRessource" method="post">
			<input type="hidden" name="id" value="${ressource.id}"/>
			<div class="form-group">
				<label for="titre">Titre:</label> <input type="text"
					class="form-control" name="titre" id="titre"
					value="${ressource.titre }">
			</div>
			<div class="form-group">
				<label for="dateE">Date d'édition:</label> <input type="date"
					class="form-control" name="dateE" id="dateE"
					value="${ressource.dateEdition }">
			</div>
			<div class="form-group">
				<label for="url">URL:</label> <input type="text"
					class="form-control" name="url" id="url" value="${ressource.url }">
			</div>
			<div class="form-group">
				<label for="typeR">Type de ressource:</label> <input type="text"
					class="form-control" name="typeR" id="typeR"
					value="${ressource.typeRessource.nom }">
			</div>


			<div class="form-group">
				<label for="nomE">Editeur:</label> <input type="text"
					class="form-control" name="nomE" id="nomE"
					value="${ressource.edition.nom }">
			</div>
			<button id="newLine" type="button" class="btn btn-default">Ajouter
				auteur</button>
			<button id="deleteLine" type="button" class="btn btn-default">Supprimer
				auteur</button>
			<input id="nbr_auteur" type="hidden" name="nbr"></input>
			<table class="table">
				<thead>
					<tr>
						<th class="col-md-2">Nom de l'auteur</th>
						<th class="col-md-2">Prénom de l'auteur</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="count" value="0" scope="page" />
					<c:forEach items="${ressource.auteurs }" var="item">
						<tr>
							<td class="col-md-2"><input class="form-control" type="text"
								name="auteurs[${count}].nom" value="${item.prenom }" /></td>
							<td class="col-md-2"><input class="form-control" type="text"
								name="auteurs[${count}].prenom" value="${item.nom }"/></td>
						</tr>
						<c:set var="count" value="${count + 1}" scope="page" />
					</c:forEach>
				</tbody>
			</table>
			<button type="submit" class="btn btn-default">Enregistrer</button>
		</form>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var index = 0;

							$("#newLine")
									.click(
											function() {
												var line = $("tbody")
														.children().first();
												var newLine = line.clone();
												index++;
												$("#nbr_auteur").val(index + 1);
												newLine
														.children()
														.each(
																function() {
																	switch ($(
																			this)
																			.index()) {
																	case 0:
																		$(this)
																				.children()
																				.first()
																				.attr(
																						{
																							"name" : "auteurs["
																									+ index
																									+ "].nom",
																							class : "form-control col-md-2"
																						});
																		break;
																	case 1:
																		$(this)
																				.children()
																				.first()
																				.attr(
																						"name",
																						"auteurs["
																								+ index
																								+ "].prenom");
																		break;
																	}

																});

												$("tbody").append(newLine);
											});

							$("#deleteLine").click(function() {
								if (index > 0) {
									$("tbody").children().last().remove();
									index--;
								}
							});
						});
	</script>
</body>
</html>