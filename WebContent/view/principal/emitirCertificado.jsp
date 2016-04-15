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

<script type="text/javascript">

	$(document).ready(function() {
	
		$("#campoAno").change(function() {
			var campoAno = $('#campoAno').val();
			$.get("carregarEventos", {'anoSelecionado' : campoAno}, function(dados) {
				$('#campoEvento').html(dados);
		  	});
		});
	});

</script>

</head>

<body id="corpoPadrao">

	<div style="background-color: #33A95B; padding: 15px;">
		<img src="view/img/logo-reitoria.png">
	</div>

	<div align="center">
		<table style="width: 70%; color: #6E6E6E;">
			<tr>
				<td>
					<div style="margin-top: 2%;">
						Bem vindo ao sistema de <strong style="color: #FA5858;">Emissão de Certificados</strong> do <span style="color: #088A4B;">IFPE Campus Jaboatão</span>, informe os campos abaixo para emitir o seu certificado.
					</div>
					<hr />
					<c:if test="${msg ne null}">
						<div class="alert alert-error" style="width: 100%;">
							<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
							${msg}
						</div>
					</c:if>
					<form action="emitirCertificado">
						<div style="width: 100%;">
							<div style="float: left; width: 70%; font-size: 20px;">
								<div class="form-group">
									<label for="campoAno" style="color: #33A95B;">Ano de Realização do Evento/Curso:</label> <br />
									<select id="campoAno" name="ano" required="required" tabindex="1" style="width:100px; height: 30px; font-size: 16px; border: 1px solid #BDC7D8; color: #000000; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px;">
										<option value=""> Selecione </option>
										<option value="2014"> 2014 </option>
					    				<option value="2015"> 2015 </option>
					    				<option value="2016"> 2016 </option>
									</select>
								</div>
								<div class="form-group">
									<label for="campoEvento" style="color: #33A95B;">Evento/Curso:</label> <br />
									<select id="campoEvento" name="evento" required="required" tabindex="2" style="height: 30px; font-size: 16px; border: 1px solid #BDC7D8; color: #000000; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px;">
										<option value=""> Selecione </option>
									</select>
								</div>
								<div class="form-group">
									<label for="nome" style="color: #33A95B;">Nome Completo:</label>
									<input type="text" id="nome" class="form-control" name="nome" required="required" tabindex="3" style="width: 500px;" maxlength="100" />
								</div>
				    			<br/>
		  						<button type="submit" class="btn btn-primary" tabindex="4" style="width: 30%; height: 40px; font-size: 20px;"> &nbsp; Emitir Certificado &nbsp; </button>
							</div>
							<div style="float: right; width: 30%; text-align: right; vertical-align: top;">
								<img src="view/img/certificadoIFPE.png" style="width: 90%;">
							</div>
						</div>
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<br /> <br />
					<hr>
					<div class="textoRodape">
						<p><c:import url="/view/comum/textoRodape.jsp" /></p>
					</div>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>