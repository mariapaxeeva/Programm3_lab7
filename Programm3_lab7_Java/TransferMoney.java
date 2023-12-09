import java.util.Scanner;

public class TransferMoney<Type> {
    private Type senderDetails;
    private Type recipientDetails;
    private int amount;

    public TransferMoney() {
        senderDetails = (Type) "+7()- - -";
        recipientDetails = (Type) "+7()- - -";
        amount = 0;
    }

    public TransferMoney(Type sender, Type recipient, int summa) {
        senderDetails = sender;
        recipientDetails = recipient;
        amount = summa;
    }

    public TransferMoney<Type> Transfer() {
        Scanner in = new Scanner(System.in);
        String answer;
        System.out.println("Enter sender details (name, account number, etc.):");
        senderDetails = (Type) new Scanner(System.in).nextLine();
        System.out.println("Enter recipient details (name, account number, etc.):");
        recipientDetails = (Type) new Scanner(System.in).nextLine();
        System.out.println("Enter amount: ");
        amount = new Scanner(System.in).nextInt();
        System.out.println("Confirm transfer from " + senderDetails + " to " + recipientDetails + " of amount " + amount + " units?");
        answer = new Scanner(System.in).nextLine();
        if (answer.equals("yes")) {
            System.out.println("Transfer successful!");
        } else if (answer.equals("no")) {
            System.out.println("Transfer cancelled.");
        } else {
            System.out.println("Invalid response.");
        }
        return this;
    }

    public Type getSenderDetails() {
        return senderDetails;
    }

    public Type getRecipientDetails() {
        return recipientDetails;
    }

    public int getAmount() {
        return amount;
    }

    public void setSenderDetails(Type newValue) {
        senderDetails = newValue;
    }

    public void setRecipientDetails(Type newValue) {
        recipientDetails = newValue;
    }

    public void setAmount(int newValue) {
        amount = newValue;
    }
}