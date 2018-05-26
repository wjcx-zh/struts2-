package com.wjcx.language;

import java.util.Locale;

import org.junit.Test;

public class TestLan {
	@Test
	public void testLAN(){
		Locale[] locales=Locale.getAvailableLocales();
		for(Locale locale:locales){
			System.out.println(locale);
		}
	}
}
