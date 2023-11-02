package LoL.Search.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import LoL.Match.dto.MatchDto;
import LoL.Match.dto.MatchIdDTO;
import LoL.Match.service.MatchIdService;
import LoL.Match.service.MatchService;
import LoL.Rank.dto.LeagueEntryDTO;
import LoL.Rank.service.RankService;
import LoL.Summoner.dto.SummonerDTO;
import LoL.Summoner.service.SummonerService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final SummonerService summonerService;
	//private final MatchIdService matchIdService;
	//private final MatchService matchService;
	private final RankService rankService;
	
	@GetMapping("/")
	public String searchSummoner(Model model) {
		
		model.addAttribute("title", "롤전적검색사이트");
		
		return "user/index";
	}
	
	@GetMapping("/search")
	public String searchResult(Model model, @RequestParam(value = "summonerName") String summonerName) {
		
		SummonerDTO summonerInfo = summonerService.requestPuuidSearch(summonerName);
		//List<MatchIdDTO> matchId = matchIdService.requestPuuidSearch(summonerInfo.getPuuid()); 최근 20개의 게임 리그 아이디
		//MatchDto match = matchService.requestMatchIdSearch(matchId.get(0)); 반복문을 통해 20가지의 리그 아이디를 통해 게임의 정보를 나타내는 매치정보
		List<LeagueEntryDTO> rankInfo = rankService.requestIdSearch(summonerInfo.getId());
		
		LeagueEntryDTO rankInfo1, rankInfo2 = null;
		
		rankInfo1 = new LeagueEntryDTO(rankInfo.get(1).getWins(), rankInfo.get(1).getLosses(), rankInfo.get(1).getRank(), rankInfo.get(1).getTier(), rankInfo.get(1).getLeaguePoints(), Math.round(rankInfo.get(1).getWins()*100/(float)(rankInfo.get(1).getWins() + rankInfo.get(1).getLosses())));
		rankInfo2 = new LeagueEntryDTO(rankInfo.get(0).getWins(), rankInfo.get(0).getLosses(), rankInfo.get(0).getRank(), rankInfo.get(0).getTier(), rankInfo.get(0).getLeaguePoints(),Math.round(rankInfo.get(0).getWins()*100/(float)(rankInfo.get(0).getWins() + rankInfo.get(0).getLosses())));
		
		// 타이틀
		model.addAttribute("title", summonerName + " - 게임 전적 - League of Legends");
		// 아이콘 이미지
		model.addAttribute("imgURL", "http://ddragon.leagueoflegends.com/cdn/13.21.1/img/profileicon/"
				+ summonerInfo.getProfileIconId() + ".png");
		// 소환사 정보
		model.addAttribute("info", summonerInfo); 
		// 랭크정보
		model.addAttribute("rankInfo1", rankInfo1); 
		model.addAttribute("rankInfo2", rankInfo2); 
		// 티어 이미지
		model.addAttribute("tierImgURL1", "img/emblems/emblem-" + rankInfo1.getTier() + ".png");
		model.addAttribute("tierImgURL2", "img/emblems/emblem-" + rankInfo2.getTier() + ".png");
		
		return "user/result";
		
	}
}
