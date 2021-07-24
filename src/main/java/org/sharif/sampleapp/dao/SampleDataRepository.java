package org.sharif.sampleapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import org.sharif.sampleapp.dao.models.SampleDataDao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SampleDataRepository extends CrudRepository<SampleDataDao, Long> {
     List<SampleDataDao> getAllByEntityAndEntityTypeOrderByCreatedDateDesc(String entity, String entityType);

     Optional<SampleDataDao> getAllById(UUID id);
}
