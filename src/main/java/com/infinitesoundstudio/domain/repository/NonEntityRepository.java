package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.domain.entity.ExampleEntity;
import com.infinitesoundstudio.domain.nonentity.NonEntity;
import java.time.Instant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NonEntityRepository extends JpaRepository<ExampleEntity, Long> {

    /**
     * Return non-entity from query.
     * <p>
     * NOTE: Notice the fully-qualified class name -- after the "new" operator
     * -- in the SELECT statement. This is the only way to use a non-entity POJO
     * as the return value from an {@code @Query} statement. If the package name
     * is removed, then {@code NonEntity} would need to be annotated with
     * {@code @Entity} to be instantiated successfully in the SELECT statement.
     *
     * @param startDate start of the temporal boundary (inclusive)
     * @param endDate end of the temporal boundary (inclusive)
     * @return list of non-entity POJOs initialized from query values
     */
    @Query(value = ""
            + "SELECT new com.infinitesoundstudio.domain.nonentity.NonEntity( "
            //            + "SELECT new NonEntity( "
            + "     q.caseId, q.propId, q.label, q.insertDate, q.id "
            + ") "
            + "FROM ExampleEntity AS q "
            + "WHERE q.insertDate BETWEEN :startDate AND :endDate "
            + "ORDER BY q.insertDate "
            + "")
    List<NonEntity> findByInsertDateBetween(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
}
