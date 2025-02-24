package com.mahi.first_rest_api.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {
	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question question1 = new Question("Question1", "1 Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "1 Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "1 Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "1 My Favorite Survey", "1 Description of the Survey", questions);

		surveys.add(survey);

		question1 = new Question("Question1", "2 Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		question2 = new Question("Question2", "2 Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		question3 = new Question("Question3", "2 Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		survey = new Survey("Survey2", "2 My Favorite Survey", "2 Description of the Survey", questions);

		surveys.add(survey);
	}

	private static Predicate<? super Survey> generateSurveyByIdPredicate(String surveyId) {
		return survey -> survey.getId().equalsIgnoreCase(surveyId);
	}

	private static Predicate<? super Question> generateQuestionByIdPredicate(String questionId) {
		return question -> question.getId().equalsIgnoreCase(questionId);
	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurveyById(String surveyId) {
		Optional<Survey> survey = surveys.stream().filter(generateSurveyByIdPredicate(surveyId)).findFirst();
		return survey.orElse(null);
	}

	public List<Question> retrieveSurveyQuestions(String surveyId) {
		Survey survey = retrieveSurveyById(surveyId);
		if (survey == null) {
			return null;
		}
		return survey.getQuestions();
	}

	public Question retrieveSpecificSurveyQuestion(String surveyId, String questionId) {
		List<Question> surveyQuestions = retrieveSurveyQuestions(surveyId);
		if (surveyQuestions == null) {
			return null;
		}

		Optional<Question> question = surveyQuestions.stream()
												.filter(generateQuestionByIdPredicate(questionId))
												.findFirst();
		return question.orElse(null);
	}

	public String addQuestionToSurvey(String surveyId, Question question) {
		Survey survey = retrieveSurveyById(surveyId);
		if (survey == null) {
			return null;
		}
		question.setId(generateRandomId());
		survey.getQuestions().add(question);
		
		return question.getId();		
	}

	private String generateRandomId() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId = new BigInteger(32, secureRandom).toString();
		return randomId;
	}
}
