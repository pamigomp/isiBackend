package com.pwr.isi.project.web;

import static com.pwr.isi.project.ExchangeRatesApplication.HOST_URL;

import com.pwr.isi.project.service.dto.exchange.rates.ExchangeRatesPageableDto;
import com.pwr.isi.project.service.exchange.rates.parser.ParserService;
import com.pwr.isi.project.service.external.ExternalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/exchange/v1")
@CrossOrigin(origins = HOST_URL)
public class ExchangeRatesController {

  private ParserService parserService;
  private ExternalService externalService;

  @Autowired
  public ExchangeRatesController(ParserService parserService, ExternalService externalService) {
    this.parserService = parserService;
    this.externalService = externalService;
  }

  /**
   * @param currency    currency ISO 4217 code in UPPERCASE
   * @param startDate   yyyy-mm-dd - must be older than 3 day
   * @param endDate     yyyy-mm-dd - cannot be in the future
   * @param pageRequest page, size, sort
   */
  @RequestMapping(value = "/nbp/exchange_rates", method = RequestMethod.GET)
  public ExchangeRatesPageableDto getCurrencyFromNBP(@RequestParam("currency") String currency,
                                                     @RequestParam("startDate") String startDate,
                                                     @RequestParam("endDate") String endDate,
                                                     Pageable pageRequest) {
    return parserService.getExchangeRatesFromNBP(externalService.getExchangeRatesFromNBP(currency, startDate, endDate), pageRequest);
  }

  /**
   * @param currency    currency ISO 4217 code in UPPERCASE
   * @param startDate   yyyy-mm-dd - must be older than 3 day
   * @param endDate     yyyy-mm-dd - cannot be in the future
   * @param pageRequest page, size, sort
   */
  @RequestMapping(value = "/ecb/exchange_rates", method = RequestMethod.GET)
  public ExchangeRatesPageableDto getCurrencyFromECB(@RequestParam("currency") String currency,
                                                     @RequestParam("startDate") String startDate,
                                                     @RequestParam("endDate") String endDate,
                                                     Pageable pageRequest) {
    return parserService.getExchangeRatesFromECB(externalService.getExchangeRatesFromECB(currency, startDate, endDate), pageRequest);
  }
}
