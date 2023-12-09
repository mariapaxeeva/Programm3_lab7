#include "CreditLib.h"
#include "stdio.h"
#include "conio.h"
#include "string"
#include <iostream>
#define _CRT_SECURE_NO_WARNINGS

using namespace std;

bool ProtectInputString(string* str)
{
	string word;
	getline(cin, word);
	*str = word;
	int l = word.length();
	if (word[0] == '\n' || word[0] == ' ')
		return true;
	for (int i = 1; i < l; i++) {
		if (word[i] != '\n' && word[i] != ' ')
			return false;
	}
	return true;
}

bool ProtectInputUnsigned(int* num, string message)
{
	string number;
	while (true) {
		try
		{
			cout << message << endl;
			cin >> number;
			for (char c : number) {
				if (!isdigit(c))
					throw "������! ������������ ����.";
			}
			*num = stoi(number);
			break;
		}
		catch (const char* error_message)
		{
			cin.clear();
			cout << error_message << endl;
		}
	}
	return false;
}

bool ProtectInputRate(float* num, string message)
{
	string number;
	while (true) {
		try
		{
			cout << message << endl;
			cin >> number;
			for (char c : number) {
				if ((!isdigit(c)) && !(c == '.'))
					throw "������! ������������ ����.";
			}
			*num = stof(number);
			break;
		}
		catch (const char* error_message)
		{
			cin.clear();
			cout << error_message << endl;
		}
	}
	return false;
}

Borrower InputBorrower()
{
	string nameValue;
	int ageValue;
	int profitValue;
	int repay;
	int debtValue;
	char criminalValue;
	string nameGuarant;
	int profitGuarant;
	while (getchar() != '\n');
	do {
		cout << "������� ��� �������:" << endl;
	} while (ProtectInputString(&nameValue));
	ProtectInputUnsigned(&ageValue, "������� ������� �������:");
	ProtectInputUnsigned(&profitValue, "������� ����� ������ ������� � �����:");
	ProtectInputUnsigned(&repay, "������� ���������� ����� ���������� ��������:");
	ProtectInputUnsigned(&debtValue, "������� ����� ��������� �������������:");
	cin.clear();
	do
	{
		printf("������� ��������� (- - ���, + - ����):\n");
		while (getchar() != '\n');
		scanf("%c", &criminalValue);
	} while (criminalValue != '-' && criminalValue != '+');
	do {
		cout << "������� ��� ����������:" << endl;
		while (getchar() != '\n');
	} while (ProtectInputString(&nameGuarant));
	ProtectInputUnsigned(&profitGuarant, "������� ����� ������ ���������� � �����:");
	Borrower borrower = Borrower(nameValue, ageValue, profitValue, repay, debtValue, criminalValue, \
		nameGuarant, profitGuarant);
	return borrower;
}

void Borrower::OutBorrower()
{
	cout << "��� �������:                      " + this->name << endl;
	cout << "������� �������:                  " << this->age << endl;
	cout << "����� �������:                    " << this->profit << endl;
	cout << "���������� ���������� ��������     " << this->historyBorrower.GetRepayLoan() << endl;
	cout << "����� �������������:               " << this->historyBorrower.GetDebt() << endl;
	cout << "������� ���������:                 " + this->criminal;
	cout << "��� ����������:                    " + this->guarantorBorrower.GetNameGuarantor() << endl;
	cout << "����� ����������:                  " << this->guarantorBorrower.GetProfitGuarantor() << endl;
}

//������� ��������� ����������� ��������� ������� ���������� �������
int Borrower::CheckProbabilityApproval()
{
	Borrower borrowerCredit = InputBorrower();
	bool conditionAge = true;
	bool conditionProfit = true;
	bool conditionHistory = true;
	bool conditionCriminal = true;
	if (borrowerCredit.age < 18)
		conditionAge = false;
	if (borrowerCredit.profit < 14375)
		conditionProfit = false;
	if (borrowerCredit.historyBorrower.GetRepayLoan() < 2 && borrowerCredit.historyBorrower.GetDebt() > borrowerCredit.profit * 3)
		conditionHistory = false;
	if (borrowerCredit.criminal == '+')
		conditionCriminal = false;
	cout << "������: " << borrowerCredit.name << endl;
	if (conditionAge && conditionProfit && conditionHistory && conditionCriminal)
	{
		cout << "����������� ��������� ������� ������!" << endl;
		return 0;
	}
	else
	{
		cout << "� ���������, ������ ���� �� ����� �������." << endl;
		return -1;
	}
}

