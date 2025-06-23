import java.util.Map;

public class StackOverflow {

    private final Map<Integer,User> Users;
    private final Map<Integer,Question>Questions;

    public StackOverflow(Map<Integer, User> users, Map<Integer, Question> questions) {
        Users = users;
        Questions = questions;
    }

    public String createUser(String name){
        User user = new User();
    }
}
