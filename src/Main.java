import entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        int opcaoMenu;

        ArrayList<Produto> listaProduto = new ArrayList<>();

        do {
            System.out.println("Menu Produtos:");
            System.out.println("1 - Cadastrar produto:");
            System.out.println("2 - Alterar produto:");
            System.out.println("3 - Remover produto:");
            System.out.println("4 - Pesquisar produto:");
            System.out.println("5 - Catalogo produto:");
            System.out.println("6 - Sair:");
            opcaoMenu = scanner.nextInt();
            executarOpcao(opcaoMenu, listaProduto);
        } while (opcaoMenu != 6);
    }

    public static void executarOpcao(int opcaoMenu, ArrayList<Produto> listaProduto) {
        switch (opcaoMenu) {
            case 1:
                cadastrar(listaProduto);
                break;
            case 2:
                alterarProduto(listaProduto);
                break;
            case 5:
                catalogo(listaProduto);
                break;
            default:
                System.out.println("Saindo...");
        }
    }

    public static void cadastrar(ArrayList<Produto> listaProduto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto");
        String nome = scanner.nextLine();
        System.out.println("Digite a descricao do produto");
        String descricao = scanner.nextLine();
        System.out.println("Digite o preco do produto");
        double preco = scanner.nextDouble();
        System.out.println("Digite a quantidade do produto");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, descricao, preco, quantidade);

        listaProduto.add(produto);

    }

    public static void alterarProduto(ArrayList<Produto> listaProduto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero do produto que deseja remover");
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mudar nome");
        String nome = scanner.nextLine();;
        listaProduto.get(idProduto-1).setNome(nome);
    }

    public static void catalogo(ArrayList<Produto> listaProduto) {
        for (Produto produto : listaProduto) {
            System.out.println(produto.toString());
        }
    }

}