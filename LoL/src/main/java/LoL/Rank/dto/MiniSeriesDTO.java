package LoL.Rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor	
public class MiniSeriesDTO {
	
	private int losses;
	private String progress;
	private int target;
	private int wins;

}
