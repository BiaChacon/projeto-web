package bean;

import dao.SalaDaoImpl;
import dao.UsuarioDaoImpl;
import interfaces.ISalaDao;
import interfaces.IUsuarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Reserva;
import model.Sala;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "usuario")
@SessionScoped
public class UsuarioBean {

    List<Reserva> listaReserva;
    List<Sala> listaSalaDisp;
    ISalaDao sd = new SalaDaoImpl();
    Usuario user;
    IUsuarioDao ud = new UsuarioDaoImpl();
    
    public UsuarioBean() {}

    public List<Reserva> getListaReserva() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        Usuario u = (Usuario) s.getAttribute("usuario-logado");
        listaReserva = u.getReservas();
        return listaReserva;
    }

    public Usuario getUser() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        user = (Usuario) s.getAttribute("usuario-logado");
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public List<Sala> getListaSalaDisp() {
        return listaSalaDisp;
    }

    public void setListaSalaDisp(List<Sala> listaSalaDisp) {
        this.listaSalaDisp = listaSalaDisp;
    }
    
    public String editarDados(){
        return "editar.xhtml";
    }
    
    public String editar(){
        Usuario s = user;
       s.setId(user.getId());
       ud.save(s);
        return "/user/home.xhtml";
    } 
    
}
