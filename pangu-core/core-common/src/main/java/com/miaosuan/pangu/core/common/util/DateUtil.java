package com.miaosuan.pangu.core.common.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.miaosuan.pangu.core.common.enums.WeekEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期工具
 *
 * @author spy
 * @version 1.0 2019-06-09
 * @since 1.0
 */
@Slf4j
public class DateUtil {
    /**
     * 默认日期格式
     */
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DAY_FORMAT = "yyyy-MM-dd";
    public static final String DAY_FORMAT2 = "yyyyMMdd";
    public static final String DATETIME_FORMAT = "yyyyMMddHHmmss";
    public static final String DATETIME_FORMAT2 = "yyyyMMddHHmmssSSS";

    public static final String OUTPUT_FORMAT = "yyyy年MM月dd日";

    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_FORMAT2 = "HHmmss";
    public static final String TIME_FORMAT3 = "HH:mm";

    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    public static final String FORMAT_YMD_HMS = "yyyy年MM月dd日HH时mm分ss秒";


    private static final String SPLIT_COLON = ":";
    private static final String SPLIT_HYPHEN = "-";

    private static final int LENGTH_19 = 19;
    private static final int LENGTH_17 = 17;
    private static final int LENGTH_15 = 15;
    private static final int LENGTH_11 = 11;
    private static final int LENGTH_2 = 2;


    /**
     * <默认构造函数>
     */
    private DateUtil() {
    }

    /**
     * <字符串转换成日期>
     * <如果转换格式为空，则利用默认格式进行转换操作>
     *
     * @param str    字符串
     * @param format 日期格式
     * @return 日期
     * @see [类、类#方法、类#成员]
     */
    public static Date strDate(String str, String format) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }

        DateTime dateTime = DateTime.parse(str, DateTimeFormat.forPattern(format));
        return dateTime.toDate();
    }

    public static Date strDate(String str) {
        return strDate(str, null);
    }

    /**
     * <一句话功能简述>
     * <功能详细描述>
     *
     * @param date   日期
     * @param format 日期格式
     * @return 字符串
     * @see [类、类#方法、类#成员]
     */
    public static String dateStr(Date date, String format) {
        if (null == date) {
            return null;
        }
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format);
    }

    /**
     * <时间戳转换为字符串>
     * <功能详细描述>
     *
     * @param time
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String timestampStr(Timestamp time) {
        Date date = new Date(time.getTime());
        return dateStr(date, DEFAULT_FORMAT);
    }

    /**
     * <一句话功能简述>
     * <功能详细描述>
     *
     * @param str
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static Timestamp strTimestamp(String str) {
        Date date = strDate(str, DEFAULT_FORMAT);
        return new Timestamp(date.getTime());
    }

    /**
     * 获取两个日期之间相差分钟,包含当前分钟
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDifMinutes(Date beginDate, Date endDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.clear();
        calendar1.setTime(beginDate);

        calendar2.clear();
        calendar2.setTime(endDate);

        long diffMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
//		long diffSeconds = diffMillis / 1000;
		long diffMinutes = diffMillis / (60 * 1000);
//		long diffHours = diffMillis / (60 * 60 * 1000);
//        long diffDays = diffMillis / (24L * 60 * 60 * 1000);

        return diffMinutes+1;
    }

    /**
     * 获取两个日期之间相差天数,包含两个日期当天
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static long dateDifDays(Date beginDate, Date endDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.clear();
        calendar1.setTime(beginDate);

        calendar2.clear();
        calendar2.setTime(endDate);

        long diffMillis = calendar2.getTimeInMillis() - calendar1.getTimeInMillis();
//		long diffSeconds = diffMillis / 1000;
//		long diffMinutes = diffMillis / (60 * 1000);
//		long diffHours = diffMillis / (60 * 60 * 1000);
        long diffDays = diffMillis / (24L * 60 * 60 * 1000);

        return diffDays + 1;
    }

    public static Date getNextDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static Date getPreDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static Date getDate(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, n);
        return calendar.getTime();
    }

    public static Date getCurrentDateWithOutTimeStamp() {
        return DateUtil.strDate(DateUtil.dateStr(new Date(), DEFAULT_DATE_FORMAT), DEFAULT_DATE_FORMAT);
    }

    /**
     * 格式化到秒 <br />
     * 如果为null,则返回null
     *
     * @param date
     * @return
     */
    public static String toYMDHMS(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(DEFAULT_FORMAT);
    }

    /**
     * 格式化到日 <br />
     * 如果为null,则返回null
     *
     * @return
     */
    public static String now() {
        return new DateTime().toString(DAY_FORMAT);
    }

    /**
     * 今日日期
     *
     * @return
     */
    public static String today() {
        return new DateTime().toString(DAY_FORMAT);
    }

    public static String toYMD(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(DAY_FORMAT);
    }

    public static String toIntYMD(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(DAY_FORMAT2);
    }

    public static String toYMDHMSNoPoint(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(DATETIME_FORMAT);
    }


    public static String toHMS(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(TIME_FORMAT);
    }

    public static String toIntHMS(Date date) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(TIME_FORMAT2);
    }

    public static String toString(Date date, String format) {
        if (date == null) {
            return null;
        }

        return new DateTime(date).toString(format);
    }

