package org.choongang.board.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.repositories.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /* main.html : 게시글 목록 조회 | write.html : 게시글 등록 | update.html : 게시글 수정 | delete.html : 게시글 삭제 */

    // 게시글 목록 조회
    @GetMapping("/main")
    public String main(Model model) {
        List<Board> board = BoardRepository.findAll();
        model.addAttribute("board", board);

        return "board/main";
    }

    // 게시글 등록
    @GetMapping("/write")
    public String writeBoard(Model model) {
        model.addAttribute("board", new Board());


        return "board/write";
    }

    // 게시글 수정
    @GetMapping("/update/{id}")
    public String editBoard(@PathVariable("id") Long id, Model model) {

        return "board/update";
    }

    // 게시글 삭제
    @PostMapping("/delete")
    public String deleteBoard() {

        return "board/main";
    }
}