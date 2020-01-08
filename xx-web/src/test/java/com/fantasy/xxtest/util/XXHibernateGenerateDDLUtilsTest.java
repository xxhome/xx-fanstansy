package com.fantasy.xxtest.util;

import com.fantasy.xxbase.method.XXImprovedNamingStrategy;
import com.fantasy.xxtest.base.SpringTest;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.schema.Action;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.util.EnumSet;

import static org.hibernate.cfg.AvailableSettings.*;
import static org.hibernate.tool.schema.TargetType.STDOUT;

/**
 * @author li.fang
 * @since 2017/5/9
 */
public class XXHibernateGenerateDDLUtilsTest extends SpringTest {
    @Value(value = "${jdbc.url}")
    private String url;

    @Value(value = "${jdbc.username}")
    private String username;

    @Value(value = "${jdbc.password}")
    private String password;

    @Test
    public void generateSchemaDDL() {
        logger.info("url:{}", url);
        logger.info("username:{}", username);
        logger.info("password:{}", password);
        generateSchemaDDL(MySQL5Dialect.class, "com.fantasy.**.entity");
    }

    private void generateSchemaDDL(Class<? extends Dialect> dialect, String... packagesToScan) {
        final String STORAGE_ENGINE_INNODB = "innodb";
        System.setProperty(STORAGE_ENGINE, STORAGE_ENGINE_INNODB);
        StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                .applySetting(URL, url)
                .applySetting(USER, username)
                .applySetting(PASS, password)
                .applySetting(DIALECT, dialect)
                .applySetting(SHOW_SQL, false)
                .applySetting(FORMAT_SQL, false)
                .applySetting(HBM2DDL_AUTO, Action.NONE)
                .applySetting(ORDER_UPDATES, false)
                .applySetting(PHYSICAL_NAMING_STRATEGY, XXImprovedNamingStrategy.INSTANCE)
                .applySetting(STORAGE_ENGINE, STORAGE_ENGINE_INNODB)
                .applySetting(USE_SECOND_LEVEL_CACHE, false)
                .build();

        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

        PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        new LocalSessionFactoryBuilder(null, resourceLoader, metadataSources)
                .scanPackages(packagesToScan);

        Metadata metadata = metadataSources.buildMetadata();

        SchemaUpdate executor = new SchemaUpdate();
        //SchemaExport executor = new SchemaExport();
        executor.setDelimiter(";");
        executor.setFormat(false);
        executor.execute(EnumSet.of(STDOUT), metadata);
        //executor.execute(EnumSet.of(STDOUT), SchemaExport.Action.BOTH, metadata);
        metadata.buildSessionFactory().close();
    }
}
