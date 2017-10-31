package com.infinitesoundstudio.domain.nonentity;

import java.time.Instant;
import lombok.*;

// Lombok annotations to cut down on boilerplate code
@Data
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
public class NonEntity {

    // Lombok creates an all-args constructor that takes parameters in this
    // order. I rearranged the fields in this class so Lombok would generate an
    // all-args constructor different from ExampleEntity.
    private String caseId;
    private String propId;
    private String label;
    private Instant insertDate;
    private long id;
}
