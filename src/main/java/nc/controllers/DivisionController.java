package nc.controllers;

import nc.dao.ObjectDao;
import nc.entity.Club;
import nc.entity.Division;
import nc.entity.impl.ClubImpl;
import nc.entity.impl.DivisionImpl;
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
 * Created by petka on 14.04.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
@RequestMapping("/division")
public class DivisionController {

    public static final Logger log = Logger.getLogger(DivisionController.class);
    public static String CLUB_ID;

    @Autowired
    @Qualifier("objectDaoImpl")
    private ObjectDao objectDao;

    @Autowired
    @Qualifier("clubDBService")
    private ClubService clubService;

    @Autowired
    @Qualifier("divisionDBService")
    private DivisionService divisionService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addDivision(@RequestBody DivisionImpl division) {
        //add validator...
        log.info("Run add method... club = " + division.toString());
        String id = divisionService.createDivision(division, CLUB_ID);
        log.info("added : " + id);
        return ResponseEntity.ok().body("success");
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String deleteDivision(@PathVariable String id, Model model) {
        log.info("delete...");
        divisionService.deleteDivision(id);
        log.info("success delete!");
        return "redirect:/division/views/" + CLUB_ID;
    }

    @RequestMapping(value = "/views/{id}", method = RequestMethod.GET)
    public String viewDivisionInClub(@PathVariable String id, Model model) {
        log.info("run view divisions in club method...");
        CLUB_ID = id;

        Club club = clubService.getById(id);
        log.info("parent ig : " + club.getId());
        model.addAttribute("title", "Divisions from " + club.getName());
        List<Division> divisions = divisionService.getByClub(club);
        model.addAttribute("club", club);
        log.info(divisions.toString());
        model.addAttribute("divisions", divisions);
        return "division/view";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDivision(@PathVariable String id, Model model) {
        Division division = divisionService.getById(id);
        model.addAttribute("division", division);
        return "division/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDivision(@RequestParam String id, @RequestParam String name) {
        divisionService.updateDivision(new DivisionImpl(id, name));
        return "redirect:/division/views/" + CLUB_ID;
    }

}
