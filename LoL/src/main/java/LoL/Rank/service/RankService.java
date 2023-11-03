package LoL.Rank.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import LoL.Match.dto.MatchIdDTO;
import LoL.Rank.dto.LeagueEntryDTO;
import LoL.Search.service.UriBuilderService;
import LoL.Summoner.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankService {

	private final RestTemplate restTemplate;
	private final UriBuilderService uriBuilderService;

	@Value("${RIOT.API.KEY}")
	private String riotApiKey;

	public List<LeagueEntryDTO> requestIdSearch(String id) {

		if (ObjectUtils.isEmpty(id))
			return null;

		URI uri = uriBuilderService.buildUriByIdSearch(id);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		HttpEntity httpEntity = new HttpEntity<>(headers);

		ResponseEntity<List<LeagueEntryDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<LeagueEntryDTO>>() {
				});
		
		return response.getBody();

	}
}
