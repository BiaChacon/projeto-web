package bean;

import dao.ReservaDaoImpl;
import interfaces.IReservaDao;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@ManagedBean(name = "reserva")
public class ReservaBean {
    
   private Reserva novaReserva;
   List<Reserva> listaReserva;
   IReservaDao rd = new ReservaDaoImpl();

    public ReservaBean() {
        novaReserva = new Reserva();
    }

    public List<Reserva> getListaReserva() {
        listaReserva = rd.findAll();
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public Reserva getNovaReserva() {
        return novaReserva;
    }

    public void setNovaReserva(Reserva novaReserva) {
        this.novaReserva = novaReserva;
    }
   
    public String reservarSala(Sala sala){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        Usuario user = (Usuario) s.getAttribute("usuario-logado");
        novaReserva.setUsuario(user);
        
        novaReserva.setSala(sala);
        
        String data = "dd/MM/yyyy";
	Date agora = new Date();
	SimpleDateFormat formata = new SimpleDateFormat(data);
	String data1 = formata.format(agora);
        novaReserva.setInicio(agora);
        
        rd.save(novaReserva);
        
        novaReserva = new Reserva();
        return "";
    }

    public String removerReservar(Reserva r){
        rd.delete(r);
        return "";
    }
    
}
