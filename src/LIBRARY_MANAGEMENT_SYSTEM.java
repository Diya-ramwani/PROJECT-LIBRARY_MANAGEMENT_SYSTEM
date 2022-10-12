
import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.util.Scanner;

public class LIBRARY_MANAGEMENT_SYSTEM {
    static String fileName;
    static library lib=new library();
    static Scanner in=new Scanner(System.in);
    static boolean running =true;



    public static void main(String[] args) {
        while (running){
            System.out.println();
            System.out.println("                  ******LIBRARY MANAGEMENT SYSTEM******");
            list li=new list();
            li.run();
            System.out.println("\n 1). enter 0 for load a library"+"\n " +
                    "2). enter 1 for save and quite" + "\n " +
                    "3). enter 2 for list all book in library"+"\n" +
                    " 4). enter 3 for add books in library");
            loader l = new loader();
            l.start();

            int answer=in.nextInt();

            switch (answer){
                case 0:
                    System.out.println("enter the file name to load");
                    fileName=in.next();
                    loadScript(fileName);

                    break;
                case 1:
                    saveAndQuit(); //methods
                    break;
                case 2:
                    System.out.println(lib.toString());
                    break;
                case 3:
                    addbook();
                    break;
            }
        }
        System.exit(0);
    }
    public static  void addbook(){
        int isbn;
        String title, auther;
        double price;

        System.out.println("\n Enter title: ");
        title=in.next();

        System.out.println("\n Enter Author: ");
        auther=in.next();

        System.out.println("\n Enter isbn: ");
        isbn=in.nextInt();

        System.out.println("\n Enter price: ");
        price=in.nextDouble();

        book b=new book(isbn, title, auther, price);
        lib.addbook(b);
    }
    static void saveAndQuit(){
        System.out.println("Enter file name: ");
        fileName=in.next()+".ser";
        running=false;
        FileOutputStream fos=null;
        ObjectOutputStream out=null;
        try {
            fos=new FileOutputStream(fileName);
            out=new ObjectOutputStream(fos);
            out.writeObject(lib);
            fos.close();
            out.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void loadScript(String name){
        FileInputStream fis=null;
        ObjectInputStream in=null;
        File file=new File(fileName+".ser");
        if (file.exists()){
            try {
                fis=new FileInputStream(file);
                in=new ObjectInputStream(fis);
                lib=(library) in.readObject();
                fis.close();
                in.close();
            }
            catch (IOException ex){
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("\n The file does not exist! ");
        }
    }
}