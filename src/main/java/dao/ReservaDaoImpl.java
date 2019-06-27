package dao;

import interfaces.IReservaDao;
import model.Reserva;

/**
 *
 * @author BiaChacon
 */
public class ReservaDaoImpl extends GenericDaoImpl<Reserva, Integer> implements IReservaDao{

    public ReservaDaoImpl() {
        super(Reserva.class);
    } 
    
}
 