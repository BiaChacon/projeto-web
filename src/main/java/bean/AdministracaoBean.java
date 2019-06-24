package bean;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "admin")
@SessionScoped
public class AdministracaoBean {
    
    List<Usuario> listaUsuario;
    IUsuarioDao ud = new UsuarioDaoImpl();

    public AdministracaoBean() {}

    public List<Usuario> getListaUsuario() {
        listaUsuario = ud.findAll();
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public String removerUsuario(Usuario u){
        ud.delete(u);
        return "";
    }
    
}
