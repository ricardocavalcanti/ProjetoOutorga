package br.com.pgo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override // Contexto ao desligar o Tomcat
	public void contextDestroyed(ServletContextEvent evento) {

		HibernateUtil.getFabricaDeSessoes().close();

	}

	@Override // Contexto ao ligar o Tomcat
	public void contextInitialized(ServletContextEvent evento) {

		HibernateUtil.getFabricaDeSessoes().openSession();

	}

}
