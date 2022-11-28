package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Seleccion;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
	public List<Seleccion> findByDescripcion(String descripcion);

	public List<Seleccion> findAll();

	public void save(Seleccion seleccion);
}
