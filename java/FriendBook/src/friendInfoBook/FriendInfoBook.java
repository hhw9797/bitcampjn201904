package friendInfoBook;

import java.util.Scanner;

class Friend {
	String name;
	String phoneNum;
	String addr;

	public Friend(String name, String phone, String addr) {
		this.name = name;
		this.phoneNum = phone;
		this.addr = addr;
	}

	public void showData() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("주소 : " + addr);
	}

	public void showBasicInfo() {
	}

}



class HighFriend extends Friend { // 고교동창
	String work;

	public HighFriend(String name, String phone, String addr, String job) {
		super(name, phone, addr);
		work = job;
	}

	public void showData() {
		super.showData();
		System.out.println("직업 : " + work);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
	}
}

class UnivFriend extends Friend // 대학동기
{
	String major; // 전공학과

	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone, addr);
		this.major = major;
	}

	public void showData() {
		super.showData();
		System.out.println("전공 : " + major);
	}

	public void showBasicInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + phoneNum);
		System.out.println("전공 : " + major);
	}
}

class FriendInfoHandler {
	private Friend[] myFriends;
	private int numOfFriends;

	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}

	private void addFriendInfo(Friend fren) {
		myFriends[numOfFriends++] = fren;
	}

	public void addFriend(int choice) {
		String name, phoneNum, addr, job, major;
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		name = sc.nextLine();
		System.out.print("전화 : ");
		phoneNum = sc.nextLine();
		System.out.print("주소 : ");
		addr = sc.nextLine();
		if (choice == 1) {
			System.out.print("직업 : ");
			job = sc.nextLine();
			addFriendInfo(new HighFriend(name, phoneNum, addr, job));
		}

		else // if(choice==2)
		{
			System.out.print("학과 : ");
			major = sc.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNum, addr, major));
		}
		System.out.println("입력 완료! \n");
	}

	public void showAllData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showData();
			System.out.println("");
		}
	}

	public void showAllSimpleData() {
		for (int i = 0; i < numOfFriends; i++) {
			myFriends[i].showBasicInfo();
			System.out.println("");
		}

	}
}
