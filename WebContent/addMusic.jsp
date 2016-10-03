<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="cadastrarControllerApp">
	<head>
		<title>Listar Música</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script>
    	
    	var cadastrarControllerApp = angular.module("cadastrarControllerApp",[]);
    	 
    	cadastrarControllerApp.controller("cadastrarController",function($scope, $window, $http){
    	 
    		/*DEFININDO O MODELO PARA O NOSSO FORMULÁRIO*/
    		$scope.nome  = null;
    		$scope.banda = null;
    		$scope.duracao = null;
    		$scope.id = null;
    		$scope.idbanda = null;
    	 
    		$scope.cadastrar = function(){
    	 
    			/*DEFINI O OBJETO QUE VAI SER ENVIADO VIA AJAX PELO ANGULARJS*/
    			var banda = new Object();
    			banda.id = $scope.idbanda;
    			banda.nome = $scope.banda;
    			
    			var music =  new Object();
    			music.nome  = $scope.nome;
    			music.banda = banda;
    			music.duracao = $scope.duracao;		
    			music.id = $scope.id;
    			
    			if(music.nome == null || banda.nome == null || music.duracao == null){
    				$window.alert('Preencher todos os campos!');
    			}else{
    	 
	    			/*EXECUTA O POST PARA SALVAR O REGISTRO*/
	    			var response = $http.post("http://localhost:8080/MusicSinax/rest/music", music);
	    	 
	    			response.success(function(data) {
	    				$scope.nome  = null;
	    	    		$scope.banda = null;
	    	    		$scope.duracao = null;
	    	    		
	    				$window.alert(data);
	    			 
	    		    });
    			}
    		};
    	 
    	});
    	
    	</script>
	</head>

	<body>
	
    <form ng-controller="cadastrarController">
	<table align="left" >
			<tr>
				<td align="right"><font face="Arial">Banda</font></td><td><input type="text" ng-model="banda"></td>
			</tr>
			<tr>
				<td align="right"><font face="Arial">Nome música</font></td><td><input type="text" ng-model="nome"></td>
			</tr>
			<tr>
				<td align="right"><font face="Arial">Duração(ex:00:02:45)</font></td><td><input type="text" ng-model="duracao" id="duracao"></td>
			</tr>		
	</table>
	<input type="button" value="Cadastrar" ng-click="cadastrar()"/>
	</form>
	
	<br/>
<br/>
<br/>
<table align="center" >
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/listMusic.jsp"><font face="Arial">Listar Música</font></a></td>
	</tr>
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/findMusic.jsp"><font face="Arial">Procurar Música</font></a></td>
	</tr>	
</table>
</html>