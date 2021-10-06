package quotes;

public class ApiQuotes {

    private String quoteAuthor;
    private String quoteText;

    public ApiQuotes(String author, String text) {
        this.quoteAuthor = author;
        this.quoteText = text;
    }

    public String getAuthor() {
        return quoteAuthor;
    }

    public String getText() {
        return quoteText;
    }

    @Override
    public String toString() {
        return "ApiQuotes{" +
                "author='" + quoteAuthor + '\'' +
                ", text='" + quoteText + '\'' +
                '}';
    }
}
