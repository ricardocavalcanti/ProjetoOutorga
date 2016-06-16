package br.com.pgo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Venda extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;
	@OneToOne
	@JoinColumn(nullable = false)
	private Outorgante outorgante;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Usuario usuario;

	public Venda() {

	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Outorgante getProcesso() {
		return outorgante;
	}

	public void setProcesso(Outorgante processo) {
		this.outorgante = processo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
