package dao;

import interfaces.IReservaDao;
import model.Reserva;

public class ReservaDaoImpl extends GenericDaoImpl<Reserva, Integer> implements IReservaDao{

    public ReservaDaoImpl() {
        super(Reserva.class);
    }    
}
