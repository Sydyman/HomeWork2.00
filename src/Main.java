import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите сумму для снятия: ");
            double sum = scanner.nextDouble();

            try {
                account.withDraw(sum);
                System.out.println("Снято" + sum + " сом Остаток на счете: " + account.getAmount());
            } catch (LimitException e) {
                System.out.println(e.getMessage());
                System.out.println("Попытка снять оставшуюся сумму: " + e.getRemainingAmount() + " сом");
                try {
                    account.withDraw(e.getRemainingAmount());
                    System.out.println("Снято " + e.getRemainingAmount() + " сом. Остаток на счете: " + account.getAmount());
                } catch (LimitException ex) {

                    ex.printStackTrace();
                }
                break;
            }
        }


    }
}
