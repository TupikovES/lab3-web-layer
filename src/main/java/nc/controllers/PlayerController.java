package nc.controllers;

import nc.dao.ObjectDao;
import nc.entity.Division;
import nc.entity.ObjectEntity;
import nc.entity.Player;
import nc.entity.impl.PlayerImpl;
import nc.service.DivisionService;
import nc.service.PlayerService;
import nc.util.Breadcrumb;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by petka on 12.05.2017.
 *
 * @author Evgeniy Tupikov
 */
@Controller
@RequestMapping("/player")
public class PlayerController {

    public static final Logger log = Logger.getLogger(PlayerController.class);
    public static String LAST_DIVISION;

    @Autowired
    @Qualifier("divisionDBService")
    private DivisionService divisionService;

    @Autowired
    @Qualifier("playerDBService")
    private PlayerService playerService;

    @RequestMapping(value = "/views/{divisionId}", method = RequestMethod.GET)
    public String viewPlayerList(@PathVariable String divisionId, Model model) {
        LAST_DIVISION = divisionId;
        String breadcrumb = divisionService.getBreadcrumb(LAST_DIVISION);
        model.addAttribute("breadcrumb", breadcrumb);
        Division division = divisionService.getById(LAST_DIVISION);
        List<Player> players = playerService.getByDivision(division);
        model.addAttribute("division", division);
        model.addAttribute("players", players);
        return "player/view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addPlayer(@RequestBody PlayerImpl player) {
        log.info("Add player " + player.toString());
        String id = playerService.createPlayer(player, LAST_DIVISION);
        log.info("success add player.");
        return ResponseEntity.ok().body("success");
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String deletePlayer(@PathVariable String id) {
        playerService.deletePlayer(id);
        return "redirect:/player/views/" + LAST_DIVISION;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editDivision(@PathVariable String id, Model model) {
        Player player = playerService.getById(id);
        log.info("get player for id : " + id + "\n" +
        "player : " + player.toString());
        model.addAttribute("player", player);
        return "player/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateDivision(
            @RequestParam String id,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String age) {
        playerService.updatePlayer(new PlayerImpl(id, firstName, lastName, Integer.parseInt(age)));
        return "redirect:/player/views/" + LAST_DIVISION;
    }

}
