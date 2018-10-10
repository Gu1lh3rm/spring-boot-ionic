package com.gml.cursomc.services;

import com.gml.cursomc.domain.Categoria;
import com.gml.cursomc.dto.CategoriaDTO;
import com.gml.cursomc.dto.bucketDTO;
import com.gml.cursomc.repositories.CategoriaRepository;
import com.gml.cursomc.services.exceptions.DataIntegrityException;
import com.gml.cursomc.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class BucketService {
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(BucketService.class);

    @Value("${bucket.url}")
    private String urlBase;

    public String getImgUrl(String imgName, Integer id){

        try{

            String url = urlBase + imgName + id.toString() +".jpg";
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);



            ResponseEntity<bucketDTO> response =
                    restTemplate.exchange(url, HttpMethod.GET, entity, bucketDTO.class, "1");
            bucketDTO bucket = response.getBody();

            return bucket.getDownloadTokens();

        }catch (Exception e){

           LOG.info("GET: Erro ao buscar Url da imagem no firebase");
           LOG.info(e.toString());
           return null;

        }
    }

}
