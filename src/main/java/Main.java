import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args)
    {
        Database.getSessionFactory().getSchemaManager().exportMappedObjects(true);
    }
}
