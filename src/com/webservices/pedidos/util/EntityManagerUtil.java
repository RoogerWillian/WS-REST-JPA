package com.webservices.pedidos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("wspedidos");
	
	public static EntityManager getEntityManager(){
		return entityFactory.createEntityManager();
	}
}
