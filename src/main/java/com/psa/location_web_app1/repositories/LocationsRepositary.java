package com.psa.location_web_app1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.psa.location_web_app1.entities.Locations;

public interface LocationsRepositary extends JpaRepository<Locations, Long> {

}
