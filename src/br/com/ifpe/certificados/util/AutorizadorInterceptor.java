package br.com.ifpe.certificados.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Roberto Alencar
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws Exception {

	String uri = request.getRequestURI();
	if (uri.contains("bootstrap") || uri.contains("css") || uri.contains("img") || uri.contains("js")
		|| uri.contains("carregarEventos") || uri.contains("emitirCertificado") || uri.endsWith("certificados/")
		|| uri.endsWith("entrar") || uri.endsWith("efetuarLogin")) {

	    return true;
	}

	if (request.getSession().getAttribute("usuarioLogado") != null) {

	    return true;
	}

	response.sendRedirect("/certificados/");
	return false;
    }
}
