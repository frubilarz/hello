package cl.codo.fernando.modelo;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class Venta extends BaseBean {

    private Integer idventa = null;
    private String cantidad = null;
    private String proveedor = null;
    private Float preciocompra = null;
    private Float precioventa = null;
    private String producto = null;
    private Integer idboleta = null;


    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Float getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(Float preciocompra) {
        this.preciocompra = preciocompra;
    }

    public Float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Float precioventa) {
        this.precioventa = precioventa;
    }

  

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }
}
