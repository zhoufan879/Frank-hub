package frank.random;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class ApacheLangTest {
	
	public static void main(String[] args) {
		System.out.println(RandomStringUtils.random(10));
		System.out.println(RandomStringUtils.randomAlphabetic(10));
		System.out.println(RandomStringUtils.randomAlphanumeric(10));
		System.out.println(RandomStringUtils.randomAscii(10));
		
		new ApacheLangTest().rand();
	}
	
	public void rand(){
		Random r = new Random();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(2));
		}
		
	}
}
