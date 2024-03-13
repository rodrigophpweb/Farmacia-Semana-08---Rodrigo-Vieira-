package br.com.alura.springfarmacia.repository;

import br.com.alura.springfarmacia.orm.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
