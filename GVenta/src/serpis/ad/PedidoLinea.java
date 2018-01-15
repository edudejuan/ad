package serpis.ad;

import java.math.BigDecimal;

public class PedidoLinea {
	private long id;
	private Pedido pedido;
	private Articulo articulo;
	private BigDecimal precio;
	private BigDecimal unidades;
	private BigDecimal importe;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getUnidades() {
		return unidades;
	}

	public void setUnidades(BigDecimal unidades) {
		this.unidades = unidades;
	}
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		pedido.getPedidoLinea().add(this);
		this.pedido = pedido;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	
	@Override
	public String toString(){
		return String.format("%s %s %s %s %s %s", 
				id,
				pedido == null ? null :pedido.getId(),
				articulo ==null ?null : articulo.getId(),
				precio,
				unidades,
				importe);
		
	}

}
