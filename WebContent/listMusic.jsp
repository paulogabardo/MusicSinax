<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
	<head>
		<title>Listar Música</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script>
    	function ListCtrl($scope, $http) {
    	    $http.get('http://localhost:8080/MusicSinax/rest/music/listar').
    	        success(function(data) {        	
    	            $scope.musicas = data.music;
    	        });
    	}
    	</script>
	</head>

	<body>
	<br/>
<br/>
<br/>
<table align="center" >
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/addMusic.jsp"><font face="Arial">Adicionar Música </font></a></td>
	</tr>
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/findMusic.jsp"><font face="Arial">Procurar Música</font></a></td>
	</tr>	
</table>
<br/>
<br/>
	<div ng-controller="ListCtrl">
		<ul ng-repeat="musica in musicas">
	        <li >{{musica.banda.nome}} - {{musica.nome}} - {{musica.duracao}}</li>	
	    </ul>
	</div>
	</body>
</html>