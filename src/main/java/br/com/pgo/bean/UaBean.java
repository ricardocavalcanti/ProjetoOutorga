package br.com.pgo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.domain.Ua;

@ManagedBean
@ViewScoped //Tempo de vida do objeto
public class UaBean {

	private Ua ua;

	public Ua getUa() {
		return ua;
	}

	public void setUa(Ua ua) {
		this.ua = ua;
	}
	
	public void novo(){
		
		ua = new Ua();
	}

	public void salvar() {

		Messages.addGlobalInfo(
				"Numero UA: " + ua.getNumeroUa() + "-" + "Ano UA: " + ua.getAno() + "-" 
		+ "JAN: " + ua.getJan());
	}

}
