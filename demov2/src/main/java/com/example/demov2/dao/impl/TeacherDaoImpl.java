package com.example.demov2.dao.impl;

import com.example.demov2.dao.TeacherDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.CourseInfo;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.TeacherInfo;
import com.example.demov2.util.PageUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/25 9:17
 * @Modified By:
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<ScoreInfo> listScoreByTeacher(ListScoreRequest scoreInfoDto) {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(ScoreInfo.class,"si");
            criteria.setProjection(Projections.projectionList()
                            .add(Projections.avg("si.score"))
                            .add(Projections.max("si.score"))
                            .add(Projections.min("si.score"))
                            .add(Projections.property("si.teacherInfo"))
                            .add(Projections.groupProperty("si.courseInfo"))
                            .add(Projections.groupProperty("si.term"))
            );
            criteria.add(Restrictions.eq("si.teacherInfo.teacherId", scoreInfoDto.getTeacherId()));
            criteria.addOrder(Order.asc("si.term"));
            criteria.addOrder(Order.asc("si.courseInfo.courseId"));
            PageUtil.pageCriteria(criteria,scoreInfoDto.getPageNo(),scoreInfoDto.getPageSize());
            List<Object[]> objectList = criteria.list();
            List<ScoreInfo> scoreInfoList = new ArrayList<>();
            for (Object[] ob : objectList) {
                ScoreInfo scoreInfo = new ScoreInfo();
                scoreInfo.setAvg((Double) ob[0]);
                scoreInfo.setMax((Double) ob[1]);
                scoreInfo.setMin((Double) ob[2]);
                scoreInfo.setTeacherInfo((TeacherInfo) ob[3]);
                scoreInfo.setCourseInfo((CourseInfo) ob[4]);
                scoreInfo.setTerm((Integer) ob[5]);
                scoreInfoList.add(scoreInfo);
            }
            return scoreInfoList;
    }

    @Override
    public Integer countScoreByTeacher(ListScoreRequest scoreInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ScoreInfo.class,"si");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.avg("si.score"))
                .add(Projections.max("si.score"))
                .add(Projections.min("si.score"))
                .add(Projections.property("si.teacherInfo"))
                .add(Projections.groupProperty("si.courseInfo"))
                .add(Projections.groupProperty("si.term"))
        );
        criteria.add(Restrictions.eq("si.teacherInfo.teacherId", scoreInfoDto.getTeacherId()));
        criteria.addOrder(Order.asc("si.term"));
        criteria.addOrder(Order.asc("si.courseInfo.courseId"));
        PageUtil.pageCriteria(criteria,scoreInfoDto.getPageNo(),scoreInfoDto.getPageSize());
        Integer total = criteria.list().size();
        return total;
    }
}
