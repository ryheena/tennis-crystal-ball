package org.strangeforest.tcb.stats.controler;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.strangeforest.tcb.stats.service.*;

@Controller
public class StatsLeadersController {

	@Autowired private StatsLeadersService statsLeadersService;

	@RequestMapping("/statsLeaders")
	public ModelAndView statsLeaders() {
		List<Integer> seasons = statsLeadersService.getSeasons();
		return new ModelAndView("statsLeaders", "seasons", seasons);
	}
}