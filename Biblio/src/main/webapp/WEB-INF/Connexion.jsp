<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>LaCuillere.com | Connexion</title>

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
    <div class="card card-container">
        <h2>Biblio</h2>
        <h1>Connexion</h1>
        <img id="profile-img" class="profile-img-card" src="img/profile.jpg"/>
        <p id="profile-name" class="profile-name-card"></p>
        <% if( (Boolean) request.getAttribute("bad_credentials") != null) {
            out.print("<p style='color: white;'>Vos informations de connexion sont incorrectes. Merci de réessayer.</p>");
        } %>
        <form class="form-signin" action="connexion" method="post">
            <input type="email" id="inputEmail" class="form-control" name="email" placeholder="Addresse e-mail" required autofocus>
            <input type="password" id="inputPassword" class="form-control" placeholder="Mot de Passe" name="password" required>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Se connecter</button>
        </form><!-- /form -->
    </div><!-- /card-container -->
</div><!-- /container -->

<!-- Javascript imports -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
