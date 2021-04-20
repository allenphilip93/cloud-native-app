package com.cloudnative.services.orders.repository;

import com.cloudnative.services.orders.model.EntityPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<EntityPOJO, String> {
}
