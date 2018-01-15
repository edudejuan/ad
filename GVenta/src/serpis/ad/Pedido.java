package serpis.ad;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pedido {
	private long id;
	private Cliente cliente;
	private Calendar fecha;
	private List<PedidoLinea> pedidoLinea = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public List<PedidoLinea> getPedidoLinea() {
		return pedidoLinea;
	}

	public void setPedidoLinea(List<PedidoLinea> pedidoLinea) {
		this.pedidoLinea = pedidoLinea;
	}
	
	@Override
	public String toString(){
		return String.format("%s [cliente-%s] %s", 
				id,
				cliente ==null ? null : cliente.getId(),
				fecha == null ? null : fecha.getTime()
		);
	}
}
