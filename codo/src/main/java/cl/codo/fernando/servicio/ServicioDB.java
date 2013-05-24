package cl.codo.fernando.servicio;

import cl.codo.fernando.modelo.Boleta;
import cl.codo.fernando.modelo.Empresa;
import cl.codo.fernando.modelo.Mantencion;
import cl.codo.fernando.modelo.Pago;
import cl.codo.fernando.modelo.Usuario;
import cl.codo.fernando.modelo.Venta;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
                            boleta.setFecha(rs.getString("fecha"));
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
                            boleta.setFecha(rs.getString("fecha"));
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

    
    public boolean guardar(Empresa empresa) {
        boolean resultado = false;
        try {
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

                boolean update = false;
                if ( pago.getIdPago()!= null) {
                    if (pago.getIdPago() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";

                    query = "INSERT INTO pago (fechavencimiento,monto,estado,idbolta,idfactoring) VALUES (?, ?,?,?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, pago.getFechaVencimiento());
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
                logger.info("ERROR: usuaio nulo");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar usuario", e);
        }
        return resultado;
    }
       public boolean guardar(Mantencion mantencion) {
        boolean resultado = false;
        try {
            if (mantencion != null) {
                // Conectamos si no está conectado
                if (!isConectado()) {
                    conectar();
                }

                boolean update = false;
                if ( mantencion!= null) {
                    if (mantencion.getIdmantencion()> 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";

                    query = "INSERT INTO mantencion (fechainicio,fechafin,lugarl,detalle,comentario,idboleta) VALUES (?, ?,?,?,?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, mantencion.getFechainicio());
                    st.setString(2, mantencion.getFechafin());
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
                logger.info("ERROR: usuaio nulo");
            }
        } catch (Exception e) {
            resultado = false;
            logger.error(e.toString());
            logger.debug("Error al guardar usuario", e);
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

                boolean update = false;
                if ( venta!= null) {
                    if (venta.getIdventa() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";

                    query = "INSERT INTO venta (cantidad,proveedor,preciocompra,precioventa,producto,idboleta) VALUES (?, ?,?,?,?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, venta.getCantidad());
                    st.setString(2, venta.getProveedor());
                    st.setFloat(3, venta.getPreciocompra());
                    st.setFloat(4,venta.getPrecioventa());
                    st.setString(5, venta.getProducto());
                    st.setInt(5, venta.getIdboleta());

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
                if (boleta.getIdempresa() != null) {
                    if (boleta.getIdempresa() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE boleta SET , fecha=?, idempresa = ? WHERE idboleta=?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, boleta.getFecha());
                    st.setInt(2, boleta.getIdempresa());
                    st.setInt(3, boleta.getIdboleta());
                } else {
                    query = "INSERT INTO boleta (idboleta,fecha, idempresa) VALUES ( ?,?, ?)";
                    st = conexion.prepareStatement(query);
                    st.setInt(1, boleta.getIdboleta());
                    st.setString(2, boleta.getFecha());
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

