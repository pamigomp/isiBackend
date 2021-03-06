package com.pwr.isi.project.service.dto.subscription.output;

import com.pwr.isi.project.service.enums.BaseCurrency;
import com.pwr.isi.project.service.enums.FrequencyValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "aSubscription")
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionOutputDto {
  public String email;
  public String targetCurrency;
  public BaseCurrency baseCurrency;
  public FrequencyValue period;
}
