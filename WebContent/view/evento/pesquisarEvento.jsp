<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Sistema de Emissão de Certificados do IFPE Campus Jaboatão</title>

<link rel="stylesheet" type="text/css" href="view/css/estilo.css" />
<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
  
<script type="text/javascript" src="view/js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">

	$(document).ready(function() {
	
		$("#descricao").keyup(function() {
			
			var descricao = $('#descricao').val();
			var ano = $('#ano').val();
			
			$.post("pesquisarEvento", {'descricao' : descricao, 'ano' : ano}, function(dados) {
				$('#tabelaListaEvento').html(dados);
		  	});
		});
	
		
		$("#ano").change(function() {
			
			var descricao = $('#descricao').val();
			var ano = $('#ano').val();
			
			$.post("pesquisarEvento", {'descricao' : descricao, 'ano' : ano}, function(dados) {
				$('#tabelaListaEvento').html(dados);
		  	});
		});
	});

</script>

</head>

<body id="corpoPadrao">

	<c:import url="/view/comum/menu.jsp" />

	<div align="center">
	
		<div align="left" style="color: #6E6E6E; width: 70%;">
		
			<c:if test="${msg ne null}">
				<div class="alert alert-success" style="width: 100%;">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					${msg}
				</div>
			</c:if>
			
			<div class="panel-group">
  				<div class="panel panel-default">
    				<div class="panel-heading">
      					<h4 class="panel-title">
        					<a data-toggle="collapse" href="#collapse1">Clique <strong>aqui</strong> para exibir os campos de pesquisa de <strong>Evento</strong></a>
      					</h4>
    				</div>
    				<div id="collapse1" class="panel-collapse collapse">
      					<div class="panel-body">
      						<div class="form-group" style="text-align: left;">
								<label for="descricao">Descrição:</label>
				   				<input type="text" class="form-control" id="descricao" name="descricao" value="${descricao}">
				 			</div>
				
							<div class="form-group" style="text-align: left;">
				   				<label for="categoriaProduto">Ano:</label> <br />
				   				<select id="ano" name="ano" style="width:150px; height: 30px; font-size: 16px; border: 1px solid #BDC7D8; color: #000000; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px;">
									<option value=""> Selecione </option>
									<option value="2014"> 2014 </option>
				    				<option value="2015"> 2015 </option>
				    				<option value="2016"> 2016 </option>
								</select>
							</div>
      					</div>
    				</div>
  				</div>
			</div>
			
			<hr />
			
			<p>
				<table style="width: 100%">
					<tr>
						<td style="float: left; font-size: 24px;"> Listagem de <strong>Evento</strong> </td>
						<td style="float: right;"> <a href="exibirIncluirEvento" class="btn btn-primary" role="button">Novo</a> </td>
					</tr>
				</table>
			</p>
			
			<hr />
			
			<table class="table table-striped table-bordered" id="tabelaListaEvento">
				<thead>
					<tr>
						<th style="width: 10%; vertical-align: middle; text-align: center;">Ano</th>
						<th style="width: 70%; vertical-align: middle;">Descrição</th>
						<th style="width: 20%; vertical-align: middle; text-align: center;">Ações</th>
					</tr>
				</thead>
				<c:forEach items="${listaEvento}" var="obj">
					<tr>
						<td style="vertical-align: middle; text-align: center;">${obj.ano}</td>
						<td style="vertical-align: middle;">${obj.descricao}</td>
						<td style="vertical-align: middle; text-align: center;">
							<a href="exibirAlterarEvento?id=${obj.id}" class="btn btn-warning" role="button">E</a> &nbsp;
							<a href="removerEvento?id=${obj.id}" class="btn btn-danger" role="button">R</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
			
	</div>
	
	<br />
	
	<hr class="linhaSeparador">
	
	<div class="textoRodape">
		<p><c:import url="/view/comum/textoRodape.jsp" /></p>
	</div>

</body>
</html>
