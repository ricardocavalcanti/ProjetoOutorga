package br.com.pgo.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date vencimento;

	@OneToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	@OneToOne
	@JoinColumn(nullable = false)
	private Outorgante outorgante;

	@Column(length = 50, nullable = false)
	private int numeroUa;

	@Column(length = 50, nullable = false)
	private int processoMotante;

	@Column(length = 50, nullable = false)
	private int processoJusante;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal areaUa;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal areaDrenagem;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal valorOutorgado;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal vazaoDisponivel;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal jan;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal fev;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal mar;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal abr;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal mai;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal jun;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal jul;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal ago;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal set;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal out;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal nov;

	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal dez;

	public Venda() {

	}

	public BigDecimal getVazaoDisponivel() {
		return vazaoDisponivel;
	}

	public void setVazaoDisponivel(BigDecimal vazaoDisponivel) {
		this.vazaoDisponivel = vazaoDisponivel;
	}

	public BigDecimal getValorOutorgado() {
		return valorOutorgado;
	}

	public void setValorOutorgado(BigDecimal valorOutorgado) {
		this.valorOutorgado = valorOutorgado;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public int getNumeroUa() {
		return numeroUa;
	}

	public void setNumeroUa(int numeroUa) {
		this.numeroUa = numeroUa;
	}

	public BigDecimal getAreaUa() {
		return areaUa;
	}

	public void setAreaUa(BigDecimal areaUa) {
		this.areaUa = areaUa;
	}

	public BigDecimal getAreaDrenagem() {
		return areaDrenagem;
	}

	public void setAreaDrenagem(BigDecimal areaDrenagem) {
		this.areaDrenagem = areaDrenagem;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getProcessoMotante() {
		return processoMotante;
	}

	public void setProcessoMotante(int processoMotante) {
		this.processoMotante = processoMotante;
	}

	public int getProcessoJusante() {
		return processoJusante;
	}

	public void setProcessoJusante(int processoJusante) {
		this.processoJusante = processoJusante;
	}

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

}