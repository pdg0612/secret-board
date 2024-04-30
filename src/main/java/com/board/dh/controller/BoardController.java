package com.board.dh.controller;

import com.board.dh.Service.BoardService;
import com.board.dh.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@Controller
@RequestMapping("/")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("")
    public String list(@RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
                       @RequestParam(value = "search", required = false) String search,
                       Model model) {
        Page<Board> page = boardService.list(pageNumber, search);
        model.addAttribute("page", page); // 페이지 전달
        return "list";
    }

    @GetMapping("write")
    public String write(){
        return "write";
    }



    @GetMapping("{idx}")
    public String read(@PathVariable("idx")int idx,Model model){
        model.addAttribute("board",boardService.read(idx));
        return "read";
    }

    @GetMapping("update/{idx}")
    public String update(@PathVariable("idx")int idx, Model model){
        model.addAttribute("board",boardService.read(idx));
        return "update";
    }

    @GetMapping("/delete/{idx}")
    public String delete(@PathVariable("idx") int idx){
        boardService.delete(idx);
        return "redirect:/";
    }
}
