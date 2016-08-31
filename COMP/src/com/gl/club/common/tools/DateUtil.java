package com.gl.club.common.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 
 * <b>类名：</b>DateUtil.java<br>
 * <p><b>标题：</b>球会在线管理平台</p>
 * <p><b>描述：</b>时间处理封装类 </p>
 * <p><b>版权声明：</b>Copyright (c) 2016</p>
 * <p><b>公司：</b>上海格灵信息科技有限公司 </p>
 * @author <font color='blue'>张祥</font> 
 * @version 2.0.1
 * @date  2016-6-30 上午10:45:51
 */
public class DateUtil {


	public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";

	public static final String ISO_EXPANDED_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	// 格式化查询时间yyyy-mm-dd hh24:mi:ss
	public static String formatQueryTime(String queryTimeField) {
		
		//return "to_char(" + queryTimeField + ",'yyyy-mm-dd hh24:mi:ss')  ";//oracle
		return "date_format(" + queryTimeField + ",'%Y-%m-%d')  ";//mysql
		
	}

	// 指定开始时间从" 00:00:00";
	public static String getStartTime(String startTime) {
		return startTime + " 00:00:00";
	}

	// 指定结束时间到" 23:59:59";
	public static String getEndTime(String endTime) {
		return endTime + " 23:59:59";
	}

	// 获取当前年度的下一年度
	public static int getNextYear(int year) {
		return year + 1;
	}

	// 根据年度获取第一天日期(yyyy-MM-dd)
	public static String getYearFristDay(int year) {
		return String.valueOf(year) + "-01-01";
	}

	// 根据年度获取最后一天日期(yyyy-MM-dd)
	public static String getYearLastDay(int year) {
		return String.valueOf(year) + "-12-31";
	}
	
	public static String formatDateForSolr(Date date){
		 SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 
		 outFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		 return  outFormat.format(date);
	}

	// 日期格式化
	public static String formatDate(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
		return outFormat.format(date);
	}
	
	// 日期格式化
	public static String formatTime(Date date,String timeStr) {
		SimpleDateFormat outFormat = new SimpleDateFormat(timeStr);
		return outFormat.format(date);
	}

	// 日期格式化
	public static String formatDateTwo(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy年MM月dd日");
		return outFormat.format(date);
	}
	
