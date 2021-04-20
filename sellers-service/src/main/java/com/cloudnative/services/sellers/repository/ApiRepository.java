package com.cloudnative.services.sellers.repository;

import com.cloudnative.services.sellers.model.EntityPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<EntityPOJO, String> {
}
