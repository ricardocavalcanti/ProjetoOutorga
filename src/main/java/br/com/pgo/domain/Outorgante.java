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
	private String cidade;

	@Column(length = 50, nullable = false)
	private String bairro;

	@Column(length = 50, nullable = false)
	private String complemento;

	@Column(length = 50, nullable = false)
	private String uf;

	@Column(length = 50, nullable = false)
	private String numero;

	@Column(length = 50, nullable = false)
	private int cep;

	@Column(length = 50, nullable = false)
	private int telefone;

	@Column(length = 50, nullable = false)
	private String email;

	@Column(length = 32, nullable = false)
	private char tipoRequerimento;

	@Column(length = 32, nullable = false)
	private String nomeTecnico;

	@Column(length = 50, nullable = false)
	private int registroTecnico;

	@Column(length = 50, nullable = false)
	private int telefoneTecnico;

	@Column(length = 50, nullable = false)
	private String emailTecnico;

	@Column(length = 50)
	private String outrasModalidades;

	@Column(nullable = false)
	private boolean captacao;

	@Column(nullable = false)
	private boolean diluicao;

	@Column(nullable = false)
	private boolean drdh;

	@Column(nullable = false)
	private boolean construcaoObra;

	@Column(nullable = false)
	private boolean irrigacao;

	@Column(nullable = false)
	private boolean abastecimentoInCom;

	@Column(nullable = false)
	private boolean dessentacaoAnimal;

	@Column(nullable = false)
	private boolean abastecimentoHum;

	@Column(nullable = false)
	private boolean aquiculturaCarcini;

	@Column(nullable = false)
	private char barragem;

	@Column(nullable = false)
	private boolean ponte;

	@Column(nullable = false)
	private boolean chartravessiaDutos;

	@Column(nullable = false)
	private boolean terraplanagem;

	@Column(nullable = false)
	private boolean geracaoEnergia;

	@Column(nullable = false)
	private boolean lancamentoEfluentes;

	@Column(nullable = false)
	private boolean extracaoMineral;

	@Column(nullable = false)
	private boolean obrasDrenagem;

	@Column(nullable = false)
	private boolean revestimentoCanal;

	@Column(nullable = false)
	private boolean dique;

	@Column(nullable = false)
	private boolean travessiaDutos;

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
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

	public String getOutrasModalidades() {
		return outrasModalidades;
	}

	public void setOutrasModalidades(String outrasModalidades) {
		this.outrasModalidades = outrasModalidades;
	}

	public boolean isCaptacao() {
		return captacao;
	}

	public void setCaptacao(boolean captacao) {
		this.captacao = captacao;
	}

	public boolean isDiluicao() {
		return diluicao;
	}

	public void setDiluicao(boolean diluicao) {
		this.diluicao = diluicao;
	}

	public boolean isDrdh() {
		return drdh;
	}

	public void setDrdh(boolean drdh) {
		this.drdh = drdh;
	}

	public boolean isConstrucaoObra() {
		return construcaoObra;
	}

	public void setConstrucaoObra(boolean construcaoObra) {
		this.construcaoObra = construcaoObra;
	}

	public boolean isIrrigacao() {
		return irrigacao;
	}

	public void setIrrigacao(boolean irrigacao) {
		this.irrigacao = irrigacao;
	}

	public boolean isAbastecimentoInCom() {
		return abastecimentoInCom;
	}

	public void setAbastecimentoInCom(boolean abastecimentoInCom) {
		this.abastecimentoInCom = abastecimentoInCom;
	}

	public boolean isDessentacaoAnimal() {
		return dessentacaoAnimal;
	}

	public void setDessentacaoAnimal(boolean dessentacaoAnimal) {
		this.dessentacaoAnimal = dessentacaoAnimal;
	}

	public boolean isAbastecimentoHum() {
		return abastecimentoHum;
	}

	public void setAbastecimentoHum(boolean abastecimentoHum) {
		this.abastecimentoHum = abastecimentoHum;
	}

	public boolean isAquiculturaCarcini() {
		return aquiculturaCarcini;
	}

	public void setAquiculturaCarcini(boolean aquiculturaCarcini) {
		this.aquiculturaCarcini = aquiculturaCarcini;
	}

	public char getBarragem() {
		return barragem;
	}

	public void setBarragem(char barragem) {
		this.barragem = barragem;
	}

	public boolean isPonte() {
		return ponte;
	}

	public void setPonte(boolean ponte) {
		this.ponte = ponte;
	}

	public boolean isChartravessiaDutos() {
		return chartravessiaDutos;
	}

	public void setChartravessiaDutos(boolean chartravessiaDutos) {
		this.chartravessiaDutos = chartravessiaDutos;
	}

	public boolean isTerraplanagem() {
		return terraplanagem;
	}

	public void setTerraplanagem(boolean terraplanagem) {
		this.terraplanagem = terraplanagem;
	}

	public boolean isGeracaoEnergia() {
		return geracaoEnergia;
	}

	public void setGeracaoEnergia(boolean geracaoEnergia) {
		this.geracaoEnergia = geracaoEnergia;
	}

	public boolean isLancamentoEfluentes() {
		return lancamentoEfluentes;
	}

	public void setLancamentoEfluentes(boolean lancamentoEfluentes) {
		this.lancamentoEfluentes = lancamentoEfluentes;
	}

	public boolean isExtracaoMineral() {
		return extracaoMineral;
	}

	public void setExtracaoMineral(boolean extracaoMineral) {
		this.extracaoMineral = extracaoMineral;
	}

	public boolean isObrasDrenagem() {
		return obrasDrenagem;
	}

	public void setObrasDrenagem(boolean obrasDrenagem) {
		this.obrasDrenagem = obrasDrenagem;
	}

	public boolean isRevestimentoCanal() {
		return revestimentoCanal;
	}

	public void setRevestimentoCanal(boolean revestimentoCanal) {
		this.revestimentoCanal = revestimentoCanal;
	}

	public boolean isDique() {
		return dique;
	}

	public void setDique(boolean dique) {
		this.dique = dique;
	}

	public boolean isTravessiaDutos() {
		return travessiaDutos;
	}

	public void setTravessiaDutos(boolean travessiaDutos) {
		this.travessiaDutos = travessiaDutos;
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