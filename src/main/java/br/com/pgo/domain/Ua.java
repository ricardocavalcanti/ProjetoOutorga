package br.com.pgo.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Ua extends GenericDomain {

	@Column(length = 50, nullable = false)
	private int numeroUa;

	@Column(length = 50, nullable = false)
	private int ano;

	// precision, informa total de numero usados
	// scale, informa total de digitos depois da virgula
	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal jan;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal fev;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal mar;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal abr;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal mai;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal jun;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal jul;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal ago;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal set;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal out;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal nov;

	@Column(nullable = false, precision = 5, scale = 3)
	private BigDecimal dez;

	public Ua() {

	}

	public int getNumeroUa() {
		return numeroUa;
	}

	public void setNumeroUa(int numeroUa) {
		this.numeroUa = numeroUa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public BigDecimal getJan() {
		return jan;
	}

	public void setJan(BigDecimal jan) {
		this.jan = jan;
	}

	public BigDecimal getFev() {
		return fev;
	}

	public void setFev(BigDecimal fev) {
		this.fev = fev;
	}

	public BigDecimal getMar() {
		return mar;
	}

	public void setMar(BigDecimal mar) {
		this.mar = mar;
	}

	public BigDecimal getAbr() {
		return abr;
	}

	public void setAbr(BigDecimal abr) {
		this.abr = abr;
	}

	public BigDecimal getMai() {
		return mai;
	}

	public void setMai(BigDecimal mai) {
		this.mai = mai;
	}

	public BigDecimal getJun() {
		return jun;
	}

	public void setJun(BigDecimal jun) {
		this.jun = jun;
	}

	public BigDecimal getJul() {
		return jul;
	}

	public void setJul(BigDecimal jul) {
		this.jul = jul;
	}

	public BigDecimal getAgo() {
		return ago;
	}

	public void setAgo(BigDecimal ago) {
		this.ago = ago;
	}

	public BigDecimal getSet() {
		return set;
	}

	public void setSet(BigDecimal set) {
		this.set = set;
	}

	public BigDecimal getOut() {
		return out;
	}

	public void setOut(BigDecimal out) {
		this.out = out;
	}

	public BigDecimal getNov() {
		return nov;
	}

	public void setNov(BigDecimal nov) {
		this.nov = nov;
	}

	public BigDecimal getDez() {
		return dez;
	}

	public void setDez(BigDecimal dez) {
		this.dez = dez;
	}

	
}
