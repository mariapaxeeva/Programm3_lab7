import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private List<Borrower> borrowers;

    public Bank() {
        this.borrowers = new ArrayList<>();
    }

    public int AddBorrower(Borrower b) {
        this.borrowers.add(b);
        return 0;
    }

    public int AddBorrower(LegalPerson lp) {
        this.borrowers.add(lp);
        return 0;
    }

    public void OutBorrowers() {
        System.out.println("База данных заёмщиков\n");
        for (Borrower borrower : borrowers) {
            if (borrower instanceof LegalPerson) {
                LegalPerson lp = (LegalPerson) borrower;
                lp.OutBorrower();
                System.out.println();
            } else {
                borrower.OutBorrower();
                System.out.println();
            }
        }
    }

    public List<Borrower> GetBorrowers() {
        return borrowers;
    }

    public void SortedBorrowersByName() {
        Collections.sort(borrowers, (b1, b2) -> b1.GetName().compareTo(b2.GetName()));
    }

    public int FindName(String searched) {
        for (Borrower borrower : borrowers) {
            if (borrower.GetName().equals(searched)) {
                System.out.println("Найдено " + searched + "\n");
                borrower.OutBorrower();
                System.out.println();
                return 0;
            }
        }
        System.out.println("Не найдено " + searched + "\n");
        return 0;
    }
}