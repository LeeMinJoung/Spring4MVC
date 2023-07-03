package ming.hello.spring4.controller;

import ming.hello.spring4.model.Board;
import ming.hello.spring4.service.BoardService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired BoardService bsrv;

    private Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list")
    public String list(Model m, int cpg) {
        logger.info("board/list 호출!!");

        m.addAttribute("boards", bsrv.readBoard(cpg));
        //m.addAttribute("psnum", bsrv.readBoard(cpg));   // 페이지네이션 시작번호
        //m.addAttribute("allpg", bsrv.readBoard(cpg));   // 총페이지수

        return "board/list.tiles";
    }

    @GetMapping("/write")
    public String write(Model m) {

        return "board/write.tiles";
    }

    @GetMapping("/view")
    public String view(Model m, String bno) {
        logger.info("board/view 호출!!");
        Board board = bsrv.readOneBoard(bno);

        m.addAttribute("board", board);

        return "board/view.tiles";
    }
}
