import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===============================");
        System.out.print("Número do contrato: ");
        System.out.println(" ");
        String numeroContrato = scanner.nextLine();
        System.out.println(" ");
        System.out.print("Data do contrato (dd/MM/yyyy): ");
        String dataContratoStr = scanner.nextLine();
        LocalDate dataContrato = LocalDate.parse(dataContratoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(" ");
        System.out.print("Valor total do contrato: ");
        double valorTotal = scanner.nextDouble();
        System.out.println(" ");
        System.out.print("Número de meses para parcelamento: ");
        
        int numeroMeses = scanner.nextInt();

        gerarParcelas(numeroContrato, dataContrato, valorTotal, numeroMeses);

        scanner.close();
    }

    public static void gerarParcelas(String numeroContrato, LocalDate dataContrato, double valorTotal, int numeroMeses) {
        double valorParcelaBase = valorTotal / numeroMeses;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(" ");
        System.out.println("Número do contrato: " + numeroContrato);
        System.out.println("Data do contrato: " + dataContrato.format(formatter));
        System.out.println("Valor total do contrato: " + valorTotal);
        System.out.println("Número de meses para parcelamento: " + numeroMeses);
        System.out.println(" ");
        System.out.println("\nParcelas:");

        for (int i = 1; i <= numeroMeses; i++) {
            LocalDate dataParcela = dataContrato.plusMonths(i);
            double valorParcela = valorParcelaBase + (valorParcelaBase * 0.01 * i);
            valorParcela += valorParcela * 0.02;  
            System.out.println("===============================");
            System.out.printf("Parcela %d: Data: %s, Valor: %.2f\n", i, dataParcela.format(formatter), valorParcela);
System.out.println("===============================");
        }
    }
}