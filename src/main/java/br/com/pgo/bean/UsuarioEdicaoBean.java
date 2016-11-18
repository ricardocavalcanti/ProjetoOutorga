package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Pessoa;
import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioEdicaoBean implements Serializable {

	private Long codigoUsuario;
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	private List<Pessoa> listaPessoa;
	private UsuarioDAO usuarioDAO;
	private PessoaDAO pessoaDAO;

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

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public List<Pessoa> getListaPessoa() {
		return listaPessoa;
	}

	public void setListaPessoa(List<Pessoa> listaPessoa) {
		this.listaPessoa = listaPessoa;
	}

	@PostConstruct
	public void iniciar() {

		usuarioDAO = new UsuarioDAO();
		pessoaDAO = new PessoaDAO();

	}

	public void carregarEdicao() {

		try {

			usuario = usuarioDAO.buscar(codigoUsuario);
			listaPessoa = pessoaDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao carregar edição do usuário");
			erro.printStackTrace();

		}

	}

	public void salvarEdicao() {

		try {

			usuarioDAO.merge(usuario);

			Messages.addGlobalInfo("Usuário editado com sucesso");

		} catch (RuntimeException erro) {

			Messages.addGlobalError("Erro ao editar usuário");
			erro.printStackTrace();

		}

	}

}
