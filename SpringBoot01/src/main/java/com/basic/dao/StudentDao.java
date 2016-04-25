package com.basic.dao;

import com.basic.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by dell-pc on 2016/1/15.
 */
@Transactional
public interface StudentDao extends CrudRepository<Student,Long>{
    public Student findByName(String name);

    @Modifying
    @Query("update Student stu set stu.age= ?1 where  stu.age >?2")
    public int updateStudentAgeThen(String before,String after);

    @Query("select s from Student s where s.age> ?1")
    public Page<Student> findStudentByAgeThen(String age, Pageable pageable);
}
