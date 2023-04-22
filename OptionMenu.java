import java.util.*;
import java.util.Map.Entry;
import java.io.IOException;
import java.text.DecimalFormat;

public class OptionMenu extends Account {

	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	HashMap<Long,Integer> data = new HashMap<>();

	//Validate login information customer account number and pin number
	public void getLogin() throws IOException{
		int x = 1;
		do {
			try {
				data.put(7461842411L, 2103);
				data.put(9078915586l, 0321);
				data.put(7239925917l, 2121);

				System.out.println("Welcome to SBI ATM");
				System.out.println("Enter your Account Number: ");
				setCustomerAccountNO(menuInput.nextLong());
				System.out.println("Enter your Pin Number: " );
				setPinNumber(menuInput.nextInt());
			}
			catch (Exception e) {
				System.out.println("\nInvalid character(s). Only Numbers Allowed" + "\n");
				x=2;
			}
			for(Entry<Long, Integer> entry : data.entrySet()) {
				if(entry.getKey()==getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\nInvalid Account Number or Pin." + "\n");
		}
		while(x==1);
	}

	//displaying current account Menu with selection
	public void getCurrentMenu() {
		System.out.println("\nCurrent Account");
		System.out.println("1 - View Balance ");
		System.out.println("2 - Withdraw Amount");
		System.out.println("3 - Deposit Amount");
		System.out.println("4 - Exit");
		System.out.println("\n" + "Select any Option: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Chechking Account Balance: " + moneyFormat.format(getcurrentAccountBalance()));
			getAccountType();
			break;

		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;

		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("\nThankyou for using SBI ATM");
			break;

		default:
			System.out.println("\n" + "Invaild Selection");
			getCurrentMenu();
			break;
		}
	}

	//displaying current account Menu with selection
	public void getSavingMenu() {
		System.out.println("\nSaving Account");
		System.out.println("1 - View Balance ");
		System.out.println("2 - Withdraw Amount");
		System.out.println("3 - Deposit Amount");
		System.out.println("4 - Exit");
		System.out.println("\n" + "Select any Option: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingAccountBalance()));
			getAccountType();
			break;

		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getSavingDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("\nThankyou for using SBI ATM");
			break;

		default:
			System.out.println("\n" + "Invaild Selection");
			getSavingMenu();
			break;
		}
	}

	//Displaying Account type
	public void getAccountType() {
		System.out.println("\n Select the Account type you want to access: ");
		System.out.println("1 - Current Account: ");
		System.out.println("2 - Saving Account: ");
		System.out.println("3 - Exit: ");
		System.out.println("\n" + "Select any Option: ");

		int seletion = menuInput.nextInt();

		switch (seletion) {
		case 1:
			getCurrentMenu();
			break;

		case 2:
			getSavingMenu();
			break;

		case 3:
			System.out.println("\nThankyou for using SBI ATM");
			break;

		default:
			System.out.println("\n" + "Invaild Selection");
			getAccountType();
			break;
		}
	}
}