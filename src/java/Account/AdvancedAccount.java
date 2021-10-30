package Account;

import java.time.LocalDateTime;

public class AdvancedAccount extends BankAccount {

    //Конструктор класса
    public AdvancedAccount(double account, String bio, Integer pin, int openMonth) {
        super(account, bio, pin, openMonth, 100, 0.1, 0.01);
    }




    public double getAccount() {
        return this.account;
    }

    //Снятие денег со счета
    @Override
    public void getSomeMoney(double money, Integer inputPin) {
        if (checkPin(inputPin)) {
            if (checkMoney(money)) {
                this.account -= money;
                this.detalis.add("Снятие денег: " + money);
            } else {
                System.out.println("На вашем счету недостаточно денег.");
            }
        } else {
            pinError();
        }
    }

    //Обслуживание
    public void makeFineAndOther() {
        this.account -= Math.min(fine, this.account*commission);
        this.detalis.add(LocalDateTime.now().format(formatter)+" Обслуживание: " + Math.min(fine, this.account*commission));
    }
}
