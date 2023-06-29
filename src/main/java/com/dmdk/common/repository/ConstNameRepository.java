package com.dmdk.common.repository;

import com.dmdk.common.domain.ConstTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstNameRepository extends JpaRepository<ConstTeamEntity, Long> {
}
