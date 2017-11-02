package com.infinitesoundstudio.service;

import com.infinitesoundstudio.domain.entity.ExampleEntity;
import com.infinitesoundstudio.domain.nonentity.NonEntity;
import com.infinitesoundstudio.domain.repository.NonEntityRepository;
import com.infinitesoundstudio.domain.repository.StoredProcedureRepository;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataGatheringService {

    private final StoredProcedureRepository storedProcedureRepository;
    private final NonEntityRepository nonEntityRepository;

    /**
     * Constructor for the data gathering service.
     *
     * @param storedProcedureRepository the repository
     * @param nonEntityRepository the repository to retrieve table data as list
     * of non-entity instances
     */
    @Autowired
    public DataGatheringService(
            StoredProcedureRepository storedProcedureRepository,
            NonEntityRepository nonEntityRepository) {
        this.storedProcedureRepository = storedProcedureRepository;
        this.nonEntityRepository = nonEntityRepository;
    }

    /**
     * Returns entities from example table, whose insert_date falls between
     * startDate and endDate.
     *
     * @param startDate the start timestamp
     * @param endDate the end timestamp
     * @return the list of entities (i.e., result set)
     */
    public List<ExampleEntity> getEntityData(Instant startDate, Instant endDate) {
        return storedProcedureRepository.getEntityData(startDate, endDate);
    }

    /**
     * Converts entities to non-entities, based on persisted example data whose
     * insert_date falls between startDate and endDate.
     *
     * @param startDate the start timestamp
     * @param endDate the end timestamp
     * @return the list of non-entities (i.e., result set)
     */
    public List<NonEntity> getConvertedEntityData(Instant startDate, Instant endDate) {
        List<ExampleEntity> list = getEntityData(startDate, endDate);
        return list.stream()
                .map(ee -> new NonEntity(ee.getCaseId(), ee.getPropId(), ee.getLabel(), ee.getInsertDate(), ee.getId()))
                .collect(Collectors.toList());
    }

    /**
     * Returns non-entities, based on persisted example data whose insert_date
     * falls between startDate and endDate.
     *
     * @param startDate the start timestamp
     * @param endDate the end timestamp
     * @return the list of non-entities (i.e., result set)
     */
    public List<NonEntity> getNonEntityData(Instant startDate, Instant endDate) {
        return nonEntityRepository.findByInsertDateBetween(startDate, endDate);
    }

}
