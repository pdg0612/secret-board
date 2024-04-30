package com.board.dh.Entity;

import com.board.dh.Entity.BoardEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardEntityTest {

    @Test
    public void testWriteTime() {
        // given
        String title = "Test Title";
        String content = "Test Content";
        String writer = "Test Writer";

        // when
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setTitle(title);
        boardEntity.setContent(content);
        boardEntity.setWriter(writer);
        String  writeTime = boardEntity.getWriteTime();

        // then
        assertThat(boardEntity.getTitle()).isEqualTo(title); // 입력된 제목이 일치하는지 확인
        assertThat(boardEntity.getContent()).isEqualTo(content); // 입력된 내용이 일치하는지 확인
        assertThat(boardEntity.getWriter()).isEqualTo(writer); // 입력된 작성자가 일치하는지 확인
        assertThat(writeTime).isNotNull(); // 생성된 날짜가 null이 아닌지 확인
//        assertThat(writeTime).isBeforeOrEqualsTo(new Date()); // 생성된 날짜가 현재 시간 이전이거나 현재 시간과 같은지 확인
    }
}
