package JohnProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MobileShop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Number of Phones :");
		int n = scanner.nextInt();
		Map<String, List<Mobile>> mobilesMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the OS :");
			String os = scanner.next();
			System.out.println("Enter the RAM :");
			int ram = scanner.nextInt();
			System.out.println("Enter the Memory :");
			int memory = scanner.nextInt();
			System.out.println("Enter the Price :");
			int price = scanner.nextInt();
			System.out.println("Enter the Rating :");
			int rating = scanner.nextInt();
			Mobile mobile = new Mobile(os, ram, memory, price, rating);
			if (!mobilesMap.containsKey(os)) {
				mobilesMap.put(os, new ArrayList<>());
			}
			mobilesMap.get(os).add(mobile);
		}
		System.out.println("Enter the number of Customer");
		int q = scanner.nextInt();
		for (int i = 0; i < q; i++) {
			System.out.println("Enter the Operating System :");
			String os = scanner.next();
			System.out.println("Enter the RAM :");
			int ram = scanner.nextInt();
			System.out.println("Enter the Memory :");
			int memory = scanner.nextInt();
			System.out.println("Enter the Budget :");
			int budget = scanner.nextInt();
			int maxRating = -1;
			for (Mobile mobile : mobilesMap.getOrDefault(os, new ArrayList<>())) {
				if (mobile.ram == ram && mobile.memory == memory && mobile.price <= budget) {
					maxRating = Math.max(maxRating, mobile.rating);
				}
			}
			System.out.println(maxRating);
		}

		scanner.close();
	}
}

class Mobile {
	String os;
	int ram;
	int memory;
	int price;
	int rating;

	public Mobile(String os, int ram, int memory, int price, int rating) {
		this.os = os;
		this.ram = ram;
		this.memory = memory;
		this.price = price;
		this.rating = rating;
	}
}
