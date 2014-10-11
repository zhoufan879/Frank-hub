package frank.enums;

import java.util.EnumSet;

public class EnumSetTest {

	public static void main(String[] args) {
		EnumSet<Weeks> weeks = EnumSet.noneOf(Weeks.class);
		weeks.add(Weeks.MONDAY);
		
		System.out.println(weeks.range(Weeks.FRIDAY, Weeks.SUNDAY));
		
		System.out.println(EnumSet.complementOf(weeks));
		
		System.out.println(EnumSet.copyOf(weeks));
		
		System.out.println(weeks);
	}
	
}

enum Weeks {
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY,
	SUNDAY;
}
