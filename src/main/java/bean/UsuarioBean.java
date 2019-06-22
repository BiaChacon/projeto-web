package bean;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {
    
    private Usuario novoUsuario;
    List<Usuario> listaUsuario;
    IUsuarioDao ud = new UsuarioDaoImpl();
    
    public UsuarioBean() {
        novoUsuario = new Usuario();
    }

    public Usuario getNovoUsuario() {
        return novoUsuario;
    }

    public void setNovoUsuario(Usuario novoUsuario) {
        this.novoUsuario = novoUsuario;
    }

    public List<Usuario> getListaUsuario() {
        listaUsuario = ud.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
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
    
    public String removerUsuario(Usuario u){
        ud.delete(u);
        return "";
    }
    
    public String cancelarCadastro(){
	return "/index.xhtml";
    }
        
}
