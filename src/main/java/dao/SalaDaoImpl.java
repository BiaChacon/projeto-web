package dao;

import interfaces.ISalaDao;
import model.Sala;

public class SalaDaoImpl extends GenericDaoImpl<Sala, Integer> implements ISalaDao{

    public SalaDaoImpl() {
        super(Sala.class);
    }
    
}
