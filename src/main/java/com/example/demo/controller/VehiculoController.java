package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Vehiculo;
import com.example.demo.service.IVehiculoService;

@Controller
public class VehiculoController {
	
	@Autowired
	private IVehiculoService vehiculoService;
	
	@GetMapping("/vehiculos")
	public String findAll(Model model){
		model.addAttribute("vehiculo", new Vehiculo());
		model.addAttribute("vehiculos", vehiculoService.findAll());
		return "vehiculos";
	}
	
	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("vehiculo") Vehiculo vehiculo){
		Vehiculo v = vehiculoService.save(vehiculo);
		v.setImpuesto(vehiculoService.getTax(vehiculo));
		return "redirect:/vehiculos";
		
	}

}
