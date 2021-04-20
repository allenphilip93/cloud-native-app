package com.cloudnative.services.customers.repository;

import com.cloudnative.services.customers.model.EntityPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<EntityPOJO, String> {
}
