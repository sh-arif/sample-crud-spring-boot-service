package org.sharif.sampleapp.dao.models;

import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.sharif.sampleapp.common.UpdatableEntity;
import javax.persistence.*;
import java.util.UUID;


@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sample_data_table")
public class SampleDataDao extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID id;

    @Column(name = "entity")
    private String entity;

    @Column(name = "entity_type")
    private String entityType;
}
