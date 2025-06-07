package com.basepack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.basepack.model.Location;
import java.util.List;
import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, Long> {
    List<Location> findByUserId(Long userId);
    Optional<Location> findByIdAndUserId(Long id, Long userId);
}
