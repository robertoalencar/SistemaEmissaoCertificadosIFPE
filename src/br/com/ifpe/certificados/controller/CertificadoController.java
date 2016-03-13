package br.com.ifpe.certificados.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ifpe.certificados.util.Util;

/**
 * @author Roberto Alencar
 *
 */
@Controller
public class CertificadoController {

    @RequestMapping("/")
    public String exibirEmitirCertificado(Model model) {

	return "principal/emitirCertificado";
    }

    @RequestMapping("emitirCertificado")
    public String emitirCertificado(@RequestParam String ano, @RequestParam String evento, @RequestParam String nome,
	    HttpServletResponse response) throws IOException {

	String nomeComExtensao = nome + "0.pdf";

	String localArquivos = System.getProperty("user.home") + "/Certificados/" + ano + "/" + evento + "/";
	File diretorio = new File(localArquivos);
	File[] listaArquivos = diretorio.listFiles();

	for (File file : listaArquivos) {
	    if (nomeComExtensao.trim().toUpperCase().equals(file.getName().trim().toUpperCase())) {
		System.out.println(file.getName());
		disponibilizarArquivo(response, localArquivos + file.getName(), nome);
	    }
	}

	return "principal/emitirCertificado";
    }

    private void disponibilizarArquivo(HttpServletResponse response, String arquivo, String name) throws IOException {

	byte[] pdf = Util.lerConteudoArquivoPDF(arquivo);

	response.setContentType("application/pdf");
	response.setHeader("Content-disposition", "attachment; filename=" + name);
	response.setContentLength(pdf.length);
	response.getOutputStream().write(pdf);
	response.getOutputStream().flush();
    }

}
