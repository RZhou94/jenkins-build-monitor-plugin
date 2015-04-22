package com.smartcodeltd.jenkinsci.plugins.buildmonitor;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

import com.smartcodeltd.jenkinsci.plugins.buildmonitor.viewmodel.Duration;

public class DurationTest {

	private static final long millisec  = 18000000;
	private static final long millisec2 = 172800000;
	private static final Duration heure = new Duration(millisec);
	private static final Duration jour = new Duration(millisec2);

	@Test
	public void toStringTest() {
		
		assertEquals("5h 0s", heure.toString());
		assertEquals("48h 0s", jour.toString());
	}

	@Test 
	public void toStringDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		long lastDay = Calendar.getInstance().getTimeInMillis() - millisec2;
		assertEquals("5h 0s ago", heure.toStringDate());
		assertEquals(dateFormat.format(lastDay), jour.toStringDate());
	}
}
