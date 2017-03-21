<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Ajouter une ressource</h2>


	<form action="/biblio/Test" method="post">

		<div class="col-md-7">

			<div class="form-group">
				<label for="titre">Titre:</label> <input type="text"
					class="form-control" name="titre" id="titre"
					placeholder="titre de la ressource">
			</div>
			<div class="form-group">
				<label for="dateE">Date d'édition:</label> <input type="date"
					class="form-control" name="dateE" id="dateE">
			</div>
			<div class="form-group">
				<label for="url">URL:</label> <input type="text"
					class="form-control" name="url" id="url"
					placeholder="URL de la ressource">
			</div>
			<div class="form-group">
				<label for="typeR">Type de ressource:</label> <input type="text"
					class="form-control" name="typeR" id="typeR"
					placeholder="Type de la ressource">
			</div>


			<div class="form-group">
				<label for="nomE">Editeur:</label> <input type="text"
					class="form-control" name="nomE" id="nomE"
					placeholder="Nom de l'editeur">
			</div>
			<button id="newLine" type="button" class="btn btn-default">Ajouter auteur</button>
			<button id="deleteLine" type="button" class="btn btn-default">Supprimer auteur</button>
			<input id="nbr_auteur" type="hidden" name="nbr"></input>
			<table class="table">

				<thead>
					<tr>
						<th class="col-md-2">Nom de l'auteur</th>
						<th class="col-md-2">Prénom de l'auteur</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="col-md-2"><input class="form-control" type="text"
							name="auteurs[0].nom" /></td>
						<td class="col-md-2"><input class="form-control" type="text"
							name="auteurs[0].prenom" /></td>
					</tr>
				</tbody>
			</table>

			<button type="submit" class="btn btn-default">Submit</button>
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			var index = 0;
	
		    $("#newLine").click(function () {
		        var line = $("tbody").children().first();
		        var newLine = line.clone();
		        index++;
		        $("#nbr_auteur").val(index+1);
		        newLine.children().each(function () {
		            switch ($(this).index()) {
		                case 0: $(this).children().first().attr({ "name": "auteurs[" + index + "].nom", class: "form-control col-md-2" }); break;
		                case 1: $(this).children().first().attr("name", "auteurs[" + index + "].prenom"); break;
		            }

		        });

		        $("tbody").append(newLine);
		    });

		    $("#deleteLine").click(function () {
		        if (index > 0) {
		            $("tbody").children().last().remove();
		            index--;
		        }
		    });
		});
	</script>
</body>

</html>