package com.lottery.lotteryweb.common.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateUtils {

    private static final String yyyyMMddHHmmss = "yyyy/MM/dd HH:mm:ss";
    private static final String yyyy_MM_ddHHmmss = "yyyy-MM-dd HH:mm:ss";
    private static final String yyyy_MM_dd = "yyyy-MM-dd";
    private static final String MM = "MM月";
    private static final String yyyyMM = "yyyy年MM月";
    private static final String YYYYMMDD = "yyyy年MM月dd日";
    private static final String YYYY = "yyyy";

    public static String yyyyMMddHHmmss(LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern(yyyyMMddHHmmss).format(localDateTime);
    }

    public static Long timeAgoInSeconds(LocalDateTime fromDate) {

        return Duration.between(fromDate, LocalDateTime.now()).getSeconds();
    }

    public static String dateFormatMM(Date date, String title) {
        return new SimpleDateFormat(MM + title).format(date);
    }

    public static String yyyyMMDateFormat(Date date) {
        return new SimpleDateFormat(yyyyMM).format(date);
    }

    public static String yyyyMMddDateFormat(final Date date) {
        if (date == null) {
            return null;
        }

        return new SimpleDateFormat(YYYYMMDD).format(date);
    }

    public static String yyyyMMddDateFormat(final LocalDateTime localDateTime) {
        return DateTimeFormatter.ofPattern(YYYYMMDD).format(localDateTime);
    }

    public static final Integer ONE = 1;

    /**
     * Today
     * @return LocalDate
     */
    private static LocalDate today() {
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        return LocalDate.now(zoneId);
    }

    /**
     * Get next month day in yyyy年MM月dd日
     * @return yyyy年MM月dd日
     */
    public static String getYearMonthDayOfNextMonth() {

        return today().plusMonths(ONE).format(DateTimeFormatter.ofPattern(YYYYMMDD));
    }

    /**
     * Get current year
     * @return year in String
     */
    public static String getCurrentYear() {
        return today().format(DateTimeFormatter.ofPattern(YYYY));
    }

    public static String yyyyMMDateFormat (final String date) {
        return date.substring(0, 4) + "年" + date.substring(4, 6) + "月";
    }

    public static String changeLocalDateToString (final LocalDate localDate) {
        return DateTimeFormatter.ofPattern("yyyyMM").format(localDate);
    }

    // String（yyyy-MM-dd）-> Date
    public static java.util.Date toDateFromString(String str) {
        java.util.Date date = new java.util.Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(str);
        } catch(ParseException e) {
            System.err.println(e.getMessage());
        }
        return date;
    }

    // Date -> String（yyyy-MM-dd）
    public static String toStringFromDate(java.util.Date date)  {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    // 本日のLocalDate文字列を取得（yyyy-MM-dd）
    public static String getLocalDateTodayString () {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(yyyy_MM_dd);
        return localDate.format(dtf);
    }

    // 対象日付の文字列からLocalDateTimeにして対象日を返す(デフォルトは前日）主にAnalytics系で利用している
    public static LocalDateTime getTargetDatetime (String dateString) {
        // 引数がなければ前日を代入
        if ("".equals(dateString)) {
            // 前日にする
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            dateString = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        }

        return DateUtils.toLocalDateTime(dateString, yyyy_MM_ddHHmmss);
    }

    // String -> LocalDateTime (yyyy-MM-dd HH:mm:ss)
    public static LocalDateTime toLocalDateTime(String dateString, String format) {
        dateString = dateString.replaceAll("/", "-").substring(0, 10) + " 00:00:00";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateString, dtf);
    }

    // LocalDate -> java.util.Date
    public static java.util.Date getDateFromLocalDate(final LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // LocalDateTime -> java.util.Date
    public static java.util.Date getDateFromLocalDateTime(final LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zone);
        Instant instant = zonedDateTime.toInstant();
        return java.util.Date.from(instant);
    }

    // UTCのLocalDateTime -> JSTのString(LocalDate) （メール文章に使用)
    public static String getTargetDateToString (LocalDateTime utcLocalDateTime) {

        // JSTの時間に変更して返す
        return utcLocalDateTime.with(LocalTime.of(9, 0)).toLocalDate().toString();
    }
}

