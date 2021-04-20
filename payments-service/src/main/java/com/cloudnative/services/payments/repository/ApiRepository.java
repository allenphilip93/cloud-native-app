package com.cloudnative.services.payments.repository;

import com.cloudnative.services.payments.model.EntityPOJO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<EntityPOJO, String> {
}
