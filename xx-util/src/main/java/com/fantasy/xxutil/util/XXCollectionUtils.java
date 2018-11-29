package com.fantasy.xxutil.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author lifang@winployee.com
 * @since 2018-03-02
 */
public final class XXCollectionUtils {

    /**
     * 将集合进行分页。
     *
     * @param coll     需分页的集合
     * @param pageSize 每页数量
     * @param <T>      集合对象
     * @return List<List   <   T>> 分页后的集合。
     */
    public static <T> List<List<T>> toPage(Collection<T> coll, int pageSize) {
        final int total = coll.size();
        final int page = total / pageSize + 1;

        List<List<T>> result = new ArrayList<>(page);

        for (int i = 0; i < page; i++) {

            int fromIndex = Math.max(i * pageSize, 0);

            int toIndex = Math.min((i + 1) * pageSize, total);

            List<T> pageEmpIds = new ArrayList<>(coll).subList(fromIndex, toIndex);

            result.add(pageEmpIds);
        }
        return result;
    }
}
