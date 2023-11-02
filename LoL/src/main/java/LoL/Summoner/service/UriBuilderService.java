package LoL.Summoner.service;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import LoL.Match.dto.MatchIdDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UriBuilderService {

	private static final String LOL_SUMMONER_SEARCH_URL = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	private static final String LOL_MATCHID_SEARCH_URL = "https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/";
	private static final String LOL_MATCH_SEARCH_URL = "https://asia.api.riotgames.com/lol/match/v5/matches/";
	private static final String LOL_RANK_SEARCH_URL = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";

	public URI buildUriByNameSearch(String name) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOL_SUMMONER_SEARCH_URL);

		uriBuilder.path(name);

		URI uri = uriBuilder.build().encode().toUri();
		log.info("[UriBuilderService buildUriByNameSearch] name: {}, uri: {}", name, uri);

		return uri;
	}
	
	public URI buildUriByPuuidSearch(String puuid) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOL_MATCHID_SEARCH_URL);

		uriBuilder.path(puuid + "/ids");
		uriBuilder.query("start=0&count=20");

		URI uri = uriBuilder.build().encode().toUri();
		log.info("[UriBuilderService buildUriByPuuidSearch] puuid: {}, uri: {}", puuid, uri);

		return uri;
	}
	
	public URI buildUriByMatchIdSearch(MatchIdDTO matchId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOL_MATCH_SEARCH_URL);
		
	    String matchIdString = matchId.getMatchId();

		uriBuilder.path(matchIdString);

		URI uri = uriBuilder.build().encode().toUri();
		log.info("[UriBuilderService buildUriByMatchIdSearch] matchId: {}, uri: {}", matchId, uri);

		return uri;
	}
	
	public URI buildUriByIdSearch(String id) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(LOL_RANK_SEARCH_URL);
		
		uriBuilder.path(id);

		URI uri = uriBuilder.build().encode().toUri();
		log.info("[UriBuilderService buildUriByMatchIdSearch] id: {}, uri: {}", id, uri);

		return uri;
	}
}
