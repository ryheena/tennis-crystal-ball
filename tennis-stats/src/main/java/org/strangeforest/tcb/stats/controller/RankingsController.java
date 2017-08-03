package org.strangeforest.tcb.stats.controller;

import java.time.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.format.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.strangeforest.tcb.stats.model.*;
import org.strangeforest.tcb.stats.service.*;

import static java.lang.Boolean.*;
import static org.strangeforest.tcb.util.DateUtil.*;

@Controller
public class RankingsController extends PageController {

	@Autowired private PlayerService playerService;
	@Autowired private RankingsService rankingsService;

	@GetMapping("/rankingsTable")
	public ModelAndView rankingsTable(
		@RequestParam(name = "rankType", required = false) RankType rankType,
		@RequestParam(name = "season", required = false) Integer season,
		@RequestParam(name = "date", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate date
	) {
		if (date != null)
			season = date.getYear();
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("surfaces", Surface.values());
		modelMap.addAttribute("seasons", dataService.getSeasons());
		modelMap.addAttribute("rankType", rankType);
		modelMap.addAttribute("season", season);
		modelMap.addAttribute("date", toDate(date));
		if (season != null)
			modelMap.addAttribute("dates", rankingsService.getSeasonRankingDates(rankType, season));
		return new ModelAndView("rankingsTable", modelMap);
	}

	@GetMapping("/peakEloRatings")
	public ModelAndView peakEloRatings() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("surfaces", Surface.values());
		modelMap.addAttribute("peakElo", TRUE);
		return new ModelAndView("peakEloRatings", modelMap);
	}

	@GetMapping("/rankingsChart")
	public ModelAndView rankingsChart() {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("playerQuickPicks", playerService.getPlayerQuickPicks());
		modelMap.addAttribute("seasons", dataService.getSeasons());
		modelMap.addAttribute("rankTypes", RankType.values());
		return new ModelAndView("rankingsChart", modelMap);
	}
}
