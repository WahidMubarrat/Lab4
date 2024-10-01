public class Book {
    private String title;
    private String author;
    private String genre;
    private int pages;
    private String dateRead;

    // Constructor
    public Book(String title, String author, String genre, int pages, String dateRead) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.dateRead = dateRead;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDateRead() {
        return dateRead;
    }

    public void setDateRead(String dateRead) {
        this.dateRead = dateRead;
    }



    public String print() {
        return  "title=" + title + '\'' + ", author='" + author + '\'' + ", genre='" + genre + '\'' + ", pages=" + pages + ", dateRead='" + dateRead + '\'' ;
    }
}
