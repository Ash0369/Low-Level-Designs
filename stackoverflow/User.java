import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userName;
    private String userId;
    private String emailId;
    int score;
    private List<Question> questionList;

    public User(String userName,String emailId){
        this.userName = userName;
        this.emailId = emailId;
        this.userId  = UUID.randomUUID().toString();
        this.score = 0;
        questionList = new ArrayList<>();
    }

    public String askQuestion(String title, String content, List<String>tags){
        Question question = new Question(this,content,title,tags);
        questionList.add(question);
        return question.getQuestionId();
    }

    public void addRating(int value){
        this.score+=value;
    }

    public int getRating(){
        return this.score;
    }

    public Comment addComment(String content){
        Comment c = new Comment(content,this);
        return c;
    }
}
