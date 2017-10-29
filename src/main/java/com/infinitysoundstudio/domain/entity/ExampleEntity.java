package com.infinitysoundstudio.domain.entity;

import java.time.Instant;
import javax.persistence.*;
import lombok.*;

// JPA annotations
@Entity
@Table(name = "example")
// Lombok annotations to cut down on boilerplate code
@Data
@EqualsAndHashCode(exclude = "id")
@AllArgsConstructor
@NoArgsConstructor
public class ExampleEntity {

    // Lombok creates an all-args constructor that takes parameters in this
    // order.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant insertDate;
    private String label;
    private String propId;
    private String caseId;
}
