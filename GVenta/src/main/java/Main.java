import java.util.Calendar;
import java.util.List;
import java.util.logging.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	
	public static void main(String[] args){
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		System.out.println("Iniciando aplicacion:");
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("serpis.ad.gventa");
		persist();
		query();
		
		entityManagerFactory.close();
		System.out.println("Adios");
	}
	private static void show (Pedido pedido){
		System.out.println(pedido);
		for(PedidoLinea pedidoLinea : pedido.getPedidoLineas()){
			System.out.println(pedidoLinea);
		}
	
	}
	private static void query(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Pedido> Pedidos = entityManager.createQuery("from Pedido", Pedido.class).getResultList();
		for (Pedido pedido: Pedidos)
			show(pedido);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	private static Long persist() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Pedido pedido = new Pedido();
		Clientes cliente = entityManager.find(Clientes.class, 1L);
		pedido.setCliente(cliente);
		pedido.setFecha(Calendar.getInstance());
		
		for(Long articuloId = 1L; articuloId <= 3; articuloId++){
			Articulo articulo = entityManager.find(Articulo.class, articuloId);
			PedidoLinea pedidoLinea = new PedidoLinea();
			pedidoLinea.add(pedido);
			pedidoLinea.setArticulo(articulo);
			pedido.getPedidoLineas().add(pedidoLinea);
		}
		
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		entityManager.close();
		show(pedido);
		return pedido.getId();
	}
}
