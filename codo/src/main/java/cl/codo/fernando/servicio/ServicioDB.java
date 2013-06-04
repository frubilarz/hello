package cl.codo.fernando.servicio;

import cl.codo.fernando.modelo.Boleta;
import cl.codo.fernando.modelo.vista;
import cl.codo.fernando.modelo.Empresa;
import cl.codo.fernando.modelo.Mantencion;
import cl.codo.fernando.modelo.Pago;
import cl.codo.fernando.modelo.Usuario;
import cl.codo.fernando.modelo.Venta;
import cl.codo.fernando.utils.FechaUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public class ServicioDB implements Serializable {

    private boolean conectado = false;
    private Connection conexion = null;
    private static Logger logger = LoggerFactory.getLogger(ServicioDB.class);

    @PostConstruct
    public void iniciar() {
        boolean ok = conectar();
        if (!ok) {
            logger.info("ERROR: no fue posible conectarme a la base de datos");
        }

    }

    boolean conectar() {
        this.conectado = false;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/cododb?zeroDateTimeBehavior=convertToNull";
            Properties props = new Properties();
            props.setProperty("user", "codo");
            props.setProperty("password", "codo123");
//            props.setProperty("ssl", "true");
            this.conexion = DriverManager.getConnection(url, props);

            if (conexion != null) {
                this.conectado = true;
            } else {
                this.conectado = false;
            }

            if (!conectado) {
                throw new RuntimeException("No se puede conectar al motor de base de datos.");
            }

        } catch (Exception e) {
            this.conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    boolean desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                conexion = null;
                conectado = false;
            } else {
                conectado = false;
            }
        } catch (Exception e) {
            conexion = null;
            conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @PreDestroy
    public void finalizar() {
        boolean desconectar = desconectar();
        if (desconectar) {
            logger.info("ERROR: conexión aún activa");
        }
    }
public Boleta getBoletaporid(Integer id) {
        Boleta boleta = null;
        try {
            if (id != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM boleta WHERE idboleta=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            boleta = new Boleta();
                            boleta.setFecha(rs.getDate("fecha"));
                            boleta.setIdempresa(rs.getString("idempresa"));
                            boleta.setIdboleta(rs.getInt("idboleta"));
                            boleta.setIdempresa(rs.getInt("idempresa"));

                        } else {
                            logger.info("No existe usuario: " + id);
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: Rut vacío");
            }
        } catch (Exception e) {
            boleta = null;
            logger.error(e.toString());
            logger.debug("Error al obtener usuario", e);
        }
        return boleta;
    }


    public Usuario getUsuario(Integer rut) {
        Usuario usuario = null;
        try {
            if (rut != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM usuario WHERE rut=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            usuario = new Usuario();
                            usuario.setRut(rs.getInt("rut"));
                            usuario.setClave(rs.getString("clave"));
                        } else {
                            logger.info("No existe usuario: " + rut);
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: Rut vacío");
            }
        } catch (Exception e) {
            usuario = null;
            logger.error(e.toString());
            logger.debug("Error al obtener usuario", e);
        }
        return usuario;
    }

    public Empresa getEmpresaPorId(Integer id) {
        Empresa empresa = null;
        try {
            if (id != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM empresa WHERE idempresa=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            empresa = new Empresa();
                            empresa.setContacto(rs.getString("contacto"));
                            empresa.setDireccion(rs.getString("direccion"));
                            empresa.setIdempresa(rs.getInt("idempresa"));
                            empresa.setNombre(rs.getString("nombre"));
                            empresa.setRut(rs.getString("rut"));
                        } else {
                            logger.info("ERROR: No existe empresa");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
            empresa = null;
            logger.error(e.toString());
            logger.debug("Error al obtener empresa por id " + id, e);
        }
        return empresa;
    }
    public Pago getpago(Integer id) {
        Pago pago = null;
        try {
            if (id != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM pago WHERE idboleta=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            pago = new Pago();
                            pago.setEstado(rs.getString("estado"));
                            pago.setFechaVencimiento(rs.getDate("fechavencimiento"));
                            pago.setIdfactoring(rs.getInt("idfactoring"));
                            pago.setIdPago(rs.getInt("idpago"));
                            pago.setMonto(rs.getFloat("monto"));
                            
                        } else {
                            logger.info("ERROR: no existe pago");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
            pago = null;
            logger.error(e.toString());
            logger.debug("Error al obtener empresa por id " + id, e);
        }
        return pago;
    }
         public List<Mantencion> getmantencion(java.util.Date fecha) {
        List<Mantencion> mantenciones = new ArrayList<Mantencion>();

        try {
            if (fecha != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM mantencion WHERE fechainicio=? || fechafinl=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    
                    java.sql.Date few = new java.sql.Date(fecha.getTime());
                    st.setDate(1, few);
                    st.setDate(2, few);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            mantencion = new Mantencion();
                            mantencion.setComentario(rs.getString("comentario"));
                           mantencion.setDetalle(rs.getString("detalle"));
                           mantencion.setFechafin(rs.getDate("fechafinl"));
                           mantencion.setFechainicio(rs.getDate("fechainicio"));
                           mantencion.setLugar(rs.getString("lugarl"));
                           mantencion.setIdmantencion(rs.getInt("idmantencion"));
                           mantencion.setIdboleta(rs.getInt("idboleta"));
                           mantenciones.add(mantencion);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          mantenciones = new ArrayList<Mantencion>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por fecha " + fecha, e);
        }
        return mantenciones;
    }
 public List<Mantencion> getmantencion( String lugar , String id) {
        List<Mantencion> mantenciones = new ArrayList<Mantencion>();

        try {
            if (lugar!=null && id!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM mantencion WHERE   lugarl=? and idboleta in "
                        + "(select idboleta from boleta where idempresa="
                        + "(select idempresa from empresa  where rut=?))";
                st = conexion.prepareStatement(query);
                if (st != null) {

                    st.setString(1, lugar);
                    Integer id1 = Integer.parseInt(id);
                    st.setInt(2, id1);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            mantencion = new Mantencion();
                            mantencion.setComentario(rs.getString("comentario"));
                           mantencion.setDetalle(rs.getString("detalle"));
                           mantencion.setFechafin(rs.getDate("fechafinl"));
                           mantencion.setFechainicio(rs.getDate("fechainicio"));
                           mantencion.setLugar(rs.getString("lugarl"));
                           mantencion.setIdmantencion(rs.getInt("idmantencion"));
                           mantencion.setIdboleta(rs.getInt("idboleta"));
                           mantenciones.add(mantencion);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          mantenciones = new ArrayList<Mantencion>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + lugar, e);
        }
        return mantenciones;
    }
 
 public List<Mantencion> getmantencion( String lugar , String id, java.util.Date fecha) {
        List<Mantencion> mantenciones = new ArrayList<Mantencion>();

        try {
            if (lugar!=null && id!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM mantencion WHERE (fechainicio=? || fechafinl=?)"
                        + "  and  lugarl=? and idboleta in "
                        + "(select idboleta from boleta where idempresa="
                        + "(select idempresa from empresa  where rut=?))";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    java.sql.Date few = new java.sql.Date(fecha.getTime());
                    st.setDate(1, few);
                    st.setDate(2, few);
                    st.setString(3, lugar);
                    Integer id1 = Integer.parseInt(id);
                    st.setInt(4, id1);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            mantencion = new Mantencion();
                            mantencion.setComentario(rs.getString("comentario"));
                           mantencion.setDetalle(rs.getString("detalle"));
                           mantencion.setFechafin(rs.getDate("fechafinl"));
                           mantencion.setFechainicio(rs.getDate("fechainicio"));
                           mantencion.setLugar(rs.getString("lugarl"));
                           mantencion.setIdmantencion(rs.getInt("idmantencion"));
                           mantencion.setIdboleta(rs.getInt("idboleta"));
                           mantenciones.add(mantencion);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          mantenciones = new ArrayList<Mantencion>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + lugar, e);
        }
        return mantenciones;
    }
  public List<Mantencion> getmantencionporid( String id) {
        List<Mantencion> mantenciones = new ArrayList<Mantencion>();

        try {
            if (id!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM mantencion WHERE idboleta in "
                        + "(select idboleta from boleta where idempresa="
                        + "(select idempresa from empresa  where rut=?))";
                st = conexion.prepareStatement(query);
                if (st != null) {


                    Integer id1 = Integer.parseInt(id);
                    st.setInt(1, id1);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            mantencion = new Mantencion();
                            mantencion.setComentario(rs.getString("comentario"));
                           mantencion.setDetalle(rs.getString("detalle"));
                           mantencion.setFechafin(rs.getDate("fechafinl"));
                           mantencion.setFechainicio(rs.getDate("fechainicio"));
                           mantencion.setLugar(rs.getString("lugarl"));
                           mantencion.setIdmantencion(rs.getInt("idmantencion"));
                           mantencion.setIdboleta(rs.getInt("idboleta"));
                           mantenciones.add(mantencion);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          mantenciones = new ArrayList<Mantencion>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + id, e);
        }
        return mantenciones;
    }
  public List<Venta> getventa( String producto, java.util.Date fecha, java.util.Date fecha2 ) {
        List<Venta> ventas = new ArrayList<Venta>();

        try {
            if (producto!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query ="select * from venta where producto = ?"
                        + " and idboleta in (select idboleta from boleta WHERE DATE(fecha) BETWEEN ? AND ?)";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    java.sql.Date few = new java.sql.Date(fecha.getTime());
                    java.sql.Date fe =new java.sql.Date(fecha2.getTime());
                    st.setDate(2, few);
                    st.setString(1, producto);
                    st.setDate(3, fe);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            Venta venta = new Venta();
                            venta.setCantidad(rs.getString("cantidad"));
                            venta.setPreciocompra(rs.getFloat("preciocompra"));
                            venta.setPrecioventa(rs.getFloat("precioventa"));
                            venta.setProducto(rs.getString("producto"));
                            venta.setIdboleta(rs.getInt("idboleta"));
                            venta.setProveedor(rs.getString("proveedor"));
                            ventas.add(venta);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          ventas = new ArrayList<Venta>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + producto, e);
        }
        return ventas;
    }
  public List<Venta> getventa( String producto) {
        List<Venta> ventas = new ArrayList<Venta>();

        try {
            if (producto!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query ="select * from venta where producto = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {



                    st.setString(1, producto);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            Venta venta = new Venta();
                            venta.setCantidad(rs.getString("cantidad"));
                            venta.setPreciocompra(rs.getFloat("preciocompra"));
                            venta.setPrecioventa(rs.getFloat("precioventa"));
                            venta.setProducto(rs.getString("producto"));
                            venta.setIdboleta(rs.getInt("idboleta"));
                            venta.setProveedor(rs.getString("proveedor"));
                            ventas.add(venta);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          ventas = new ArrayList<Venta>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + producto, e);
        }
        return ventas;
    }

  
  
     public List<Mantencion> getmantencion( String lugar ) {
        List<Mantencion> mantenciones = new ArrayList<Mantencion>();

        try {
            if (lugar!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM mantencion WHERE lugarl=?";
                st = conexion.prepareStatement(query);
                if (st != null) {

                    st.setString(1, lugar);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Mantencion mantencion =new Mantencion();
                            mantencion = new Mantencion();
                            mantencion.setComentario(rs.getString("comentario"));
                           mantencion.setDetalle(rs.getString("detalle"));
                           mantencion.setFechafin(rs.getDate("fechafinl"));
                           mantencion.setFechainicio(rs.getDate("fechainicio"));
                           mantencion.setLugar(rs.getString("lugarl"));
                           mantencion.setIdmantencion(rs.getInt("idmantencion"));
                           mantencion.setIdboleta(rs.getInt("idboleta"));
                           mantenciones.add(mantencion);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          mantenciones = new ArrayList<Mantencion>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + lugar, e);
        }
        return mantenciones;
    }
     
         public List<Pago> getmonto( java.util.Date fecha1, java.util.Date fecha2 ) {
        List<Pago> pagos = new ArrayList<Pago>();

        try {
            if (fecha1!=null && fecha2!=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "select monto from pago  where idboleta in  "
                        + "(SELECT idboleta FROM boleta WHERE DATE(fecha) BETWEEN ? AND ?)";
                st = conexion.prepareStatement(query);
                if (st != null) {
                        java.sql.Date fe = new java.sql.Date(fecha1.getTime());
                       java.sql.Date few = new java.sql.Date(fecha2.getTime());
                    st.setDate(1, fe);
                    st.setDate(2, few);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            
                            Pago pago= new Pago();
                            pago.setMonto(rs.getFloat("monto"));
                            pagos.add(pago);
 
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
          pagos = new ArrayList<Pago>();
            logger.error(e.toString());
            logger.debug("Error al obtener mantencion por lugar " + fecha1, e);
        }
        return pagos;
    }
     
       public List<vista> getdatos(java.util.Date fecha1, java.util.Date fecha2 ) {
        List<vista> vistas = new ArrayList<vista>();

        try {
            if (fecha1!=null && fecha2 !=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM todo WHERE DATE(fecha) BETWEEN ? AND ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                      java.sql.Date fe = new java.sql.Date(fecha1.getTime());
                       java.sql.Date few = new java.sql.Date(fecha2.getTime());
                    st.setDate(1, fe);
                    st.setDate(2, few);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            vista vist =new vista();
                            vist.setRut(rs.getInt("rut"));
                            vist.setNombre(rs.getString("nombre"));
                            vist.setEstado(rs.getString("estado"));
                            vist.setFechaemicion(rs.getDate("fecha"));
                            vist.setFechavencimiento(rs.getDate("fechavencimiento"));
                            vist.setFactoring(rs.getString("factoring"));
                            vist.setMonto(rs.getFloat("monto"));
                            vist.setNumero(rs.getInt("contacto"));
                            
                            vistas.add(vist);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
         vistas = new ArrayList<vista>();
            logger.error(e.toString());
            logger.debug("Error al obtener vista con esa fecha " + fecha1, e);
        }
        return vistas;
    }
            public List<vista> getdatos(java.util.Date fecha1, java.util.Date fecha2 , int rut) {
        List<vista> vistas = new ArrayList<vista>();

        try {
            if (fecha1!=null && fecha2 !=null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM todo WHERE DATE(fecha) BETWEEN ? AND ? AND rut =?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                      java.sql.Date fe = new java.sql.Date(fecha1.getTime());
                       java.sql.Date few = new java.sql.Date(fecha2.getTime());
                    st.setDate(1, fe);
                    st.setDate(2, few);
                    st.setInt(3, rut);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            vista vist =new vista();
                            vist.setRut(rs.getInt("rut"));
                            vist.setNombre(rs.getString("nombre"));
                            vist.setEstado(rs.getString("estado"));
                            vist.setFechaemicion(rs.getDate("fecha"));
                            vist.setFechavencimiento(rs.getDate("fechavencimiento"));
                            vist.setFactoring(rs.getString("factoring"));
                            vist.setMonto(rs.getFloat("monto"));
                            vist.setNumero(rs.getInt("contacto"));
                            
                            vistas.add(vist);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
         vistas = new ArrayList<vista>();
            logger.error(e.toString());
            logger.debug("Error al obtener vista con esa fecha " + fecha1, e);
        }
        return vistas;
    }
               public List<vista> getdatos( int rut) {
        List<vista> vistas = new ArrayList<vista>();

        try {
            if (rut!=0) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM todo WHERE  rut =?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            vista vist =new vista();
                            vist.setRut(rs.getInt("rut"));
                            vist.setNombre(rs.getString("nombre"));
                            vist.setEstado(rs.getString("estado"));
                            vist.setFechaemicion(rs.getDate("fecha"));
                            vist.setFechavencimiento(rs.getDate("fechavencimiento"));
                            vist.setFactoring(rs.getString("factoring"));
                            vist.setMonto(rs.getFloat("monto"));
                            vist.setNumero(rs.getInt("contacto"));
                            
                            vistas.add(vist);
                        } 
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
         vistas = new ArrayList<vista>();
            logger.error(e.toString());
            logger.debug("Error al obtener vista con ese rut " + rut, e);
        }
        return vistas;
    }
     
      public List<Boleta> getboletas(int id) {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
        
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM boleta WHERE idempresa=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {

                            Boleta boleta =new Boleta();
                            boleta.setIdboleta(rs.getInt("idboleta"));
                            boleta.setFecha(rs.getDate("fecha"));
                            boletas.add(boleta);
                            }
                        rs.close();
                    }
                    st.close();
                }

        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.error(e.toString());
            logger.debug("Error al obtener empresas por rut " + id, e);
        }
        return boletas;
    }

    
    public List<Empresa> getEmpresasPorRut(String rut) {
        List<Empresa> empresas = new ArrayList<Empresa>();
        try {
            if (!StringUtils.isEmpty(rut)) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM empresa WHERE rut=?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setString(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            Empresa empresa = new Empresa();
                            empresa.setContacto(rs.getString("contacto"));
                            empresa.setDireccion(rs.getString("direccion"));
                            empresa.setIdempresa(rs.getInt("idempresa"));
                            empresa.setNombre(rs.getString("nombre"));
                            empresa.setRut(rs.getString("rut"));

                            empresas.add(empresa);
                        } else {
                            logger.info("ERROR: No existe empresa");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
            empresas = new ArrayList<Empresa>();
            logger.error(e.toString());
            logger.debug("Error al obtener empresas por rut " + rut, e);
        }
        return empresas;
    }

    
    
    
public Empresa getEmpresaPorRut(String rut) {
        Empresa empresa = new Empresa();

        try {
            if (!StringUtils.isEmpty(rut)) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM empresa WHERE rut=? ORDER BY rut DESC LIMIT 1";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setString(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            empresa.setContacto(rs.getString("contacto"));
                            empresa.setDireccion(rs.getString("direccion"));
                            empresa.setIdempresa(rs.getInt("idempresa"));
                            empresa.setNombre(rs.getString("nombre"));
                            empresa.setRut(rs.getString("rut"));
                        } else {
                            logger.info("ERROR: No existe empresa");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
            empresa = null;
            logger.error(e.toString());
            logger.debug("Error al obtener empresas por rut " + rut, e);
        }
        return empresa;
    }


 public Usuario getUsuario() {
        Usuario usuario = null;
        try {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                PreparedStatement st = null;
                String query = "SELECT * FROM usuario";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    //st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            usuario = new Usuario();
                            usuario.setRut(rs.getInt("rut"));
                            usuario.setClave(rs.getString("clave"));
                        } else {
                            logger.info("No existe usuario: ");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: Rut vacío");
            }
        } catch (Exception e) {
            usuario = null;
            logger.error(e.toString());
            logger.debug("Error al obtener usuario", e);
        }
        return usuario;
    }
    public Boleta getBoletaPorIdEmpresa(Integer id) {
        Boleta boleta = null;
        try {
            if (id != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                PreparedStatement st = null;
                String query = "SELECT * FROM boleta WHERE idempresa=? ORDER BY idboleta DESC LIMIT 1";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            boleta = new Boleta();
                            boleta.setFecha(rs.getDate("fecha"));
                            //boleta.setNumero(rs.getString("numero"));
                            boleta.setIdboleta(rs.getInt("idboleta"));
                            boleta.setIdempresa(rs.getInt("idempresa"));
                        } else {
                            logger.info("ERROR: No existe boleta");
                        }
                        rs.close();
                    }
                    st.close();
                }
            } else {
                logger.info("ERROR: ID nulo");
            }
        } catch (Exception e) {
            boleta = null;
            logger.error(e.toString());
            logger.debug("Error al obtener boleta por id empresa " + id, e);
        }
        return boleta;
    }
public boolean guardar(Mantencion mantencion) {

    boolean resultado = false;
 try {
     logger.error("hola");
     if (mantencion != null) {
         // Conectamos si no está conectado
         if (!isConectado()) {
             conectar();

         }

         PreparedStatement st = null;
         String query = "";
         query = "INSERT INTO mantencion (fechainicio,fechafinl,lugarl,detalle,comentario,idboleta)"
                 + " VALUES (?,?,?,?,?,?)";
         st = conexion.prepareStatement(query);

         java.sql.Date fe =new java.sql.Date(mantencion.getFechainicio().getTime());
         st.setDate(1,fe);
         java.sql.Date few = new java.sql.Date(mantencion.getFechafin().getTime());
         st.setDate(2,few);
         st.setString(3, mantencion.getLugar());
         st.setString(4, mantencion.getDetalle());
         st.setString(5, mantencion.getComentario());
         st.setInt(6, mantencion.getIdboleta());
         if (st != null) {
             logger.info(st.toString());
             st.execute();
             int updateCount = st.getUpdateCount();
             if (updateCount > 0) {
                 resultado = true;
             }
         }
     } else {
         logger.info("ERROR: mala mantencion");
     }
 } catch (Exception e) {
     resultado = false;
     logger.error(e.toString());
     logger.debug("Error al guardar mantencion", e);
 }
 return resultado;
}

    
    public boolean guardar(Empresa empresa) {
        boolean resultado = false;
        try {
            logger.error("algo");
            if (empresa != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                boolean update = false;
                if (empresa.getIdempresa() != null) {
                    if (empresa.getIdempresa() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE empresa SET rut=?, nombre=?, direccion=?, contacto=? WHERE idempresa = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, empresa.getRut());
                    st.setString(2, empresa.getNombre());
                    st.setString(3, empresa.getDireccion());
                    st.setString(4, empresa.getContacto());
                    st.setInt(5, empresa.getIdempresa());
                } else {
                    query = "INSERT INTO empresa (rut, nombre, direccion, contacto) VALUES (?, ?, ?, ?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, empresa.getRut());
                    st.setString(2, empresa.getNombre());
                    st.setString(3, empresa.getDireccion());
                    st.setString(4, empresa.getContacto());
                    
                }

                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        resultado = true;
                    }
                }
            } else {
                logger.info("ERROR: empresa nula");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar empresa", e);
        }
        return resultado;
    }  
    
       public boolean guardar(Pago pago) {
        boolean resultado = false;
        try {
            if (pago != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                    
                }

                PreparedStatement st = null;
                String query = "";
                query = "INSERT INTO pago (fechavencimiento,monto,estado,idboleta,idfactoring) VALUES (?, ?,?,?,?)";
                st = conexion.prepareStatement(query);
                
                java.sql.Date fe =new java.sql.Date(pago.getFechaVencimiento().getTime());
                st.setDate(1,fe);
                st.setFloat(2, pago.getMonto());
                st.setString(3, pago.getEstado());
                st.setInt(4, pago.getIdboleta());
                st.setInt(5, pago.getIdfactoring());
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();
                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        resultado = true;
                    }
                }
            } else {
                logger.info("ERROR: pago nulo");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar pago", e);
        }
        return resultado;
    }

       public boolean guardar(Venta venta) {
        boolean resultado = false;
        try {
            if (venta != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }



                PreparedStatement st = null;
                String query = "";

                    query = "INSERT INTO venta (idboleta,cantidad,producto,preciocompra,precioventa,proveedor) VALUES (?, ?,?,?,?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(2, venta.getCantidad());
                    st.setString(6, venta.getProveedor());
                    st.setFloat(4, venta.getPreciocompra());
                    st.setFloat(5,venta.getPrecioventa());
                    st.setString(3, venta.getProducto());
                    st.setInt(1, venta.getIdboleta());

                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        resultado = true;
                    }
                }
            } else {
                logger.info("ERROR: venta nulo");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar venta", e);
        }
        return resultado;
    }

    
    public boolean guardar(Usuario usuario) {
        boolean resultado = false;
        try {
            if (usuario != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                boolean update = false;
                if (usuario.getRut() != null) {
                    if (usuario.getRut() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";

                    query = "INSERT INTO usuario (rut, clave) VALUES (?, ?)";
                    st = conexion.prepareStatement(query);
                    st.setInt(1, usuario.getRut());
                    st.setString(2, usuario.getClave());

                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        resultado = true;
                    }
                }
            } else {
                logger.info("ERROR: usuaio nulo");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar usuario", e);
        }
        return resultado;
    }

    public boolean guardar(Boleta boleta) {
        boolean resultado = false;
        try {
            if (boleta != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                boolean update = false;
                if (boleta != null) {
                    if (boleta.getIdboleta()> 0) {
                        update = false;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE boleta SET , fecha=?, idempresa = ? WHERE idboleta=?";
                    st = conexion.prepareStatement(query);
                    java.sql.Date fe =new java.sql.Date(boleta.getFecha().getTime());
                    st.setDate(1, fe);
                    st.setInt(2, boleta.getIdempresa());
                    st.setInt(3, boleta.getIdboleta());
                } else {
                    query = "INSERT INTO boleta (idboleta,fecha, idempresa) VALUES ( ?,?, ?)";
                    st = conexion.prepareStatement(query);
                    st.setInt(1, boleta.getIdboleta());
                    java.sql.Date fe =new java.sql.Date(boleta.getFecha().getTime());
                    st.setDate(2, fe );
                    st.setInt(3, boleta.getIdempresa());
                    
                }

                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        resultado = true;
                    }
                }
            } else {
                logger.info("ERROR: boleta nula");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar Boleta", e);
        }
        return resultado;
    }
}

