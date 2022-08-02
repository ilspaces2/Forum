package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostMem;

import java.util.Collection;

@Service
public class PostService {

    private PostMem store;

    public PostService(PostMem store) {
        this.store = store;
    }

    public Post save(Post post) {
        return store.save(post);
    }

    public void update(Post post) {
        store.update(post);
    }

    public void deleteById(int id) {
        store.deleteById(id);
    }

    public Post findByIdPost(int id) {
      return store.findByIdPost(id);
    }

    public Collection<Post> findAll() {
        return store.findAll();
    }
}