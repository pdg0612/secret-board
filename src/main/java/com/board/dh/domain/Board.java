package com.board.dh.domain;

import com.board.dh.Entity.BoardEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idx;

    private String title;

    private String content;

    private String writer;

    private String writeTime;

    public static Board toDomain(BoardEntity entity) {
        return Board.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .writeTime(entity.getWriteTime())
                .build();
    }

    public static BoardEntity toEntity(Board board) {
        return BoardEntity.builder()
                .idx(board.getIdx())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .writeTime(board.getWriteTime())
                .build();
    }

}