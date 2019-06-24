package bean;

import dao.SalaDaoImpl;
import interfaces.ISalaDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
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
public class UsuarioBean {

    List<Reserva> listaReserva;
    List<Sala> listaSalaDisp;
    ISalaDao sd = new SalaDaoImpl();
    
    public UsuarioBean() {}

    public List<Reserva> getListaReserva() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        Usuario u = (Usuario) s.getAttribute("usuario-logado");
        listaReserva = u.getReservas();
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }
    
    public void listaSalaDisp(){
        listaSalaDisp = sd.findAll();
        for(int i=0; i<listaSalaDisp.size(); i++){
            if(!(listaSalaDisp.get(i).getReserva() == null)){
                listaSalaDisp.remove(i);
            }
        }
        System.out.println(listaSalaDisp);
        
    }
    
    public List<Sala> getListaSalaDisp() {
        return listaSalaDisp;
    }

    public void setListaSalaDisp(List<Sala> listaSalaDisp) {
        this.listaSalaDisp = listaSalaDisp;
    }
    
}
