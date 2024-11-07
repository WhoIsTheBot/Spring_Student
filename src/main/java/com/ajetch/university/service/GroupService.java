package com.ajetch.university.service;



import com.ajetch.university.entity.Group;
import com.ajetch.university.repo.GroupRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;


    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    public Optional<Group> getGroupById(Integer id) {
        return groupRepository.findById(id);
    }

    public Group saveGroup(Group group) {
        System.out.println("saveGroup (-) Started");
        //log.info("saveStudent(-) Started");
        return groupRepository.save(group);
    }

    public Group updateGroup(Integer id, Group groupDetails) {
        System.out.println("updateGroup(-) Started");
        //log.info("updateStudent(-) Started");
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        group.setGroupNumber(groupDetails.getGroupNumber());
        group.setYearCreated(groupDetails.getYearCreated());
        group.setDepartment(groupDetails.getDepartment());
        group.setTeacher(groupDetails.getTeacher());
        return groupRepository.save(group);
    }

    public void deleteGroup(Integer id) {
        System.out.println("deleteGroup(-) Started");
        //log.info("deleteStudent(-) Started");
        Group group = groupRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        groupRepository.delete(group);
    }
}
