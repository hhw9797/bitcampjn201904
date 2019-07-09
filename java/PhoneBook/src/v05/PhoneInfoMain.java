package v05;

import util.Menu;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		//PhoneBookmanager manager = new PhoneBookmanager(100);

		PhoneBookmanager manager = PhoneBookmanager.getinstance();
		
		while (true) {

			int choice = manager.printMenu();			

			switch (choice) {
			case Menu.INSERT:
			
				manager.insert();
				break;

			case Menu.SEARCH:
				manager.searchPrint();
				break;

			case Menu.ALLDATA:
				manager.showAllData();
				break;

			case Menu.DELETE:
				manager.searchDelete();
				break;

			case Menu.QUIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}	
}
