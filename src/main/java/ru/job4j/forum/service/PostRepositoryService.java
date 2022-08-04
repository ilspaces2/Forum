package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.Collection;

@Service
public class PostRepositoryService {

    private PostRepository store;

    public PostRepositoryService(PostRepository store) {
        this.store = store;
    }

    public Post save(Post post) {
        return store.save(post);
    }

    public void update(Post post) {

        store.save(post);
    }

    public Post findByIdPost(int id) {
        return store.findById(id).get();
    }

    public Collection<Post> findAll() {
        return (Collection<Post>) store.findAll();
    }
}
