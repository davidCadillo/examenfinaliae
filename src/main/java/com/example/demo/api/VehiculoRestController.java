package com.example.demo.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Vehiculo;
import com.example.demo.service.VehiculoService;

@RestController
@RequestMapping("/api/v1")
public class VehiculoRestController {

	@Autowired
	private VehiculoService service;

	@GetMapping("/vehiculos")
	public ResponseEntity<Collection<Vehiculo>> getVehiculos() {
		return new ResponseEntity<>((Collection<Vehiculo>) service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/vehiculos/{id}")
     public ResponseEntity<Vehiculo> getVehiculo(@PathVariable Long id) {
         return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
     }
	
	
	 @PostMapping("/vehiculos")
	 public Vehiculo create(@RequestBody Vehiculo vehiculo) {
		    return service.save(vehiculo);
	}

	

}
