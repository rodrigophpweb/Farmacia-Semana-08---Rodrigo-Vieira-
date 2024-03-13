package br.com.alura.springfarmacia.repository;


import br.com.alura.springfarmacia.orm.Fabricante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends CrudRepository<Fabricante, Integer> {
}
