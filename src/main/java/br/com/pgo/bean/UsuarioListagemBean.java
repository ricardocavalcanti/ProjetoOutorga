package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioListagemBean implements Serializable {

	private List<Usuario> listaUsuario;
	private UsuarioDAO usuarioDAO;

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
	@PostConstruct
	public void iniciar() {

		usuarioDAO = new UsuarioDAO();

	}
	
	public void listar(){
		
		try{
			
			listaUsuario = usuarioDAO.listar();
			
		} catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao listar Usuário");
			erro.printStackTrace();
			
			
		}
		
		
	}

}
