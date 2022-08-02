package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PostMem {

    private AtomicInteger id = new AtomicInteger();
    private Map<Integer, Post> posts = new HashMap<>();

    public Post save(Post post) {
        post.setId(id.incrementAndGet());
        post.setCreated(new GregorianCalendar());
        return posts.put(post.getId(), post);
    }

    public void update(Post post) {
        post.setCreated(new GregorianCalendar());
        posts.replace(post.getId(), post);
    }

    public void deleteById(int id) {
        posts.remove(id);
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public Post findByIdPost(int id) {
        return posts.get(id);
    }
}
