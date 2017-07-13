package com.example.demo.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Vehiculo;
import com.example.demo.repository.VehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService{
	
	@Autowired
	private VehiculoRepository repository;

	@Override
	public List<Vehiculo> findAll() {
		return repository.findAll();
	}

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		double discount=getTax(vehiculo);
		vehiculo.setImpuesto(discount);
		return repository.save(vehiculo);
	}

	@Override
	public Vehiculo findById(long id) {
		return repository.findOne(id);
	}

	@Override
	public double getTax(Vehiculo vehiculo) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int anios = year - vehiculo.getAnio();
		double discount = 0.0;
		if(anios >= 5 && anios <10){
			discount = 0.03*vehiculo.getPreciofactura();
		}else if(anios >=10 && anios <15){
			discount = 0.06*vehiculo.getPreciofactura();
		}else if(anios >=15){
			discount = 0.1*vehiculo.getPreciofactura();
		}
		return discount;
	}

}
