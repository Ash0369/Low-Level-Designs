import java.util.UUID;

public class Comment implements Ratable {
    private String content;
    private String commentId;
    private User author;

    public  Comment(String content, User author){
        this.content=content;
        this.author=author;
        commentId = UUID.randomUUID().toString();
    }

    @Override
    public void addRating(User user, VoteType voteType) {

    }

    @Override
    public int getRating() {

    }
}
