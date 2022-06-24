package com.jojoldu.book.springboot.web.domain.posts;

import com.jojoldu.book.springboot.web.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor  // 기본 생성자 생성.
@Entity  // JPA ANNOTATION. 테이블과 링크될 어노테이션
public class Posts extends BaseTimeEntity {

    @Id     // 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // PK 생성규칙. auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private String userName;

    @Builder    // 해당 클래스의 빌드 패턴 생성. 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author, String userName){
        this.title = title;
        this.content = content;
        this.author = author;
        this.userName = userName;
    }

    public void update(String title, String content, String userName){
        this.title = title;
        this.content = content;
        this.userName = userName;
    }
}
