import java.util.UUID;

public class Tag {
    private String tagId;
    private String tagName;

    public Tag(String tagName){
        this.tagName=tagName;
        tagId= UUID.randomUUID().toString();
    }

    
}
