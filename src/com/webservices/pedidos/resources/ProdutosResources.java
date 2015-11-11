package com.webservices.pedidos.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.webservices.pedidos.dao.ProdutoDAO;
import com.webservices.pedidos.model.Produto;

@Path("/produtos")
public class ProdutosResources {
	
	@GET
	@Path("/buscar/produto/{id}")
	public String getOneProduto(@PathParam("id") int id){
		System.out.println("Call em URI /buscar/produto/{id}");
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscarObjectManager(id);
		
		return new Gson().toJson(produto);
	}
	
	@GET
	@Path("/buscar/produtos")
	public String listarProdutos(){
		System.out.println("Call em URI /buscar/produtos");
		ProdutoDAO dao = new ProdutoDAO();
		
		List<Produto> produtos = dao.buscarTodosObject();
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(produtos);
		
		return jsonResponse;
	}
	
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public String insertProduto(String p){
		System.out.println("Call em URI /salvar: ");
		Produto produto = new Gson().fromJson(p, Produto.class);
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
		
		return new Gson().toJson(produto);
	}
}
