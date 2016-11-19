package br.com.pgo.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.pgo.dao.PessoaDAO;
import br.com.pgo.dao.UsuarioDAO;
import br.com.pgo.domain.Pessoa;
import br.com.pgo.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioCadastroBean implements Serializable {

	private Usuario usuario;
	private UsuarioDAO usuarioDAO;
	private PessoaDAO pessoaDAO;
	private List<Pessoa> listaPessoa;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		usuario = new Usuario();
	}

	public void carregarLista(){
		
		try{
			
			listaPessoa = pessoaDAO.listar();
			
		}catch (RuntimeException erro){
			
			Messages.addFlashGlobalInfo("Erro ao carregar lista de pessoas");
			erro.printStackTrace();
		}
		
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
