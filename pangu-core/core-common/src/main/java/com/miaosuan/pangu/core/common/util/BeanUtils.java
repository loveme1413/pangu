package com.miaosuan.pangu.core.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName BeanUtils
 * @Description 集合操作
 * @Author dxk
 * @Date 2019-07-10 11:09
 * @Version 1.0
 */
public class BeanUtils {
    public BeanUtils() {
    }

    /**
     * @description: 获取类属性
     * @return:
     * @date: 2019-07-25 22:43
     * @auther: dxk
     *
    */
    private static PropertyDescriptor getPropertyDescriptor(PropertyDescriptor[] pds, PropertyDescriptor ref, boolean isStrict) {
        if (ref.getDisplayName().equals("class")) {
            return null;
        } else {
            PropertyDescriptor[] var3 = pds;
            int var4 = pds.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                PropertyDescriptor pd = var3[var5];
                if (isStrict) {
                    if (pd.equals(ref)) {
                        return pd;
                    }
                } else if (ref.getPropertyType().equals(pd.getPropertyType()) && pd.getName().equals(ref.getName())) {
                    return pd;
                }
            }

            return null;
        }
    }

    /**
     * 合并两个javaBean属性值
     *
     * @param fromObj
     * @param toObj
     * @throws RuntimeException
     * @author qin_wei
     * @Date: 23:24 2019-07-24
     */
    public static void copyProperties(Object fromObj, Object toObj) throws RuntimeException {
        copyProperties(fromObj, toObj, true);
    }

    /**
     * 合并javaBean属性值
     *
     * @param fromObj
     * @param toObj
     * @param ignoreNull
     * @throws RuntimeException
     * @author qin_wei
     * @Date: 23:25 2019-07-24
     */
    public static void copyProperties(Object fromObj, Object toObj, boolean ignoreNull) throws RuntimeException {
        if (fromObj != null && toObj != null) {
            Class<? extends Object> fromClass = fromObj.getClass();
            Class<? extends Object> toClass = toObj.getClass();
            boolean isStrict = fromClass == toClass;

            try {
                BeanInfo fromBean = Introspector.getBeanInfo(fromClass);
                BeanInfo toBean = Introspector.getBeanInfo(toClass);
                PropertyDescriptor[] toPds = toBean.getPropertyDescriptors();
                PropertyDescriptor[] fromPds = fromBean.getPropertyDescriptors();
                PropertyDescriptor[] var10 = toPds;
                int var11 = toPds.length;

                for (int var12 = 0; var12 < var11; ++var12) {
                    PropertyDescriptor toPd = var10[var12];
                    PropertyDescriptor fromPd = getPropertyDescriptor(fromPds, toPd, isStrict);
                    if (fromPd != null && fromPd.getDisplayName().equals(toPd.getDisplayName())) {
                        Method readMethod = fromPd.getReadMethod();
                        Method writeMethod = writeMethod(toClass, toPd);
                        if (writeMethod != null && readMethod != null) {
                            Object param = readMethod.invoke(fromObj, (Object[]) null);
                            if (!ignoreNull || param != null) {
                                writeMethod.invoke(toObj, param);
                            }
                        }
                    }
                }

            } catch (Exception var18) {
                throw new RuntimeException(var18);
            }
        }
    }

    /**
     * 赋值，并返回值
     *
     * @param from
     * @param toClass
     * @param <T>
     * @return
     * @throws RuntimeException
     * @author qin_wei
     * @Date: 23:25 2019-07-24
     */
    public static <T> T copyProperties(Object from, Class<T> toClass) throws RuntimeException {
        if (from == null) {
            return null;
        } else {
            try {
                T to = toClass.newInstance();
                copyProperties(from, to);
                return to;
            } catch (IllegalAccessException | InstantiationException var4) {
                throw new RuntimeException(var4);
            }
        }
    }

    /**
     * 赋值集合
     *
     * @param fromList
     * @param toClass
     * @param <T>
     * @return
     * @throws RuntimeException
     */
    public static <T> List<T> copyListProperties(Collection<? extends Object> fromList, Class<T> toClass) throws RuntimeException {
        if (fromList == null) {
            return null;
        } else {
            List<T> result = new ArrayList(fromList.size());
            Iterator var3 = fromList.iterator();

            while (var3.hasNext()) {
                Object from = var3.next();
                T to = copyProperties(from, toClass);
                result.add(to);
            }

            return result;
        }
    }

    public static Method writeMethod(Class<?> clz, PropertyDescriptor property) {
        String firstByte = property.getDisplayName().substring(0, 1).toUpperCase();
        String setMethodStr = "set" + firstByte + property.getDisplayName().substring(1);
        Method method = null;

        try {
            method = clz.getMethod(setMethodStr, property.getPropertyType());
        } catch (NoSuchMethodException var6) {
        }

        return method;
    }
}
