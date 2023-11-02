package LoL.Match.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerkStyleDto {

	private String description;
	private List<PerkStyleSelectionDto> selections;
	private int style;
}
