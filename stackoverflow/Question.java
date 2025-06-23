import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question implements Commentable, Ratable {

    private List<Comment>comments;
    private String content;
    private String questionId;
    private String title;
    private final User user;
    private final LocalDate createdDate;

    public String getQuestionId() {
        return questionId;
    }

    private List<Tag>tags;
    private List<Answer>answers;
    private List<Comment>comments;

    public Question(User user, String content, String title, List<String>tagNames) {
        this.user = user;
        createdDate = LocalDate.now();
        this.content=content;
        questionId = UUID.randomUUID().toString();
        this.answers=  new ArrayList<>();
        this.tags = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.title = title;
        for(String tagName:tagNames){
            this.tags.add(new Tag(tagName));
        }
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void addRating(User user, VoteType voteType) {

    }

    @Override
    public int getRating() {

    }
}
