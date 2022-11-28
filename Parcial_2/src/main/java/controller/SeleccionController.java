package controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Continente;
import entities.Seleccion;
import repository.SeleccionRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/selecciones")
public class SeleccionController {
	
	@Autowired
	SeleccionRepository seleccionRepository;
	
	@GetMapping
	public List<Seleccion> getSeleccionAll() {

		return seleccionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Seleccion getSeleccionesbyId(@PathVariable Integer id) {
		
		Optional<Seleccion> seleccion = seleccionRepository.findById(id);
		
		if (seleccion.isPresent()) {
			return seleccion.get();
		}
		
		return null;

	}
	
	@PostMapping
	public Seleccion postSelecciones(@RequestBody Seleccion seleccion) {
		
		seleccionRepository.save(seleccion);
		
		return seleccion;
		

	}
}
