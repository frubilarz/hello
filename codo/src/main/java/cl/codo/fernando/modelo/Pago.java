package cl.codo.fernando.modelo;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class Pago extends BaseBean {

    private Integer idPago = null;
    private String fechaVencimiento = null;
    private String monto = null;
    private String estado = null;
    private Integer idboleta = null;
    private Integer idfactoring = null;

    public Integer getIdfactoring() {
        return idfactoring;
    }

    public void setIdfactoring(Integer idfactoring) {
        this.idfactoring = idfactoring;
    }

    
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


}