	//格式化字符串
	public static Date formatDateStr(String dateStr, String formatStr) {
		SimpleDateFormat outFormat = new SimpleDateFormat(formatStr);
		try {
			return outFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	// 日期格式化
	public static String formatDateThree(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm:ss");
		return outFormat.format(date);
	}

	// 日期格式化
	public static String formatDateTime(Date date) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return outFormat.format(date);
	}

	// 返回指定日期指定天数之前的日期
	public static String dateBefore(Date date1, int cut) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, cut);
		return outFormat.format(calendar.getTime());
	}
	
	// 返回指定日期指定天数之前的日期
	public static String dateBeforeSimple(Date date1, int cut) {
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, cut);
		return outFormat.format(calendar.getTime());
	}
	// 计算两个日期之间相差的天数[date1-date2]
	public static int diffDateDays(String date1, String date2) throws Exception {
		if ("".equals(date1) || "".equals(date2))
			return 0;
		int result = 0;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = df.parse(date1), d2 = df.parse(date2);
			long dt1 = d1.getTime(), dt2 = d2.getTime();
			result = (int) ((dt1 - dt2) / (1000 * 60 * 60 * 24));
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}

	// 计算两个日期之间相差的天数[date1-date2]
	public static int diffDateDays(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return 0;
		}
		long dt1 = date1.getTime(), dt2 = date2.getTime();

		return (int) ((dt1 - dt2) / (1000 * 60 * 60 * 24));
	}

	/**
	 * 
	 * @Title: getMonthSpace
	 * @Description: 求2个日期之间间隔月数
	 * @author：束文奇
	 * @date 2015-7-27 下午01:35:01
	 * @param dateStart 开始时间
	 * @param dateEnd	结束时间
	 * @return
	 * @throws ParseException  
	 * @throws
	 */
	public static int getMonthSpace(Date dateStart, Date dateEnd) throws ParseException {

		int result;

		Calendar calendarStart = Calendar.getInstance();
		Calendar calendarEnd = Calendar.getInstance();

		calendarStart.setTime(dateStart);
		calendarEnd.setTime(dateEnd);
		// 同年同月
		if (calendarStart.get(Calendar.YEAR) == calendarEnd.get(Calendar.YEAR) && calendarStart.get(Calendar.MONTH) == calendarEnd.get(Calendar.MONTH)) {
			result = 0;
			// 同年不同月
		} else if (calendarStart.get(Calendar.YEAR) == calendarEnd.get(Calendar.YEAR) && calendarStart.get(Calendar.MONTH) != calendarEnd.get(Calendar.MONTH)) {
			result = Math.abs(calendarEnd.get(Calendar.MONTH) - calendarStart.get(Calendar.MONTH));
			// 不同年同月
		} else if (calendarStart.get(Calendar.YEAR) != calendarEnd.get(Calendar.YEAR) && calendarStart.get(Calendar.MONTH) == calendarEnd.get(Calendar.MONTH)) {
			result = Math.abs(calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR)) * 12;
			// 不同年不同月
		} else {
			result = Math.abs(calendarEnd.get(Calendar.YEAR) - calendarStart.get(Calendar.YEAR)) * 12 + calendarEnd.get(Calendar.MONTH) - calendarStart.get(Calendar.MONTH);
		}

		return Math.abs(result);

	}

	// 根据日期获取星期几
	public static String getWeekOfDate(String dates) throws ParseException {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	// 根据日期获取星期几
	public static String getWeekOfDate(Date date) throws ParseException {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return weekDays[w];
	}

	// 根据星期几获取是否为周日
	public static String checkStatusByWeek(String weeks) {
		String status = "1";
		if ("星期一".equals(weeks)) {
			status = "1";
		}
		if ("星期二".equals(weeks)) {
			status = "1";
		}
		if ("星期三".equals(weeks)) {
			status = "1";
		}
		if ("星期四".equals(weeks)) {
			status = "1";
		}
		if ("星期五".equals(weeks)) {
			status = "1";
		}
		if ("星期六".equals(weeks)) {
			status = "2";
		}
		if ("星期日".equals(weeks)) {
			status = "2";
		}
		return status;
	}

	// 返回给定日期的年
	public static int getYear(String dates) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);

		Calendar cld = Calendar.getInstance();
		cld.setTime(date);

		return cld.get(Calendar.YEAR);
	}

	// 返回给定日期的月
	public static int getMonth(String dates) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);

		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.MONTH) + 1;
	}

	// 返回给定日期的日
	public static int getDay(String dates) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dates);

		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.DAY_OF_MONTH);
	}

	// 返回给定日期的日
	public static int getDay(Date date) throws ParseException {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.DAY_OF_MONTH);
	}

	// 返回当前年
	public static int getCurrentYear() {
		return getYear(new Date());
	}

	// 返回当前月
	public static int getCurrentMonth() {
		return getMonth(new Date());
	}

	// 返回给定日期的年份
	public static int getYear(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.YEAR);
	}

	// 返回给定日期的月份
	public static int getMonth(Date date) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		return cld.get(Calendar.MONTH) + 1;
	}

	/**
	 * getCurrTimeSomeYearString(这里用一句话描述这个方法的作用)
	 * @Title: getCurrTimeSomeYearString
	 * @Description: 获取多年后的今天 返回字符串
	 * @param year 年  可为负
	 * @return  传入参数
	 * @throws
	 */
	private static String getCurrTimeSomeYearString(int year) {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar canlandar = Calendar.getInstance();
		canlandar.setTime(date);
		canlandar.add(Calendar.YEAR, year);
		return df.format(canlandar.getTime()).toString();
	}

	/**
	 * getCurrTimeSomeYearString(这里用一句话描述这个方法的作用)
	 * @Title: getCurrTimeSomeYearString
	 * @Description: 获取多年后的今天 返回 java.util.Date
	 * @param year 年  可为负
	 * @return  传入参数
	 * @throws
	 */
	public static Date getCurrTimeSomeYearDate(int year) {
		String source = DateUtil.getCurrTimeSomeYearString(year);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return df.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getMinuteInterval(这里用一句话描述这个方法的作用)
	 * @Title: getMinuteInterval
	 * @Description: 获得两时间的分钟间隔
	 * @param date1  开始时间
	 * @param date2  结束时间
	 * @return  传入参数
	 * @throws
	 */
	public static Long getMinuteInterval(Date date1, Date date2) {
		long minutes = 0;
		minutes = (date2.getTime() - date1.getTime()) / 1000 / 60;
		return minutes;
	}

	/**
	 * getMinuteInterval(这里用一句话描述这个方法的作用)
	 * @Title: getMinuteInterval
	 * @Description: 获得两时间的分钟间隔
	 * @param date1  开始时间
	 * @param date2  结束时间
	 * @return  传入参数
	 * @throws
	 */
	public static Long getMinuteInterval(String date1, String date2) {
		long minutes = (getGregorianCalendar(date2).getTimeInMillis() - getGregorianCalendar(date1).getTimeInMillis()) / 1000 / 60;
		return minutes;
	}

	/**
	 * getInterval(这里用一句话描述这个方法的作用)
	 * @Title: getInterval
	 * @Description: 获得两时间的秒间隔
	 * @param date1  开始时间
	 * @param date2  结束时间
	 * @return  传入参数   
	 * @throws
	 */
	public static Long getSecondInterval(String date1, String date2) {
		long minutes = (getGregorianCalendar(date2).getTimeInMillis() - getGregorianCalendar(date1).getTimeInMillis()) / 1000;
		return minutes;
	}

	/**
	 * getInterval(这里用一句话描述这个方法的作用)
	 * @Title: getInterval
	 * @Description: 获得两时间的秒间隔
	 * @param date1  开始时间
	 * @param date2  结束时间
	 * @return  传入参数   
	 * @throws
	 */
	public static Long getSecondInterval(Date date1, Date date2) {
		long minutes = (date2.getTime() - date1.getTime()) / 1000;
		return minutes;
	}

	/**
	 * getGregorianCalendar(这里用一句话描述这个方法的作用)
	 * @Title: getGregorianCalendar
	 * @Description: 通过字符串转换成GregorianCalendar对象       yyyy-MM-dd HH:mm:ss
	 * @param strDateTime
	 * @return  传入参数
	 * @throws
	 */
	public static GregorianCalendar getGregorianCalendar(String strDateTime) {
		SimpleDateFormat timeFormat = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		Date date = new Date();
		GregorianCalendar calendar = new GregorianCalendar();
		try {
			if (isValidateString(strDateTime)) {
				date = timeFormat.parse(strDateTime);
				date = new Date(date.getTime());
				calendar.setTime(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return calendar;
	}

	/**
	 * getDate(这里用一句话描述这个方法的作用)
	 * @Title: getDate
	 * @Description: 通过字符串获取Date对象
	 * @param strDateTime
	 * @return  传入参数
	 * @throws
	 */
	public static Date getDate(String strDateTime) {

		SimpleDateFormat timeFormat = new SimpleDateFormat(strDateTime.length() > 10 ? ISO_EXPANDED_DATETIME_FORMAT : ISO_EXPANDED_DATE_FORMAT);
		Date date = null;
		try {
			if (isValidateString(strDateTime)) {
				date = timeFormat.parse(strDateTime);
				date = new Date(date.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static boolean isValidateString(String strTemp) {
		boolean b = false;
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = true;
		}
		return b;
	}

	/**
	 * 日期增加-按月增加
	 * 
	 * @param date
	 * @param days
	 * @return java.util.Date
	 */
	public static Date dateIncreaseByMonth(Date date, int mnt) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, mnt);

		return c.getTime();
	}

	/**
	 * 
	 * dateIncreaseByDay(这里用一句话描述这个方法的作用)
	 *
	 * @Title: dateIncreaseByDay
	 * @Description: 日期增加-按日增加
	 * @author：束文奇
	 * @date 2015-7-27 下午01:17:52
	 * @param date 日期
	 * @param day 增加或减少天数
	 * @return  
	 * @throws
	 */
	public static Date dateIncreaseByDay(Date date, int day) {

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, day);

		return c.getTime();
	}

	/*
	 * 获得周六的日期 2007-08-25
	 */
	public static String getSaturday(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		return new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT).format(c.getTime());

	}

	/**
	 * MonthMove(这里用一句话描述这个方法的作用)
	 * @Title: MonthMove
	 * @Description: 日期增加 月份增加      可跨年
	 * @param startDate
	 * @param monthNum
	 * @return  传入参数
	 * @throws
	 */
	public static String moveMonth(String startDate, int monthNum) {
		String resultDate;
		resultDate = "";
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
			calendar.setTime(sdf.parse(startDate));
			calendar.add(Calendar.MONTH, monthNum);
			calendar.add(Calendar.DATE, 0);
			Date date = calendar.getTime();
			resultDate = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		return resultDate;
	}

	/**
	 * @Title: afterMonth
	 * @author:徐飞
	 * @Description: 获得指定日期的下几个月的日期
	 * @param date 指定起始日期 [2014-07-31 11:49:10]
	 * @param next 指定间隔月数 [2]
	 * @return 返回间隔后的日期 [2015-09-30 11:49:10]
	 * @throws
	 */
	public static Date afterMonth(Date date, Integer next) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, next);
		return c.getTime();
	}

	/**
	 * @Title: nextDay
	 * @author:徐飞
	 * @Description: 获得下一天的时间
	 * @param date
	 * @return 
	 * @throws
	 */
	public static Date nextDay(Date date) {
		return new Date(date.getTime() + 24 * 60 * 60 * 1000);
	}

	/**
	 * 
	 * @方法名：取得指定日期的最小时间（yyyy-MM-dd 0:0:0）
	 * @author xuf
	 * @date Dec 19, 2013 11:16:22 AM
	 * @return
	 */
	public static Date getMintimeOfDay(Date date) {
		Calendar min = Calendar.getInstance();
		min.setTime(date);
		min.set(Calendar.HOUR_OF_DAY, min.getActualMinimum(Calendar.HOUR_OF_DAY));
		min.set(Calendar.MINUTE, min.getActualMinimum(Calendar.MINUTE));
		min.set(Calendar.SECOND, min.getActualMinimum(Calendar.SECOND));
		min.set(Calendar.MILLISECOND, min.getActualMinimum(Calendar.MILLISECOND));
		return min.getTime();
	}

	/**
	 * 
	 * @方法名：取得指定日期的最大时间（yyyy-MM-dd 23:59:59）
	 * @author xuf
	 * @date Dec 19, 2013 11:16:22 AM
	 * @return
	 */
	public static Date getMaxtimeOfDay(Date date) {
		Calendar max = Calendar.getInstance();
		max.setTime(date);
		max.set(Calendar.HOUR_OF_DAY, max.getActualMaximum(Calendar.HOUR_OF_DAY));
		max.set(Calendar.MINUTE, max.getActualMaximum(Calendar.MINUTE));
		max.set(Calendar.SECOND, max.getActualMaximum(Calendar.SECOND));
		max.set(Calendar.MILLISECOND, max.getActualMaximum(Calendar.MILLISECOND));
		return max.getTime();
	}

	/**
	 * getDaysOFDate	 
	 *
	 * @Title: getDaysOFDate
	 * @Description: 返回给定日期所在的月数的总的天数
	 * @author oaoCoder-李广
	 * @date 2015-9-2 下午04:19:06
	 * @version V1.0
	 * @param date
	 * @return  传入参数
	 * @throws
	 */
	public static int getDaysOFDate(Date date) {
		Calendar max = Calendar.getInstance();
		max.setTime(date);
		return max.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static String getBeginDateTimeFromDate(String strDate) {
		return validateString(strDate) + " 00:00:00";
	}

	public static String getEndDateTimeFromDate(String strDate) {
		return validateString(strDate) + " 23:59:59 ";
	}

	public static String validateString(String strTemp) {
		String b = "";
		if ((strTemp != null) && (!(strTemp.trim().equals(""))) && (!(strTemp.trim().equalsIgnoreCase("null")))) {
			b = strTemp;
		}
		return b.trim();
	}

	/**
	 * 
	 *
	 * @Title: getTodaySurplusSecond
	 * @Description: 计算当前时间到零点剩余的秒数
	 * @return   传入参数
	 * @author   pm-陈鹏
	 * @createTime 2015-7-14 下午06:58:22
	 * @throws
	 */
	public static int getTodaySurplusSecond() {
		SimpleDateFormat sdf = new SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		String curtime = sdf.format(new Date());
		String date2 = curtime.substring(0, 11)+"23:59:59";
		int time = getSecondInterval(curtime,date2).intValue();
		return time+1;
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// System.out.println(getCurrTimeSomeYearString(-1));
		// TODO Auto-generated method stub
		/*
		int year = 2012;
		int nextYear = getNextYear(year);

		String fristDay = getYearFristDay(year);
		String nextYearFristDay = getYearFristDay(nextYear);
		
		int days = diffDateDays(nextYearFristDay,fristDay);

		String beforeDay = dateBefore(fristDay,1);
		
		for(int i=0;i<days;i++){
			String day = dateBefore(fristDay,i);
			String weeks = getWeekOfDate(day);
			int sYear = getYear(day);
			int sMonth = getMonth(day);
			int sDay = getDay(day);
			String isWeek = checkStatusByWeek(weeks);
			System.out.println(day+"    今天是"+weeks+"    年度是"+sYear+"    月份是"+sMonth+"    日期是"+sDay+"    是否为周末"+isWeek);
		}
		*/
		/*
		System.out.println();
		System.out.println();
		System.out.println(getYearFristDay("2011"));
		System.out.println(getYearLastDay("2011"));
		System.out.println(diffDateDays(nextYearFristDay,fristDay));
		System.out.println(beforeDay);
		System.out.println(nextYear);
		*/
		// System.out.println(nextYear);
		// Calendar c = Calendar.getInstance();
		// c.add(Calendar.MONTH, 2);
		// SimpleDateFormat timeFormat = new
		// SimpleDateFormat(ISO_EXPANDED_DATETIME_FORMAT);
		// System.out.println(timeFormat.format(c.getTime()));

		Date dateStart = new Date();
		Date dateEnd = DateUtil.getDate("2015-11-1 13:34:35");
		System.out.println(DateUtil.getMonthSpace(dateStart, dateEnd));
	}
	
}
