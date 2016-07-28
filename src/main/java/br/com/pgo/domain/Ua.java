package br.com.pgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Ua extends GenericDomain  {

	
	@Column(length = 50, nullable = false)
	private int numeroUa;
	@Column(length = 50, nullable = false)
	private int ano;
	@Column(length = 50, nullable = false)
	private double jan;
	@Column(length = 50, nullable = false)
	private double fev;
	@Column(length = 50, nullable = false)
	private double mar;
	@Column(nullable = false, length = 50)
	private double abr;
	@Column(length = 50, nullable = false)
	private double mai;
	@Column(length = 50, nullable = false)
	private double jun;
	@Column(length = 50, nullable = false)
	private double jul;
	@Column(length = 50, nullable = false)
	private double ago;
	@Column(length = 50, nullable = false)
	private double set;
	@Column(length = 50, nullable = false)
	private double out;
	@Column(length = 50, nullable = false)
	private double nov;
	@Column(length = 50, nullable = false)
	private double dez;

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

	public double getJan() {
		return jan;
	}

	public void setJan(double jan) {
		this.jan = jan;
	}

	public double getFev() {
		return fev;
	}

	public void setFev(double fev) {
		this.fev = fev;
	}

	public double getMar() {
		return mar;
	}

	public void setMar(double mar) {
		this.mar = mar;
	}

	public double getAbr() {
		return abr;
	}

	public void setAbr(double abr) {
		this.abr = abr;
	}

	public double getMai() {
		return mai;
	}

	public void setMai(double mai) {
		this.mai = mai;
	}

	public double getJun() {
		return jun;
	}

	public void setJun(double jun) {
		this.jun = jun;
	}

	public double getJul() {
		return jul;
	}

	public void setJul(double jul) {
		this.jul = jul;
	}

	public double getAgo() {
		return ago;
	}

	public void setAgo(double ago) {
		this.ago = ago;
	}

	public double getSet() {
		return set;
	}

	public void setSet(double set) {
		this.set = set;
	}

	public double getOut() {
		return out;
	}

	public void setOut(double out) {
		this.out = out;
	}

	public double getNov() {
		return nov;
	}

	public void setNov(double nov) {
		this.nov = nov;
	}

	public double getDez() {
		return dez;
	}

	public void setDez(double dez) {
		this.dez = dez;
	}

}
