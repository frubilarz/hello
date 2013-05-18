package cl.codo.fernando.utils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.annotation.PostConstruct;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.regexp.RE;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sebastián Salazar Molina <ssalazar@orangepeople.cl>
 */
public abstract class RutUtils implements Serializable {

    public final static String DEFAULT_RUT_PATTERN = "##.###.###-X";
    private static RE outRutRE = null;
    private static RE inRutRE = null;
    //private static RE outRutRE = new RE("([0\\#\\.\\,]+)([^X^x^\\,^\\.^9]*)([Xx]*)");
    //private static RE inRutRE = new RE("([0-9\\.]+)\\-([a-zA-Z0-9]+)");
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(RutUtils.class);

    @PostConstruct
    void iniciar() {
        try {
            if (outRutRE == null) {
                outRutRE = new RE("([0\\#\\.\\,]+)([^X^x^\\,^\\.^9]*)([Xx]*)");
            }

            if (inRutRE == null) {
                inRutRE = new RE("([0-9\\.]+)\\-([a-zA-Z0-9]+)");
            }
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug("Error al crear expresiones regulares", e);
        }
    }

    public static Integer parseRut(String value) {
        Integer result = null;
        if (value != null) {
            // Borramos los caracteres esperables
            String rut = StringUtils.remove(value, ".");
            rut = StringUtils.remove(rut, ",");
            rut = StringUtils.remove(rut, "-");
            // Separamos el numero y el digito verificador
            if (!StringUtils.isEmpty(rut) && rut.length() > 1 && rut.length() < 11) {
                String numRut = rut.substring(0, rut.length() - 1);
                String dv = rut.substring(rut.length() - 1).toUpperCase();
                if (NumberUtils.isDigits(numRut)) {
                    int intRut = Integer.parseInt(numRut);
                    if (dv.charAt(0) == getDV(intRut)) {
                        result = new Integer(intRut);
                    }
                }
            }
        }
        return result;
    }

    public static String formatRut(Number o) throws Exception {
        String pattern = DEFAULT_RUT_PATTERN;
        String formatedCheck = StringUtils.EMPTY;
        Number rut = (Number) o;
        if (rut != null) {

            // Validación
            if (outRutRE == null) {
                outRutRE = new RE("([0\\#\\.\\,]+)([^X^x^\\,^\\.^9]*)([Xx]*)");
            }

            if (inRutRE == null) {
                inRutRE = new RE("([0-9\\.]+)\\-([a-zA-Z0-9]+)");
            }

            String value = rut + "-" + getDV(rut.intValue());
            if (!(outRutRE.match(pattern))) {
                formatedCheck = "Inválido";
            }
            if (!(inRutRE.match(value))) {
                throw new Exception("Formato de entrada incorrecto:"
                        + rut);
            }
            String checkFmt = outRutRE.getParen(1);
            String valueCheck = inRutRE.getParen(1);
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            int indexGroupChar = checkFmt.indexOf(".") >= 0 ? checkFmt.indexOf(".") : checkFmt.indexOf(",");
            if (indexGroupChar >= 0) {
                dfs.setGroupingSeparator(checkFmt.charAt(indexGroupChar));
            }
            DecimalFormat df = null;
            if (indexGroupChar >= 0) {
                df = new DecimalFormat(checkFmt.replace(
                        checkFmt.charAt(indexGroupChar), ','), dfs);
            } else {
                df = new DecimalFormat(checkFmt, dfs);
            }
            df.setGroupingUsed(indexGroupChar >= 0);
            formatedCheck = df.format(Long.parseLong(valueCheck));
            String separator = outRutRE.getParen(2);
            if (!StringUtils.isEmpty(separator)) {
                formatedCheck = formatedCheck + separator;
            }
            String dv = outRutRE.getParen(3);
            if (!StringUtils.isEmpty(dv)) {
                formatedCheck = formatedCheck + inRutRE.getParen(2);
            }
        }
        return formatedCheck;
    }

    public static char getDV(int rut) {
        int M = 0, S = 1, T = rut;
        for (; T != 0; T /= 10) {
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        }
        return (char) (S != 0 ? S + 47 : 75);
    }

    public static String formatoExterno(Integer rut) {
        String formato = null;
        try {
            formato = formatRut(rut);
            formato = StringUtils.remove(formato, ".");
            formato = StringUtils.remove(formato, ",");
            formato = StringUtils.remove(formato, "-");

            if (formato.length() < 10) {
                formato = "0" + formato;
            }
        } catch (Exception ex) {
            formato = StringUtils.EMPTY;
            logger.error(ex.toString());
            logger.debug("Error al parsear formato", ex);
        }
        return formato;
    }

    public static boolean isRut(String rut) {
        boolean resultado = false;
        String formato = "";

        try {
            formato = StringUtils.remove(rut, ".");
            formato = StringUtils.remove(formato, ",");
            formato = StringUtils.remove(formato, "-");
            formato = formato.toUpperCase();

            String numeroStr = formato.substring(0, formato.length() - 1);
            Character digito = formato.charAt(formato.length() - 1);

            Integer numero = Integer.parseInt(numeroStr);
            if (digito == getDV(numero)) {
                resultado = true;
            }

        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug("Error al parsear rut", e);
        }

        return resultado;
    }

    public static String formatear(Integer rutNum) {
        String rut = "";
        try {
            Number numero = (Number) rutNum;
            rut = formatRut(numero);
        } catch (Exception e) {
            logger.error(e.toString());
            logger.debug("Error Al formatear", e);
        }
        return rut;
    }
}
