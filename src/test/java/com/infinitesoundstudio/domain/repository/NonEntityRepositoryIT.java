package com.infinitesoundstudio.domain.repository;

import com.infinitesoundstudio.FakeDataGenerator;
import static com.infinitesoundstudio.TestUtil.print;
import com.infinitesoundstudio.domain.nonentity.NonEntity;
import java.time.Instant;
import static java.time.temporal.ChronoUnit.DAYS;
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

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@EnableAutoConfiguration
@ActiveProfiles("integration-test")
public class NonEntityRepositoryIT extends FakeDataGenerator {

    int COUNT = 10;

    @Autowired
    NonEntityRepository nonEntityRepository;

    @Autowired
    ExampleEntityRepository exampleEntityRepository;

    @Before
    public void setUp() {
        print(this, "setUp");
        exampleEntityRepository.deleteAll();
        exampleEntityRepository.save(createEntity(COUNT));
    }

    @Test
    public void testFindInsertDateBetween() throws Exception {
        print(this, "testFindInsertDateBetween");
        List<NonEntity> list = nonEntityRepository.findByInsertDateBetween(Instant.now().minus(1, DAYS), Instant.now().plus(1, DAYS));
        assertThat(list, notNullValue());
        assertThat(list, not(emptyIterable()));
        assertThat(list, hasSize(COUNT));
    }
}
