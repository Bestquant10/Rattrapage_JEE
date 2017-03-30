<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<title>Authentification</title>
</head>

<body class="my_background">

	<nav class="navbar navbar-default">
		 
		<div class="container-fluid">
			<div class="navbar-header">
				      <a class="navbar-brand" href="#">Bibliothèque</a>    
			</div>
		</div>
	</nav>

	<div id="login-overlay" class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Authentification</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-6">
						<div class="well">
							<form id="loginForm" method="POST" action="/login/"
								novalidate="novalidate">
								<div class="form-group">
									<label for="username" class="control-label">Email</label> <input
										type="text" class="form-control" id="username" name="username"
										value="" required="" title="Please enter you username"
										placeholder="example@gmail.com"> <span
										class="help-block"></span>
								</div>
								<div class="form-group">
									<label for="password" class="control-label">Mot de
										passe</label> <input type="password" class="form-control"
										id="password" name="password" value="" required=""
										title="Please enter your password"> <span
										class="help-block"></span>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" name="remember"
										id="remember"> Se souvenir de moi
									</label>
								</div>
								<button type="submit" class="btn btn-success btn-block">Se
									connecter</button>
								<a href="/biblio/Inscription" class="btn btn-default btn-block">Inscription</a>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>