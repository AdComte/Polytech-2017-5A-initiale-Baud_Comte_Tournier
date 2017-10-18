package polytech5a.quentint.com.tppolytech.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by p1303674 on 18/10/2017.
 */

public class TextQuestion implements Parcelable {
    private String question;
    private String[] possibleAnswers;
    private String  actualAnswer;
    private int value;
    private int time;

    public static final Parcelable.Creator<TextQuestion> CREATOR = new Parcelable.Creator<TextQuestion>() {

        @Override

        public TextQuestion createFromParcel(Parcel source) {

            return new TextQuestion(source);

        }


        @Override

        public TextQuestion[] newArray(int size) {

            return new TextQuestion[size];

        }

    };

    public TextQuestion(Parcel in){
        question = in.readString();
        in.readStringArray(possibleAnswers);
        actualAnswer = in.readString();
        value = in.readInt();
        time = in.readInt();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeStringArray(possibleAnswers);
        dest.writeString(actualAnswer);
        dest.writeInt(value);
        dest.writeInt(time);
    }
}
