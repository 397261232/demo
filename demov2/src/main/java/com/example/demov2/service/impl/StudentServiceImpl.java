package com.example.demov2.service.impl;

import com.example.demov2.dao.StudentInfoDao;
import com.example.demov2.dto.StudentInfoDTO;
import com.example.demov2.dto.request.ListScoreRequest;
import com.example.demov2.model.ScoreInfo;
import com.example.demov2.model.StudentInfo;
import com.example.demov2.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: 刘子铨
 * @Description:
 * @Date:Create: 2019/4/23 15:00
 * @Modified By:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    static private Logger logger = LoggerFactory.getLogger(Object.class);

    @Override
    public StudentInfo getStudentById(Integer id) {
        StudentInfo studentInfo =  studentInfoDao.getStudentById(id);
        return studentInfo;
    }

    @Override
    public List<StudentInfo> listStudent(StudentInfoDTO studentInfoDto) {
        List<StudentInfo> studentInfoList = studentInfoDao.listStudent(studentInfoDto);
        return studentInfoList;
    }

    /**
     * 根据条件查询学生列表总数
     *
     * @param studentInfoDto
     * @return
     */
    @Override
    public Integer countStudentList(StudentInfoDTO studentInfoDto) {
        Integer total = studentInfoDao.countStudentList(studentInfoDto);
        return total;
    }

    @Override
    public void saveStudent(StudentInfoDTO studentInfoDto) {
        studentInfoDao.saveStudent(studentInfoDto);
    }

    @Override
    public void updateStudent(StudentInfoDTO studentInfoDto) {
        try {
            studentInfoDao.updateStudent(studentInfoDto);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<ScoreInfo> listScoreByStudent(ListScoreRequest scoreInfoDto) {
        List<ScoreInfo> scoreInfoList = studentInfoDao.listStudentScore(scoreInfoDto);
        return scoreInfoList;
    }

    /**
     * 学生查询成绩信息总数
     *
     * @param scoreInfoDto
     * @return
     */
    @Override
    public Integer countScoreByStudent(ListScoreRequest scoreInfoDto) {
        Integer total = studentInfoDao.countStudentScore(scoreInfoDto);
        return total;
    }


}
