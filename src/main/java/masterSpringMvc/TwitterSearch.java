package masterSpringMvc;


import java.util.List;

public interface TwitterSearch {
    List<LightTweet> search(String searchType, List<String> keywords);
}
