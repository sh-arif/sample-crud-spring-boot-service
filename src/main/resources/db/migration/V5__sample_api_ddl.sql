DROP TABLE IF EXISTS sample_data_table;
CREATE TABLE sample_data_table (
    id                  UUID PRIMARY KEY           ,
    entity              VARCHAR(50)                     ,
    entity_type         VARCHAR(50)                     ,
    created_date        TIMESTAMP                       ,
    last_modified_date  TIMESTAMP                       ,
    created_by          VARCHAR(255)                    ,
    last_modified_by    VARCHAR(255)
);
