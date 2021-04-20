package com.cloudnative.services.reviews.repository;

import com.cloudnative.services.reviews.model.EntityPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<EntityPOJO, String> {
}
