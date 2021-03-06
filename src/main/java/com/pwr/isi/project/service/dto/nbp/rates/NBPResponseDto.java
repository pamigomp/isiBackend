package com.pwr.isi.project.service.dto.nbp.rates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class NBPResponseDto {
  private String table;
  private String currency;
  private String code;
  private List<NBPRateDto> rates;
}
