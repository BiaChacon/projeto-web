package bean;

import dao.SalaDaoImpl;
import dao.UsuarioDaoImpl;
import interfaces.ISalaDao;
import interfaces.IUsuarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import model.Reserva;
import model.Sala;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "usuario")
public class UsuarioBean {

    @ManagedProperty (value = "#{sessionScope['usuario-logado']}")
    Usuario user;
    
    @ManagedProperty (value = "#{sessionScope['usuario-logado'].reservas}")
    List<Reserva> listaReserva;
    
    List<Sala> listaSalaDisp;
    ISalaDao sd = new SalaDaoImpl();
   
    IUsuarioDao ud = new UsuarioDaoImpl();
    List<Usuario> listaUsuario;

    public List<Usuario> getListaUsuario() {
        listaUsuario = ud.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public UsuarioBean() {
        user = new Usuario();
    }
    
    public String removerUsuario(Usuario u){
        ud.delete(u);
        return "";
    } 
    
    public List<Reserva> getListaReserva() {
        /*
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        Usuario u = (Usuario) s.getAttribute("usuario-logado");
        listaReserva = u.getReservas();
        */
        return this.listaReserva;
    }

    public Usuario getUser() {
        /*FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        user = (Usuario) s.getAttribute("usuario-logado");*/
        return this.user;
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
        System.out.println("bean.UsuarioBean.editar()");
        Usuario s = user;
       s.setId(user.getId());
        System.out.println(s.getId());
       ud.save(s);
        return "/user/home.xhtml";
    } 
    
}
