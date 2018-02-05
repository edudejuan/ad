package serpis.ad;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articulo {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String nombre;
		private BigDecimal precio;
		@ManyToOne
		@JoinColumn(name="categoria")
		private Categoria categoria;
		
		public Articulo(long id, String nombre, BigDecimal precio, Categoria categoria) {
		
		}
		
		public long getId() {
			// TODO Auto-generated method stub
			return id;
		}
		
		public String getNombre() {
			// TODO Auto-generated method stub
			return nombre;
		}
		

		public BigDecimal getPrecio() {
			// TODO Auto-generated method stub
			return precio;
		}

		public Categoria getCategoria() {
			// TODO Auto-generated method stub
			return categoria;
		}

		
		public String toString() {
			return String.format("[%s] %s %s (%s)", id, nombre, precio, categoria);
		}
	 
	}


