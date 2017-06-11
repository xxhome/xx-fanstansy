package com.fantasy.xxbase.method;

import com.fantasy.xxutil.util.XXStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author li.fang
 * @since 2017/6/3
 */
@Test
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class XXTableStringGenerator extends TableGenerator {

    private static final String TABLE = "t_xx_generator";
    private static final String DB_TABLE = "db_fantasy_base.t_xx_generator";

    @Override
    public void configure(Type type, Properties params, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(new LongType(), params, serviceRegistry);
    }

    @Override
    public synchronized Serializable generate(SharedSessionContractImplementor session, Object obj) {
        String prefix = StringUtils.substring(XXStringUtils.getUpperCase(obj.getClass().getSimpleName()), 0, 2);
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        sb.append(super.generate(session, obj));
        return sb.toString();
    }

    @Override
    protected String buildSelectQuery(Dialect dialect) {
        String sql = super.buildSelectQuery(dialect);
        return StringUtils.replace(sql, TABLE, DB_TABLE);
    }

    @Override
    protected String buildUpdateQuery() {
        String sql = super.buildUpdateQuery();
        return StringUtils.replace(sql, TABLE, DB_TABLE);
    }

    @Override
    protected String buildInsertQuery() {
        String sql = super.buildInsertQuery();
        return StringUtils.replace(sql, TABLE, DB_TABLE);
    }
}
