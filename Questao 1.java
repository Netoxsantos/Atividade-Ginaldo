import java.util.ArrayList;
import java.util.Scanner;


class Funcionario {
    protected String nome;
    protected double horasTrabalhadas;
    protected double valorHora;

    public Funcionario(String nome, double horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public String getNome() {
        return nome;
    }

    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }
}


class FuncionarioTerceirizado extends Funcionario {
    public FuncionarioTerceirizado(String nome, double horasTrabalhadas, double valorHora) {
        super(nome, horasTrabalhadas, valorHora);
    }

    @Override
    public double calcularPagamento() {

        return super.calcularPagamento() * 1.1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        System.out.println("=======================================================");
        System.out.println("CADASTRO DE FUNCIONÁRIOS");
        System.out.println("Digite os dados dos funcionários. Para ver os funcionários cadastrados, digite 'l'para ver os funcionarios cadastrados");
        System.out.println("=======================================================");
        System.out.println(" ");

        while (true) {
            System.out.print("Tipo de funcionário (normal) ou (terceirizado): ");
            System.out.println(" ");
            String tipoFuncionario = scanner.nextLine();

            if (tipoFuncionario.equalsIgnoreCase("l")) {
                break;
            }
System.out.println(" ");
            System.out.print("Nome do funcionário: ");
            String nome = scanner.nextLine();
System.out.println(" ");
            System.out.print("Horas trabalhadas: ");
            double horasTrabalhadas = scanner.nextDouble();
            scanner.nextLine();
System.out.println(" ");
            System.out.print("Valor por hora: ");
            double valorHora = scanner.nextDouble();
            scanner.nextLine();

            if (tipoFuncionario.equalsIgnoreCase("terceirizado")) {
                FuncionarioTerceirizado terceirizado = new FuncionarioTerceirizado(nome, horasTrabalhadas, valorHora);
                funcionarios.add(terceirizado);
            } else {
                Funcionario normal = new Funcionario(nome, horasTrabalhadas, valorHora);
                funcionarios.add(normal);
            }

            System.out.println(" ");System.out.println("Funcionário cadastrado com sucesso!");
            System.out.println();
        }
System.out.println(" ");
        System.out.println("FUNCIONÁRIOS CADASTRADOS:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof FuncionarioTerceirizado) {
                FuncionarioTerceirizado terceirizado = (FuncionarioTerceirizado) funcionario;
                System.out.println(" ");
                System.out.print("Nome: " + terceirizado.getNome() + " - Tipo: Terceirizado - Pagamento: " + terceirizado.calcularPagamento());
            } else {
                System.out.print("Nome: " + funcionario.getNome() + " - Tipo: Normal - Pagamento: " + funcionario.calcularPagamento());
            }
            System.out.println();
        }

        scanner.close();
    }
}
