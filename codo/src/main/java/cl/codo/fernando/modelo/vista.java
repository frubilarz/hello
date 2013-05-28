package cl.codo.fernando.modelo;

import java.util.Date;

/**
 *
 * @author fernando
 */
public class vista extends BaseBean {
    private Integer rut;
    private String Nombre;
    private Integer numero;
    private Date fechaemicion;
    private Date fechavencimiento;
    private Float monto;
    private String estado;
    private String factoring;

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFechaemicion(Date fechaemicion) {
        this.fechaemicion = fechaemicion;
    }

    public void setFechavencimiento(Date fechavencimiento) {
        this.fechavencimiento = fechavencimiento;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFactoring(String factoring) {
        this.factoring = factoring;
    }

    public Integer getRut() {
        return rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public Date getFechaemicion() {
        return fechaemicion;
    }

    public Date getFechavencimiento() {
        return fechavencimiento;
    }

    public Float getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public String getFactoring() {
        return factoring;
    }
    
}
