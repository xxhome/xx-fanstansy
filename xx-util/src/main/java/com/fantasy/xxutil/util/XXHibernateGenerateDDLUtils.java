package com.fantasy.xxutil.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.EnumSet;

import static org.hibernate.cfg.AvailableSettings.DATASOURCE;
import static org.hibernate.cfg.AvailableSettings.DIALECT;
import static org.hibernate.tool.schema.TargetType.DATABASE;

/**
 * @author li.fang
 * @since 2017/5/9
 */
public class XXHibernateGenerateDDLUtils{


    public static void export(DataSource dataSource, Class<? extends Dialect> dialect, String... packagesToScan) {

        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder()
                .applySetting(DATASOURCE, dataSource)
                .applySetting(DIALECT, dialect); // dialect could be omitted
        MetadataSources metadataSources = new MetadataSources(registryBuilder.build());

        PathMatchingResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
        new LocalSessionFactoryBuilder(null, resourceLoader, metadataSources)
                .scanPackages(packagesToScan);

        Metadata metadata = metadataSources.buildMetadata();

        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setFormat(false);
        schemaExport.create(EnumSet.of(DATABASE), metadata);
    }

}
