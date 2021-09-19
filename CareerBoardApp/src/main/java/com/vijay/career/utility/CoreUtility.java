package com.vijay.career.utility;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

@Component
public class CoreUtility {
	
	public CoreUtility() {
		
	}
	
	public Period computePeriod(LocalDate start, LocalDate end) {
		return Period.between(start, end).plusDays(1);
	}
	
	public Period normalizePeriod(Period cumulative) {
		System.out.println(cumulative);
		int days = cumulative.getDays();
		cumulative = cumulative.plusMonths(days/30).normalized();
		cumulative = cumulative.minusDays(days).plusDays(days%30);
		return cumulative;
	}
}
