#pragma once
#define _CRT_SECURE_NO_WARNINGS
#include <string>
#include <iostream>
#include <vector>

using namespace std;

class Lender
{
private:
	string typeLender;
	string title;

public:

	Lender()
	{
		this->typeLender = "none";
		this->title = "none";
	}

	Lender(string type) :Lender()
	{
		this->typeLender = type;
	}

	Lender(
		string type,
		string titleValue
	)
	{
		this->typeLender = type;
		this->title = titleValue;
	}

	string GetTypeLender() {
		return typeLender;
	}

	string GetTitle() {
		return title;
	}

	void SetTypeLender(string type) {
		typeLender = type;
	}

	void SetTitle(string titleNew) {
		title = titleNew;
	}
};

class History
{
private:
	int repayLoan;
	int debt;
public:

	History()
	{
		this->repayLoan = 0;
		this->debt = 0;
	}
	History(
		int repay,
		int debtValue)
	{
		repayLoan = repay;
		debt = debtValue;
	}

	int GetRepayLoan() {
		return repayLoan;
	}

	int GetDebt() {
		return debt;
	}

	void SetRepayLoan(int repay) {
		repayLoan = repay;
	}

	void SetDebt(int debtNew) {
		debt = debtNew;
	}
};

class Guarantor
{
private:
	string nameGuarantor;
	int profitGuarantor;
public:

	Guarantor()
	{
		this->nameGuarantor = "none";
		this->profitGuarantor = 0;
	}
	Guarantor(
		string nameGuarant,
		int profitGuarant)
	{
		nameGuarantor = nameGuarant;
		profitGuarantor = profitGuarant;
	}

	string GetNameGuarantor() {
		return nameGuarantor;
	}

	int GetProfitGuarantor() {
		return profitGuarantor;
	}
	void SetNameGuarantor(string nameGuarant) {
		nameGuarantor = nameGuarant;
	}

	void SetProfitGuarantor(int profitGuarant) {
		profitGuarantor = profitGuarant;
	}
};

class AbstractBorrower
{
public:
	virtual int CheckProbabilityApproval() = 0;
};

class Borrower : public AbstractBorrower
{
private:
	int age;
	char criminal;

protected:
	string name;
	int profit;
	History historyBorrower;
	Guarantor guarantorBorrower;

public:
	void OutBorrower();
	int CheckProbabilityApproval() override;

	Borrower()
	{
		this->name = "none";
		this->age = 0;
		this->profit = 0;
		this->criminal = '-';
	}
	Borrower(
		string nameValue,
		int ageValue,
		int profitValue,
		int repay,
		int debtValue,
		char criminalValue,
		string nameGuarant,
		int profitGuarant)
	{
		historyBorrower = History(repay, debtValue);
		guarantorBorrower = Guarantor(nameGuarant, profitGuarant);
		name = nameValue;
		age = ageValue;
		profit = profitValue;
		criminal = criminalValue;
	}

	string GetName() {
		return name;
	}

	int GetAge() {
		return age;
	}

	int GetProfit() {
		return profit;
	}

	int GetRepayLoan() {
		return historyBorrower.GetRepayLoan();
	}

	int GetDebt() {
		return historyBorrower.GetDebt();
	}

	char GetCriminal() {
		return criminal;
	}

	string GetNameGuarantor() {
		return guarantorBorrower.GetNameGuarantor();
	}

	int GetProfitGuarantor() {
		return guarantorBorrower.GetProfitGuarantor();
	}

	History GetHistory() {
		return historyBorrower;
	}

	Guarantor GetGuarantor() {
		return guarantorBorrower;
	}

	void SetName(string nameNew) {
		name = nameNew;
	}

	void SetAge(int ageNew) {
		age = ageNew;
	}

	void SetProfit(int profitNew) {
		profit = profitNew;
	}

	void SetCriminal(const char criminalNew) {
		criminal = criminalNew;
	}

	void SetHistory(History newHistory) {
		historyBorrower = newHistory;
	}
};

class Credit
{
private:
	int number;
	Lender lenderCredit;
	Borrower borrowerCredit;
	int amount;
	float rate;
	int period;
	string currency;

public:
	Credit InputData();
	void OutData();
	void PercentCalculate();
	float CalculateMonthPayment();
	void EarlyRepaymentPercentCalculate();
	void Approve();
	void SearchNum(int* index, Credit* data, int sizeData);

	Credit()
	{
		this->number = 0;
		this->amount = 0;
		this->rate = 0;
		this->period = 0;
		this->currency = "рубль";
	};

	Credit(int numberValue) :Credit()
	{
		this->number = numberValue;
	}

