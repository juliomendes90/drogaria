package br.com.juliomendes90.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.juliomendes90.drogaria.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}