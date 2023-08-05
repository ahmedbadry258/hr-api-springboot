package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Location;
import com.example.demo.entities.Region;
import com.example.demo.repositories.LocationRepository;
import com.example.demo.repositories.RegionRepository;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/locations")
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;

	
	@GetMapping
	public List<Location> findAll(){
		return locationRepository.findAll();
	}
	@GetMapping("/{id}")
	public Location findLocationById(@PathVariable ("id") Long id){
		return locationRepository.findById(id).get();
	}
	@PostMapping
	public Location saveLocation(@RequestBody Location location){
		location=locationRepository.save(location);
		return location;
	}
	@PutMapping("/{id}")
	public Location editLocation(@PathVariable ("id") Long id,@RequestBody Location location){
		Location l=locationRepository.findById(id).get();
		l.setCity(location.getCity());
		l.setCountry(location.getCountry());
		l.setPostalCode(location.getPostalCode());
		l.setStateProvince(location.getStateProvince());
		l.setStreetAddress(location.getStreetAddress());
		l=	locationRepository.save(l);
		return l;
	}
	@DeleteMapping("/{id}")
	public String deleteLocation(@PathVariable ("id") Long id){
		locationRepository.deleteById(id);
		return "Location has been deleted";
	}

}
