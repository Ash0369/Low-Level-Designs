public interface Ratable {
    int rating=0;
    void addRating(User user, VoteType voteType);
    int getRating();
}
