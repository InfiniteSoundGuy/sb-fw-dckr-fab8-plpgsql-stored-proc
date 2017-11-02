package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.FakeDataGenerator;
import static com.infinitesoundstudio.TestUtil.print;
import com.infinitesoundstudio.domain.entity.ExampleEntity;
import java.math.BigInteger;
import java.time.Instant;
import java.util.Random;
import javax.persistence.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles("integration-test")
public class EntityManagerRepositoryIT extends FakeDataGenerator {

    @PersistenceContext
    private EntityManager entityManager;

    Random random = new Random();

    @Autowired
    ExampleEntityRepository exampleEntityRepository;

    @Before
    public void setUp() {
        print(this, "setUp");
        exampleEntityRepository.deleteAll();
    }

    @Test
    public void testInsertExample() {
        print(this, "testInsertExample");
        createEntity(10).forEach(example -> {
            insertExample(example);
            System.out.println("example == " + example);
        });
    }

    public void insertExample(ExampleEntity example) {
        BigInteger id = (BigInteger) entityManager.createStoredProcedureQuery("insert_example")
                .registerStoredProcedureParameter(1, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(3, String.class, ParameterMode.IN)
                .registerStoredProcedureParameter(4, Instant.class, ParameterMode.IN)
                .setParameter(1, example.getLabel())
                .setParameter(2, example.getPropId())
                .setParameter(3, example.getCaseId())
                .setParameter(4, example.getInsertDate())
                .getSingleResult();
        example.setId(id.longValue());
    }

}
