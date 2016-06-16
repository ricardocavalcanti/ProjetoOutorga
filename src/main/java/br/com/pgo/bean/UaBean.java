package br.com.pgo.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class UaBean {

	public void salvar() {

		String texto = "Programação WEB com Java";
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, texto, texto);
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, message);

	}

}
