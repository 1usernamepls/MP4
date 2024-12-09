import java.util.Random;

public abstract class Book implements Comparable<Book> {

    protected String title;
    protected String author;
    protected String language;
    protected int publishing;
    protected int ISBN;
    protected double price;
    protected boolean availability;
    protected int stock;
    protected String category; //Replace genre with category (Fiction, Nonfiction, etc. are categories not genres)

    public Book(String t, String auth, String l, int pub, double p, boolean a, int s, String c) {
        title = t;
        author = auth;
        language = l;
        publishing = pub;
        Random rand = new Random();
        int min = 1000000000; // Assumes a 10-digit ISBN
        int max = 1999999999;
        ISBN = rand.nextInt(max - min + 1) + min; 
        price = p;
        availability = a;
        stock = s;
        category = c; 
    }

    public Book(Book b) {
        title = b.title;
        author = b.author;
        language = b.language;
        publishing = b.publishing;
        Random rand = new Random();
        int min = 1000000000;
        int max = 1999999999;
        ISBN = rand.nextInt(max - min + 1) + min;
        price = b.price;
        availability = b.availability;
        stock = b.stock;
        category = b.category; // Copy category
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLanguage() {
        return language;
    }

    public int getPublishing() {
        return publishing;
    }

    public int getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public int getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }

    public void setStock(int s) {
        stock = s;
    }

    public void setPrice(double p) {
        price = p;
    }

    public abstract String getGenre();
    public abstract void setGenre(String genre);
    public abstract String getTargetAudience();

    @Override
    public String toString() {
        String s = "";
        s += "\n";
        s += "Title: " + title + "\n";
        s += "Author: " + author + "\n";
        s += "Language: " + language + "\n";
        s += "Published: " + publishing + "\n";
        s += "\tISBN: " + ISBN + "\n";
        s += "\tPrice: $" + price + "\n";
        s += "\tAvailability: " + availability + "\n";
        s += "\tCategory: " + category + "\n";
        s += "\t# IN STOCK: " + stock + "\n";
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book b = (Book) o;
        return (this.title.equals(b.title) 
        && this.author.equals(b.author));
    }
    
    public int compareTo(Book b) {
        if (this.price == b.price) {
            return 0;
        }
        else if (this.price > b.price) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
