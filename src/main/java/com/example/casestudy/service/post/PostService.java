package com.example.casestudy.service.post;

import com.example.casestudy.model.Post;
import com.example.casestudy.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService{

    @Autowired
    private IPostRepository postRepository;

    @Override
    public Post savePost(Post post) {
        postRepository.save(post);
        return postRepository.findById(post.getPostId()).get();
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllPost() {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC,"postId"));
    }

    @Override
    public Post findPostByPostId(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Iterable<Post> findPostByPosterId(Long userId) {
        return postRepository.findByPosterId(userId);
    }

    @Override
    public Iterable<Post> findByPosterIdAndTextPostContains(Long id, String textPost) {
        return postRepository.findByPosterIdAndTextPostContains(id,textPost);
    }


}
