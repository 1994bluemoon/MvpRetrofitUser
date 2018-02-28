package vinova.henry.com.mvpretrofituser.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Post  implements Serializable {
    @SerializedName("words")
    @Expose
    private String words;
    @SerializedName("sentence")
    @Expose
    private String sentence;
    @SerializedName("sentences")
    @Expose
    private String sentences;
    @SerializedName("paragraph")
    @Expose
    private String paragraph;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentences() {
        return sentences;
    }

    public void setSentences(String sentences) {
        this.sentences = sentences;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
