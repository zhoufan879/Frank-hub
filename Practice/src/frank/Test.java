package frank;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import frank.bean.JavaBean;
import frank.enums.MyEnum;
import frank.extend.Father;
import frank.extend.Son;
import frank.interfaces.Constants;

public class Test implements Constants {

	private static final Logger log = LoggerFactory.getLogger(Test.class);
	
	@org.junit.Test
	public void testMyEnum(){
		Vector vec = new Vector();
		for (Object object : vec) {
			
		}
		log.info(this.name);
		log.info(this.name.intern());
		log.info("");
		System.out.println(MyEnum.USER.getCommand());
		
		long currCount = Long.parseLong("-17823891624961") + 1 ;
		System.out.println(currCount);
		
		long l = 1000;
		int i = 999;
		
		System.out.println(l>i);
	}
	

	@org.junit.Test
	public void testMyExt(){
		Father f = new Father();
		f.whatsthis();
		
		Father son = new Son();
		son.whatsthis();
	}
	
	@org.junit.Test
	public void testDoWhile(){
		do{
			System.out.println(this.getClass());
		}while(false);	
	}
	
	@org.junit.Test
	public void testRandomstring(){
		System.out.println(RandomStringUtils.randomAlphanumeric(4));
	}
	
	@org.junit.Test
	public void testFinalJavaBean(){
		final JavaBean jb = new JavaBean();
		
		jb.setDesc("123");
		
		
		System.out.println(jb.getDesc());
		
		int i = 0;
		System.out.println(i);
		
		String s = "0";
		System.out.println(s.getBytes().length);
		
		System.out.println("9223372036854775807".length());
	}
	
	@org.junit.Test
	public void testNumDouble() throws Exception {
		double d = 0.00;
		int i = (int)d;
		assertEquals(0, i);
		
		d = 0.5;
		i = (int)d;
		assertEquals(0, i);
		
		d = 0.6;
		i = (int)d;
		assertEquals(0, i);
		
		d = 0.99;
		i = (int)d;
		assertEquals(0, i);

		System.out.println("all-"+new SimpleDateFormat("yyyyMMddHHHHmmss").format(new Date()));
		
		d = 1.99;
		i = (int)d;
		assertEquals(0, i);
		
	}

}
