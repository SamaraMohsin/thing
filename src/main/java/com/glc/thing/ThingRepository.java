package com.glc.thing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThingRepository extends JpaRepository<Thing,Long> {
    public Optional<Thing> findByMyName(String name);

}
