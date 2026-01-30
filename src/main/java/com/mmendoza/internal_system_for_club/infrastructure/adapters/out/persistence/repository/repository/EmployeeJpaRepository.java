package com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.repository.repository;

import com.mmendoza.internal_system_for_club.infrastructure.adapters.out.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
