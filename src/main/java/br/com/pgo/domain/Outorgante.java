package br.com.pgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class Outorgante extends GenericDomain {

	@Column(length = 50, nullable = false)
	private int processoCprh;
	@Column(length = 50, nullable = false)
	private int processoApac;
	@Column(length = 50, nullable = false)
	private String nomeRazao;
	@Column(length = 50, nullable = false)
	private String cpfCnpj;
	@Column(length = 50, nullable = false)
	private String rua;
	@Column(length = 50, nullable = false)
	private String municipio;
	@Column(length = 50, nullable = false)
	private String bairro;
	@Column(length = 50, nullable = false)
	private int cep;
	@Column(length = 50, nullable = false)
	private int telefone;
	@Column(length = 50, nullable = false)
	private String email;
	@Column(length = 32, nullable = false)
	private char tipoRequerimento;
	@Column(length = 32, nullable = false)
	private String resposavelTecnico;
	@Column(length = 50, nullable = false)
	private int registroTecnico;
	@Column(length = 50, nullable = false)
	private int telefoneTecnico;
	@Column(length = 50, nullable = false)
	private String emailTecnico;
	@Column(length = 50, nullable = false)
	private char captacao;
	@Column(length = 50, nullable = false)
	private char diluicao;
	@Column(length = 50, nullable = false)
	private char drdh;
	@Column(length = 50, nullable = false)
	private char construçãoObra;
	@Column(length = 50, nullable = false)
	private char irrigacao;
	@Column(length = 50, nullable = false)
	private char abastecimentoInCom;
	@Column(length = 50, nullable = false)
	private char dessentacaoAnimal;
	@Column(length = 50, nullable = false)
	private char abastecimentoHum;
	@Column(length = 50, nullable = false)
	private char aquiculturaCarcini;
	@Column(length = 32, nullable = false)
	private char barragem;
	@Column(length = 50, nullable = false)
	private char ponte;
	@Column(length = 50, nullable = false)
	private char chartravessiaDutos;
	@Column(length = 50, nullable = false)
	private char terraplanagem;
	@Column(length = 50, nullable = false)
	private char geracaoEnergia;
	@Column(length = 50, nullable = false)
	private char lancamentoEfluentes;
	@Column(length = 50, nullable = false)
	private char extracaoMineral;
	@Column(length = 50, nullable = false)
	private char obrasDrenagem;
	@Column(length = 50, nullable = false)
	private char revestimentoCanal;
	@Column(length = 50, nullable = false)
	private char dique;
	@Column(length = 50, nullable = false)
	private char travessiaDutos;
	@Column(length = 50, nullable = false)
	private char outrasModalidades;

	public Outorgante() {

	}

	public int getProcessoCprh() {
		return processoCprh;
	}

	public void setProcessoCprh(int processoCprh) {
		this.processoCprh = processoCprh;
	}

	public int getProcessoApac() {
		return processoApac;
	}

	public void setProcessoApac(int processoApac) {
		this.processoApac = processoApac;
	}

	public String getNomeRazao() {
		return nomeRazao;
	}

	public void setNomeRazao(String nomeRazao) {
		this.nomeRazao = nomeRazao;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getTipoRequerimento() {
		return tipoRequerimento;
	}

	public void setTipoRequerimento(char tipoRequerimento) {
		this.tipoRequerimento = tipoRequerimento;
	}

	public String getResposavelTecnico() {
		return resposavelTecnico;
	}

	public void setResposavelTecnico(String resposavelTecnico) {
		this.resposavelTecnico = resposavelTecnico;
	}

	public int getRegistroTecnico() {
		return registroTecnico;
	}

	public void setRegistroTecnico(int registroTecnico) {
		this.registroTecnico = registroTecnico;
	}

	public int getTelefoneTecnico() {
		return telefoneTecnico;
	}

	public void setTelefoneTecnico(int telefoneTecnico) {
		this.telefoneTecnico = telefoneTecnico;
	}

	public String getEmailTecnico() {
		return emailTecnico;
	}

	public void setEmailTecnico(String emailTecnico) {
		this.emailTecnico = emailTecnico;
	}

	public char getCaptacao() {
		return captacao;
	}

	public void setCaptacao(char captacao) {
		this.captacao = captacao;
	}

	public char getDiluicao() {
		return diluicao;
	}

	public void setDiluicao(char diluicao) {
		this.diluicao = diluicao;
	}

	public char getDrdh() {
		return drdh;
	}

	public void setDrdh(char drdh) {
		this.drdh = drdh;
	}

	public char getConstruçãoObra() {
		return construçãoObra;
	}

	public void setConstruçãoObra(char construçãoObra) {
		this.construçãoObra = construçãoObra;
	}

	public char getIrrigacao() {
		return irrigacao;
	}

	public void setIrrigacao(char irrigacao) {
		this.irrigacao = irrigacao;
	}

	public char getAbastecimentoInCom() {
		return abastecimentoInCom;
	}

	public void setAbastecimentoInCom(char abastecimentoInCom) {
		this.abastecimentoInCom = abastecimentoInCom;
	}

	public char getDessentacaoAnimal() {
		return dessentacaoAnimal;
	}

	public void setDessentacaoAnimal(char dessentacaoAnimal) {
		this.dessentacaoAnimal = dessentacaoAnimal;
	}

	public char getAbastecimentoHum() {
		return abastecimentoHum;
	}

	public void setAbastecimentoHum(char abastecimentoHum) {
		this.abastecimentoHum = abastecimentoHum;
	}

	public char getAquiculturaCarcini() {
		return aquiculturaCarcini;
	}

	public void setAquiculturaCarcini(char aquiculturaCarcini) {
		this.aquiculturaCarcini = aquiculturaCarcini;
	}

	public char getBarragem() {
		return barragem;
	}

	public void setBarragem(char barragem) {
		this.barragem = barragem;
	}

	public char getPonte() {
		return ponte;
	}

	public void setPonte(char ponte) {
		this.ponte = ponte;
	}

	public char getChartravessiaDutos() {
		return chartravessiaDutos;
	}

	public void setChartravessiaDutos(char chartravessiaDutos) {
		this.chartravessiaDutos = chartravessiaDutos;
	}

	public char getTerraplanagem() {
		return terraplanagem;
	}

	public void setTerraplanagem(char terraplanagem) {
		this.terraplanagem = terraplanagem;
	}

	public char getGeracaoEnergia() {
		return geracaoEnergia;
	}

	public void setGeracaoEnergia(char geracaoEnergia) {
		this.geracaoEnergia = geracaoEnergia;
	}

	public char getLancamentoEfluentes() {
		return lancamentoEfluentes;
	}

	public void setLancamentoEfluentes(char lancamentoEfluentes) {
		this.lancamentoEfluentes = lancamentoEfluentes;
	}

	public char getExtracaoMineral() {
		return extracaoMineral;
	}

	public void setExtracaoMineral(char extracaoMineral) {
		this.extracaoMineral = extracaoMineral;
	}

	public char getObrasDrenagem() {
		return obrasDrenagem;
	}

	public void setObrasDrenagem(char obrasDrenagem) {
		this.obrasDrenagem = obrasDrenagem;
	}

	public char getRevestimentoCanal() {
		return revestimentoCanal;
	}

	public void setRevestimentoCanal(char revestimentoCanal) {
		this.revestimentoCanal = revestimentoCanal;
	}

	public char getDique() {
		return dique;
	}

	public void setDique(char dique) {
		this.dique = dique;
	}

	public char getTravessiaDutos() {
		return travessiaDutos;
	}

	public void setTravessiaDutos(char travessiaDutos) {
		this.travessiaDutos = travessiaDutos;
	}

	public char getoutrasModalidades() {
		return outrasModalidades;
	}

	public void setoutrasModalidades(char outrasModalidades) {
		this.outrasModalidades = outrasModalidades;
	}

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

	@Transient
	public String getTipoFormatadoBarragem() {
		String tipoFormatado = null;

		if (tipoRequerimento == '1') {
			tipoFormatado = "Maior500";
		} else if (tipoRequerimento == '2') {
			tipoFormatado = "Menor500";
		}
		return tipoFormatado;
	}

}