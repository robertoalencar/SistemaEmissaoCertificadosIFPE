<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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

	<div align="center">
	
		<div align="left" style="color: #6E6E6E; width: 70%; margin-top: 4%;">

			<c:if test="${msg ne null}">
				<div class="alert alert-error" style="width: 70%;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					${msg}
				</div>
			</c:if>

			<hr />
			
			<p>
				<table style="width: 100%">
					<tr>
						<td style="float: left; font-size: 24px;">Incluir <strong>Evento</strong> </td>
						<td style="float: right; text-align: right;"> <img src="view/img/salvar.jpg" style="width: 14%;">  </td>
					</tr>
				</table>
			</p>
			
			<hr />
			
			<form action="incluirEvento" method="post">
				
				<div class="form-group">
    				<label for="ano">Ano</label>
    				<input type="text" class="form-control" id="ano" name="ano" style="width: 100px;" maxlength="4" required="required" value="${evento.ano}"> &nbsp;
    				<form:errors path="evento.ano" cssStyle="color:red" /> <br />
  				</div>
  				
  				<div class="form-group">
					<label for="inputDescricao">Descrição</label>
					<input type="text" id="inputDescricao" class="form-control" name="descricao" style="width: 600px;" maxlength="100" required="required" value="${evento.descricao}" /> &nbsp;
					<form:errors path="evento.descricao" cssStyle="color:red" />
				</div>

				<br />
  				
  				<a href="listarEvento" class="btn btn-danger" role="button">Cancelar</a> &nbsp;
  				<button type="reset" class="btn btn-default"> &nbsp; Limpar &nbsp; </button> &nbsp;
  				<button type="submit" class="btn btn-primary"> &nbsp; Inserir &nbsp; </button>
  				
			</form>
		</div>
			
	</div>
	
	<br />
	
	<hr class="linhaSeparador">
	
	<div class="textoRodape">
		<p><c:import url="/view/comum/textoRodape.jsp" /></p>
	</div>

</body>
</html>