//    public static String addDay(Date date, int duration) {
//        if (date == null) {
//            return null;
//        }
//
//        return new DateTime(date).plus(duration).toString(DAY_FORMAT);
//    }

    /**
     * 计算 day 天后的时间
     *
     * @param date
     * @param day
     * @return
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static String toYMD(String date) {
        if (date == null || "".equals(date)) {
            return null;
        }

        long time = 0;
        try {
            time = Long.parseLong(date);
        } catch (Exception e) {
        }

        return new DateTime(new Date(time)).toString(DEFAULT_FORMAT);
    }

    public static DateTime parseToDateTime(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        return DateTime.parse(date);
    }

    public static DateTime parseToDateYMDHMS(String date) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        date = StringUtils.trim(date);
        if (date.contains(SPLIT_COLON)) {
            return format(date, DEFAULT_FORMAT);
        } else if (date.contains(SPLIT_HYPHEN)) {
            return format(date, DAY_FORMAT);
        } else {
            return format(date, DAY_FORMAT2);
        }
    }

    public static Date parseToDateYMDHMS(String date, String time) {
        if (StringUtils.isBlank(date)) {
            return null;
        }

        DateTime dtDate, dtTime;
        String sformat;
        date = StringUtils.trim(date);
        time = StringUtils.trim(time);

        if (StringUtils.isEmpty(date)) {
            return null;
        }
        if (StringUtils.isEmpty(time)) {
            return null;
        }

        if (date.contains(SPLIT_COLON)) {
            sformat = DEFAULT_FORMAT;
        } else if (date.contains(SPLIT_HYPHEN)) {
            sformat = DAY_FORMAT;
        } else {
            sformat = DAY_FORMAT2;
        }

        if (time.contains(SPLIT_COLON)) {
            sformat = sformat + " " + TIME_FORMAT;
        } else {
            sformat = sformat + " " + TIME_FORMAT2;
        }

        try {
            return format(date + " " + time, sformat).toDate();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static DateTime parseToDateYMD(String date) {
        return format(date, DAY_FORMAT);
    }

    public static String parseHumanDate(Date date) {
        return new DateTime(date).toString(OUTPUT_FORMAT);
    }

    public static DateTime format(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        try {
            return DateTimeFormat.forPattern(pattern).parseDateTime(date);
        } catch (Exception e) {
            //兼容以下几种情况
            //2017-11-05 14:19:48
            //20171105 14242018
            //1105 152840
            try {
                if (date.contains(SPLIT_HYPHEN) && date.contains(SPLIT_COLON) && date.trim().length() == LENGTH_19) {
                    //2017-11-05 14:19:48
                    return DateTimeFormat.forPattern(DEFAULT_FORMAT).parseDateTime(date);
                } else if (!date.contains(SPLIT_HYPHEN) && !date.contains(SPLIT_COLON) && date.trim().length() == LENGTH_17) {
                    //20171105 14242018
                    return DateTimeFormat.forPattern("yyyyMMdd HHmmssSS").parseDateTime(date);
                } else if (!date.contains(SPLIT_HYPHEN) && !date.contains(SPLIT_COLON) && date.trim().length() == LENGTH_15) {
                    //20171105 14242018
                    return DateTimeFormat.forPattern("yyyyMMdd HHmmss").parseDateTime(date);
                } else if (!date.contains(SPLIT_HYPHEN) && !date.contains(SPLIT_COLON) && date.trim().length() == LENGTH_11) {
                    //1105 152840
                    return DateTimeFormat.forPattern("yyyyMMdd HHmmss").parseDateTime(new DateTime().toString("yyyy") + date);
                }
            } catch (Exception e1) {
                log.warn("format date fail. data:{" + date + "},format:{" + pattern + "}. exception:{" + e + "}");
                return null;
            }

            log.warn("format date fail. data:{" + date + "},format:{" + pattern + "}. exception:{" + e + "}");
            return null;
        }
    }

    public static DateTime truncate(Date date) {
        return new DateTime(org.apache.commons.lang.time.DateUtils.truncate(date, Calendar.DATE));
    }

    /**
     * 生成只到天的时间，保留精度到天
     */
    public static Date truncDate(Date date) {

        DateTime dt = new DateTime(date);

        return dt.withTimeAtStartOfDay().toDate();
    }

    public static long getCurrentMillis() {
        return DateTime.now().getMillis();
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        return truncDate(date1).getTime() == truncDate(date2).getTime();
    }


    /**
     * @param sDate 格式 yyyy-MM-dd
     * @return
     */
    public static Date parseToDate(String sDate) {
        if (StringUtils.isBlank(sDate)) {
            return null;
        }
        String sDateTemp = null;
        String sTime = null;
        switch (sDate.split(" ").length) {
            case 1:
                return parseToDate(sDate, sTime);
            case 2:
                sDateTemp = sDate.split(" ")[0];
                sTime = sDate.split(" ")[1];
                return parseToDate(sDateTemp, sTime);
            default:
                return null;

        }
    }


    /**
     * @param sDate 格式 yyyy-MM-dd
     * @param sTime 格式 HH:mm:ss
     * @return
     */
    public static Date parseToDate(String sDate, String sTime) {
        if (StringUtils.isBlank(sDate)) {
            return null;
        }

        if (StringUtils.isBlank(sTime)) {
            sTime = "00:00:00";
        } else {
            if (sTime.lastIndexOf(SPLIT_COLON) == sTime.length() - 1) {
                sTime = sTime.substring(0, sTime.length() - 1);
            }
            switch (sTime.split(SPLIT_COLON).length) {
                case 1:
                    sTime = sTime + ":00:00";
                    break;
                case 2:
                    sTime = sTime + ":00";
                    break;
                default:
                    break;
            }

        }

        String strDate = sDate.trim() + " " + sTime.trim();
        return strDate(strDate, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parseToDate(String sDate, String sTime, String sDatePattern, String sTimePattern) {
        if (StringUtils.isBlank(sDate)) {
            return null;
        }

        if (StringUtils.isBlank(sTime)) {
            return null;
        }

        String strDate = sDate.trim() + " " + sTime.trim();
        return strDate(strDate, sDatePattern + " " + sTimePattern);
    }


    /**
     * get offset day from today, clear the hour, min, sec, millsec
     */
    public static Date getTodayOffSet(int offSet) {

        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, offSet);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date string2Date(String date) {
        Preconditions.checkNotNull(date, "date不能为空");
        return strDate(date, DAY_FORMAT);
    }

    public static String formatDate2YMD(Date date) {
        return dateStr(date, DAY_FORMAT);
    }


    /**
     * 凌晨
     *
     * @param date
     * @return
     * @flag 0 返回yyyy-MM-dd 00:00:00日期<br>
     * 1 返回yyyy-MM-dd 23:59:59日期
     */
    public static Date weeHours(Date date, int flag) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        //时分秒（毫秒数）
        long millisecond = hour * 60 * 60 * 1000 + minute * 60 * 1000 + second * 1000;
        //凌晨00:00:00
        cal.setTimeInMillis(cal.getTimeInMillis() - millisecond);

        if (flag == 0) {
            return cal.getTime();
        } else if (flag == 1) {
            //凌晨23:59:59
            cal.setTimeInMillis(cal.getTimeInMillis() + 23 * 60 * 60 * 1000 + 59 * 60 * 1000 + 59 * 1000);
        }
        return cal.getTime();
    }

    /**
     * start和end之间的日期，包含start和end
     * 例如：
     * start:2017/03/02 12:00:00
     * end :2017/03/04 13:00:00
     * 返回的list为03/02、03/03、03/04
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> betweenDays(Date start, Date end) {
        if (start.after(end)) {
            return Lists.newArrayList();
        }

        List<String> returnBetweentDaysList = Lists.newArrayList();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        returnBetweentDaysList.add(dateStr(start, DEFAULT_DATE_FORMAT));

        while (true) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.getTime().compareTo(end) == -1 || calendar.getTime().compareTo(end) == 0) {
                returnBetweentDaysList.add(dateStr(calendar.getTime(), DEFAULT_DATE_FORMAT));
            } else {
                break;
            }
        }

        return returnBetweentDaysList;
    }

    public static List<String> betweenDays(Date start, Date end, String dateFormat) {
        if (start.after(end)) {
            return Lists.newArrayList();
        }

        List<String> returnBetweentDaysList = Lists.newArrayList();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        returnBetweentDaysList.add(dateStr(start, dateFormat));

        while (true) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.getTime().compareTo(end) == -1 || calendar.getTime().compareTo(end) == 0) {
                returnBetweentDaysList.add(dateStr(calendar.getTime(), dateFormat));
            } else {
                break;
            }
        }

        return returnBetweentDaysList;
    }


    /**
     * 比较时间必须在day天之前
     *
     * @param beginDate
     * @param endDate
     * @param day
     * @return
     */
    public static boolean compareDay(Date beginDate, Date endDate, Integer day) {
        //获取N天前的时间
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -day);
        Date date = cal.getTime();
        //获取N天前的23:59:59
        Date beforeTwoDay = DateUtil.weeHours(date, 1);
        if (endDate != null) {
            if (beginDate.compareTo(beforeTwoDay) > 0 || endDate.compareTo(beforeTwoDay) > 0 || beginDate.compareTo(endDate) > 0) {
                return false;
            }
        } else {
            if (beginDate.compareTo(beforeTwoDay) > 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * 尝试把一个String按照指定的多个pattern进行转换,转换成功返回结果,失败返回null,如果值为空直接返回null
     *
     * @param value    需要转换为日期的字符串
     * @param patterns 日期pattern数组
     * @return
     */
    public static Date tryStr2Date(String value, String[] patterns) {
        Validate.notEmpty(patterns, "patterns 不能为空");
        Date d = null;
        if (org.apache.commons.lang.StringUtils.isNotEmpty(value)) {
            for (String p : patterns) {
                try {
                    d = DateUtil.str2Date(value, p);
                    break;
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return d;
    }

    /**
     * 按指定格式将字符串转换为日期
     *
     * @param dateStr 日期串
     * @param pattern 格式
     * @return 日期
     */
    public static Date str2Date(String dateStr, String pattern) {
        return strDate(dateStr, pattern);
    }

    /**
     * start和end之间的时数，包含start和end
     * 例如：
     *
     * @param start
     * @param end
     * @return
     */
    public static List<String> betweenHous(Date start, Date end) {
        if (start.after(end)) {
            return Lists.newArrayList();
        }

        List<String> returnBetweentDaysList = Lists.newArrayList();

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        String formatStr = "yyyy-MM-dd HH";

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        returnBetweentDaysList.add(DateUtil.dateStr(start, formatStr));

        while (true) {
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            if (calendar.getTime().compareTo(end) == -1 || calendar.getTime().compareTo(end) == 0) {
                returnBetweentDaysList.add(DateUtil.dateStr(calendar.getTime(), formatStr));
            } else {
                break;
            }
        }

        return returnBetweentDaysList;
    }

    /**
     * 获取周
     * 例如：2017-09-11 返回 周一
     *
     * @param date
     * @return
     */
    public static String getWeek(String date) {
        DateTime dateTime = DateTime.parse(date, DateTimeFormat.forPattern(DEFAULT_DATE_FORMAT));
        return WeekEnum.getDescByType(dateTime.getDayOfWeek());
    }

    /**
     * 获取当前月的第一天
     */
    public static Date getFirstDay(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //当前月第一天
        return cal.getTime();
    }

    /**
     * 获取当前月的最后一天
     */
    public static Date getLastDay(String year, String month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //当前月最后一天
        return cal.getTime();
    }


    /**
     * 获取日历上显示的  第一天
     */
    public static Date getCalendarFirstDay(Date beginDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        while (calendar.get(Calendar.DAY_OF_WEEK) != LENGTH_2) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }

        return calendar.getTime();
    }

    /**
     * 获取日历上显示的最后一天
     */
    public static Date getCalendarEndDay(Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        while (calendar.get(Calendar.DAY_OF_WEEK) != 1) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return calendar.getTime();
    }


    /**
     * 校验日期格式是否合法
     *
     * @param str
     * @param format yyyy-MM-dd,  yyyyMMdd
     * @return
     */
    public static boolean isValidDate(String str, String format) {
        if (StringUtils.isEmpty(format) || StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            Date date = strDate(str, format);
            return str.equals(dateStr(date, format));
        } catch (Exception e) {
            return false;
        }
    }

    public static String now(String format) {
        if (StringUtils.isEmpty(format)) {
            format = DEFAULT_FORMAT;
        }
        return DateTime.now().toString(format);
    }

    public static Date nowDate() {
        return DateTime.now().toDate();
    }

    public static Integer thisYear() {
        LocalDateTime localDateTime = new LocalDateTime();
        return localDateTime.getYear();
    }

    public static Date getDayStartTime(Date date) {
        String str = dateStr(date, DAY_FORMAT) + " 00:00:00";
        return strDate(str, DEFAULT_FORMAT);
    }

    public static Date getDayEndTime(Date date) {
        String str = dateStr(date, DAY_FORMAT) + " 23:59:59";
        return strDate(str, DEFAULT_FORMAT);
    }
}
