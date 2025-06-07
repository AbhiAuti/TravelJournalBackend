package com.basepack.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.basepack.model.LocationMedia;

public interface LocationMediaRepo extends JpaRepository<LocationMedia, Long> {
	
}

