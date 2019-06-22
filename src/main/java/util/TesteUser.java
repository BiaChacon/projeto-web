/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.UsuarioDaoImpl;
import interfaces.IUsuarioDao;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Usuario;

/**
 *
 * @author BiaChacon
 */
public class TesteUser {
    /*public static void main(String[] args) {
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
        ud.save(u);
    }*/
}
