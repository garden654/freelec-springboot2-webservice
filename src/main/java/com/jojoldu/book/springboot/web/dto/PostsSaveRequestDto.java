package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.web.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String userName;
    @Builder
    public PostsSaveRequestDto(String title, String content,
                                           String author, String userName) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.userName = userName;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .userName(userName)
                .build();
    }
}
