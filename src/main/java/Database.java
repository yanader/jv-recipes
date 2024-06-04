import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static java.lang.Boolean.TRUE;

import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {

        var sessionFactory = new Configuration()
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Rating.class)
                .addAnnotatedClass(Ingredient.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Image.class)

                // Use H2 in-mem database
                .setProperty(URL, "jdbc:h2:mem:db1")
                // default username/pass
                .setProperty(USER, "sa")
                .setProperty(PASS, "")
                .setProperty("hibernate.agroal.maxSize", "20")


                //options to display SQL in console
                .setProperty(SHOW_SQL, TRUE.toString())
                .setProperty(FORMAT_SQL, TRUE.toString())
                .setProperty(HIGHLIGHT_SQL, TRUE.toString())
                .buildSessionFactory();

        return sessionFactory;
    }

    public static void seed() {
        var sessionFactory = getSessionFactory();

        sessionFactory.inTransaction(session -> {
            session.persist(new Tag("Pasta"));
            session.persist(new Tag("Vegan"));
            session.persist(new Tag("Sweet"));
        });

        sessionFactory.inTransaction(session -> {
            Tag t = session.find(Tag.class, 1L);
            System.out.println(t.getName());
        });
    }
}
