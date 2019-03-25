package dev.warrensnipes.cashregisterserver.utils;

import java.util.HashMap;
import java.util.Map;

public class Questionnaire {

    private final Map<Integer, String> questions;
    private Map<Integer, String> answers;
    private int count;

    public Questionnaire(Map<Integer, String> questions) {
        this.questions = questions;
        this.answers = new HashMap<>(questions.size());
    }

    public void addAnswer(String answer) {
        answers.put(count, answer);
        count++;
    }

    public void putAnswer(int question, String answer) {
        answers.put(question, answer);
    }

    public String getQuestion() {
        return questions.get(count);
    }

    public String getFormattedQuestion() {
        return count + ". " + getQuestion();
    }

    public String getQuestion(int questionNumber) {
        if (questionNumber >= questions.size()) {
            throw new RuntimeException("You can't get a question that's out of the HashMap's size.");
        }
        return questions.get(questionNumber);
    }

    public void reset() {
        this.count = 0;
        answers.clear();
    }
}
