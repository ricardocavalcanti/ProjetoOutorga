package br.com.pgo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

 /**	@OneToOne
	@JoinColumn(nullable = false)
	private Outorgante processo;

	@OneToOne
	@JoinColumn(nullable = false)
	private Ua numeroUa;

	@OneToOne
	@JoinColumn(nullable = false)
	private Outorgante demandaPontual;

	@OneToOne
	@JoinColumn(nullable = false)
	private Outorgante vencimento;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;  **/
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Ua numeroUa;

	public Venda() {

	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Ua getNumeroUa() {
		return numeroUa;
	}

	public void setNumeroUa(Ua numeroUa) {
		this.numeroUa = numeroUa;
	}

	

}