package com.example.demov2.util;

import org.hibernate.Criteria;
import org.springframework.util.StringUtils;

import org.hibernate.query.Query;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/25 10:11
 * @Modified By:
 */
public class PageUtil {
    public static void pageList(Query query,Integer pageNo,Integer pageSize){

        query.setMaxResults(10);
        if (!StringUtils.isEmpty(pageSize)) {
            query.setMaxResults(pageSize);
        }
        query.setFirstResult(0);
        if (!StringUtils.isEmpty(pageNo)) {
            query.setFirstResult((pageNo-1)*query.getMaxResults());
        }
    }

    public static Criteria pageCriteria(Criteria criteria, Integer pageNo, Integer pageSize){
        if (StringUtils.isEmpty(pageSize)) {
            pageSize = 10;
        }
        if (StringUtils.isEmpty(pageNo)) {
            pageNo = 1;
        }
        criteria.setFirstResult((pageNo-1)*pageSize);
        criteria.setMaxResults(pageSize);
        return criteria;
    }
}
