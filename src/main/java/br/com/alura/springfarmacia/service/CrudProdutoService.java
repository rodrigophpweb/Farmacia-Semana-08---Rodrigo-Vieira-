package br.com.alura.springfarmacia.service;

import br.com.alura.springfarmacia.orm.Fabricante;
import br.com.alura.springfarmacia.orm.Produto;
import br.com.alura.springfarmacia.repository.FabricanteRepository;
import br.com.alura.springfarmacia.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudProdutoService {

    private Boolean system = true;
    private final ProdutoRepository produtoRepository;

    private final FabricanteRepository fabricanteRepository;

    public CrudProdutoService(ProdutoRepository produtoRepository, FabricanteRepository fabricanteRepository) {
        this.produtoRepository = produtoRepository;
        this.fabricanteRepository = fabricanteRepository;
    }

    public void inicial(Scanner scanner) {
        while (system){
            System.out.println("Qual ação de produto deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    editarNomeProduto(scanner);
                    break;
                case 3:
                    listar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner){
        System.out.println("Inisra o id do produto");
        Integer id = scanner.nextInt();
        System.out.println("Insira o nome do produto");
        String nome = scanner.next();
        System.out.println("Insira a descricao do produto");
        String descricao = scanner.next();
        System.out.println("Insira o preco do produto");
        Double preco = scanner.nextDouble();

        System.out.println("Insira o id do fabricante");
        Integer fabricanteId = scanner.nextInt();
        Fabricante fabricante = fabricanteRepository.findById(fabricanteId)
                .orElseGet(() -> {
                    System.out.println("Fabricante não encontrado. Insira o nome do novo fabricante:");
                    String nomeFabricante = scanner.next();
                    Fabricante novoFabricante = new Fabricante();
                    novoFabricante.setNome(nomeFabricante);
                    return fabricanteRepository.save(novoFabricante); // Salve o novo fabricante
                });


        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produto.setFabricante(fabricante);
        produtoRepository.save(produto);
        System.out.println("Produto salvo");
    }

    private void editarNomeProduto(Scanner scanner) {
        System.out.println("Insira o id do produto");
        Integer id = scanner.nextInt();
        System.out.println("Insira o nome do produto");
        String nome = scanner.next();
        System.out.println(("Insira a descricao do produto"));
        String descricao = scanner.next();
        System.out.println(("Insira o preço do produto"));
        Double preco = scanner.nextDouble();


        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setPreco(preco);
        produtoRepository.save(produto);
        System.out.println("Produto editado");

    }

    private void listar() {
        Iterable<Produto> produtos = produtoRepository.findAll();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private void deletar(Scanner scanner) {
        System.out.println("Digite o Id do produto");
        int id = scanner.nextInt();
        produtoRepository.deleteById(id);
        System.out.println("Produto deletado");
    }
}
