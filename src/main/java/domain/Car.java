package Code3;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Car {

	private final String name;
	private int position=0;
	
	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public Car(String name) {
		this.name=name;
	}
	
	public void Move() {
		this.position++;
	}
	
	

}
