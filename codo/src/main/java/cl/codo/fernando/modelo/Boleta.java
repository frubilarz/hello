package cl.codo.fernando.modelo;

import java.util.Date;


/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class Boleta extends BaseBean {

    private Integer idboleta = null;
    private Integer dia = null;
    private Integer mes=null;
    private Integer anio=null;
    private Integer idempresa = null;
    private Date fecha =null;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Integer getIdboleta() {
        return idboleta;
    }

    public void setIdboleta(Integer idboleta) {
        this.idboleta = idboleta;
    }

    public Boleta() {
    }


    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }






    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idboleta != null ? idboleta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleta)) {
            return false;
        }
        Boleta other = (Boleta) object;
        if ((this.idboleta == null && other.idboleta != null) || (this.idboleta != null && !this.idboleta.equals(other.idboleta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.codo.fernando.modelo.Boleta[ idboleta=" + idboleta + " ]";
    }

    public String getNumero() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdempresa(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
