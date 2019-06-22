package dao;

import interfaces.ISalaDao;
import model.Sala;

/**
 *
 * @author BiaChacon
 */
public class SalaDaoImpl extends GenericDaoImpl<Sala, Integer> implements ISalaDao{

    public SalaDaoImpl() {
        super(Sala.class);
    }
    
}
