package br.com.ifpe.certificados.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Evento {

    private int id;

    @NotEmpty(message = "O ano deve ser preenchido")
    @Size(min = 4, max = 4, message = "O ano deve deve ter um tamanho de 4 caracteres")
    private String ano;

    @NotEmpty(message = "A descrição deve ser preenchida")
    @Size(max = 100, message = "A descrição deve ter um tamanho máximo de 100 caracteres")
    private String descricao;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getAno() {
	return ano;
    }

    public void setAno(String ano) {
	this.ano = ano;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

}
