package com.fantasy.xxtest.sharding;

import com.google.common.collect.Lists;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

public class HintTableShardingAlgorithm implements HintShardingAlgorithm {

    private static Logger logger = LoggerFactory.getLogger(HintTableShardingAlgorithm.class);

    @Override
    public Collection<String> doSharding(Collection collection, HintShardingValue hintShardingValue) {
        return Lists.newArrayList("t_order_item_0");
    }
}
