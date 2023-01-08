package ru.api.project3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.api.project3.models.Sensor;

@Repository
public interface SensorsRepository extends JpaRepository<Sensor, Integer> {
    Sensor findByName(String name);
}
