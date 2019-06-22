package bean;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

@ManagedBean
@SessionScoped
public class CadastraUsuarioBean {
    
    private Usuario novoUsuario;
    
    public CadastraUsuarioBean() {
        novoUsuario = new Usuario();
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

        
    public String cadastrar(){
        
        IUsuarioDao ud = new UsuarioDaoImpl();
        
	FacesContext fc = FacesContext.getCurrentInstance();
        
	ud.save(novoUsuario);
        
	FacesMessage mensagem = new FacesMessage("Cadastro efetuado com sucesso");
	mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
	fc.addMessage(null, mensagem);
        
        novoUsuario = new Usuario();
	return "/index.xhtml";
        
    }
        
    public String cancelar(){
	return "/index.xhtml";
    }
        

}
