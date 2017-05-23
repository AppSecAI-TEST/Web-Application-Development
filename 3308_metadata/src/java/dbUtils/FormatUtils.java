package dbUtils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;

/* FormatUtils: provides methods that know how to nicely format various data types, such as date or string. */
public class FormatUtils {

    // DecimalFormat percentFormat = new DecimalFormat("%###.##");
    public static String formatDate(Object obj) {
        String out = "<td style='text-align:center'>";
        if (obj == null) {
            out += "&nbsp;";
        } else {
            try {
                java.util.Date dateval = (java.util.Date) obj;
                SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
                dateformat.setLenient(false);
                out += dateformat.format(dateval);
            } catch (Exception e) {
                out += "bad date: " + e.getMessage();
            }
        }
        out += "</td>";
        return out;
    } // formatDate

    public static String formatDollar(Object obj) {
        String out = "<td style='text-align:right;'>";
        if (obj == null) {
            out += "&nbsp;";
        } else {
            try {
                BigDecimal bd = (BigDecimal) obj;
                DecimalFormat intFormat = new DecimalFormat("$###,###,###,##0.00");
                out += intFormat.format(bd);
            } catch (Exception e) {
                out += "bad Dollar Amount:" + obj.toString() + " Error:" + e.getMessage();
            }
        }
        out += "</td>";
        return out;
    } // formatDollar

    public static String formatInteger(Object obj) {
        String out = "<td style='text-align:right;'>";
        if (obj == null) {
            out += "&nbsp;";
        } else {
            try {
                Integer ival = (Integer) obj;
                DecimalFormat intFormat = new DecimalFormat("###,###,###,##0");
                out += intFormat.format(ival);
            } catch (Exception e) {
                out += "bad Integer:" + obj.toString() + " Error:" + e.getMessage();
            }
        }
        out += "</td>";
        return out;
    } // formatInteger

    public static String formatString(Object obj) {
        String converted;
        if (obj == null) {
            converted = "";
        } else {
            try {
                converted = obj.toString();
            } catch (Exception e) {
                converted = "Exception in FormatUtils.formatString(): " + e.getMessage();
            }
            if (converted.length() == 0) {
                converted = "&nbsp;";
            }
        }
        return "<td style='text-align:left;'>" + converted + "</td>";
    } // formatString
} // FormatUtils class

