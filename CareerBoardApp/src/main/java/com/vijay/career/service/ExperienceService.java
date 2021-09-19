package com.vijay.career.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.career.utility.CoreUtility;

@Service
public class ExperienceService {
	
	@Autowired
	CoreUtility util;
	
	public ExperienceService() {
		
	}
	
	public Map<String, Period> findTotalExperience() {
		Period cams = util.computePeriod(LocalDate.of(2016, 4, 4), LocalDate.of(2016, 7, 1));
		Period vamsoft = util.computePeriod(LocalDate.of(2017, 8, 23), LocalDate.of(2019, 4, 3));
		Period virtusa = util.computePeriod(LocalDate.of(2019, 7, 5), LocalDate.of(2021, 4, 30));
		Period accenture = util.computePeriod(LocalDate.of(2021, 5, 7), LocalDate.now());
		Period cumulative = cams.plus(vamsoft).plus(virtusa).plus(accenture);
		Period normalized = util.normalizePeriod(cumulative);
		
		Map<String, Period> experienceMap = new HashMap<>();
		experienceMap.put("cams", cams);
		experienceMap.put("vamsoft", vamsoft);
		experienceMap.put("virtusa", virtusa);
		experienceMap.put("accenture", accenture);
		experienceMap.put("normalized", normalized);
		
		return experienceMap;
	}
}
