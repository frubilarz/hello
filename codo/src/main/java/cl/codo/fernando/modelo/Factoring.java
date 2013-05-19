package cl.codo.fernando.modelo;

/**
 *
 * @author fernando
 */
public class Factoring extends BaseBean {
    
    private Integer idfactoring =null;
    private String nombre = null;

    public Integer getIdfactoring() {
        return idfactoring;
    }

    public void setIdfactoring(Integer idfactoring) {
        this.idfactoring = idfactoring;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.idfactoring != null ? this.idfactoring.hashCode() : 0);
        hash = 11 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Factoring other = (Factoring) obj;
        if (this.idfactoring != other.idfactoring && (this.idfactoring == null || !this.idfactoring.equals(other.idfactoring))) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }
    
    
}
