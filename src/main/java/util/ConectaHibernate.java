package util;

import org.hibernate.Session;

public class ConectaHibernate {

	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Conectou!");
		sessao.close();
	}
}
