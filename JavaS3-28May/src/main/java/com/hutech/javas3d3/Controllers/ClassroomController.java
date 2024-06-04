package com.hutech.javas3d3.Controllers;

import com.hutech.javas3d3.Entities.Classroom;
import com.hutech.javas3d3.Services.ClassroomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/classrooms")
public class ClassroomController {
    @Autowired
    private ClassroomServices classroomServices;
    @GetMapping("")
    public String getClassrooms(Model model) {
        List<Classroom> classrooms = classroomServices.getAllClassrooms();
        model.addAttribute("classrooms", classrooms);
        return "Classroom/getAll";
    }

    @GetMapping("/new")
    public String AddClassroom(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "Classroom/add";
    }
    @PostMapping("/save")
    public String saveClassroom(Classroom classroom) {
        classroomServices.addClassroom(classroom);
        return "redirect:/classrooms";
    }
}
