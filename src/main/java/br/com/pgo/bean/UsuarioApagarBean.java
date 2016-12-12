package br.com.pgo.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioApagarBean implements Serializable {

	private Long codigoUsuario;
	private UsuarioDAO usuarioDAO;
	private Usuario usuario;

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void iniciar() {

		usuarioDAO = new UsuarioDAO();
	}

	public void message() {

		addMessage("Usuário excluído com sucesso", null);
	}

	private void addMessage(String summary, String detail) {

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void buscarUsuario() {

		try {

			usuario = usuarioDAO.buscar(codigoUsuario);

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao buscar usuário");
		}

	}

	public void excluirUsuario() throws IOException {

		buscarUsuario();

		try {

			usuarioDAO.excluir(usuario);
			message();
			Faces.redirect("./pages/usuarioListagem.xhtml");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao excluir usuário");
			erro.printStackTrace();

		}
	}

}
