package br.com.pgo.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.omnifaces.util.Faces;

import br.com.pgo.bean.AutenticacaoBean;
import br.com.pgo.domain.Usuario;

/**
 * 
 * 
 * @author ricardo Classe para o controle de acesso do usuário,
 * bloqueando acessos não autorizados
 */

@SuppressWarnings("serial")
public class AutenticacaoListener implements PhaseListener {

	// Saber se tem um usuário logado
	@Override
	public void afterPhase(PhaseEvent event) {

		String paginaAtual = Faces.getViewId();
		System.out.println("Página atual: " + paginaAtual);

		/**
		 * Verificarção se é uma página pública ou privada
		 */
		boolean paginaDeAutenticacao = paginaAtual.contains("autenticacao.xhtml");

		/**
		 * Se não for a página de autenticação que é pública
		 */
		if (!paginaDeAutenticacao) {
			/**
			 * Página privada preciso verificar se tenho usuário logado
			 */
			AutenticacaoBean autenticacaoBean = Faces.getSessionAttribute("autenticacaoBean");
			System.out.println("AutenticacaoBean: " + autenticacaoBean);
			/**
			 * Se meu usuário não autenticou na aplicação será null entao deverá
			 * ser redirecionado para a página de autenticação, caso tente
			 * acessar a primeira vez e não tenha o Bean criado
			 */
			if (autenticacaoBean == null) {

				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}
			/**
			 * Depois da primeira tentativa o Bean é criado ou seja não é null
			 * então devemos verificar se o usuário foi localizado no banco e
			 * deverá ser diferente de null
			 */
			Usuario usuario = autenticacaoBean.getUsuarioLogin();
			if (usuario == null) {
				Faces.navigate("/pages/autenticacao.xhtml");
				return;
			}

		}
	}

	// Antes de dar inicio
	@Override
	public void beforePhase(PhaseEvent event) {

	}

	// Quando for restaurar a pagina
	@Override
	public PhaseId getPhaseId() {

		return PhaseId.RESTORE_VIEW;
	}

}
