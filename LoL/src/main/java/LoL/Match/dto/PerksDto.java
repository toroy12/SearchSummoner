package LoL.Match.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerksDto {
	
	private PerkStatsDto statPerks;
	private List<PerkStyleDto> styles;

}