	Credit(
		int numberValue,
		string type,
		string titleValue,
		string nameValue,
		int ageValue,
		int profitValue,
		int repay,
		int debtValue,
		char criminalValue,
		string nameGuarant,
		int profitGuarant,
		int amountValue,
		float rateValue,
		int periodValue,
		string cur)
	{
		lenderCredit = Lender(type, titleValue);
		borrowerCredit = Borrower(nameValue, ageValue, profitValue, repay, debtValue, criminalValue, \
			nameGuarant, profitGuarant);
		number = numberValue;
		amount = amountValue;
		rate = rateValue;
		period = periodValue;
		currency = cur;
	}

	int GetNumber() {
		return number;
	}
	int GetAmount() {
		return amount;
	}
	float GetRate() {
		return rate;
	}
	int GetPeriod() {
		return period;
	}
	string GetCurrency() {
		return currency;
	}
	void SetNumber(int num) {
		number = num;
	}
	void SetAmount(int amountNew) {
		amount = amountNew;
	}
	void SetRate(float rateNew) {
		rate = rateNew;
	}
	void SetPeriod(int periodNew) {
		period = periodNew;
	}
	void SetCurrency(string cur) {
		currency = cur;
	}
};

class LegalPerson : public Borrower
{
private:
	int inn;
	int ogrn;
	string placeBusiness;

public:
	void OutBorrower();
	int CheckProbabilityApproval() override;

	LegalPerson()
	{
		this->inn = 0;
		this->ogrn = 0;
		this->placeBusiness = "none";
	};

	LegalPerson(Borrower b)
	{
		this->name = b.GetName();
		this->profit = b.GetProfit();
		this->historyBorrower = b.GetHistory();
		this->guarantorBorrower = b.GetGuarantor();
		this->inn = 0;
		this->ogrn = 0;
		this->placeBusiness = "none";
	};

	LegalPerson(string nameValue,
		int profitValue,
		int repay,
		int debtValue,
		string nameGuarant,
		int profitGuarant,
		int inn,
		int ogrn,
		string placeBusiness) :Borrower()
	{
		this->name = nameValue;
		this->profit = profitValue;
		this->historyBorrower = History(repay, debtValue);
		this->guarantorBorrower = Guarantor(nameGuarant, profitGuarant);
		this->inn = inn;
		this->ogrn = ogrn;
		this->placeBusiness = placeBusiness;
	};

	LegalPerson& operator=(const Borrower& other);

	string GetPlaceBusiness() {
		return placeBusiness;
	}

	int GetINN() {
		return inn;
	}

	int GetOGRN() {
		return ogrn;
	}

	void SetPlaceBusiness(string placeNew) {
		placeBusiness = placeNew;
	}

	void SetINN(int innNew) {
		inn = innNew;
	}

	void SetOGRN(int ogrnNew) {
		ogrn = ogrnNew;
	}
};

// хранит данные о всех заёмщиках
class Bank
{
private:
	vector <Borrower*> borrowers;
public:
	Bank() {};
	int AddBorrower(Borrower* b)
	{
		this->borrowers.push_back(b);
		return 0;
	}
	int AddBorrower(LegalPerson* lp)
	{
		this->borrowers.push_back(lp);
		return 0;
	}
	void OutBorromers();
	vector <Borrower*> getBorrowers()
	{
		return borrowers;
	}
};

// Шаблон класса для перевода денег по реквизитам (номеру телефона, ФИО или номеру счета)
template <typename Type>
class TransferMoney
{
private:
	Type senderDetails;
	Type recipientDetails;
	int amount;
public:
	TransferMoney()
	{
		senderDetails = "+7()- - -";
		recipientDetails = "+7()- - -";
		amount = 0;
	}
	TransferMoney(Type sender, Type recipient, int summa)
	{
		senderDetails = sender;
		recipientDetails = recipient;
		amount = summa;
	}
	TransferMoney<Type> Transfer()
	{
		string answer;
		cout << "Введите свои реквизиты (номер счета, ФИО или номер телефона):" << endl;
		cin >> senderDetails;
		cout << "Введите реквизиты получателя (номер счета, ФИО или номер телефона):" << endl;
		cin >> recipientDetails;
		cout << "Введите сумму: " << endl;
		cin >> amount;
		cout << "Подтвердить перевод " << senderDetails << " -> " << recipientDetails << " на сумму " << amount << " рублей?" << endl;
		cin >> answer;
		if (answer == "yes")
			cout << "Операция прошла успешно!" << endl;
		else if (answer == "no")
			cout << "Операция отменена." << endl;
		else
			cout << "Операция отклонена." << endl;
		return *this;
	}
	Type GetSenderDetails()
	{
		return senderDetails;
	}
	Type GetRecipientDetails()
	{
		return recipientDetails;
	}
	int GetAmount()
	{
		return amount;
	}
	void SetSenderDetails(Type newValue)
	{
		senderDetails = newValue;
	}
	void SetRecipientDetails(Type newValue)
	{
		recipientDetails = newValue;
	}
	void SetAmount(int newValue)
	{
		amount = newValue;
	}
};
