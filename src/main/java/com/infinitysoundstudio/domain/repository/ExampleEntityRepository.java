package com.infinitysoundstudio.domain.repository;

import com.infinitysoundstudio.domain.entity.ExampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for persisting instances of {@link ExampleEntity}
 */
@Repository
public interface ExampleEntityRepository extends JpaRepository<ExampleEntity, Long> {
}
