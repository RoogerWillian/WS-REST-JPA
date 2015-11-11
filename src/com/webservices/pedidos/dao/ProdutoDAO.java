package com.webservices.pedidos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.webservices.pedidos.interfaces.PersistenceDefaultJPA;
import com.webservices.pedidos.model.Produto;
import com.webservices.pedidos.util.EntityManagerUtil;

public class ProdutoDAO implements PersistenceDefaultJPA<Produto>{
	public ProdutoDAO() {
	}
	
	@Override
	public Produto salvar(Produto produto) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			em.getTransaction().begin();;
			em.persist(produto);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			em.close();
		}
		
		return produto;
	}

	@Override
	public void editar(Produto produto) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			em.getTransaction().begin();;
			em.persist(produto);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			em.close();
		}
	}

	@Override
	public void deletar(Produto produto) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		try{
			Produto prodExcluir = em.find(Produto.class, produto);
			
			em.getTransaction().begin();
			em.remove(prodExcluir);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			em.close();
		}
	}

	@Override
	public Produto buscarObjectManager(int id) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Produto produto = null;
		try{
			produto = em.find(Produto.class, id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return produto;
	}

	@Override
	public List<Produto> buscarTodosObject() {
		EntityManager em = EntityManagerUtil.getEntityManager();
		List<Produto> produtos = null;
		try{
			produtos = em.createQuery("from Produto", Produto.class).getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return produtos;
	}
}
