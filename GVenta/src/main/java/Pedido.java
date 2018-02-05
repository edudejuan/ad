
import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Pedido {
	private Long id;
	private Clientes cliente;
	private Calendar fecha = Calendar.getInstance();
	private List<PedidoLinea> pedidoLineas = new ArrayList<>();
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="cliente")
	public Clientes getCliente() {
		return cliente;
	}
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString(){
		return String.format("%s, [cliente-%s] %s", 
				id, 
				cliente == null ? null : cliente.getId(),
				fecha == null ? null : fecha.getTime()
				);
	}
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	public PedidoLinea[] getPedidoLineas() {
		return pedidoLineas.toArray(new PedidoLinea[0]);
	}
	public void setPedidoLineas(List<PedidoLinea> pedidoLineas) {
		this.pedidoLineas = pedidoLineas;
	}
	public void remove(PedidoLinea linea) {
		pedidoLineas.remove(linea);
	    linea.setPedido(this);;
		
	}
}