<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="pesquisarControllerApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Procurar Música</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script>
    	var pesquisarControllerApp = angular.module("pesquisarControllerApp",[]);
    	 
    	pesquisarControllerApp.controller("pesquisarController",function($scope, $window, $http){
    	  
    		$scope.pesquisar = function(){
    	 
    			var response = $http.get('http://localhost:8080/MusicSinax/rest/music/' + nome.value);
    	        response.success(function(data) {
    	 			
    			 	 if(data == 'null'){
    			 		$scope.banda = '';
				 		$scope.nomeMusica = '';
				 		$scope.id = '';
				 		$scope.duracao = '';
    			 		$window.alert("Nenhuma música encontrada!");	 
    			 	 }else{	
    				 	$scope.bandas = data;
    				 	angular.forEach(data, function(value, key){
    				 		$window.alert('Banda: '+ value.banda.nome+'\n Música: '+ value.nome +'\n Duração: '+ value.duracao);
    				 		$scope.banda = value.banda.nome;
    				 		$scope.nomeMusica = value.nome;
    				 		$scope.id = value.id;
    				 		$scope.duracao = value.duracao;
    				 	});
    			 	 }
    			
    		    });
    	 
    		     
    	 
    		};
    	 
    	});
    	</script>
</head>
<body>
	<br/>
	<br/>
	<br/>
	<form ng-controller="pesquisarController">
		<table align="left" >
			
			<tr>
				<td align="right"><font face="Arial">Nome música</font></td>
				<td><input type="text" id="nome" name="nome" ></td>
				<td><img src="img/lupa.png" height="30" width="30" ng-click="pesquisar()"> </td>
			</tr>
				
		</table>
		<br><br><br>
		ID:<input type="text" ng-model="id" readonly="readonly" style="border:0;"><br>
		Nome:<input type="text" ng-model="nomeMusica" readonly="readonly" style="border:0;"><br>
		Banda:<input type="text" ng-model="banda" readonly="readonly" style="border:0;"><br>
		Duração:<input type="text" ng-model="duracao" readonly="readonly" style="border:0;"><br>
	</form>
	<br/>
<br/>
<br/>
<table align="center" >
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/addMusic.jsp"><font face="Arial">Adicionar Música </font></a></td>
	</tr>
	<tr>
		<td><a href="http://localhost:8080/MusicSinax/listMusic.jsp"><font face="Arial">Listar Música</font></a></td>
	</tr>

</table>
</body>
</html>