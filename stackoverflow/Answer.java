import java.util.List;

public class Answer implements Commentable, Ratable {
    private Question question;
    private String answerId;
    private String content;
    List<String>comments;
    List<Rate>votes;

    public Answer(){

    }
    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public List<Comment> getComments() {
        return List.of();
    }

    @Override
    public void addRating(User user, VoteType voteType) {

    }

    @Override
    public int getRating() {

    }
}
