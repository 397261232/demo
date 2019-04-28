package com.example.demov2.dao.impl;

import com.example.demov2.dao.StudentInfoDao;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.dto.StudentInfoDTO;
import com.example.demov2.model.CourseInfo;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;
import com.example.demov2.util.PageUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 16:53
 * @Modified By:
 */
@Repository
public class StudentInfoDaoImpl implements StudentInfoDao {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    @Override
    public StudentInfo readStudentById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StudentInfo.class);
        criteria.add(Restrictions.eq("id", id));
        return (StudentInfo) criteria.uniqueResult();
    }

    @Override
    public List<StudentInfo> listStudent(StudentInfoDTO studentInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StudentInfo.class);
        if (!StringUtils.isEmpty(studentInfoDto.getStudentId())) {
            criteria.add(Restrictions.eq("studentId", studentInfoDto.getStudentId()));
        }
        return PageUtil.pageCriteria(criteria, studentInfoDto.getPageNo(), studentInfoDto.getPageSize()).list();
    }

    @Override
    public Integer countStudentList(StudentInfoDTO studentInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(StudentInfo.class);
        if (!StringUtils.isEmpty(studentInfoDto.getStudentId())) {
            criteria.add(Restrictions.eq("studentId", studentInfoDto.getStudentId()));
        }
        return criteria.list().size();
    }

    @Override
    public void saveStudent(StudentInfoDTO studentInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        StudentInfo StudentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentInfoDto, StudentInfo);
        session.save(StudentInfo);
    }

    @Override
    public List<ScoreInfo> listStudentScore(ListScoreRequest scoreInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ScoreInfo.class, "si");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("si.studentInfo"))
                .add(Projections.property("si.score"))
                .add(Projections.groupProperty("si.courseInfo"))
                .add(Projections.groupProperty("si.term"))
        );
        criteria.add(Restrictions.eq("si.studentInfo.studentId", scoreInfoDto.getStudentId()));
        criteria.addOrder(Order.asc("si.term"));
        criteria.addOrder(Order.asc("si.courseInfo.courseId"));
        PageUtil.pageCriteria(criteria, scoreInfoDto.getPageNo(), scoreInfoDto.getPageSize());
        List<Object[]> objectList = criteria.list();
        List<ScoreInfo> scoreInfoList = new ArrayList<>();
        for (Object[] ob : objectList) {
            ScoreInfo scoreInfo = new ScoreInfo();
            StudentInfo studentInfo = (StudentInfo) ob[0];
            scoreInfo.setStudentInfo(studentInfo);
            scoreInfo.setScore((Double) ob[1]);
            CourseInfo courseInfo = (CourseInfo) ob[2];
            scoreInfo.setCourseInfo(courseInfo);
            scoreInfo.setTerm((Integer) ob[3]);
            scoreInfoList.add(scoreInfo);
        }
        return scoreInfoList;
    }

    @Override
    public Integer countStudentScore(ListScoreRequest scoreInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(ScoreInfo.class, "si");
        criteria.setProjection(Projections.projectionList()
                .add(Projections.property("si.studentInfo"))
                .add(Projections.property("si.score"))
                .add(Projections.groupProperty("si.courseInfo"))
                .add(Projections.groupProperty("si.term"))
        );
        criteria.add(Restrictions.eq("si.studentInfo.studentId", scoreInfoDto.getStudentId()));
        criteria.addOrder(Order.asc("si.term"));
        criteria.addOrder(Order.asc("si.courseInfo.courseId"));
        PageUtil.pageCriteria(criteria, scoreInfoDto.getPageNo(), scoreInfoDto.getPageSize());
        Integer total = criteria.list().size();
        return total;
    }

    @Override
    public void updateStudent(StudentInfoDTO studentInfoDto) {
        Session session = sessionFactory.getCurrentSession();
        StudentInfo StudentInfo = new StudentInfo();
        BeanUtils.copyProperties(studentInfoDto, StudentInfo);
        session.merge(StudentInfo);
    }
}
