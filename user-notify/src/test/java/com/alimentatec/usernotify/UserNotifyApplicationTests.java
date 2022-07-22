package com.alimentatec.usernotify;

import com.alimentatec.usernotify.client.MsProducerClient;
import com.alimentatec.usernotify.common.model.dto.response.ResponseDTO;
import com.alimentatec.usernotify.common.model.enums.EResponseType;
import com.alimentatec.usernotify.dto.RequestMsProducer;
import com.alimentatec.usernotify.service.IUserNotifyService;
import com.alimentatec.usernotify.service.UserNotifyServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserNotifyApplicationTests {

	@InjectMocks
	private UserNotifyServiceImpl userNotifyService;

	@Mock
	private MsProducerClient msProducerClient;

	@Test
	void sendUserNotify(){
		ResponseDTO responseDTO = new ResponseDTO(EResponseType.SUCCESS,"Success consume to ms-producer", "202");
		when(msProducerClient.consumerMsProducer(Mockito.any())).thenReturn(responseDTO);
		RequestMsProducer requestMsProducer = new RequestMsProducer(
				"3003003030",
				"jmartinez79@uan.edu.co",
				"{\"idCampaign\":\"6645|6646|6647\",\"idUser\":\"10MB+MINILIMMOVISTAR+25MBChatwa+15MBFB+TWx$1000|350MB+MinilimTD+ChatWhatsApp+Redesilimx$3.000|1.3GB+MinilimTD+ChatWhatsApp+Redesilimx$6.000\",\"campaignResult\":\"1000|3000|6000\"}");
		ResponseDTO response = userNotifyService.sendUserNotify(requestMsProducer);
		assertNotNull(response);
	}

}
