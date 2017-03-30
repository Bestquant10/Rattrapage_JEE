<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
<meta name="Content-Language" content="fr" />
<meta name="Description" content="" />
<meta name="Keywords"
	content="Tutoriel Bootstrap avec une page d'inscriptionl" />
<meta name="Subject" content="" />
<meta name="Content-Type" content="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="style.css" />
<title>Inscription</title>
</head>

<body class="my_background">

	<nav class="navbar navbar-default">
		 
		<div class="container-fluid">
			<div class="navbar-header">
				      <a class="navbar-brand" href="#">Bibliothèque</a>    
			</div>
		</div>
	</nav>
	<div class="container">

		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<h1>
					Inscription <br /> <small> Merci de renseigner vos
						informations </small>
				</h1>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-3">
				<div class="form-group">
					<label for="Nom">Nom</label> <input type="text"
						class="form-control" id="nom" placeholder="Nom">
				</div>
			</div>
			<div class="col-md-offset-1 col-md-3">
				<div class="form-group">
					<label for="Prenom">Prénom</label> <input type="text"
						class="form-control" id="prenom" placeholder="Prénom">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-7">
				<div class="form-group">
					<label for="Email">Email</label> <input type="text"
						class="form-control" id="email" placeholder="Email">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-offset-2 col-md-3">
				<div class="form-group">
					<label for="Password">Mot de passe</label> <input type="password"
						class="form-control" id="password" placeholder="Mot de passe">
				</div>
			</div>
			<div class="col-md-offset-1 col-md-3">
				<div class="form-group">
					<label for="Vpassword">Vérification mot de passe</label> <input
						type="password" class="form-control" id="vpassword"
						placeholder="Vérification mot de passe">
				</div>
			</div>
		</div>

		<br />
		<div class="row">
			<div class="col-md-offset-5 col-md-1">
				<button type="button" class="btn btn-primary">S'inscrire</button>
			</div>
		</div>

	</div>
</body>
</html>
