<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Emissão de Certificados do IFPE Campus Jaboatão</title>

<link rel="stylesheet" type="text/css" href="view/css/estilo.css" />
<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
  
<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

</head>

<body id="corpoPadrao">

	<c:import url="/view/comum/menu.jsp" />
	
	<div align="right" style="color: #6E6E6E; margin-right: 2%;">
		Bem vindo, ${usuarioLogado.nome}
	</div>

	<div align="center" style="color: #33A95B; font-size: 24px;">
		
		<br />
	
		<p>
			Sistema de Emissão de Certificados IFPE Campus Jaboatão 
		</p>
		
		<br />
		
		<p>
			<img src="view/img/logo-IFPE.png" style="width: 40%;">
		</p>
	</div>
	
	<p style="margin-top: 8%;">
	
	<hr class="linhaSeparador">
	
	<div class="textoRodape">
		<p><c:import url="/view/comum/textoRodape.jsp" /></p>
	</div>
	
</body>
</html>