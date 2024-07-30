import java.util.ArrayList;
import java.util.Scanner;

class Produtos {
    private String nome;
    private String validade;
    private double preco;

    public Produtos(String nome, double preco, String validade) {
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
    }

    public String getValidade() {
        return validade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produtos> produtos = new ArrayList<>();

        System.out.println("=======================================================");
        System.out.println("Gerenciamento de produtos");
        System.out.println("Qual tipo de produto você deseja cadastrar?");
        System.out.println("1- Normal, 2- Usado, 3- Importado, 4- Encerrar Cadastros");
        while (true) {
            System.out.println(" ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println(" ");
            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); 
                    Produtos novoProduto = new Produtos(nome, preco, "");
                    produtos.add(novoProduto);
            System.out.println(" ");
            System.out.println("Produto cadastrado com sucesso!");
            System.out.println(" ");
                    break;

                case 2:
                    System.out.print("Nome do produto:");
                    String nomeU = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoU = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Validade do produto:");
                    String validade = scanner.nextLine();
                    Produtos novoProdutoU = new Produtos(nomeU, precoU, validade);
                    produtos.add(novoProdutoU);
                    System.out.println(" ");
            System.out.println("Produto cadastrado com sucesso!");
System.out.println(" ");
                    break;

                case 3:
                    System.out.print("Nome do produto:");
                    String nomeI = scanner.nextLine();
                    System.out.print("Preço: ");
                    double precoI = scanner.nextDouble();
                    scanner.nextLine(); 
                    precoI *= 1.60; 
                    Produtos novoProdutoI = new Produtos(nomeI, precoI, "");
                    produtos.add(novoProdutoI);
                    System.out.println(" ");
                    System.out.println("Produto cadastrado com sucesso!");
                    System.out.println(" ");
                    break;

                case 4:
                    System.out.println("Encerrando cadastros...");
                    System.out.println(" ");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            if (opcao == 4) {
                break; 
            }

            System.out.println("Qual tipo de produto você deseja cadastrar?");
            System.out.println("1- Normal, 2- Usado, 3- Importado, 4- Encerrar Cadastros");
        }

        System.out.println("Produtos cadastrados:");
        for (Produtos p : produtos) {
            System.out.println("Nome: " + p.getNome() + " - Preço: " + p.getPreco() + " - Validade: " + p.getValidade());
        }
        System.out.println("=======================================================");
        scanner.close();
    }
}
