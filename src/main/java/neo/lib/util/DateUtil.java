package neo.lib.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import neo.lib.constant.Constants;

import org.springframework.util.StringUtils;

public final class DateUtil {
	
	/**
     * Get date string with format
     *
     * @param date
     * @param format
     * @return String
     */
    public static String parse(Date date)
    {
        if (date == null)
        {
            return null;
        }
        // create date format
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.YYYY_MM_DD);
        String dateStr = dateFormat.format(date);
        
        return dateStr;
    }
    
    /**
     * Get date string with format
     *
     * @param date
     * @param format
     * @return String
     */
    public static String parse(String date)
    {
        if (StringUtils.isEmpty(date))
        {
            return null;
        }
        
        return date;
    }
}
