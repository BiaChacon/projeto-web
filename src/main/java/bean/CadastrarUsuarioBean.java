package bean;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "cadastro")
@SessionScoped
public class CadastrarUsuarioBean {
    
    private Usuario novoUsuario;
    IUsuarioDao ud = new UsuarioDaoImpl();
    
    public CadastrarUsuarioBean() {
        novoUsuario = new Usuario();
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }
  
    public String cadastrarUsuario(){
        
	FacesContext fc = FacesContext.getCurrentInstance();
        
        novoUsuario.setAdmin(Boolean.FALSE);
	ud.save(novoUsuario);
        
	FacesMessage mensagem = new FacesMessage("Cadastro efetuado com sucesso");
	mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
	fc.addMessage(null, mensagem);
        
        novoUsuario = new Usuario();
	return "/index.xhtml";
        
    }
    
    public String cancelarCadastro(){
	return "/index.xhtml";
    }
        
}
