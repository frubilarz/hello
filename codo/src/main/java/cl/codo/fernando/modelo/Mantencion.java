package cl.codo.fernando.modelo;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class Mantencion extends BaseBean {

    private Integer idmantencion = null;
    private String fechainicio = null;
    private String fechafin = null;
    private String lugar = null;
    private String detalle = null;
    private String comentario = null;
    private Integer idboleta = null;
    private Integer boletaId = null;

    public Integer getIdmantencion() {
        return idmantencion;
    }

    public void setIdmantencion(Integer idmantencion) {
        this.idmantencion = idmantencion;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantencion != null ? idmantencion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantencion)) {
            return false;
        }
        Mantencion other = (Mantencion) object;
        if ((this.idmantencion == null && other.idmantencion != null) || (this.idmantencion != null && !this.idmantencion.equals(other.idmantencion))) {
            return false;
        }
        return true;
    }
}
