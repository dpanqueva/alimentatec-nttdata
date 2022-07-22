package com.alimentatec.msconsumer.utils;

import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.alimentatec.msconsumer.util.UtilImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UtilMockitoTests {

	@InjectMocks
	private UtilImpl util;

	@Test
	void convertMonoStringToMonoObjectNotificationDTO(){
		String jsonStringValue = "{\"msisdn\":\"3003003030\",\"email\":\"jmartinez79@uan.edu.co\",\"payLoad\":\"{\\\"idCampaign\\\":\\\"6645|6646|6647\\\",\\\"idUser\\\":\\\"10MB+MINILIMMOVISTAR+25MBChatwa+15MBFB+TWx$1000|350MB+MinilimTD+ChatWhatsApp+Redesilimx$3.000|1.3GB+MinilimTD+ChatWhatsApp+Redesilimx$6.000\\\",\\\"campaignResult\\\":\\\"1000|3000|6000\\\"}\"}";
		Mono<NotificationDTO> responseMono = util.convertMonoStringToMonoObjectNotificationDTO(jsonStringValue);
		assertNotNull(responseMono.block());
	}
}
