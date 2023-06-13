package com.example.threetier.mapper;

import com.example.threetier.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void insertTest(){
        PostVO postVO = new PostVO();
        postVO.setMemberName("한동석");
        postVO.setPostTitle("책 소개");
        postVO.setPostContent("재밌는 책 소개해요!");
        postMapper.insert(postVO);
    }

    @Test
    public void selectAllTest(){
        assertThat(postMapper.selectAll()).hasSize(1);
    }

    @Test
    public void selectTest(){
        final Optional<PostVO> foundPost = postMapper.select(3L);
//        foundPost.ifPresent(postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석"));
//        foundPost.ifPresentOrElse(
//                postVO -> assertThat(postVO.getMemberName()).isEqualTo("한동석")
//                , () -> {log.error("회원 조회 실패");});
//        PostVO post = foundPost.orElseThrow(() -> {throw new RuntimeException();});

//        if(foundPost.isPresent()){
//            foundPost.get();
//        }
//
//        foundPost.ifPresent();
    }

    @Test
    public void updateTest(){
        Optional<PostVO> foundPost = postMapper.select(1L);
        foundPost.ifPresent(post -> post.setPostContent("수정된 내용"));
        PostVO postVO = foundPost.orElseThrow();
        postMapper.update(postVO);
        foundPost = postMapper.select(1L);
        foundPost.ifPresent(post -> assertThat(post.getPostContent()).isEqualTo("수정된 내용"));
    }

    @Test
    public void deleteTest(){
        postMapper.delete(1L);
        assertThat(postMapper.selectAll()).hasSize(0);
    }
}













