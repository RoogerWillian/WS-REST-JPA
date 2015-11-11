package com.webservices.pedidos.interfaces;

import java.util.List;

public interface PersistenceDefaultJPA<T> {
	public T salvar(T t);
	public void editar(T t);
	public void deletar(T t);
	public T buscarObjectManager(int id);
	public List<T> buscarTodosObject();
}
