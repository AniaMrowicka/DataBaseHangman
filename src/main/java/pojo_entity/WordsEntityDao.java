package pojo_entity;

import entities.WordsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


class WordsEntityDao {
    @SuppressWarnings("CanBeFinal")
    private static Logger logger = LoggerFactory.getLogger(WordsEntityDao.class);
    private final SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        WordsEntityDao wed = new WordsEntityDao();

        try (Session session = wed.sessionFactory.openSession()) {
            List<WordsEntity> list = new ArrayList();

            list.add(new WordsEntity("pies", "easy"));
            list.add(new WordsEntity("kot", "easy"));
            list.add(new WordsEntity("kwiat", "easy"));
            list.add(new WordsEntity("nos", "easy"));
            list.add(new WordsEntity("krzak", "easy"));
            list.add(new WordsEntity("nic", "easy"));
            list.add(new WordsEntity("dawno", "easy"));
            list.add(new WordsEntity("okno", "easy"));
            list.add(new WordsEntity("koc", "easy"));
            list.add(new WordsEntity("mysz", "easy"));
            list.add(new WordsEntity("książka", "medium"));
            list.add(new WordsEntity("koszyk", "medium"));
            list.add(new WordsEntity("bocian", "medium"));
            list.add(new WordsEntity("zabawka", "medium"));
            list.add(new WordsEntity("bałwan", "medium"));
            list.add(new WordsEntity("rower", "medium"));
            list.add(new WordsEntity("chmura", "medium"));
            list.add(new WordsEntity("dywan", "medium"));
            list.add(new WordsEntity("omlety", "medium"));
            list.add(new WordsEntity("dziwny", "medium"));
            list.add(new WordsEntity("dzwonnik", "medium"));
            list.add(new WordsEntity("suszarka", "medium"));
            list.add(new WordsEntity("kartofel", "hard"));
            list.add(new WordsEntity("wycieraczka", "hard"));
            list.add(new WordsEntity("AGNIESZKA", "hard"));
            list.add(new WordsEntity("ONOMATOPEJA", "hard"));
            list.add(new WordsEntity("KALENDARIUM", "hard"));
            list.add(new WordsEntity("PLANETARIUM", "hard"));
            list.add(new WordsEntity("ASTRONAUTA", "hard"));
            list.add(new WordsEntity("WŚCIEKŁY", "hard"));
            list.add(new WordsEntity("KOSMONAUTA", "hard"));
            list.add(new WordsEntity("SZCZEBRZESZYNO", "hard"));
            list.add(new WordsEntity("MAŁŻEŃSWTO", "hard"));
            list.add(new WordsEntity("MALEŃSTWO", "hard"));
            list.add(new WordsEntity("PUCHATEK", "hard"));
            list.add(new WordsEntity("MIKSER", "hard"));
            list.add(new WordsEntity("TELEWIZOR", "hard"));
            list.add(new WordsEntity("SATELITA", "hard"));
            list.add(new WordsEntity("SESJA", "medium"));


            list.stream()
                    .forEach(words -> wed.save(words, session));
            wed.sessionFactory.close();

        }
    }

    private WordsEntityDao() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(WordsEntity.class)
                .buildMetadata();

        sessionFactory = metadata.buildSessionFactory();
    }

    private SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private void save(WordsEntity wordsEntity, Session session) {
        Transaction transaction = session.beginTransaction();
        logger.info("Saving: {}", wordsEntity);
        session.save(wordsEntity);
        logger.info("Saving to db: {}", wordsEntity);
        transaction.commit();
    }

    public WordsEntity update(WordsEntity wordsEntity) {
        try (SessionFactory sessionFactory = getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            logger.info("Updating: {}", wordsEntity);
            session.update(wordsEntity);
            logger.info("Updating in db: {}", wordsEntity);
            transaction.commit();
        }
        return wordsEntity;
    }

    public void delete(WordsEntity wordsEntity) {
        try (SessionFactory sessionFactory = getSessionFactory();
             Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            logger.info("Deleting: {}", wordsEntity);
            session.delete(wordsEntity);
            logger.info("Deleting from db: {}", wordsEntity);
            transaction.commit();
        }
    }


}
