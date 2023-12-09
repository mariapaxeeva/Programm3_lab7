import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        int test = 0;
        Scanner in = new Scanner(System.in);
        // Credit credit0 = new Credit();
        // System.out.println(++test + ") Тест конструктора без параметров (+ демонстрация использования статического поля number - счетчика номера кредита)");
        // credit0.OutData();

        // Credit creditTest = new Credit("банк", "Сбербанк", "Иванов И. И.", 30, 20000, 0, 1000, '-', "Петров П. П.", 45000, 100000, 4.8f, 10,"рубль");
        // System.out.println("\n" + ++test + ") Тест конструктора со всеми параметрами");
        // creditTest.OutData();

        // System.out.println("\n" + ++test + ") Тест метода для подсчета хранящихся в базе кредитов (Credit реализуется интерфейсом InterfaceCredit)");
        // Credit.PrintCountCredits();

        // System.out.println("\n" + ++test + ") Тест метода для проверки одобрения кредита");
        // creditTest.Approve();

        // System.out.println("\n" + ++test + ") Тест метода для расчета суммы, которую требуется выплатить по процентной ставке");
        // creditTest.PercentCalculate();

        // System.out.println("\n" + ++test + ") Тест метода для расчета месячной выплаты");
        // System.out.printf("Выплата составляет %g\n", creditTest.CalculateMonthPayment());

        // System.out.println("\n" + ++test + ") Тест метода для расчета суммы, которую требуется выплатить по процентной ставке при досрочном погашении");
        // creditTest.EarlyRepaymentPercentCalculate();

        // Borrower borrowerTest = new Borrower();
        // System.out.println("\n" + ++test + ") Тест метода для оценки вероятности одобрения кредита");
        // borrowerTest.CheckProbabilityApproval();

        // System.out.println("\n" + ++test + ") Тест метода для ввода с консоли и вывода в консоль вероятности одобрения кредита");
        // creditTest = creditTest.InputData();
        // creditTest.OutData();

        // System.out.println("\n" + ++test + ") Одномерный динамический массив объектов класса");
        // ArrayList<Credit> data = new ArrayList<>();
        // data.add(credit0);
        // data.add(new Credit("банк", "Сбербанк", "Иванов И. И.", 30, 20000, 0, 1000, '-', "Петров П. П.", 45000, 100000, 4.8f, 10,"рубль"));
        // data.add(new Credit(45));
        // for (int i = 0; i < 3; i++)
        //     System.out.println(data.get(i).GetPeriod());

        // data.removeAll(data);

        // System.out.println("\n" + ++test + ") Двумерный массив объектов класса");
        // Credit[][] twoData = new Credit[2][2];
        // twoData[0][0] = new Credit(207);
        // twoData[0][1] = new Credit(1890);
        // twoData[1][0] = new Credit(43);
        // twoData[1][1] = new Credit(345);

        // for (int i = 0; i < twoData.length; i++)
        //     for (int j = 0; j < twoData[i].length; j++)
        //         System.out.println(twoData[i][j].GetPeriod());

        
        // System.out.println("\n" + ++test + ") Обработка строк");
        // String exa = "конка";
        // String mple = "тенация";
        // System.out.println(exa + mple);

        // System.out.println("\n" + ++test + ") Обработка строк (string pool)");
        // String literal1 = "literal";
        // String literal2 = new String("literal").intern();
        // System.out.println(literal1.equals(literal2));

        // System.out.println("\n" + ++test + ") Производный класс (+ модификатор protected предоставляет доступ производному классу,\n" +
        //         "   но запрещает использование сторонними функциями)");

        // LegalPerson urFace = new LegalPerson("банк", 10000, 5, 190000, "Иванов И. И.", 300000, 19403490, 34959484, "Пакистан");
        // System.out.println(urFace.GetDebt());

        // System.out.println("\n" + ++test + ") Перегрузка метода (без вызова метода базового класса)");
        // urFace.OutBorrower(1);

        // System.out.println("\n" + ++test + ")  Перегрузка метода (с вызовом метода базового класса)");
        // ((Borrower) urFace).OutBorrower();

        // System.out.println("\n" + ++test + ") Шаблон класса TransferMoney");
        // TransferMoney<Integer> accTransfer = new TransferMoney<>(102030400, 123405030, 4500);
        // accTransfer.Transfer();
        // TransferMoney<String> nameTransfer = new TransferMoney<>();
        // nameTransfer.Transfer();

        // System.out.println("\n" + ++test + ") Клонирование");
        // Lender lend = new Lender("bank", "Sberbank");
        // Lender clone = null;
        // clone = (Lender) lend.clone();
        // System.out.println("Cloned Object: " + clone + '\n');
        // if (lend.GetTitle() == clone.GetTitle()) {
        //     System.out.println("Shallow Copy");
        // }
        // else {
        //     System.out.println("Deep Copy");
        // }
        System.out.println("\n" + (++test) + ") Vector");
        Borrower[] borrowers = { new Borrower("Петров", 15, 150000, 5, 10000, '-', "Гарант Г. Г.", 1200),
                                 new Borrower("Иванов", 15, 15, 5, 100, '-', "Гант Г. Г.", 12), 
                                 new Borrower("Сидоров", 15, 1000, 5, 1000, '-', "Гар Г. Г.", 200) };
        LegalPerson[] urFace1 = { new LegalPerson("Банк", 10000, 5, 190000, "Иванов И. И.", 300000, 19403490, 34959484, "Пакистан"),
                                 new LegalPerson("МФО", 1000, 5, 1900, "Ива И. И.", 3000, 403490, 34959484, "Пактан"), 
                                 new LegalPerson("Должник", 100, 5, 1000, "Иван И. И.", 30, 193490, 34959484, "Пан") };
        Bank bank = new Bank();
        bank.AddBorrower(borrowers[0]);
        bank.AddBorrower(urFace1[0]);
        bank.AddBorrower(borrowers[1]);
        bank.AddBorrower(borrowers[2]);
        bank.AddBorrower(urFace1[2]);
        bank.OutBorrowers();
        System.out.println("\n" + (++test) + ") Алгоритм сортировки по имени или названию организации");
        bank.SortedBorrowersByName();
        bank.OutBorrowers();
        System.out.println("\n" + (++test) + ") Алгоритм поиска по имени или названию организации");
        bank.FindName("Сидоров");
        bank.FindName("Должник");
        bank.FindName("Бульвар");
    }
}
