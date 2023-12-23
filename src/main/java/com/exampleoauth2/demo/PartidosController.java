package com.exampleoauth2.demo;

import com.exampleoauth2.demo.dto.MatchsDTO;
import com.exampleoauth2.demo.output.YourOutputObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fixtures")
public class PartidosController {

    @Autowired
    private CustomMatchRepositoryImpl matchRepository;

    @GetMapping
    public ResponseEntity<List<MatchsDTO>> obtenerPartidosPorFechasYEquipos(@RequestParam Map<String, String> params) {
        Map<String, String> queryParams = new HashMap<>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            queryParams.put(entry.getKey(), entry.getValue());
        }
        List<MatchsDTO> partidos = matchRepository.findAllByDynamicCriteria(queryParams);
        return new ResponseEntity<>(partidos, HttpStatus.OK);
    }
}

