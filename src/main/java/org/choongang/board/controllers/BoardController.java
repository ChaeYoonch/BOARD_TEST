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
import java.util.Optional;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;

    // 게시글 목록 조회
    @GetMapping("/main")
    public String main(Model model) {
        List<Board> board = boardRepository.findAll();
        model.addAttribute("board", board);
        return "board/main";
    }

    // 게시글 등록 페이지
    @GetMapping("/write")
    public String writeBoardForm(Model model) {
        model.addAttribute("board", new Board());
        return "board/write";
    }

    // 게시글 등록 처리
    @PostMapping("/write")
    public String writeBoard(@ModelAttribute Board board) {
        boardRepository.save(board);
        return "redirect:/board/main";
    }

    // 게시글 수정 페이지
    @GetMapping("/update/{id}")
    public String editBoardForm(@PathVariable("id") Long id, Model model) {
        Optional<Board> board = boardRepository.findById(id);
        model.addAttribute("board", board.orElse(new Board()));
        return "board/update";
    }

    // 게시글 수정 처리
    @PostMapping("/update/{id}")
    public String updateBoard(@PathVariable("id") Long id, @ModelAttribute Board board) {
        board.setId(id);
        boardRepository.save(board);
        return "redirect:/board/main";
    }

    // 게시글 삭제
    @PostMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        boardRepository.deleteById(id);
        return "redirect:/board/main";
    }
}

/*package org.choongang.board.controllers;

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

/*import org.choongang.board.entities.Board;
import org.springframework.web.bind.annotation.GetMapping;// 게시글 목록 조회
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
} */