package br.com.pgo.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.OutorganteDAO;
import br.com.pgo.domain.Outorgante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class OutoganteEdicaoBean implements Serializable {

	private Long codigoOutorgante;
	private OutorganteDAO outorganteDAO;
	private Outorgante outorgante;

	public Long getCodigoOutorgante() {
		return codigoOutorgante;
	}

	public void setCodigoOutorgante(Long codigoOutorgante) {
		this.codigoOutorgante = codigoOutorgante;
	}

	public Outorgante getOutorgante() {
		return outorgante;
	}

	public void setOutorgante(Outorgante outorgante) {
		this.outorgante = outorgante;
	}

	@PostConstruct
	public void iniciar() {

		outorganteDAO = new OutorganteDAO();

	}

	public void carregarEdicao(){

		try {

			outorgante = outorganteDAO.buscar(codigoOutorgante);
			System.out.println(outorgante.getNomeRazao());

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao listar Processo !");
			erro.printStackTrace();
		}
	}
	
	public void salvarEdicao(){
		
		try{
		
		outorganteDAO.merge(outorgante);
		
		Messages.addGlobalInfo("Outorgante editado com sucesso");
		
		}catch (RuntimeException erro){
			
		Messages.addGlobalError("Erro ao editar Outorgante");
			
		}
		
	}

}
