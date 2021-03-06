package nc.controllers;

import nc.entity.Club;
import nc.entity.impl.ClubImpl;
import nc.service.ClubService;
import nc.service.DivisionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    @Qualifier("divisionDBService")
    private DivisionService divisionService;

    @RequestMapping(method = RequestMethod.GET)
    public String homeClub(Model model) {
        log.info("Go to " + ClubController.class.getName());
        model.addAttribute("title", "Clubs page");
        List<Club> clubs = clubService.getAll();
        log.info(clubs.toString());
        model.addAttribute("clubs", clubs);
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

    @RequestMapping(value = "/del/{id}",method = RequestMethod.GET)
    public String deleteClub(@PathVariable String id, Model model) {
        log.info("Run delet method... club id = " + id);
        Club club = new ClubImpl();
        club.setId(id);
        clubService.deleteClub(club);
        return "redirect:/clubs";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editClub(@PathVariable String id, Model model) {
        Club club = clubService.getById(id);
        model.addAttribute("club", club);
        return "club/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateClub(@RequestParam String id, @RequestParam String name, @RequestParam String city) {
        log.info(id + " - " + name + " - " + city);
        clubService.updateClub(new ClubImpl(id, name, city));
        return "redirect:/clubs";
    }

    @RequestMapping(value = "/rename", method = RequestMethod.POST)
    public String renameClub(@RequestParam String suffix) {



        return "redirect:/clubs";
    }

}
