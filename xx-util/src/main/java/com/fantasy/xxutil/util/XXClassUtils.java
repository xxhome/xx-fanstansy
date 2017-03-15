package com.fantasy.xxutil.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
    public static <T extends Serializable> Collection<T> deepClone(Collection<T> collection) throws IOException, ClassNotFoundException {
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
