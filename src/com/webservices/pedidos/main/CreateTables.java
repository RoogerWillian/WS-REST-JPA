package com.webservices.pedidos.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.webservices.pedidos.dao.ProdutoDAO;
import com.webservices.pedidos.model.Produto;

public class CreateTables {

	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("wspedidos");
			EntityManager em = factory.createEntityManager();
			
			Produto p = new Produto();
			p.setNome("Pizza");
			p.setValor(9.40);
			
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			
			em.close();
//			URL url = new URL("http://localhost:8080/WebservicePedidos/produtos/buscar/cidades");
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			InputStream content = connection.getInputStream();
//
//			StringBuilder stringBuilder = new StringBuilder();
//			BufferedReader reader =  new BufferedReader(new InputStreamReader(content));
//			
//			String line = null;
//			while((line = reader.readLine()) != null){
//				stringBuilder.append(line + "\n");
//				System.out.println(stringBuilder);
//			}
			
				
				try{
//					Gson gson = new Gson();
//					String pjson = gson.toJson(p, Produto.class);
//					
//					Client cliente = Client.create();
//					WebResource resource = cliente.resource("http://localhost:8080/WebservicePedidos/produtos/salvar");
//					ClientResponse response = resource.accept(MediaType.TEXT_PLAIN).post(ClientResponse.class, pjson);
//					
//					// exibe o status code do reader
//					System.out.println(response.getStatusInfo().getStatusCode());
				} catch(Exception e){
					e.printStackTrace();
				}
				
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
