package br.com.alura.springfarmacia;

import br.com.alura.springfarmacia.orm.Produto;
import br.com.alura.springfarmacia.repository.ProdutoRepository;
import br.com.alura.springfarmacia.service.CrudFabricanteService;
import br.com.alura.springfarmacia.service.CrudProdutoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringFarmaciaApplication implements CommandLineRunner {

	private final CrudProdutoService produtoService;

	private final CrudFabricanteService fabricanteService;

	private Boolean system = true;

	public SpringFarmaciaApplication(CrudProdutoService produtoService,  CrudFabricanteService fabricanteService) {
		this.produtoService = produtoService;
		this.fabricanteService = fabricanteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringFarmaciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner =new Scanner(System.in);

		while (system) {
			System.out.println("Qual ação você quer executar ");
			System.out.println("0 - Sair");
			System.out.println("1 - Produto");
			System.out.println("2 - Fabricante");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					produtoService.inicial(scanner);
					break;
				case 2:
					fabricanteService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}

	}
}
