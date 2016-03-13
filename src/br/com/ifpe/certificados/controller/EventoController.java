package br.com.ifpe.certificados.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.ifpe.certificados.model.Evento;
import br.com.ifpe.certificados.model.EventoDao;

@Controller
public class EventoController {

    @RequestMapping("/exibirIncluirEvento")
    public String exibirIncluirEvento() {

	return "evento/incluirEvento";
    }

    @RequestMapping("incluirEvento")
    public String incluirEvento(@Valid Evento evento, BindingResult result, Model model) {

	if (result.hasErrors()) {
	    return "forward:exibirIncluirEvento";
	}

	EventoDao dao = new EventoDao();
	dao.salvar(evento);
	model.addAttribute("msg", "O evento " + evento.getDescricao() + " foi inserido com sucesso !");

	return "forward:listarEvento";
    }

    @RequestMapping("/listarEvento")
    public String listarEvento(Model model) {

	EventoDao dao = new EventoDao();
	List<Evento> listaEvento = dao.listar();
	model.addAttribute("listaEvento", listaEvento);

	return "evento/pesquisarEvento";
    }

    @RequestMapping("/pesquisarEvento")
    public @ResponseBody String pesquisarEvento(@RequestParam String descricao, @RequestParam String ano, HttpServletResponse response) {

	EventoDao dao = new EventoDao();
	List<Evento> listaEvento = dao.pesquisar(descricao, ano);

	StringBuilder st = new StringBuilder();

	st.append("<tr>");
	st.append("<th style='width: 10%; vertical-align: middle; text-align: center;'>Ano</th>");
	st.append("<th style='width: 70%; vertical-align: middle;'>Descrição</th>");
	st.append("<th style='width: 20%; vertical-align: middle; text-align: center;'>Ações</th>");
	st.append("</tr>");

	for (Evento evento : listaEvento) {
	    st.append("<tr>");
	    st.append("<td style='vertical-align: middle; text-align: center;'>" + evento.getAno() + "</td>");
	    st.append("<td style='vertical-align: middle;'>" + evento.getDescricao() + "</td>");
	    st.append("<td style='vertical-align: middle; text-align: center;'>");
	    st.append("<a href='exibirAlterarEvento?id=" + evento.getId() + "' class='btn btn-warning' role='button'>E</a> &nbsp;");
	    st.append("<a href='removerEvento?id=" + evento.getId() + "' class='btn btn-danger' role='button'>R</a>");
	    st.append("</td>");
	    st.append("</tr>");
	}

	response.setStatus(200);
	return st.toString();
    }

    @RequestMapping("/carregarEventos")
    public @ResponseBody String carregarEventos(@RequestParam String anoSelecionado, HttpServletResponse response) {

	EventoDao dao = new EventoDao();
	List<Evento> listaEvento = dao.carregarEventos(anoSelecionado);

	StringBuilder st = new StringBuilder();
	st.append("<option value=''> Selecione </option>");

	for (Evento evento : listaEvento) {
	    st.append("<option value='" + evento.getDescricao() + "'> " + evento.getDescricao() + " </option>");
	}

	response.setStatus(200);
	return st.toString();
    }

    @RequestMapping("removerEvento")
    public String removerEvento(Evento evento, Model model) {

	EventoDao dao = new EventoDao();
	dao.remover(evento);
	model.addAttribute("msg", "Evento removido com sucesso !");

	return "forward:listarEvento";
    }

    @RequestMapping("exibirAlterarEvento")
    public String exibirAlterarEvento(Evento evento, Model model) {

	EventoDao dao = new EventoDao();
	Evento eventoPreenchido = dao.buscarPorId(evento.getId());
	model.addAttribute("evento", eventoPreenchido);

	return "evento/alterarEvento";
    }

    @RequestMapping("alterarEvento")
    public String alterarEvento(@Valid Evento evento, BindingResult result, Model model) {

	if (result.hasErrors()) {
	    return "evento/alterarEvento";
	}

	EventoDao dao = new EventoDao();
	dao.alterar(evento);
	model.addAttribute("msg", "Evento alterado com sucesso !");

	return "forward:listarEvento";
    }

}
