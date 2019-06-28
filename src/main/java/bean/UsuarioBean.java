package bean;

import dao.ReservaDaoImpl;
import dao.SalaDaoImpl;
import dao.UsuarioDaoImpl;
import interfaces.IReservaDao;
import interfaces.ISalaDao;
import interfaces.IUsuarioDao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    
    List<Usuario> listaUsuario;
    
    List<Sala> listaSalaDisp;
    
    public UsuarioBean() {}
    
    public List<Reserva> getListaReserva() {
        
        /*for(Reserva i : listaReserva){
            if(i.getCancelada()){
               listaReserva.remove(i);
            }
        }*/
        return listaReserva;
    }
    
    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    
    public List<Usuario> getListaUsuario() {
        
        IUsuarioDao ud = new UsuarioDaoImpl();
        Map<String, Object> condition = new HashMap<>();
        condition.put("admin", false);
        listaUsuario = ud.findAllByMulti(condition);
        
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public List<Sala> getListaSalaDisp() {
        
       ISalaDao us = new SalaDaoImpl();
        Map<String, Object> condition = new HashMap<>();
        condition.put("reserva", false);
        listaSalaDisp = us.findAllByMulti(condition);

        return listaSalaDisp;
    }

    public void setListaSalaDisp(List<Sala> listaSalaDisp) {
        this.listaSalaDisp = listaSalaDisp;
    }
    
    public String removerUsuario(Usuario u){
        IUsuarioDao ud = new UsuarioDaoImpl();
        ud.delete(u);
        return "";
    } 
    
    public String editarDados(){
        return "editar.xhtml";
    }
    
    public String editar(){
        IUsuarioDao ud = new UsuarioDaoImpl();
        //ud.save(user);
        return "/user/home.xhtml";
    } 
    
}
