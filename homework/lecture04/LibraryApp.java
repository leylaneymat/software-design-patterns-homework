package lecture04;

public class LibraryApp {

    public void saveBook() {
        // fetch from db: 1

        // do internal process

        // save into db: 2
    }

    public static void main(String[] args) {
        DBConnection connection1 = DBConnection.getInstance();

        connection1 = null;

        System.out.println("Did some work");

        DBConnection connection2 = DBConnection.getInstance();

        System.out.println("Did more work");
    }
}

class DBConnection {

    private DBConnection() {
        System.out.println("Connected to the DB");
    }

    private static class Holder {
        private static final DBConnection INSTANCE = new DBConnection();
    }

    public static DBConnection getInstance() {
        return Holder.INSTANCE;
    }
}