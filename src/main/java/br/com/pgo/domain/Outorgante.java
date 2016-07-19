package br.com.pgo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	
	
	
	
	
	
	
	

	@Column(length = 50, nullable = false)
	private double demandaPontual; /* mesma coisa de drenagem??? */

	@Column(length = 50, nullable = false)
	private int processo;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimento;

	@Column(nullable = false)
	private Boolean liberado;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Ua numeroUa;

	public Outorgante() {

	}

}	