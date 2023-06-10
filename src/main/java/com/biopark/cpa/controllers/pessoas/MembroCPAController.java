package com.biopark.cpa.controllers.pessoas;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.biopark.cpa.dto.GenericDTO;
import com.biopark.cpa.entities.pessoas.MembrosCPA;
import com.biopark.cpa.entities.user.User;
import com.biopark.cpa.form.pessoas.CadastroCPA;
import com.biopark.cpa.repository.pessoas.MembrosCPARepository;
import com.biopark.cpa.services.pessoas.MembrosCPAService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/membros-cpa")
@RequiredArgsConstructor
public class MembroCPAController {
    private final MembrosCPAService membrosCPAService;
    private final MembrosCPARepository membrosCPARepository;

    @PostMapping
    @PreAuthorize("hasRole('CPA')")
    public ResponseEntity<GenericDTO> cadastrarMembroExterno(@RequestBody CadastroCPA membroCPA){
        GenericDTO response = membrosCPAService.cadastrarCPA(membroCPA);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    /* 
    @GetMapping
    public ResponseEntity<Optional<User>> buscarPorId (@RequestParam(name = "id") Long id) {
            var membroCPA = membrosCPARepository.findById(id);
            if (membroCPA == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(membroCPA);
            }
            return ResponseEntity.status(HttpStatus.OK).body(membroCPA);
        }

    @GetMapping("/membrosCPA")
    public ResponseEntity<List<MembrosCPA>> listarMembrosCPA() {
        List<MembrosCPA> membrosCPA = membrosCPARepository.findAll();
        if (membrosCPA.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(membrosCPA);
    }
    
    @PutMapping
    public ResponseEntity<GenericDTO> editarMembroCPA(@RequestBody MembrosCPA membrosCPA) {
        GenericDTO response = MembrosCPAService.editarMembroCPA(membrosCPA);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping
    public ResponseEntity<GenericDTO> excluirMembroCpa(@PathVariable Long id) {
        GenericDTO response = MembrosCPAService.excluirMembroCPA(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
    */
}
