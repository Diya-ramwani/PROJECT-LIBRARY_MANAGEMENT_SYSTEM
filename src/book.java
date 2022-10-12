
import java.io.*;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;

class book implements Serializable{
    private int isbn;     //international standard book number
    private String title, auther;
    private double price;

    public book(){

    }
    // costr
    public book(int isbn, String title, String auther, double price){
        this.isbn=isbn;
        this.auther=auther;
        this.price=price;
        this.title=title;
    }
    public String toString(){
        list l=new list();
        l.run();
        return "\n title: "+title+"\n auther: "+auther+"\n isbn: "+isbn+"\n price: "+price+"\n ";
    }
}


class library extends Object implements Serializable{
    private List<book> collection;

    public library() {

        collection = new ArrayList<book>();
    }

    public void addbook(book b) {

        collection.add(b);
    }

    public String toString() {

        String total = "\n";
        Iterator<book> i = collection.iterator();
        while (i.hasNext()) {
            book b = (book) i.next();
            total = total + b.toString();
        }
        return total;
    }
}


class list extends Thread{
    @Override
    public void run() {
        try {
            sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}