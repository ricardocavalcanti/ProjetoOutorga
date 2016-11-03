package br.com.pgo.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.pgo.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
   @PostConstruct
   public void iniciar(){
	   usuario = new Usuario();
   }
	
   /**
    * Redirecionamento para a página principal usando o 'Ominifaces'
    */
   public void autenticar(){
	   
	   try {
		   
		Faces.redirect("./pages/principal.xhtml");
		
	} catch (IOException e) {
		
        Messages.addGlobalError("Erro de autenticação"); 
        
		e.printStackTrace();
	}
	   
      }
	
}
