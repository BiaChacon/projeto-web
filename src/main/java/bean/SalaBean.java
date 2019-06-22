package bean;

import dao.SalaDaoImpl;
import interfaces.ISalaDao;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Sala;

/**
 *
 * @author BiaChacon
 */
@ManagedBean(name = "sala")
public class SalaBean {
    
    private Sala novaSala;
    List<Sala> listaSala;
    ISalaDao sd = new SalaDaoImpl();

    public SalaBean() {
        novaSala = new Sala();
    }

    public Sala getNovaSala() {
        return novaSala;
    }

    public void setNovaSala(Sala novaSala) {
        this.novaSala = novaSala;
    }

    public List<Sala> getListaSala() {
        listaSala = sd.findAll();
        return listaSala;
    }

    public void setListaSala(List<Sala> listaSala) {
        this.listaSala = listaSala;
    }
    
    public String cadastrarSala(){
        
	FacesContext fc = FacesContext.getCurrentInstance();
        
	sd.save(novaSala);
        
	FacesMessage mensagem = new FacesMessage("Cadastro efetuado com sucesso");
	mensagem.setSeverity(FacesMessage.SEVERITY_INFO);
	fc.addMessage(null, mensagem);
        
        novaSala= new Sala();
	return "";
        
    }

    public String removerSala(Sala s){
        sd.delete(s);
	return "";
    }    
    
    public String cancelar(){
        //novaSala= new Sala();
	return "";
    }
    
}
