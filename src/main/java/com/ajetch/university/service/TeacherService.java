package com.ajetch.university.service;


import com.ajetch.university.entity.Teacher;
import com.ajetch.university.repo.TeachersRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class TeacherService {

    @Autowired
    private TeachersRepository teacherRepository;


    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Integer id) {
        return teacherRepository.findById(id);
    }

    public Teacher saveTeacher(Teacher teacher) {
        System.out.println("saveStudent(-) Started");
        //log.info("saveStudent(-) Started");
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Integer id, Teacher teacherDetails) {
        System.out.println("updateStudent(-) Started");

        //logger.info("updateStudent(-) Started");
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        teacher.setFullName(teacherDetails.getFullName());
        teacher.setBirthday(teacherDetails.getBirthday());
        teacher.setPosition(teacherDetails.getPosition());
        teacher.setPhoneNumber(teacherDetails.getPhoneNumber());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Integer id) {
        System.out.println("deleteTeacher(-) Started");
        //log.info("deleteStudent(-) Started");
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        teacherRepository.delete(teacher);
    }
}