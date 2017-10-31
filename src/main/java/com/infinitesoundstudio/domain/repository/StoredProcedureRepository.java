package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.domain.entity.ExampleEntity;
import java.time.Instant;
import java.util.List;

/**
 * Interface defining repository to take advantage of native stored procedures.
 */
public interface StoredProcedureRepository {

    /**
     * Returns list of entities, whose {@code insert_date} field falls within
     * the given time span.
     *
     * @param startDate the start timestamp
     * @param endDate the end timestamp
     * @return list of {@link ExampleEntity} instances
     */
    List<ExampleEntity> getEntityData(Instant startDate, Instant endDate);
}
