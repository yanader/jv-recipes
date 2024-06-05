import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.lang.Boolean.TRUE;

import static org.hibernate.cfg.JdbcSettings.*;

public class Database {
    public static SessionFactory getSessionFactory() {

        var sessionFactory = new Configuration()
                .addAnnotatedClass(Recipe.class)
                .addAnnotatedClass(User.class)
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

        seedTags(sessionFactory);
        seedUsers(sessionFactory);
        seedIngredients(sessionFactory);
        seedRecipes(sessionFactory);

        showAllInTable(sessionFactory, Tag.class);
        showAllInTable(sessionFactory, User.class);
        showAllInTable(sessionFactory, Ingredient.class);
        showAllInTable(sessionFactory, Recipe.class);
    }

    private static void seedTags(SessionFactory sessionFactory) {
        sessionFactory.inTransaction(session -> {
            session.persist(new Tag("Pasta"));
            session.persist(new Tag("Vegan"));
            session.persist(new Tag("Sweet"));
            session.flush();
        });
    }

    private static void showAllInTable(SessionFactory sessionFactory, Class passedClass) {
        sessionFactory.inTransaction(session -> {
            List<?> list = session.createQuery("from " + passedClass.getSimpleName(), passedClass).list();

            for (Object o : list) {
                System.out.println(o);
            }
        });
    }

    private static void seedUsers(SessionFactory sessionFactory) {
        sessionFactory.inTransaction(session -> {
            session.persist(new User("ste", "email", "password", LocalDate.now()));
            session.persist(new User("Joy", "lovely email", "tinypassword", LocalDate.now()));
            session.persist(new User("croc", "crocMail", "megaSecure", LocalDate.now()));
            session.flush();
        });
    }

    private static void seedIngredients(SessionFactory sessionFactory) {
        sessionFactory.inTransaction(session -> {
            session.persist(new Ingredient("peppers", 3, "Unit"));
            session.persist(new Ingredient("Flour", 200, "Grams"));
            session.persist(new Ingredient("Eggs", 6, "Unit"));
            session.flush();
        });
    }

    private static void seedRecipes(SessionFactory sessionFactory) {
        sessionFactory.inTransaction(session -> {
            User user = session.find(User.class, 1L);
            session.persist(new Recipe("Egg", user));
            session.flush();
        });
    }
}
