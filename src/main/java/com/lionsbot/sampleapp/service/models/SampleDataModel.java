package com.lionsbot.sampleapp.service.models;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleDataModel {

    private UUID id;
    private String entity;
    private String entityType;

}
