import java.text.DecimalFormat;
import java.util.Scanner;
public class Account {

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##00");
	
	private long customerAccNumber;
	private int pinNumber;
	private double savingAccBalance,currentAccBalance = 0;
	

	//set customer account number
	public void setCustomerAccountNO(long customerAccNumber) {
		this.customerAccNumber = customerAccNumber;
	}

	//get customer account number
	public long getCustomerNumber() {
		return customerAccNumber;
	}

	//set pin number
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	//get pin number
	public int getPinNumber() {
		return pinNumber;
	}
	
	// get current account balance
	public double getcurrentAccountBalance() {
		return currentAccBalance;
	}
	
	public void setsavingAccBalance(double savingAccBalance) {
		this.savingAccBalance = savingAccBalance;
	}

	// get saving account balance
	public double getSavingAccountBalance() {
		return savingAccBalance;
	}

	//calculating the current account withdrawal
	public double calCurrentWithdrawal(double amount) {
		currentAccBalance = (currentAccBalance-amount);
		return currentAccBalance;
	}

	//calculating the saving account withdrawal
	public double calSavingWithdrawal(double amount) {
		savingAccBalance = (savingAccBalance-amount);
		return savingAccBalance;
	}

	//calculating the current account withdrawal
		public double calCurrentDeposit(double amount) {
			currentAccBalance = (currentAccBalance+amount);
			return currentAccBalance;
		}
		
		//calculating the saving account withdrawal
		public double calSavingDeposit(double amount) {
			savingAccBalance = (savingAccBalance+amount);
			return savingAccBalance;
		}
	
	//customer current account withdrawal input
	public void getCurrentWithdrawInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(currentAccBalance));
		System.out.println("Amount you want to Withdraw from your Current Account: ");
		double amount = input.nextDouble();

		if((currentAccBalance-amount) >=0) {
			calCurrentWithdrawal(amount);
			System.out.println("New Current Account Balance is: "+moneyFormat.format(currentAccBalance));
		}
		else {
			System.out.println("Incorrect Input."+"\n");
		}
	}

	//customer saving account withdrawal input 
	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingAccBalance));
		System.out.println("Amount you want to Withdraw from your Saving Account: ");
		double amount = input.nextDouble();

		if((savingAccBalance-amount) >=0) {
			calSavingWithdrawal(amount);
			System.out.println("New Saving Account Balance is: "+moneyFormat.format(savingAccBalance));
		}
		else {
			System.out.println("Incorrect Input."+"\n");
		}
	}

	//customer current account deposit input
	public void getCurrentDepositInput() {
		System.out.println("Current Account Balance: "+moneyFormat.format(currentAccBalance));
		System.out.println("Amount you want to Deposit in your Current Account: ");
		double amount = input.nextDouble();

		if((currentAccBalance+amount) >=0) {
			calCurrentDeposit(amount);
			System.out.println("New Current Account Balance is: "+moneyFormat.format(currentAccBalance));
		}
		else {
			System.out.println("Incorrect Input."+"\n");
		}
	}
	
	//customer current account deposit input
	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingAccBalance));
		System.out.println("Amount you want to Deposit in your Saving Account: ");
		double amount = input.nextDouble();

		if((savingAccBalance+amount) >=0) {
			calSavingDeposit(amount);
			System.out.println("New Saving Account Balance is: "+moneyFormat.format(savingAccBalance));
		}
		else {
			System.out.println("Incorrect Input."+"\n");
		}
	}
}