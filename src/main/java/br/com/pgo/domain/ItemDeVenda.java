package br.com.pgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class ItemDeVenda extends GenericDomain {

	@OneToOne
	@JoinColumn(nullable = false)
	private Venda venda;

	@OneToOne
	@JoinColumn(nullable = false)
	private Ua numeroUa;

	@Column(length = 50, nullable = false)
	private double demandaPontual;

	@Column(length = 50, nullable = false)
	private double garantiaVazao;

	public ItemDeVenda() {

	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Ua getNumeroUa() {
		return numeroUa;
	}

	public void setNumeroUa(Ua numeroUa) {
		this.numeroUa = numeroUa;
	}

	public double getDemandaPontual() {
		return demandaPontual;
	}

	public void setDemandaPontual(double demandaPontual) {
		this.demandaPontual = demandaPontual;
	}

	public double getGarantiaVazao() {
		return garantiaVazao;
	}

	public void setGarantiaVazao(double garantiaVazao) {
		this.garantiaVazao = garantiaVazao;
	}

}
