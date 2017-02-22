package com.xxbase.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public final class XXClassUtils {

    private Logger logger = LoggerFactory.getLogger(XXClassUtils.class);

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
     * @param obj 克隆对象
     * @param <T> obj泛型
     * @return 克隆后产生的新对象
     * @throws ClassNotFoundException 对象类未找到
     * @throws IOException            IO异常
     */
    public static <T extends Serializable> T deepClone(T obj) throws ClassNotFoundException, IOException {
        T cloneObj = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream(); ObjectOutputStream obs = new ObjectOutputStream(out);
             ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray()); ObjectInputStream ois = new ObjectInputStream(ios)) {

            //写入字节流
            obs.writeObject(obj);

            //重新读取转换成对象
            cloneObj = (T) ois.readObject();
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        }
        return cloneObj;
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
