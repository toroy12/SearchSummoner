package LoL.Match.service;

import java.net.URI;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import LoL.Match.dto.MatchDto;
import LoL.Match.dto.MatchIdDTO;
import LoL.Summoner.dto.SummonerDTO;
import LoL.Summoner.service.UriBuilderService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchService {
	
	private final RestTemplate restTemplate;
	private final UriBuilderService uriBuilderService;

	private static final String riotApiKey = "RGAPI-08a13a44-4603-4f4a-8eee-a7bfe578c24d";

	public MatchDto requestMatchIdSearch(MatchIdDTO matchId) {

		if (ObjectUtils.isEmpty(matchId))
			return null;

		URI uri = uriBuilderService.buildUriByMatchIdSearch(matchId);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		HttpEntity httpEntity = new HttpEntity<>(headers);

		return restTemplate.exchange(uri, HttpMethod.GET, httpEntity, MatchDto.class).getBody();
	}
}
