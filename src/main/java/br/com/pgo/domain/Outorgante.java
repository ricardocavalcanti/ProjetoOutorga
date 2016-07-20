package br.com.pgo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Outorgante extends GenericDomain {
	
	private int processoCprh;
	private int processoApac;
	private String nomeRazao;
	private String cpfCnpj;
	private String rua;
	private String municipio;
	private String bairro;
	private int cep;
	private int telefone;
	private String email;
	@Column(length = 32, nullable = false)
	private char tipoRequerimento;
	private String resposavelTecnico;
	private int registroTecnico;
	private int telefoneTecnico;
	private String emailTecnico;
	
	
	
	@Transient
	public String getTipoFormatado() {
		String tipoFormatado = null;

		if (tipoRequerimento == 'O') {
			tipoFormatado = "Outorga";
		} else if (tipoRequerimento == 'R') {
			tipoFormatado = "Renovacao";
		} else if (tipoRequerimento == 'T') {
			tipoFormatado = "Transferencia";
		} else if (tipoRequerimento == 'A') {
		tipoFormatado = "Ateracao";
	    } else if (tipoRequerimento == 'N') {
	    tipoFormatado = "Outros";
        }
		return tipoFormatado;
	}
	
	
	
	

	

	public Outorgante() {

	}

}	