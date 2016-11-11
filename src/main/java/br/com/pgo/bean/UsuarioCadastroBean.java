package br.com.pgo.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.UsuarioDAO;

import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioCadastroBean implements Serializable {

	private Usuario usuario;
	private UsuarioDAO usuarioDAO;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void iniciar() {

		usuarioDAO = new UsuarioDAO();
		usuario = new Usuario();
	}

	public void salvar() {

		try {

			usuarioDAO.merge(usuario);

			Messages.addFlashGlobalInfo("Usuário salvo com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalInfo("Erro ao salvar usuário!");
			erro.printStackTrace();
		}

	}

}
