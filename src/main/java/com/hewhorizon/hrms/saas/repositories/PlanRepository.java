package com.hewhorizon.hrms.saas.repositories;

import com.hewhorizon.hrms.saas.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {}
