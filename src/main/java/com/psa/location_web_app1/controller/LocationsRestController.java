package com.psa.location_web_app1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psa.location_web_app1.entities.Locations;
import com.psa.location_web_app1.repositories.LocationsRepositary;

@RestController
@RequestMapping("/locations")
public class LocationsRestController {
	@Autowired
	private LocationsRepositary locationsRepo;
	
	
@GetMapping
	public List<Locations> getAllLocations()
	{
 return locationsRepo.findAll();

	}
@PostMapping
public Locations saveLocation(@RequestBody Locations locations)
{
return locationsRepo.save(locations);
}
@DeleteMapping("/{id}")
public void deletelocation(@PathVariable("id") Long id)
{
	locationsRepo.deleteById(id);
			}

@PutMapping
public Locations updateLocation(@RequestBody Locations locations)
{
return locationsRepo.save(locations);
}
}