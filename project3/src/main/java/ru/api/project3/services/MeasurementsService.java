package ru.api.project3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.api.project3.models.Measurement;
import ru.api.project3.repositories.MeasurementsRepository;
import ru.api.project3.repositories.SensorsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class MeasurementsService {
    private final MeasurementsRepository measurementsRepository;
    private final SensorsRepository sensorsRepository;

    @Autowired
    public MeasurementsService(MeasurementsRepository measurementsRepository, SensorsRepository sensorsRepository) {
        this.measurementsRepository = measurementsRepository;
        this.sensorsRepository = sensorsRepository;
    }


    public List<Measurement> findAll() {
        return measurementsRepository.findAll();
    }

    public Measurement findOne(int id) {
        Optional<Measurement> foundMeasurement = measurementsRepository.findById(id);
        return foundMeasurement.orElse(null);
    }

    @Transactional
    public void save(Measurement measurement) {
        enrichMeasurement(measurement);
        measurementsRepository.save(measurement);
    }

    @Transactional
    public void update(Measurement updateMeasurement, int id) {
        updateMeasurement.setMeasurementId(id);
        measurementsRepository.save(updateMeasurement);
    }

    @Transactional
    public void delete(int id) {
        measurementsRepository.deleteById(id);
    }


    public List<Measurement> findRainingDays() {
        return measurementsRepository.findAllByRainingTrue();
    }
    private void enrichMeasurement(Measurement measurement) {
        measurement.setCreatedAt(LocalDateTime.now());
        measurement.setSensor(sensorsRepository.findByName(measurement.getSensor().getName()));
    }

}
