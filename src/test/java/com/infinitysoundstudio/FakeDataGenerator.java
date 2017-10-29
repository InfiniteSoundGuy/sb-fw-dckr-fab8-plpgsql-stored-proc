package com.infinitysoundstudio;

import static com.infinitysoundstudio.TestConstants.PROP_ID1;
import com.infinitysoundstudio.domain.entity.ExampleEntity;
import com.infinitysoundstudio.domain.repository.ExampleEntityRepository;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

public class FakeDataGenerator implements TestConstants {

    Random random = new Random();

    public ExampleEntity createEntity() {
        return new ExampleEntity(0, Instant.now(), LABEL1, PROP_ID1, UUID.randomUUID().toString());
    }

    public ExampleEntity createEntity(Function<ExampleEntity, ExampleEntity> func) {
        return func.apply(FakeDataGenerator.this.createEntity());
    }

    public List<ExampleEntity> createEntity(int numberOfEachType, Function<ExampleEntity, ExampleEntity> func) {
        List<ExampleEntity> list = new ArrayList<>();
        IntStream.range(0, numberOfEachType).forEach((i) -> {
            list.add(FakeDataGenerator.this.createEntity(func));
        });
        return list;
    }

    public void loadEntities(ExampleEntityRepository eeRepo, int numberOfEachType) {
        eeRepo.save(createEntity(numberOfEachType, ee -> {
            // Randomize some field values
            int index = random.ints(0, 5).limit(1).findFirst().getAsInt();
            ee.setPropId(PROP_IDS[index]);
            ee.setLabel(LABELS[index]);
            return ee;
        }));
        eeRepo.flush();
    }
}
