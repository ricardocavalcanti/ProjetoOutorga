package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Pessoa;
import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;
	private List<Usuario> listaUsuario;
	private List<Pessoa> listaPessoa;

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

	public void novo() {

		try {

			usuario = new Usuario();
			PessoaDAO pessoaDAO = new PessoaDAO();
			listaPessoa = pessoaDAO.listar();
			

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao gerar pessoa!");
			erro.printStackTrace();
		}

	}

	public void salvar() {

		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.merge(usuario);
			usuario = new Usuario();
			listaUsuario = usuarioDAO.listar();

			PessoaDAO pessoaDAO = new PessoaDAO();
			listaPessoa = pessoaDAO.listar();

			Messages.addGlobalInfo("Usuário salvo com sucesso!");

		} catch (RuntimeException erro) {

			Messages.addGlobalInfo("Erro ao salvar usuário!");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {

		try {

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuario = usuarioDAO.listar();

		} catch (RuntimeException erro) {

			Messages.addFlashGlobalInfo("Erro ao lista usuário!");
			erro.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {

		try {
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			Messages.addGlobalInfo("Usuario: "+usuario.getLogin());
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuario);
			
			listaUsuario = usuarioDAO.listar();
			Messages.addGlobalInfo("Usuário excluido com sucesso!");
		

		} catch (RuntimeException erro) {
             
			Messages.addGlobalInfo("Erro ao excluir usuário!");
			erro.printStackTrace();
		}

	}
	
	public void editar (ActionEvent evento){
		
		try{
			
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			listaPessoa = pessoaDAO.listar();
			
			Messages.addGlobalInfo("Edição usário: "+usuario.getLogin());
			
		}catch (RuntimeException erro){
			
			Messages.addGlobalInfo("Erro ao editar Usuário!");
			erro.printStackTrace();
			
			
		}
	}
}
