package com.dmdk.common.controller.repository;

import com.dmdk.common.controller.domain.ConstTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstNameRepository extends JpaRepository<ConstTeamEntity, Long> {
}
