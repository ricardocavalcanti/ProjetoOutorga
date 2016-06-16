package br.com.pgo.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

@ManagedBean
public class UaBean {

	public void salvar() {

		Messages.addGlobalInfo("Programação Java!");

	}

}
