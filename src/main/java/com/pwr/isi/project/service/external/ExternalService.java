package com.pwr.isi.project.service.external;

import com.pwr.isi.project.service.dto.nbp.rates.NBPResponseDto;

public interface ExternalService {

  NBPResponseDto getExchangeRatesFromNBP(String currency, String startDate, String endDate);
  String getExchangeRatesFromNBPAsXml(String currency, String startDate, String endDate);

  String getExchangeRatesFromECB(String currency, String startDate, String endDate);

}
