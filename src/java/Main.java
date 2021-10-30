import Account.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RegularAccount regularAccount = new RegularAccount(123, "Иванов Иван Иванович", 1234, 5);

        regularAccount.repAccount(5000, inputPin());
        regularAccount.spendMoney(123, inputPin(), "Летуаль");
        regularAccount.spendMoney(1234, inputPin(), "Летуаль");
        regularAccount.getAccount(inputPin());
        regularAccount.makeFineAndOther();

        System.out.println(regularAccount);
        regularAccount.getDetalis();

       /* AdvancedAccount advancedAccount = new AdvancedAccount(123, "Иванов Иван Иванович", 1234, 5);

        advancedAccount.repAccount(5000, inputPin());
        advancedAccount.spendMoney(123, inputPin());
        advancedAccount.spendMoney(1234, inputPin());

        System.out.println(advancedAccount);
        advancedAccount.getDetalis();*/


    /*    YouthAccount youthAccount = new YouthAccount(123, "Иванов Иван Иванович", 1234, 5);

        youthAccount.repAccount(5000, inputPin());
        youthAccount.spendMoney(123, inputPin());
        youthAccount.spendMoney(1234, inputPin());

        System.out.println(youthAccount);
        youthAccount.getDetalis();*/



    }

    private static Integer inputPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите пин код:");
        Integer pinCode = Integer.parseInt(scanner.nextLine());
        return pinCode;
    }

}
