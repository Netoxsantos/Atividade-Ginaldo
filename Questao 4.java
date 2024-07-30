import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
System.out.print("============================"); 
        System.out.print("Digite o modelo do carro: ");
        String modeloCarro = scanner.nextLine();
        System.out.print(" ");
        System.out.print("Digite a data e hora de início da locação (formato dd/MM/yyyy HH:mm): ");
        LocalDateTime inicioLocacao = lerDataHora(scanner);
        System.out.print(" ");
        System.out.print("Digite a data e hora de término da locação (formato dd/MM/yyyy HH:mm): ");
        LocalDateTime fimLocacao = lerDataHora(scanner);
        System.out.print(" ");
        System.out.print("Digite o valor por hora de locação: ");
        double valorPorHora = scanner.nextDouble();
        System.out.print(" ");
        System.out.print("Digite o valor diário de locação: ");
        double valorDiario = scanner.nextDouble();


        long horasTotais = Duration.between(inicioLocacao, fimLocacao).toHours();


        double valorLocacao;
        if (horasTotais <= 12) {
            valorLocacao = horasTotais * valorPorHora;
        } else {
            long dias = horasTotais / 24;
            long horasRestantes = horasTotais % 24;
            valorLocacao = dias * valorDiario + horasRestantes * valorPorHora;
        }


        double imposto;
        if (valorLocacao <= 100.00) {
            imposto = valorLocacao * 0.20;
        } else {
            imposto = valorLocacao * 0.15;
        }


        double valorTotal = valorLocacao + imposto;


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String inicioFormatado = inicioLocacao.format(formatter);
        String fimFormatado = fimLocacao.format(formatter);


        System.out.println("\n--- Nota de Pagamento ---");
        System.out.println("Modelo do carro: " + modeloCarro);
        System.out.println("Data e hora de início da locação: " + inicioFormatado);
        System.out.println("Data e hora de término da locação: " + fimFormatado);
        System.out.printf("Valor da locação: R$ %.2f%n", valorLocacao);
        System.out.printf("Imposto: R$ %.2f%n", imposto);
        System.out.printf("Valor total: R$ %.2f%n", valorTotal);
        System.out.print("============================");

        scanner.close();
    }


    private static LocalDateTime lerDataHora(Scanner scanner) {
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(input, formatter);
    }
}