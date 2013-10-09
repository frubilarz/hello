package cl.codo.fernando.utils;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public abstract class FechaUtils implements Serializable {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FechaUtils.class);

    public static String getFechaStr(Date fecha) {
        String fechaStr = "";
        try {
            String patron = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(patron);
            fechaStr = sdf.format(fecha);
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug(e.toString());
        }
        return fechaStr;
    }
    public static Date sumarDia(Date fecha, int dias)
    {
        Calendar cal=Calendar.getInstance();
        cal.setTime(fecha); 
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
    public static java.sql.Date getFechaSql(Date fecha) {
        java.sql.Date fechaSql = null;
        try {
            fechaSql = new java.sql.Date(fecha.getTime());
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug(e.toString());
        }
        return fechaSql;
    }

    public static Date getFecha(int anio) {
        Date fecha = null;
        try {
            Calendar calendario = new GregorianCalendar(anio, 1, 1);
            fecha = calendario.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug(e.toString());
        }
        return fecha;
    }
public static Date destringadate(String fecha)
{
    SimpleDateFormat formatodeltexto=new SimpleDateFormat("dd-MM-yyyy");
    Date fechaEnviar= null;
    try{
        fechaEnviar= formatodeltexto.parse(fecha);
        return fechaEnviar;
    }catch(ParseException ex){
        ex.printStackTrace();
        return null;
    }
}
    public static Date getFecha(int anio, int mes) {
        Date fecha = null;
        try {
            Calendar calendario = new GregorianCalendar(anio, mes, 1);
            fecha = calendario.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug(e.toString());
        }
        return fecha;
    }

    public static Date getFecha(int anio, int mes, int dia) {
        Date fecha = null;
        try {
            Calendar calendario = new GregorianCalendar(anio, mes, dia);
            fecha = calendario.getTime();
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug(e.toString());
        }
        return fecha;
    }
}
//hola mundo