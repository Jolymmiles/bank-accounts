package Account;


import java.time.LocalDateTime;

public class YouthAccount extends BankAccount{

    //Конструктор класса
    public YouthAccount(double account, String bio, Integer pin, int openMonth) {
        super(account, bio, pin, openMonth, 300, 0.1, 0.02);
    }

    //Снятие денег со счета
    @Override
    public void getSomeMoney(double money, Integer inputPin) {
        if (checkPin(inputPin)) {
            if (checkMoney(money-10)) {
                this.account -= money-10;
                this.detalis.add("Снятие денег: " + money);
            } else {
                System.out.println("На вашем счету недостаточно денег.");
            }
        } else {
            pinError();
        }
    }

    public void makeFineAndOther() {
        if (this.account < 5000) {
            this.account -= fine;
            this.detalis.add(LocalDateTime.now().format(formatter)+" Штраф: " + fine);
        }
        this.detalis.add(LocalDateTime.now().format(formatter)+" Обслуживание: " + Math.min(fine, this.account*commission));
    }

    @Override
    public String toString() {
        return "\nДенег на счету: " + account +
                "\nФИО Владельца: " + bio +
                "\nМесяц открытия: " + openMonth +
                "\nШтраф: " + fine +
                "\nКомиссия: " + commission +
                "\nКэшбэк: " + bonus ;
    }

}
