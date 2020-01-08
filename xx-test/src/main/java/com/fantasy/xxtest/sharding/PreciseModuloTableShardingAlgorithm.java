package com.fantasy.xxtest.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Collection;

public class PreciseModuloTableShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    private static Logger logger = LoggerFactory.getLogger(PreciseModuloTableShardingAlgorithm.class);

    private static final String LOGIC_TABLE = "t_order_item";

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String doSharding(final Collection<String> tableNames, final PreciseShardingValue<String> shardingValue) {
        String orderId = shardingValue.getValue();
        String tableName = String.format("%s_%s", LOGIC_TABLE, orderId);

        //表不存在先创建
        createTableIfNotExists(tableName);

        return tableName;
    }

    private void createTableIfNotExists(String tableName){
        final String sql = String.format("CREATE TABLE IF NOT EXISTS %s SELECT * FROM %s WHERE 1=2", tableName, LOGIC_TABLE);
        jdbcTemplate.execute(sql);
    }
}