<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Supprimer type de ressource</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<h2>Supprimer une ressource</h2>

	<form action="/biblio/SupprimerTypeRessource" method="post">

		<div class="col-md-3">

			<div class="form-group">
				<label for="idRessource">Id de la ressource:</label> <input
					type="text" class="form-control" name="idRessource"
					id="idRessource" placeholder="id de la ressource">
			</div>
			<button type="submit" class="btn btn-default">Supprimer</button>
		</div>
	</form>
</body>
</html>