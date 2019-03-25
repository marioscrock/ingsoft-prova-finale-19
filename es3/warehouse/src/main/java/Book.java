public class Book extends Product {

    private String isbn;

    public Book(String title, String isbn, double price) {
        super(title, price);
        this.isbn = isbn;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + isbn;
    }

}
