package LoL.Match.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
	
	private List<BanDto> bans;
	private ObjectivesDto objectives;
	private int teamId;
	private boolean win;
	

}
