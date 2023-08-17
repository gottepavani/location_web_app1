package com.psa.location_web_app1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psa.location_web_app1.entities.Locations;
import com.psa.location_web_app1.repositories.LocationsRepositary;

@Controller
public class LocationsController {
	@Autowired
	private LocationsRepositary locationsRepo;
	
	@RequestMapping("/showLocations")
	public String showLocations()
	{
		return "showLocations";
	}
	@RequestMapping("/saveLoc")
	public String saveLoc(@ModelAttribute("locations") Locations locations,ModelMap modelMap)
	{
		locationsRepo.save(locations);
	modelMap.addAttribute("msg", "location Saved!!");
		return "showLocations";
	}
	@RequestMapping("/getLocations")
	public String getLocations(ModelMap modelMap)
	{
		List<Locations> locations = locationsRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap)
    {
		List<Locations> locations = locationsRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id") Long id,ModelMap modelMap)
	{
		locationsRepo.deleteById(id);
	List<Locations> locations = locationsRepo.findAll();
		modelMap.addAttribute("locations", locations);
		return "getLocations";
	}
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam("id")Long id,ModelMap modelMap)
	{
		Optional<Locations> findById = locationsRepo.findById(id);
		Locations locations = findById.get();
		modelMap.addAttribute("id", locations.getId());
		modelMap.addAttribute("code", locations.getCode());
		modelMap.addAttribute("name", locations.getName());
		modelMap.addAttribute("type", locations.getType());

		return "updateTheLocation";
	}
	@RequestMapping("/updateLocationData")
	public String updateLocationData(@ModelAttribute("locations") Locations locations,ModelMap modelMap)
	{
		locations.setCode(locations.getCode());
		locations.setName(locations.getName());
		locations.setType(locations.getType());
		locationsRepo.save(locations);
		modelMap.addAttribute("updatemsg","Location record is updated");
		return "updateTheLocation";
	}

}