Credit Credit::InputData()
{
	int numberValue = 0;
	string typeLender = "";
	string title = "";
	string nameValue = "";
	int ageValue = 0;
	int profitValue = 0;
	int repay = 0;
	int debtValue = 0;
	char criminalValue = '-';
	string nameGuarant = "";
	int profitGuarant = 0;
	int amountValue = 0;
	float rateValue = 0;
	int periodValue = 0;
	string cur = "";
	ProtectInputUnsigned(&numberValue, "������� ����� ���������� ��������:");
	while (getchar() != '\n');
	do {
		printf("������� ��� ��������� (���� ��� ���):\n");
		cin >> typeLender;
	} while ((typeLender != "����") && (typeLender != "���"));
	while (getchar() != '\n');
	do {
		cout << "������� �������� �����������:" << endl;
	} while (ProtectInputString(&title));
	do {
		cout << "������� ��� �������:" << endl;
	} while (ProtectInputString(&nameValue));
	ProtectInputUnsigned(&ageValue, "������� ������� �������:");
	ProtectInputUnsigned(&profitValue, "������� ����� ������ ������� � �����:");
	ProtectInputUnsigned(&repay, "������� ���������� ����� ���������� ��������:");
	ProtectInputUnsigned(&debtValue, "������� ����� ��������� �������������:");
	do
	{
		printf("������� ��������� (- - ���, + - ����):\n");
		while (getchar() != '\n');
		scanf("%c", &criminalValue);
	} while (criminalValue != '-' && criminalValue != '+');
	do {
		cout << "������� ��� ����������:" << endl;
		while (getchar() != '\n');
	} while (ProtectInputString(&nameGuarant));
	ProtectInputUnsigned(&profitGuarant, "������� ����� ������ ���������� � �����:");
	ProtectInputUnsigned(&amountValue, "������� ����� �������:");
	ProtectInputRate(&rateValue, "������� ���������� ������:");
	ProtectInputUnsigned(&periodValue, "������� ����:");
	while (getchar() != '\n');
	do {
		cout << "������� ������:" << endl;
	} while (ProtectInputString(&cur));

	Credit credit = Credit(numberValue, typeLender, title, nameValue, ageValue, profitValue, repay, debtValue, criminalValue, \
		nameGuarant, profitGuarant, amountValue, rateValue, periodValue, cur);
	return credit;
}

void Credit::OutData()
{
	cout << "\n���������� �� ������� �" << this->number << endl;
	cout << "�������� ��������� �����������:    " + this->lenderCredit.GetTitle() << endl;
	cout << "��� ��������� (���� ��� ���):      " + this->lenderCredit.GetTypeLender() << endl;
	cout << "��� �������:                      " + this->borrowerCredit.GetName() << endl;
	cout << "������� �������:                  " << this->borrowerCredit.GetAge() << endl;
	cout << "����� �������:                    " << this->borrowerCredit.GetProfit() << endl;
	cout << "���������� ���������� ��������     " << this->borrowerCredit.GetRepayLoan() << endl;
	cout << "����� �������������:               " << this->borrowerCredit.GetDebt() << endl;
	cout << "������� ���������:                 " + this->borrowerCredit.GetCriminal();
	cout << "��� ����������:                    " + this->borrowerCredit.GetNameGuarantor() << endl;
	cout << "����� ����������:                  " << this->borrowerCredit.GetProfitGuarantor() << endl;
	cout << "����� �������:                     " << this->amount << endl;
	cout << "������� ���������� ������:         " << this->rate << endl;
	cout << "����:                              " << this->period << endl;
	cout << "������:                            " + this->currency << endl;
}

void Credit::PercentCalculate()
{
	float rezult = this->amount * this->rate * this->period / 100;
	cout << "�� ������� �" << this->number << " �� " << this->period << " ��� ����� ����� ����������� ��������� "\
		<< rezult << " (" << this->currency << ") " << endl;
}

