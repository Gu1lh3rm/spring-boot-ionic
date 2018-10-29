package com.gml.cursomc.services;

import com.gml.cursomc.dto.common.BucketDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class BucketService {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(BucketService.class);

    @Value("${bucket.url}")
    private String urlBase;

    public String getImgUrl(String imgName){

        try{

            String url = urlBase + imgName +".jpg";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);



            ResponseEntity<BucketDTO> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, BucketDTO.class, "1");
            BucketDTO bucket = response.getBody();

            return bucket.getDownloadTokens();

        }catch (Exception e){

           LOG.info("GET: Erro ao buscar Url da imagem no firebase");
           LOG.info(e.toString());
           return null;

        }
    }

}
