package com.jessmorse.travelblog.post;

import com.jessmorse.travelblog.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostServiceTest {

    private PostDAO postDAO;
    private PostService underTest;

    @BeforeEach
    void setUp() {
        postDAO = mock(PostDAO.class);
        underTest = new PostService(postDAO);
    }

    //@Test
//    void canAddNewPost() {
//        //given
//        long userId = 1;
//        String postBody = "great";
//        String Country = "uk";
//        int rating = 3;
//        String topTip = "bring umbrella";
//        int cost = 50;
//        LocalDate datePosted = LocalDate.parse("2022-03-13");
//
//        //when
//        underTest.addNewPost(userId,);
//    }

    @Test
    void canGetPostByUser() {
        //given
        long userId=1;
        Post post = new Post(1,"great","uk",
                2,"it rains",10,LocalDate.parse("2022-01-01"));
        when(postDAO.getPostsByUser(userId)).thenReturn(List.of(post));

        //when
        List<Post> posts = underTest.getPostsByUser(userId);
        ArgumentCaptor<Long> userIdCaptor = ArgumentCaptor.forClass(Long.class);

        //then
        verify(postDAO,times(1)).getPostsByUser(userIdCaptor.capture());
        Long arg1sent = userIdCaptor.getValue();

        assertThat(arg1sent).isEqualTo(userId);
        assertThat(posts).isEqualTo(postDAO.getPostsByUser(userId));

    }

//    @Test
//    void canDeletePost() {}
//    //given
//
//
//    //when
//    underTest.deletePost()


}
