package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Racing
 * 
 * 19.12.26
 * 
 * https://github.com/OHHAKO
 * */
public class  Racing {
	private Car cars[];
	private String carNames[];
	private int k;
	Scanner sc;
	
	public Racing() {
		init();
	}
	
	void init() {
		makeCar();
		this.k = makeTryNumber();
	}
	
	void makeCar() {
		sc = new Scanner(System.in);
		System.out.println("������ �ڵ��� �̸��� �Է��ϼ���.(�̸��� ��ǥ(,) �������� ����)");
		String names = sc.next();
		carNames = names.split(",");
		cars = new Car[carNames.length];
	
		for(int i=0 ; i<carNames.length ; i++) 
			cars[i] = new Car(carNames[i]);	
	}
	
	int makeTryNumber() {
		System.out.println("�õ��� ȸ���� ��ȸ�ΰ���?");
		return sc.nextInt();
	}
	
	void printCarsPosition() {
		for(int i=0 ; i<cars.length ; i++) {
			System.out.print(cars[i].getName()+" : ");
			for(int j=0 ; j<cars[i].getPosition();j++)
				System.out.print("-");
			System.out.println();
		}
		System.out.println();
	}
	
	void carsMove() {
		int random;
		for(int i=0 ; i<cars.length ; i++) {
			random = (int)(Math.random()*9);
			if(random>3)
				cars[i].move();
		}
	}
	
	void road() {
		System.out.println("���� ���");
		for(int i=0 ; i < k ; i++) {
			carsMove();		
			printCarsPosition();
		}
		findWinner();
	}
	
	/*position �� ���� ū Car�̸� ã��*/
	void findWinner(){
		List<String> winners;
		int maxValue = cars[0].getPosition();
		for(int i=0 ; i<cars.length ; i++) {
			if(maxValue < cars[i].getPosition()) {
				maxValue = cars[i].getPosition();
			}
		}
		winners = findCowinner(maxValue);
		for(String w : winners)
			System.out.print(w+" ");
		System.out.println("�� ���� ����߽��ϴ�.");
	}
	
	/*�ߺ��Ǵ� ���� ��ü list�� �ֱ�*/
	List<String> findCowinner(int maxValue) {
		List<String> winners = new ArrayList<String>();
		for(int i=0 ; i<cars.length ;i++) {
			if(maxValue==cars[i].getPosition()) {
				winners.add(cars[i].getName());
			}
		}
		return winners;
	}	
}
