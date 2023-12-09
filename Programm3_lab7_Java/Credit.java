import java.util.Scanner;
public class Credit
{
	static int number = 0;
	Lender lenderCredit;
	Borrower borrowerCredit;
	int amount;
	double rate;
	int period;
	String currency;

    static void PrintCountCredits()
    {
        System.out.println("В базе существеует " + number + " кредита (ов)");
    }

    public Credit InputData()
    {
        String title = "";
        String nameValue = "";
        String typeLender = "";
        int ageValue = 0;
        int profitValue = 0;
        int repay = 0;
        int debtValue = 0;
        char criminalValue = '-';
        String nameGuarant = "";
        int profitGuarant = 0;
        int amountValue = 0;
        double rateValue = 0;
        int periodValue = 0;
        String cur = "";
        Scanner in = new Scanner(System.in);
        number++;
        do {
            System.out.print("Введите вид кредитора (bank or MFO): ");
            typeLender = in.nextLine();
        } while (!typeLender.equals("bank") && !typeLender.equals("MFO"));
        do {
            System.out.println("Введите название организации:");
        } while ((title = ProtectInputString()) == null);
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
        amountValue = ProtectInputUnsigned("Введите сумму кредита:");
        rateValue = ProtectInputRate("Введите процентную ставку:");
        periodValue = ProtectInputUnsigned("Введите срок:");
        do {
            System.out.println("Введите валюту:");
        } while ((cur = ProtectInputString()) == null);

        Credit credit = new Credit(typeLender, title, nameValue, ageValue, profitValue, repay, debtValue, criminalValue,
            nameGuarant, profitGuarant, amountValue, rateValue, periodValue, cur);
        return credit;
    }

    public void OutData()
    {
        System.out.println("\nИнформация по кредиту №" + number);
        System.out.println("Название кредитной организации:    " + this.lenderCredit.GetTitle());
        System.out.println("Вид кредитора (банк или МФО):      " + this.lenderCredit.GetTypeLender());
        System.out.println("ФИО заёмщика:                      " + this.borrowerCredit.GetName());
        System.out.println("Возраст заёмщика:                  " + this.borrowerCredit.GetAge());
        System.out.println("Доход заёмщика:                    " + this.borrowerCredit.GetProfit());
        System.out.println("Количество погашенных кредитов     " + this.borrowerCredit.GetRepayLoan());
        System.out.println("Сумма задолженности:               " + this.borrowerCredit.GetDebt());
        System.out.println("Наличие судимости:                 " + this.borrowerCredit.GetCriminal());
        System.out.println("ФИО поручителя:                    " + this.borrowerCredit.GetNameGuarantor());
        System.out.println("Доход поручителя:                  " + this.borrowerCredit.GetProfitGuarantor());
        System.out.println("Сумма кредита:                     " + this.amount);
        System.out.println("Годовая процентная ставка:         " + this.rate); 
        System.out.println("Срок:                              " + this.period);
        System.out.println("Валюта:                            " + this.currency);
    }

    public void PercentCalculate()
    {
        double rezult = this.amount * this.rate * this.period / 100;
        System.out.printf("По кредиту №%d за %d лет сверх суммы потребуется выплатить %g (%s)\n", number, this.period, rezult, this.currency);
    }

    public double CalculateMonthPayment()
    {
        double monthPayment = (1 + this.rate / 100) * this.amount / 12;
        return monthPayment;
    }

    public void EarlyRepaymentPercentCalculate()
    {
        int factPeriod = 0;
        do
        {
            factPeriod = ProtectInputUnsigned("Введите фактический срок погашения кредита:");
        } while (factPeriod >= this.period);
        double rezult = this.amount * this.rate * factPeriod / 100;
        System.out.printf("По кредиту №%d за %d лет (погасив досрочно за %d лет) сверх суммы потребуется выплатить %g (%s)\n", this.number, this.period, factPeriod, rezult, this.currency);
    }

    //функция проверяет критерии для одобрения кредита и выносит вердикт
    public void Approve()
    {
        boolean conditionAge = true;
        boolean conditionProfit = true;
        boolean conditionHistory = true;
        boolean conditionCriminal = true;
        double monthPayment = CalculateMonthPayment();
        if (this.borrowerCredit.GetAge() < 18)
            conditionAge = false;
        if (this.borrowerCredit.GetProfit() < monthPayment * 3)
            conditionProfit = false;
        if (this.borrowerCredit.GetRepayLoan() < 2 && this.borrowerCredit.GetDebt() > monthPayment * 6
            && this.borrowerCredit.GetProfitGuarantor() < monthPayment * 3)
            conditionHistory = false;
        if (this.borrowerCredit.GetCriminal() == '+')
            conditionCriminal = false;
        System.out.println("Заёмщик: " + this.borrowerCredit.GetName());
        if (conditionAge && conditionProfit && conditionHistory && conditionCriminal)
        {
            System.out.println("Кредит одобрен.");
        }
        else
        {
            System.out.println("Кредит не одобрен.");
        }
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
        Integer num;
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
        return num.intValue();
    }

    public double ProtectInputRate(String message)
    {
        Scanner scanner = new Scanner(System.in);
        double num = 0.0;
        message += "\n";
        do{
            System.out.print(message);
            String rate = scanner.nextLine();
            char[] rateChars = rate.toCharArray();
            for(char c: rateChars){
                if(!(Character.isDigit(c) || c == '.')){
                    throw new IllegalArgumentException("Ошибка! Некорректный ввод.");
                }
            }
            num = Double.parseDouble(rate);
            break;
        }while(true);
        return num;
    }

	public Credit()
	{
		number++;
        this.lenderCredit = new Lender();
        this.borrowerCredit = new Borrower();
		this.amount = 0;
		this.rate = 0;
		this.period = 0;
		this.currency = "рубль";
	};

	public Credit(int periodValue)
	{
        this();
		this.period = periodValue;
	}

	public Credit(
		String type,
		String titleValue,
		String nameValue,
		int ageValue,
		int profitValue,
		int repay,
		int debtValue,
		char criminalValue,
		String nameGuarant,
		int profitGuarant,
		int amountValue,
		double rateValue,
		int periodValue,
		String cur)
	{
		number++;
		lenderCredit = new Lender(type, titleValue);
		borrowerCredit = new Borrower(nameValue, ageValue, profitValue, repay, debtValue, criminalValue,
			nameGuarant, profitGuarant);
		amount = amountValue;
		rate = rateValue;
		period = periodValue;
		currency = cur;
	}

	public int GetNumber() {
		return number;
	}
	public int GetAmount() {
		return amount;
	}
	public double GetRate() {
		return rate;
	}
	public int GetPeriod() {
		return period;
	}
	public String GetCurrency() {
		return currency;
	}
	public void SetNumber(int num) {
		number = num;
	}
	public void SetAmount(int amountNew) {
		amount = amountNew;
	}
	public void SetRate(float rateNew) {
		rate = rateNew;
	}
	public void SetPeriod(int periodNew) {
		period = periodNew;
	}
	public void SetCurrency(String cur) {
		currency = cur;
	}
}