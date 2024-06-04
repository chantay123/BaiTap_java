package com.hutech.javas3d3.Services;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassroomServices {
    @Autowired
    private ClassroomRepository classroomRepository;

    public List<Classroom> getAllClassrooms() {
        return classroomRepository.findAll();
    }
    public  void addClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
