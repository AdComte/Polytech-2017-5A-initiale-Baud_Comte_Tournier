package polytech5a.quentint.com.tppolytech.models;

/**
 * Created by p1303674 on 18/10/2017.
 */

public class TextQuestion {
    private String question;
    private String[] possibleAnswers;
    private String  actualAnswer;
    private int value;
    private int time;

    public TextQuestion(String question, String[] possibleAnswers, String actualAnswer, int value, int time) {
        this.question = question;
        this.possibleAnswers = possibleAnswers;
        this.actualAnswer = actualAnswer;
        this.value = value;
        this.time = time;
    }

    public TextQuestion(String question, String[] pAnswers, String aAnswer, int value){
        this(question, pAnswers,aAnswer,value,30);
    }

    public boolean checkAnswer(String selected){
        return selected.equals(actualAnswer);
    }

    public String getQuestion() {
        return question;
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }

    public int getValue() {
        return value;
    }

    public int getTime() {
        return time;
    }
}
