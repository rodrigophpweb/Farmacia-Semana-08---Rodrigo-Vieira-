package br.com.alura.springfarmacia.service;

import br.com.alura.springfarmacia.orm.Fabricante;
import br.com.alura.springfarmacia.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudFabricanteService {

    private Boolean system = true;
    private final FabricanteRepository fabricanteRepository;

    public CrudFabricanteService(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }


    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual acao de fabricante deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Listar Fabricantes");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    listar();
                    break;
                default:
                    system = false;
                    break;
            }
        }

    }
        private void salvar (Scanner scanner){
            System.out.println("Insira o id do fabricante");
            Integer id = scanner.nextInt();
            System.out.println("Insira o nome do fabricante");
            String nome = scanner.next();

            Fabricante fabricante = new Fabricante();
            fabricante.setId(id);
            fabricante.setNome(nome);
            fabricanteRepository.save(fabricante);
            System.out.println("Fabricante salvo");
        }
    private void listar() {
        Iterable<Fabricante> fabricantes = fabricanteRepository.findAll();
        for (Fabricante fabricante : fabricantes) {
            System.out.println(fabricante);
        }
    }
}
