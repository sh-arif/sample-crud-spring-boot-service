package org.sharif.sampleapp.web;

import org.sharif.sampleapp.service.models.SampleDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import org.sharif.sampleapp.service.SampleDataService;


@RestController
@RequestMapping("sample")
public class SampleController {
    @Autowired
    SampleDataService sampleDataService;

    private final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/getall")
    public ResponseEntity<?> getAllData() {
        try {
            return new ResponseEntity<>(sampleDataService.getAll(), HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> saveSampleData(@RequestBody SampleDataModel sampleDataModel) {
        try {
            sampleDataService.saveSampleData(sampleDataModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw ex;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSampleData(@RequestBody SampleDataModel sampleDataModel) {
        try {
            sampleDataService.updateSampleData(sampleDataModel);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
