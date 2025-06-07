package com.basepack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.basepack.model.Flag;

public interface FlagRepo extends JpaRepository<Flag, Long> {
	
}
