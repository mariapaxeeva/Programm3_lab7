import java.util.Scanner;
abstract class AbstractBorrower {
    public abstract int CheckProbabilityApproval();
}

class Borrower extends AbstractBorrower {
    private int age;
    private char criminal;
    protected String name;
    private int profit;
    private History historyBorrower;
    private Guarantor guarantorBorrower;

    public Borrower() {
        this.name = "none";
        this.historyBorrower = new History();
        this.guarantorBorrower = new Guarantor();
        this.age = 0;
        this.profit = 0;
        this.criminal = '-';
    }

    public Borrower(String nameValue, int ageValue, int profitValue, int repay, int debtValue, char criminalValue, String nameGuarant, int profitGuarant) {
        historyBorrower = new History(repay, debtValue);
        guarantorBorrower = new Guarantor(nameGuarant, profitGuarant);
        name = nameValue;
        age = ageValue;
        profit = profitValue;
        criminal = criminalValue;
    }

    public String ProtectInputString()
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if(str == null || str.isEmpty())
            return null;
        return str;
    }

    public int ProtectInputUnsigned(String message)
    {
        Scanner in = new Scanner(System.in);
        int num;
        while (true) {  
            System.out.println(message);  
            try {  
                num = Integer.parseInt(in.nextLine());
                if (num >= 0)
                    break;
            } catch (Exception e) {  
                System.out.println("Неверный формат ввода! Попробуйте ещё раз.");  
            }  
        }
        return num;
    }

    public Borrower InputBorrower()
    {
        String nameValue;
        int ageValue;
        int profitValue;
        int repay;
        int debtValue;
        char criminalValue;
        String nameGuarant;
        int profitGuarant;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите ФИО заёмщика:");
        } while ((nameValue = ProtectInputString()) == null);
        ageValue = ProtectInputUnsigned("Введите возраст заёмщика:");
        profitValue = ProtectInputUnsigned("Введите сумму дохода заёмщика в месяц:");
        repay = ProtectInputUnsigned("Введите количество ранее погашенных кредитов:");
        debtValue = ProtectInputUnsigned("Введите сумму имеющейся задолженности:");
        do
        {
            System.out.println("Наличие судимости (- - нет, + - есть):");
            criminalValue = in.next().charAt(0);
        } while (criminalValue != '-' && criminalValue != '+');
        do {
            System.out.println("Введите ФИО поручителя:");
        } while ((nameGuarant = ProtectInputString()) == null);
        profitGuarant = ProtectInputUnsigned("Введите сумму дохода поручителя в месяц:");
        Borrower borrower = new Borrower(nameValue, ageValue, profitValue, repay, debtValue, criminalValue,
            nameGuarant, profitGuarant);
        return borrower;
    }

    public void OutBorrower()
    {
        System.out.println("ФИО заёмщика:                      " + this.name);
        System.out.println("Возраст заёмщика:                  " + this.age);
        System.out.println("Доход заёмщика:                    " + this.profit);
        System.out.println("Количество погашенных кредитов     " + this.historyBorrower.GetRepayLoan());
        System.out.println("Сумма задолженности:               " + this.historyBorrower.GetDebt());
        System.out.println("Наличие судимости:                 " + this.criminal);
        System.out.println("ФИО поручителя:                    " + this.guarantorBorrower.GetNameGuarantor());
        System.out.println("Доход поручителя:                  " + this.guarantorBorrower.GetProfitGuarantor());
    }

    //функция оценивает вероятность одобрения кредита некоторому заёмщику
    public int CheckProbabilityApproval()
    {
        Borrower borrowerCredit = InputBorrower();
        boolean conditionAge = true;
        boolean conditionProfit = true;
        boolean conditionHistory = true;
        boolean conditionCriminal = true;
        if (borrowerCredit.age < 18)
            conditionAge = false;
        if (borrowerCredit.profit < 14375)
            conditionProfit = false;
        if (borrowerCredit.historyBorrower.GetRepayLoan() < 2 && borrowerCredit.historyBorrower.GetDebt() > borrowerCredit.profit * 3)
            conditionHistory = false;
        if (borrowerCredit.criminal == '+')
            conditionCriminal = false;
        System.out.println("Заёмщик: " + borrowerCredit.GetName());
        if (conditionAge && conditionProfit && conditionHistory && conditionCriminal)
        {
            System.out.println("Вероятность одобрения кредита высока!");
            return 0;
        }
        else
        {
            System.out.println("К сожалению, кредит вряд ли будет одобрен.");
            return -1;
        }
    }

	public String GetName() {
		return name;
	}

	public int GetAge() {
		return age;
	}

	public int GetProfit() {
		return profit;
	}

	public int GetRepayLoan() {
		return historyBorrower.repayLoan;
	}

	public int GetDebt() {
		return historyBorrower.debt;
	}

	public char GetCriminal() {
		return criminal;
	}

	public String GetNameGuarantor() {
		return guarantorBorrower.nameGuarantor;
	}

	public int GetProfitGuarantor() {
		return guarantorBorrower.profitGuarantor;
	}

    public History GetHistory() {
        return History;
    }

    public Guarantor GetGuarantor() {
        return Guarantor;
    }

	public void SetName(String name) {
		name = name;
	}

	public void SetAge(int age) {
		age = age;
	}

	public void SetProfit(int profit) {
		profit = profit;
	}

	public void SetCriminal(char criminal) {
		criminal = criminal;
	}

    public void SetHistory(History hist) {
        historyBorrower = hist;
    }

    public void SetGuarantor(Guarantor guar) {
        guarantorBorrower = guar;
    }
};