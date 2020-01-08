package com.fantasy.xxbase.usertype;

import com.fantasy.xxutil.util.XXJsonUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @author li.fang
 * @since 2017/6/2
 */
public class JSONColumn implements UserType, ParameterizedType {
    private boolean jsonListColumn = false;
    private boolean stringListColumn = false;

    private Class getObjectClass() {
        if (stringListColumn) {
            return String.class;
        }
        return this.getClass();
    }


    @Override
    public int[] sqlTypes() {

        /**
         * CLOB类型，在mysql环境下会转换成longtext
         */
        return new int[]{Types.CLOB};
    }

    @Override
    public Class returnedClass() {

        if (stringListColumn) {
            return Collection.class;
        } else if (jsonListColumn) {
            return Collection.class;
        } else {
            return getObjectClass();
        }


    }


    private boolean isEqualsList(List listX, List listY) {

        int xSize = listX.size();
        int ySize = listY.size();

        if (xSize != ySize) {
            return false;
        }

        for (int i = 0; i < xSize; i++) {
            Object xObject = listX.get(i);
            Object yObject = listY.get(i);

            if (xObject != yObject) {

                //两个都不为null
                if (xObject != null && yObject != null) {
                    if (!xObject.equals(yObject)) {
                        return false;
                    }
                }

                //其中一个为null
                if (xObject == null && yObject != null) {
                    return false;
                }

                if (xObject != null && yObject == null) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x != null && y != null) {

            if (jsonListColumn || stringListColumn) {
                if (x instanceof List && y instanceof List) {
                    List listX = (List) x;
                    List listY = (List) y;
                    return isEqualsList(listX, listY);
                }
            } else {
                return x.equals(y);
            }
        }

        return false;

    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        if (x != null) {
            return x.hashCode();
        }
        return 0;
    }


    @Override
    public Object deepCopy(Object value) throws HibernateException {
        if (value == null) {
            return null;
        }

        String json = XXJsonUtils.toJsonStr(value);

        if (jsonListColumn || stringListColumn) {
            return XXJsonUtils.parseArray(json, getObjectClass());
        } else {
            return XXJsonUtils.parseObject(json, getObjectClass());
        }

    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] strings, SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException, SQLException {
        if (rs == null) {
            return null;
        }
        String value = rs.getString(strings[0]);
        if (value != null && !value.isEmpty()) {
            if (jsonListColumn || stringListColumn) {
                return XXJsonUtils.parseArray(value, getObjectClass());
            } else {
                return XXJsonUtils.parseObject(value, getObjectClass());
            }
        }
        return null;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object o, int i, SharedSessionContractImplementor sharedSessionContractImplementor) throws HibernateException, SQLException {
        if (o == null)
            st.setString(i, "");
        else {
            String s = XXJsonUtils.toJsonStr(o);
            st.setString(i, s);
        }
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }

    @Override
    public void setParameterValues(Properties parameters) {

        Object isList = parameters.get("List");

        this.jsonListColumn = false;
        if (isList != null) {
            if ("true".equalsIgnoreCase(isList.toString())) {
                this.jsonListColumn = true;
            }
        }


        Object isStringList = parameters.get("StringList");
        this.stringListColumn = false;
        if (isStringList != null) {
            if ("true".equalsIgnoreCase(isStringList.toString())) {
                this.stringListColumn = true;
            }
        }

    }

}
