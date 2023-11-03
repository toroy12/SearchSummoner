package LoL.Match.service;

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
import LoL.Search.service.UriBuilderService;
import LoL.Summoner.dto.SummonerDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchIdService {

	private final RestTemplate restTemplate;
	private final UriBuilderService uriBuilderService;
	
	@Value("${RIOT.API.KEY}")
	private String riotApiKey;

	public List<MatchIdDTO> requestPuuidSearch(String puuid) {

		if (ObjectUtils.isEmpty(puuid))
			return null;

		URI uri = uriBuilderService.buildUriByPuuidSearch(puuid);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-Riot-Token", riotApiKey);
		HttpEntity httpEntity = new HttpEntity<>(headers);

		ResponseEntity<List<MatchIdDTO>> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity,
				new ParameterizedTypeReference<List<MatchIdDTO>>() {
				});

		return response.getBody();
	}
}
