package Account;

import java.time.LocalDateTime;

public class RegularAccount extends BankAccount {

    //Конструктор класса
    public RegularAccount(double account, String bio, Integer pin, int openMonth) {
        super(account, bio, pin, openMonth, 100, 0.1, 0);
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

    //Рассчет штрафов и прочего в конце месяца
    @Override
    public void makeFineAndOther() {
        this.account -= Math.min(fine, this.account*commission);
        if (this.account < 5000) {
            this.account -= fine;
            this.detalis.add(LocalDateTime.now().format(formatter)+" Штраф: " + fine);
        }
        this.detalis.add(LocalDateTime.now().format(formatter)+" Обслуживание: " + Math.min(fine, this.account*commission));
    }
}
