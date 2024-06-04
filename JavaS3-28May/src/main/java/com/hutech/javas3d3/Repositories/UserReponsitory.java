package com.hutech.javas3d3.Repositories;

import com.hutech.javas3d3.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReponsitory extends JpaRepository<User, Long> {
}
