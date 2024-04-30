package com.board.dh.Service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardServiceTest {

    private final BoardService boardService;

    BoardServiceTest(BoardService boardService) {
        this.boardService = boardService;
    }

    @Test
    void read() {
        System.out.println(boardService.read(1));
    }
}