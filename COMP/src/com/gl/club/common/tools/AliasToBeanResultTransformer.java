package com.gl.club.common.tools;

import java.io.BufferedReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.PropertyNotFoundException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.ResultTransformer;


public class AliasToBeanResultTransformer implements ResultTransformer {

	private static final long serialVersionUID = -5199190581393587893L;

	private final Class<?> resultClass;

	private Setter[] setters;

	private PropertyAccessor propertyAccessor;

	public AliasToBeanResultTransformer(Class<?> resultClass) {
		if (resultClass == null)
			throw new IllegalArgumentException("resultClass cannot be null");
		this.resultClass = resultClass;
		propertyAccessor = new ChainedPropertyAccessor(new PropertyAccessor[] { PropertyAccessorFactory.getPropertyAccessor(resultClass, null), PropertyAccessorFactory.getPropertyAccessor("field") });
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object transformTuple(Object[] tuple, String[] aliases) {
		Object result;
		try {
			if (setters == null) {
				setters = new Setter[aliases.length];
				for (int i = 0; i < aliases.length; i++) {
					String alias = convertColumnToProperty(aliases[i]);
					if (alias != null) {
						try {
							setters[i] = propertyAccessor.getSetter(resultClass, alias);
						} catch (PropertyNotFoundException e) {
							continue;
						}
					}
				}
			}
			result = resultClass.newInstance();
			for (int i = 0; i < aliases.length; i++) {
				if (setters[i] != null) {
					Class<?> classHandl = setters[i].getMethod().getParameterTypes()[0];
					if (EmptyUtil.isNullOrEmpty(tuple[i])) {
						continue;
					}
					if (classHandl.equals(String.class) || classHandl.equals(Byte.class) || classHandl.equals(Character.class) || classHandl.equals(Short.class)) {
						String resultString = tuple[i].toString();
						//处理大字段映射
						if (resultString.indexOf("sql.CLOB") > 0) {
							Reader reader;
							try {
								reader = ((Clob) tuple[i]).getCharacterStream();
								BufferedReader br = new BufferedReader(reader);
								resultString = br.readLine();
								StringBuffer stringBuffer = new StringBuffer();
								while (resultString != null) {// 执行循环将字符串全部取出付值给 StringBuffer由StringBuffer转成STRING
									stringBuffer.append(resultString);
									resultString = br.readLine();
								}
								resultString = stringBuffer.toString();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						setters[i].set(result, resultString, null);
					} else if (classHandl.equals(Date.class)) {
						setters[i].set(result, DateUtil.getDate(tuple[i].toString()), null);
					} else if (classHandl.equals(Double.class)||classHandl.equals(double.class)) {
						setters[i].set(result, Double.valueOf(tuple[i].toString()), null);
					} else if (classHandl.equals(Integer.class)||classHandl.equals(int.class)) {
						setters[i].set(result, Integer.valueOf(tuple[i].toString()), null);
					} else if (classHandl.equals(Long.class)||classHandl.equals(long.class)) {
						setters[i].set(result, Long.valueOf(tuple[i].toString()), null);
					} else if (classHandl.equals(Float.class)||classHandl.equals(float.class)) {
						setters[i].set(result, Float.valueOf(tuple[i].toString()), null);
					} else if (classHandl.equals(Boolean.class)||classHandl.equals(boolean.class)) {
						setters[i].set(result, Boolean.valueOf(tuple[i].toString()), null);
					} else if (classHandl.equals(BigDecimal.class)) {
						setters[i].set(result, new BigDecimal(tuple[i].toString()), null);
					} else {
						Class<? extends Enum> classEnum = (Class<? extends Enum>) classHandl;
						setters[i].set(result, Enum.valueOf(classEnum, tuple[i].toString()), null);
					}
				}
			}
		} catch (InstantiationException e) {
			throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
		} catch (IllegalAccessException e) {
			throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
		}
		return result;
	}

	/**
	 * Converts the specified 'XXX_YYY_ZZZ'-like column name to its
	 * 'xxxYyyZzz'-like Java property name.
	 *
	 * @param columnName the column name
	 * @return the Java property name
	 */
	public String convertColumnToProperty(String columnName) {
		columnName = columnName.toLowerCase();
		StringBuffer buff = new StringBuffer(columnName.length());
		StringTokenizer st = new StringTokenizer(columnName, "_");
		while (st.hasMoreTokens()) {
			buff.append(StringUtils.capitalize(st.nextToken()));
		}
		buff.setCharAt(0, Character.toLowerCase(buff.charAt(0)));
		return buff.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List transformList(List collection) {
		return collection;
	}
	
}
