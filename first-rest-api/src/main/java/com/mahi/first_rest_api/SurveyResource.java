package com.mahi.first_rest_api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurveyResource {

	private SurveyService surveyService;

	public SurveyResource(SurveyService surveyService) {
		super();
		this.surveyService = surveyService;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyService.retrieveAllSurveys();
	}

}
