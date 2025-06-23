public class Rate implements Ratable{
    User userId;
    VoteType voteType;
    @Override
    public void addRating(User user, VoteType voteType) {
        this.userId=user;
        this.voteType=voteType;
    }

    @Override
    public VoteType getVoteType() {
        return voteType;
    }
}
