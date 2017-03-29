package nc.controllers;

import nc.entity.impl.ClubImpl;
import nc.service.ClubService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by petka on 28.03.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
@RequestMapping("/clubs")
public class ClubController {

    public static final Logger log = Logger.getLogger(ClubController.class);

    @Autowired
    @Qualifier("clubDBService")
    private ClubService clubService;

    @RequestMapping(method = RequestMethod.GET)
    public String homeClub(Model model) {
        log.info("Go to " + ClubController.class.getName());
        model.addAttribute("title", "Clubs page");
        return "club/club";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addClub(@RequestBody ClubImpl club) {
        //add validator...
        log.info("Run add method... club = " + club.toString());
        String id = clubService.createClub(club);
        log.info("added : " + id);
        return ResponseEntity.ok().body("success");
    }

}
