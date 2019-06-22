package dao;

import interfaces.IUsuarioDao;
import model.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements IUsuarioDao{

    public UsuarioDaoImpl() {
        super(Usuario.class);
    }
    
}
