package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.domain.entity.ExampleEntity;
import java.time.Instant;
import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;

/**
 * Implementation of interface defining repository that takes advantage of
 * native stored procedures.
 */
@Repository
public class StoredProcedureRepositoryImpl implements StoredProcedureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ExampleEntity> getEntityData(Instant startDate, Instant endDate) {

        // No special mapping necessary, as long as the stored procedure returns
        // a structure that Hibernate can map to a constructor of ExampleEntity.
        // Note that the createStoredProcedureQuery method only accepts @Entity.
        // See V2__create_stored_procedures.sql
        String storedProcedureName = "get_example_data";
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery(storedProcedureName, ExampleEntity.class)
                .registerStoredProcedureParameter(1, Instant.class, ParameterMode.IN)
                .setParameter(1, startDate)
                .registerStoredProcedureParameter(2, Instant.class, ParameterMode.IN)
                .setParameter(2, endDate);

        return query.getResultList();
    }
}
