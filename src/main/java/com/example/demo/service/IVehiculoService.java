package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Vehiculo;

public interface IVehiculoService {
	
	
	public List<Vehiculo> findAll();
	
	public Vehiculo save(Vehiculo vehiculo);
	
	public Vehiculo findById(long id);
	
	public double getTax(Vehiculo vehiculo);
	

}
