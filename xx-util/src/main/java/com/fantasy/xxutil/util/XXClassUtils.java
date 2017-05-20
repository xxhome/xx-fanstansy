package com.fantasy.xxutil.util;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public final class XXClassUtils {

    private static Logger logger = LoggerFactory.getLogger(XXClassUtils.class);

    private XXClassUtils() {
    }


    /**
     * 获取类全部的字段属性，并且递归获取父类字段属性
     *
     * @param clazz 对象类
     * @return 全部的字段
     */
    public static List<Field> getClassDeclaredFields(Class clazz) {

        List<Field> fields = new ArrayList<>();

        recursionFindClassDeclaredFields(clazz, fields);

        return fields;
    }


    public static <T extends Serializable> Object filterFieldToNULL(final T obj,final String...property) throws IOException, ClassNotFoundException {
        Object cloneObj = deepClone(obj);

        List<Field> objFields = getClassDeclaredFields(cloneObj.getClass());
        List<String> fields = Arrays.asList(property);

        for(Field field : objFields){
            try {

                Object subObj = PropertyUtils.getProperty(cloneObj, field.getName());

                if(subObj == null) continue;

                if(isBasicDataTypes(subObj)){
                    //基本数据类型
                    if(fields.contains(field.getName())) {

                        BeanUtils.setProperty(cloneObj, field.getName(), null);

                    }
                }else if(isCollectionDataTypes(subObj)){
                    //集合类型

                }else{
                    //
                }

            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                logger.error(e.getMessage());
            }
        }

        return cloneObj;
    }

    public static <T> Class getCollectionGenericType(Collection<T> collection){

        return null;
    }

    public static boolean isCollectionDataTypes(Object obj){
        if(obj == null) throw new NullPointerException();

        if(obj.getClass().isArray()) return true;

        if(obj instanceof Collection) return true;

        return false;
    }

    /**
     * 判断对象是否为基本数据类型
     * @param obj 判断对象
     * @return true 基本数据类型， false 非基本数据类型
     */
    public static boolean isBasicDataTypes(Object obj){

        if(obj == null) throw new NullPointerException();

        if(obj instanceof String) return true;

        if(obj instanceof Date) return true;

        if(obj instanceof Number) return true;

        if(obj instanceof Char) return true;

        if(obj instanceof Boolean) return true;

        return false;
    }


    /**
     * 深度克隆对象，该对象必须实现Serializable接口
     *
     * @param obj 待克隆的对象
     * @param <T> obj泛型
     * @return 克隆后产生的新对象
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 对象类未找到
     */
    public static <T extends Serializable> T deepClone(T obj) throws IOException, ClassNotFoundException {
        T cloneObj = null;

        ByteArrayOutputStream bot = null;
        ObjectOutputStream bos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bot = new ByteArrayOutputStream();
            bos = new ObjectOutputStream(bot);
            bos.writeObject(obj);

            bis = new ByteArrayInputStream(bot.toByteArray());
            ois = new ObjectInputStream(bis);

            cloneObj = (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                if (bos != null) bos.close();
                if (ois != null) bos.close();
                if (bot != null) bot.close();
                if (bis != null) bis.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return cloneObj;
    }

    /**
     * 克隆集合对象，集合对象必须实现序列化接口
     *
     * @param collection 待克隆的集合
     * @param <T>        泛型
     * @return
     * @throws IOException            IO异常
     * @throws ClassNotFoundException 对象类未找到
     */
    public static <T extends Serializable> Collection<T> deepCloneCollection(Collection<T> collection) throws IOException, ClassNotFoundException {
        Collection<T> cloneCollection = null;

        ByteArrayOutputStream bot = null;
        ObjectOutputStream bos = null;

        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            bot = new ByteArrayOutputStream();
            bos = new ObjectOutputStream(bot);
            bos.writeObject(collection);

            bis = new ByteArrayInputStream(bot.toByteArray());
            ois = new ObjectInputStream(bis);

            cloneCollection = (Collection<T>) ois.readObject();
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            try {
                if (bos != null) bos.close();
                if (ois != null) bos.close();
                if (bot != null) bot.close();
                if (bis != null) bis.close();
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return cloneCollection;
    }


    /**
     * 递归获取父类的字段
     *
     * @param clazz          对象类
     * @param declaredFields 存储字段
     */
    private static void recursionFindClassDeclaredFields(Class clazz, List<Field> declaredFields) {

        Field[] fields = clazz.getDeclaredFields();

        if (fields != null) {
            declaredFields.addAll(Arrays.asList(fields));
        }

        Class supClass = clazz.getSuperclass();

        if (supClass != null) {

            recursionFindClassDeclaredFields(supClass, declaredFields);

        }
    }


}