float Credit::CalculateMonthPayment()
{
	float monthPayment = (1 + this->rate / 100) * this->amount / 12;
	return monthPayment;
}

void Credit::EarlyRepaymentPercentCalculate()
{
	int factPeriod = 0;
	do
	{
		ProtectInputUnsigned(&factPeriod, "������� ����������� ���� ��������� �������:");
	} while (factPeriod >= this->period);
	float rezult = this->amount * this->rate * factPeriod / 100;
	cout << "�� ������� �" << this->number << " �� " << this->period << " ��� (������� �������� �� " << factPeriod\
		<< " ���) ����� ����� ����������� ��������� " << rezult << " (" << this->currency << ") " << endl;
}

//������� ��������� �������� ��� ��������� ������� � ������� �������
void Credit::Approve()
{
	bool conditionAge = true;
	bool conditionProfit = true;
	bool conditionHistory = true;
	bool conditionCriminal = true;
	float monthPayment = CalculateMonthPayment();
	if (this->borrowerCredit.GetAge() < 18)
		conditionAge = false;
	if (this->borrowerCredit.GetProfit() < monthPayment * 3)
		conditionProfit = false;
	if (this->borrowerCredit.GetRepayLoan() < 2 && this->borrowerCredit.GetDebt() > monthPayment * 6 \
		&& this->borrowerCredit.GetProfitGuarantor() < monthPayment * 3)
		conditionHistory = false;
	if (this->borrowerCredit.GetCriminal() == '+')
		conditionCriminal = false;
	cout << "������: " << this->borrowerCredit.GetName() << endl;
	if (conditionAge && conditionProfit && conditionHistory && conditionCriminal)
	{
		cout << "������ �������." << endl;
	}
	else
	{
		cout << "������ �� �������." << endl;
	}
}

//������� ������ ������� �������� � ������� �� ���� <����� �������>
void SearchNum(int* index, Credit* data, int sizeData)
{
	int num = 0;
	bool flag = true;
	puts("������� ����� �������:");
	scanf("%d", &num);
	for (int j = 0; j < sizeData; j++)
		if (data[j].GetNumber() == num)
		{
			flag = false;
			*index = j;
		}
	if (flag)
	{
		puts("�� ���������� ������ �� ������� ������.");
		*index = -1;
	}
}

void LegalPerson::OutBorrower()
{
	cout << "�������� �����������-�������:     " + this->name << endl;
	cout << "����� ������� �������:             " + this->placeBusiness << endl;
	cout << "��� :                              " << this->inn << endl;
	cout << "����:                              " << this->ogrn << endl;
	cout << "����� �����������:                 " << this->profit << endl;
	cout << "���������� ���������� ��������     " << this->historyBorrower.GetRepayLoan() << endl;
	cout << "����� �������������:               " << this->historyBorrower.GetDebt() << endl;
	cout << "��� ����������:                    " + this->guarantorBorrower.GetNameGuarantor() << endl;
	cout << "����� ����������:                  " << this->guarantorBorrower.GetProfitGuarantor() << endl;
}

int LegalPerson::CheckProbabilityApproval()
{
	bool conditionProfit = true;
	bool conditionHistory = true;
	if (this->GetProfit() < 150000)
		conditionProfit = false;
	if (this->historyBorrower.GetRepayLoan() < 2 && this->historyBorrower.GetDebt() > this->GetProfit() * 3)
		conditionHistory = false;
	cout << "\n������: " << this->GetName() << endl;
	if (conditionProfit && conditionHistory)
	{
		cout << "����������� ��������� ������� ������!" << endl;
		return 0;
	}
	else
	{
		cout << "� ���������, ������ ���� �� ����� �������." << endl;
		return -1;
	}
}

LegalPerson& LegalPerson::operator=(const Borrower& other)
{
	if (this == &other)
		return *this;
	LegalPerson temp(other);
	this->name = temp.name;
	this->profit = temp.profit;
	this->inn = temp.GetAge();
	this->ogrn = temp.GetAge();
	this->guarantorBorrower = temp.guarantorBorrower;
	this->historyBorrower = temp.historyBorrower;
	return *this;
}

