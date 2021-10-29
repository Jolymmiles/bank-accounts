import Account.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RegularAccount regularAccount = new RegularAccount(123, "bio", 1234, 5);

        regularAccount.repAccount(5000, inputPin());
        regularAccount.spendMoney(123, inputPin());
        regularAccount.spendMoney(1234, inputPin());

        System.out.println(regularAccount);
        regularAccount.getDetalis();
        //System.out.println(regularAccount.getAccount());


    }

    private static Integer inputPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пин код:");
        Integer pinCode = Integer.parseInt(scanner.nextLine());
        return pinCode;
    }

}
