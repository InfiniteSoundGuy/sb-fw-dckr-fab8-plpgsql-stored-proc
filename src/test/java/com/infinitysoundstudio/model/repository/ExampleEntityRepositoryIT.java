package com.infinitysoundstudio.model.repository;

import com.infinitysoundstudio.FakeDataGenerator;
import com.infinitysoundstudio.domain.entity.ExampleEntity;
import com.infinitysoundstudio.domain.repository.ExampleEntityRepository;
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
 * Integration gets for {@link ExampleEntityRepository}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles("integration-test")
public class ExampleEntityRepositoryIT extends FakeDataGenerator {

    @Autowired
    ExampleEntityRepository exampleEntityRepository;

    @Before
    public void setUp() {
        exampleEntityRepository.deleteAll();
    }

    @Test
    public void testSave() {
        System.out.println("testSave");
        ExampleEntity entity = createEntity();
        ExampleEntity saved = exampleEntityRepository.save(entity);
        assertThat(saved, notNullValue());
        assertThat(saved.getId(), not(equalTo(0L)));
        assertThat(saved, equalTo(entity));
    }
}
