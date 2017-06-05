package com.fantasy.xxbase.method;

import com.fantasy.xxutil.util.XXStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.internal.CoreMessageLogger;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.jboss.logging.Logger;

import java.io.Serializable;
import java.util.Properties;

/**
 * @author li.fang
 * @since 2017/6/3
 */
public class XXTableStringGenerator extends TableGenerator {

    private static final CoreMessageLogger LOG = Logger.getMessageLogger(
            CoreMessageLogger.class,
            TableGenerator.class.getName()
    );

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
}
