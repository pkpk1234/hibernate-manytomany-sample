package com.example.hibernatemanytomanysample;

import com.example.hibernatemanytomanysample.model.Post;
import com.example.hibernatemanytomanysample.model.Tag;
import com.example.hibernatemanytomanysample.repository.PostRepository;
import com.example.hibernatemanytomanysample.repository.TagRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateManytomanySampleApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(HibernateManytomanySampleApplicationTests.class);
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private EntityManager entityManager;

    @Test(expected=InvalidDataAccessApiUsageException.class)
    public void testPersistenceByJpa() {
        Post post1 = new Post("JPA with Hibernate");
        Post post2 = new Post("Native Hibernate");

        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Hibernate");

        post1.addTag(tag1);
        post1.addTag(tag2);
        post2.addTag(tag1);

        post1 = this.postRepository.save(post1);
        logger.info("Post1 : " + post1);
        logger.info("start for save post2 ==========================================");
        post2 = this.postRepository.save(post2); //Throw an exception
        logger.info("Post2 : " + post2);
    }

    @Test()
    @Transactional
    public void testPersistenceByJpa2() {
        Post post1 = new Post("JPA with Hibernate");
        Post post2 = new Post("Native Hibernate");

        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Hibernate");

        post1.addTag(tag1);
        post1.addTag(tag2);
        post2.addTag(tag1);

        post1 = this.postRepository.save(post1);
        logger.info("Post1 : " + post1);
        logger.info("start for save post2 ==========================================");
        post2 = this.postRepository.save(post2); //Throw an exception
        logger.info("Post2 : " + post2);
    }

    @Test
    @Transactional
    public void testPersistenceByEntityManager() {
        Post post1 = new Post("JPA with Hibernate");
        Post post2 = new Post("Native Hibernate");

        Tag tag1 = new Tag("Java");
        Tag tag2 = new Tag("Hibernate");

        post1.addTag(tag1);
        post1.addTag(tag2);
        post2.addTag(tag1);

        this.entityManager.persist(post1);
        logger.info("Post1 : " + post1);
        logger.info("start for save post2 by entityManager ==========================================");
        this.entityManager.persist(post2); // save successfully
        logger.info("Post2 : " + post2);
    }
}
