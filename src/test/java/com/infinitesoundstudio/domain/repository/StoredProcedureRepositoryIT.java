package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.FakeDataGenerator;
import static com.infinitesoundstudio.TestUtil.print;
import com.infinitesoundstudio.domain.entity.ExampleEntity;
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
 * Integration test for {@link StoredProcedureRepository}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles("integration-test")
public class StoredProcedureRepositoryIT extends FakeDataGenerator {

    @Autowired
    ExampleEntityRepository exampleEntityRepository;

    @Autowired
    StoredProcedureRepository storedProcedureRepository;

    @Before
    public void setUp() {
        print(this, "setUp");
        exampleEntityRepository.deleteAll(); // clean house
        loadEntities(exampleEntityRepository, 3); // load data

        // Show persisted entities
        exampleEntityRepository.findAll().stream()
                .peek(ee -> System.out.println("ee == " + ee))
                .count(); // arbitary terminal operation for peek

    }

    @Test
    public void testGetEntityData() {
        print(this, "testGetEntityData");

        System.out.println("Performing query and getting results...");

        List<ExampleEntity> result = storedProcedureRepository.getEntityData(START_DATE, END_DATE);
        result.stream()
                .peek(out -> System.out.println("out = " + out))
                .count(); // arbitary terminal operation for peek

        System.out.println("... Done!");

        assertThat(result, notNullValue());
        assertThat(result, not(emptyIterable()));
    }

}
