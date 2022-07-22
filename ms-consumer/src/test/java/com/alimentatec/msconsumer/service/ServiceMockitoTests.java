package com.alimentatec.msconsumer.service;

import com.alimentatec.msconsumer.client.MsEmailNotificationClient;
import com.alimentatec.msconsumer.dto.NotificationDTO;
import com.alimentatec.msconsumer.dto.ResponseMsEmailNotificationDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ServiceMockitoTests {

	@InjectMocks
	private NotificationServiceImpl notificationService;

	@Mock
	private MsEmailNotificationClient msEmailNotificationClient;

	@Test
	void consumeSatPushReturnInfoValue(){
		ResponseMsEmailNotificationDTO responseMsEmailNotificationDTO = new ResponseMsEmailNotificationDTO("200","Success");
		when(msEmailNotificationClient.consumeMsEmailNotification(Mockito.any())).thenReturn(Mono.just(responseMsEmailNotificationDTO));
		NotificationDTO notificationDTO = new NotificationDTO(
				"3003003030",
				"jmartinez79@uan.edu.co",
				"{\"idCampaign\":\"6645|6646|6647\",\"idUser\":\"10MB+MINILIMMOVISTAR+25MBChatwa+15MBFB+TWx$1000|350MB+MinilimTD+ChatWhatsApp+Redesilimx$3.000|1.3GB+MinilimTD+ChatWhatsApp+Redesilimx$6.000\",\"campaignResult\":\"1000|3000|6000\"}");
		Mono<ResponseMsEmailNotificationDTO> responseMono = notificationService.sendNotification(notificationDTO);
		assertNotNull(responseMono.block());
	}
}
