package LoL.Search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import LoL.Summoner.dto.SummonerDTO;
import LoL.Summoner.service.SummonerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final SummonerService summonerService;
	
	@GetMapping("/")
	public String searchSummoner(Model model) {
		
		model.addAttribute("title", "롤전적검색사이트");
		
		return "user/index";
	}
	
	@GetMapping("/search")
	public String searchResult(Model model, @RequestParam(value = "summonerName") String summonerName) {
		
		SummonerDTO summonerInfo = summonerService.requestPuuidSearch(summonerName);
		
		if(summonerInfo != null) {
			
			model.addAttribute("title", summonerName + " - 게임 전적 - League of Legends");
			model.addAttribute("imgURL", "http://ddragon.leagueoflegends.com/cdn/13.21.1/img/profileicon/"
					+ summonerInfo.getProfileIconId() + ".png");
			model.addAttribute("info", summonerInfo); 
			
			return "user/result";
			
		}
		
		model.addAttribute("title", "롤 전적 검색은 OP.GG - 게임 전적");
		
		return "user/nonExistentName";
		
	}
}
