package com.hutech.javas3d3.Controllers;


import com.hutech.javas3d3.Entities.Role;
import com.hutech.javas3d3.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleServices roleService;

    @GetMapping()
    public String listRoles(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("role", roles);
        return "roles/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("role", new Role());
        return "roles/form";
    }

    @PostMapping("/create")
    public String createRole(@ModelAttribute("role") Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Role role = roleService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        model.addAttribute("role", role);
        return "roles/edit";
    }

    @PostMapping("/update/{id}")
    public String updateRole(@PathVariable("id") Long id, @ModelAttribute("role") Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteById(id);
        return "redirect:/roles";
    }
}
