package br.com.pgo.bean;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Usuario;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {

	private Usuario usuario;
	private Usuario usuarioLogin;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(Usuario usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	@PostConstruct
	public void iniciar() {
		usuario = new Usuario();
	}

	/**
	 * Redirecionamento para a página principal usando o 'Ominifaces'
	 */
	public void autenticar() {

		try {

			UsuarioDAO usuDAO = new UsuarioDAO();
			usuarioLogin = usuDAO.autenticar(usuario.getLogin(), usuario.getSenha());

			if (usuarioLogin == null) {

				Messages.addGlobalError("'Login' ou 'Senha' incorretos, tente novamente");
				System.out.println(usuarioLogin);
				System.out.println(usuario.getLogin());
				System.out.println(usuario.getSenha());
				return;

			} else {

				Faces.redirect("./pages/principal.xhtml");

			}

		} catch (IOException e) {

			Messages.addGlobalError("Erro interno de autenticação");

			e.printStackTrace();
		}

	}

	/**
	 * Controle de permissões das paginas, onde o usuário pode ou não acessar
	 */
	public boolean temPermissoes(List<Character> permissoes) {
		
		
		System.out.println("Permissoes: " + permissoes);

		for (Character permissao : permissoes) {

			if (usuarioLogin.getTipo() == permissao) {
				return true;
			}

		}
		return false;
	}
	

}
