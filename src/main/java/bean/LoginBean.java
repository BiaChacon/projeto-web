package bean;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.*;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name="login")
public class LoginBean {
    
    private String login;
    private String senha;
    Usuario usuario;
    List<Usuario> listaUsuario;
    
    public LoginBean() {}

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

    public String getLogin() {
	return login;
    }
        
    public void setLogin(String login) {
        this.login = login;
    }
        
    public String getSenha() {
	return senha;
    }
        
    public void setSenha(String senha) {
	this.senha = senha;
    }
        
    public String autentica(){
        
        IUsuarioDao ud = new UsuarioDaoImpl();
        listaUsuario = ud.findAll();
        
        System.out.println("teste");
        
	boolean logou = false;
	FacesContext fc = FacesContext.getCurrentInstance();
        System.out.println(login);
        System.out.println(senha);
        
	for (Usuario u : listaUsuario) {
            
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                
		ExternalContext ec = fc.getExternalContext();
		HttpSession sessao = (HttpSession) ec.getSession(true);
		logou = true;
                
		if(u.getAdmin()){
                    sessao.setAttribute("admin-logado", u);
                    return "/admin/home.xhtml";
		}else{
                    sessao.setAttribute("usuario-logado", u);
                    return "/user/home.xhtml";
		}
            }
        }
		
	if(!logou){
            FacesMessage mensagem = new FacesMessage("Usuario ou senha invalidos");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(null, mensagem);
            return null;
	}
        
	return null;
        
    }
	
    public String deslogar(){
            
	FacesContext fc = FacesContext.getCurrentInstance();
	ExternalContext ec = fc.getExternalContext();
	HttpSession sessao = (HttpSession) ec.getSession(true);
	sessao.invalidate();
	FacesMessage mensagem = new FacesMessage("saiu");
	mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
        fc.addMessage(null, mensagem);
	return "/index.xhtml";
        
    }
      
}
	