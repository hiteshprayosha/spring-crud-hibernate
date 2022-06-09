package io.hitesh.repository;

import io.hitesh.model.Employee;
import io.hitesh.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}