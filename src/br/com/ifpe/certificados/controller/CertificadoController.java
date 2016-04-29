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
 * Essa classe é responsável para servir de Controller para o sistema de emissão dos certificados
 * @author Roberto Alencar
 */
@Controller
public class CertificadoController {

    @RequestMapping("/")
    public String exibirEmitirCertificado(Model model) {

	return "principal/emitirCertificado";
    }

    /**
     * Método responsável por emitir os certifiacados dos alunos.
     * 
     * @param ano
     * @param evento
     * @param nome
     * @param response
     * @param model
     * @return o nome da página que será exibida
     * @throws IOException
     */
    @RequestMapping("emitirCertificado")
    public String emitirCertificado(@RequestParam String ano, @RequestParam String evento, @RequestParam String nome,
	    HttpServletResponse response, Model model) throws IOException {

	String nomeComExtensao = nome + "0.pdf";

	//TODO: URL máquina local
	String localArquivos = "/home/roberto/Certificados/" + ano + "/" + evento + "/";
	
	//TODO: URL Servidor
//	String localArquivos = "/home/Certificados/" + ano + "/" + evento + "/";
	
	File diretorio = new File(localArquivos);
	File[] listaArquivos = diretorio.listFiles();
	boolean encontrou = false;

	for (File file : listaArquivos) {
	    if (nomeComExtensao.trim().toUpperCase().equals(file.getName().trim().toUpperCase())) {
		System.out.println(file.getName());
		disponibilizarArquivo(response, localArquivos + file.getName(), nome);
		encontrou = true;
	    }
	}

	if (!encontrou) {
	    model.addAttribute("msg",
		    "Não foi encontrato um certificado para o nome informado, verifique os dados e tente novamente.");
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
