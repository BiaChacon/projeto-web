/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.ReservaDaoImpl;
import dao.SalaDaoImpl;
import dao.UsuarioDaoImpl;
import interfaces.IReservaDao;
import interfaces.ISalaDao;
import interfaces.IUsuarioDao;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Reserva;
import model.Sala;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
public class TesteUser {
    public static void main(String[] args) {
       /* 
       IReservaDao rd = new ReservaDaoImpl();
       List<Reserva> reservas;
       Map<String, Object> condition = new HashMap<>();
       condition.put("cancelada", false);
       reservas =  rd.findAllByMulti(condition);
       List<Sala> listaSalaReservadas = new ArrayList<>();
       
       ISalaDao sd = new SalaDaoImpl();
       List<Sala> listaSalaDisp;
       List<Sala> listaSala = sd.findAll();
       listaSalaDisp = sd.findAll();
       
       for(Reserva i : reservas){
           listaSalaReservadas.add(i.getSala());
       }
       
      for(Sala j : listaSalaDisp){
            if(listaSalaReservadas.contains(j)){
               listaSala.remove(j);
            }
       }
       
        System.out.println("Sala Reservadas"+listaSalaReservadas);  
        System.out.println("Salas Disp"+listaSala); 
        
        IUsuarioDao ud = new UsuarioDaoImpl();
        Usuario u = new Usuario();
        u.setNome("Admin");
        u.setLogin("admin");
        u.setMatricula("12345");
        u.setSenha("12345");
        u.setRepete("12345");
        Date data1 = new GregorianCalendar(2012, Calendar.FEBRUARY, 19).getTime();
        u.setNascimento(data1);
        u.setTelefone("999999999");
        u.setAdmin(Boolean.TRUE);
        ud.save(u);*/
    }
}
