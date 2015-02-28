package org.zigmoi.axon.commons.op;

/**
 * Created by Zigmoi-Code on 3/1/2015.
 */
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

public class DateTimeOp {

    public final static String DATE_FORMAT_CCYYMMDD = "yyyyMMdd";
    public final static String DATE_FORMAT_YYMMDD = "yyMMdd";
    public final static String TIME_FORMAT_HHMMSS = "Hmmss";

    public static
    boolean isLegalDate(String s, String pattern, boolean lenient) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        sdf.setLenient(lenient);
        return sdf.parse(s, new ParsePosition(0)) != null;
    }

    public static
    String getSysDateCCYYMMDD() {
        return new SimpleDateFormat(DATE_FORMAT_CCYYMMDD).format(new Date());
    }

    public static
    String getSysDateYYMMDD() {
        return new SimpleDateFormat(DATE_FORMAT_YYMMDD).format(new Date());
    }

    public static
    String getSysTimeHHMMSSMS() {
        String ms = new SimpleDateFormat("S").format(new Date());
        return StringUtils.leftPad(new SimpleDateFormat(TIME_FORMAT_HHMMSS).format(new Date())
                + StringUtils.leftPad(ms, 3, "0"), 9, "0");
    }
}
