<%@ page import="javafx.util.Pair" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Biblio | Inscription</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

    <link href="css/custom.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:300' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <div class="card card-container" style="margin-top: 25px;">
        <h2>Biblio</h2>
        <h1>Inscription</h1>
        <% if( (Boolean) request.getAttribute("bad_credentials") != null) {
            out.print("<p style='color: white;'>Vos informations de connexion sont incorrectes. Merci de réessayer.</p>");
        } %>
        <form class="form-signin" action="inscription" method="post">
            <fieldset>
                <legend>Mon compte</legend>
                <input type="text" id="prenom" name="prenom" required placeholder="Prénom*">
                <input type="text" id="nom" name="nom" required placeholder="Nom*">
                <input type="email" id="email" name="email" required placeholder="Email*">
                <input type="text" id="tel" name="tel" required placeholder="Téléphone*">
                <input type="password" id="password" name="password" required placeholder="Mot de passe (<%= request.getAttribute("password_min_length")%> caractères min.)*">
                <input type="password" id="password_repeat" name="password_repeat" required placeholder="Mot de passe (répéter)*">
            </fieldset>
       
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit" style="text-align: center; margin-top: 8px;">S'inscrire</button>
        </form><!-- /form -->
    </div><!-- /card-container -->
</div><!-- /container -->

<!-- Javascript imports -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
