<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Ajouter une ressource</h2>
  <form action="/biblio/Test" method="post">
    <div class="form-group">
      <label for="titre">Titre:</label>
      <input type="text" class="form-control" name="titre" id="titre" placeholder="titre de la ressource">
    </div>
    <div class="form-group">
      <label for="dateE">Date d'édition:</label>
      <input type="date" class="form-control" name="dateE" id="dateE">
    </div>
    <div class="form-group">
      <label for="url">URL:</label>
      <input type="text" class="form-control" name="url" id="url" placeholder="URL de la ressource">
    </div>
    <div class="form-group">
      <label for="typeR">Type de ressource:</label>
      <input type="text" class="form-control" name="typeR" id="typeR" placeholder="Type de la ressource">
    </div>
    <div class="form-group">
      <label for="nomE">Editeur:</label>
      <input type="text" class="form-control" name="nomE" id="nomE" placeholder="Nom de l'editeur">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>