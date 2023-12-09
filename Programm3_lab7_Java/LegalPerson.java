import java.util.*;

class LegalPerson extends Borrower {
    private int inn;
    private int ogrn;
    private String placeBusiness;

    public void OutBorrower(Integer n) {
        System.out.println("Название организации:              " + this.name);
        System.out.println("ИНН:                               " + this.inn);
        System.out.println("ОГРН:                              " + this.ogrn);
        System.out.println("Доход организации:                 " + GetProfit());
        System.out.println("Количество погашенных кредитов     " + GetRepayLoan());
        System.out.println("Сумма задолженности:               " + GetDebt());
        System.out.println("ФИО поручителя:                    " + GetNameGuarantor());
        System.out.println("Доход поручителя:                  " + GetProfitGuarantor());
    }

    @Override
    public int CheckProbabilityApproval() {
        boolean conditionProfit = true;
        boolean conditionHistory = true;
        if (this.GetProfit() < 150000)
            conditionProfit = false;
        if (this.GetRepayLoan() < 2 && this.GetDebt() > this.GetProfit() * 3)
            conditionHistory = false;
        System.out.println("\nЗаёмщик: " + this.GetName());
        if (conditionProfit && conditionHistory) {
            System.out.println("Вероятность одобрения кредита высока!");
            return 0;
        } else {
            System.out.println("К сожалению, кредит вряд ли будет одобрен.");
            return -1;
        }
    }
  

    public LegalPerson() {
        this.inn = 0;
        this.ogrn = 0;
        this.placeBusiness = "none";
    }

    public LegalPerson(Borrower b) {
        this.name = b.GetName();
        this.SetProfit(b.GetProfit());
        this.SetHistory(b.GetHistory());
        this.SetGuarantor(b.GetGuarantor());
        this.inn = 0;
        this.ogrn = 0;
        this.placeBusiness = "none";
    }

    public LegalPerson(String nameValue, int profitValue, int repay, int debtValue, String nameGuarant, int profitGuarant, int inn, int ogrn, String placeBusiness) {
        super();
        this.name = nameValue;
        this.SetProfit(profitValue);
        this.SetHistory(new History(repay, debtValue));
        this.SetGuarantor(new Guarantor(nameGuarant, profitGuarant));
        this.inn = inn;
        this.ogrn = ogrn;
        this.placeBusiness = placeBusiness;
    }

    public String GetPlaceBusiness() {
        return placeBusiness;
    }

    public int GetINN() {
        return inn;
    }

    public int GetOGRN() {
        return ogrn;
    }

    public void SetPlaceBusiness(String placeNew) {
        placeBusiness = placeNew;
    }

    public void SetINN(int innNew) {
        inn = innNew;
    }

    public void SetOGRN(int ogrnNew) {
        ogrn = ogrnNew;
    }
}