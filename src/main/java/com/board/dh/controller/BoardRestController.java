package com.board.dh.controller;


import com.board.dh.Service.BoardService;
import com.board.dh.domain.Board;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BoardRestController {
    private final BoardService boardService;

    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }
    @PostMapping("")
    public Board writing(@RequestBody Board board){
        return boardService.write(board);
    }


    @PostMapping("update")
    public Board updating(@RequestBody Board board){
        boardService.update(board);
        return board;

    }
}
