/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

public class Book {
    public boolean someLibraryMethod() {
        return true;
    }


    private String author;
    private String text;

    public Book(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }



    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
