package cl.codo.fernando.modelo;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class Pago extends BaseBean {

    private Integer idPago = null;
    private String fechaVencimiento = null;
    private String factoring = null;
    private String monto = null;
    private String estado = null;
    private Integer idboleta = null;
    private Integer boletaId = null;

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFactoring() {
        return factoring;
    }

    public void setFactoring(String factoring) {
        this.factoring = factoring;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Integer getBoletaId() {
        return boletaId;
    }

    public void setBoletaId(Integer boletaId) {
        this.boletaId = boletaId;
    }
}
