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

	public int getProcesso() {
		return processo;
	}

	public void setProcesso(int processo) {
		this.processo = processo;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public double getDemandaPontual() {
		return demandaPontual;
	}

	public void setDemandaPontual(double demandaPontual) {
		this.demandaPontual = demandaPontual;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Ua getNumeroUa() {
		return numeroUa;
	}

	public void setNumeroUa(Ua numeroUa) {
		this.numeroUa = numeroUa;
	}

}
