package org.sharif.sampleapp.service;

import org.sharif.sampleapp.service.models.SampleDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sharif.sampleapp.dao.SampleDataRepository;
import org.sharif.sampleapp.dao.models.SampleDataDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class SampleDataService {

    @Autowired
    SampleDataRepository formMapRepository;

    public Iterable<SampleDataDao> getAll() {
        return formMapRepository.findAll();
    }

    @Transactional
    public void saveSampleData(SampleDataModel sampleDataModel) {
        formMapRepository.save(SampleDataDao.builder().entity(sampleDataModel.getEntity()).entityType(sampleDataModel.getEntityType()).build());
    }

    public void updateSampleData(SampleDataModel sampleDataModel) {
        Optional<SampleDataDao> sampleDataDao = formMapRepository.getAllById(sampleDataModel.getId());
        if(sampleDataDao.isPresent())
        {
            sampleDataDao.get().setEntity(sampleDataModel.getEntity());
            sampleDataDao.get().setEntityType(sampleDataModel.getEntityType());
            formMapRepository.save(sampleDataDao.get());
        }
    }
}
