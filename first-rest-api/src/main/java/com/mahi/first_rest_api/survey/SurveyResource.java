package com.mahi.first_rest_api.survey;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurveyById(@PathVariable String surveyId) {
		Survey survey = surveyService.retrieveSurveyById(surveyId);
		if (survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return survey;
	}

	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.POST)
	public ResponseEntity<Object> addQuestion(@PathVariable String surveyId, @RequestBody Question question) {
		String qId = surveyService.addQuestionToSurvey(surveyId, question);
		if (qId == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{questionId}").buildAndExpand(qId).toUri();
		
		return ResponseEntity.created(location ).build();
	}
	
	@RequestMapping(value="/surveys/{surveyId}/questions", method=RequestMethod.GET)
	public List<Question> retrieveSurveyQuestions(@PathVariable String surveyId) {
		List<Question> questions = surveyService.retrieveSurveyQuestions(surveyId);
		if (questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return questions;
	}

	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSurveyQuestions(@PathVariable String surveyId, @PathVariable String questionId) {
		Question question = surveyService.retrieveSpecificSurveyQuestion(surveyId, questionId);
		if (question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return question;
	}

}
