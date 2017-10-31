package com.infinitesoundstudio.service;

import com.infinitesoundstudio.service.DataGatheringService;
import com.infinitesoundstudio.FakeDataGenerator;
import com.infinitesoundstudio.domain.entity.ExampleEntity;
import com.infinitesoundstudio.domain.nonentity.NonEntity;
import com.infinitesoundstudio.domain.repository.ExampleEntityRepository;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration test for {@link DataGatheringService}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles("integration-test")
public class DataGatheringServiceIT extends FakeDataGenerator {

    @Autowired
    ExampleEntityRepository exampleEntityRepository;

    @Autowired
    DataGatheringService dataGatheringService;

    @Before
    public void setUp() {
        exampleEntityRepository.deleteAll(); // clean house

        loadEntities(exampleEntityRepository, 3); // load data

        // Show persisted entities
        exampleEntityRepository.findAll().stream()
                .peek(ee -> System.out.println("ee == " + ee))
                .count(); // arbitary terminal operation for peek

    }

    @Test
    public void testGetEntityData() {
        System.out.println("testGetEntityData");

        System.out.println("Performing query and getting results...");

        List<ExampleEntity> result = dataGatheringService.getEntityData(START_DATE, END_DATE);
        result.stream()
                .peek(out -> System.out.println("out = " + out))
                .count(); // arbitary terminal operation for peek

        System.out.println("... Done!");

        assertThat(result, notNullValue());
        assertThat(result, not(emptyIterable()));
    }

    @Test
    public void testGetNonEntityData() {
        System.out.println("testGetNonEntityData");

        System.out.println("Performing query and getting results...");

        List<NonEntity> result = dataGatheringService.getNonEntityData(START_DATE, END_DATE);
        result.stream()
                .peek(out -> System.out.println("out = " + out))
                .count(); // arbitary terminal operation for peek

        System.out.println("... Done!");

        assertThat(result, notNullValue());
        assertThat(result, not(emptyIterable()));
    }
}
