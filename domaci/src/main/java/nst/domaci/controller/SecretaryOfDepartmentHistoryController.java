package nst.domaci.controller;

import jakarta.validation.Valid;
import nst.domaci.domain.AcademicTitleHistoryId;
import nst.domaci.domain.SecretaryOfDepartmentHistoryId;
import nst.domaci.dto.AcademicTitleHistoryDto;
import nst.domaci.dto.SecretaryOfDepartmentHistoryDto;
import nst.domaci.service.AcademicTitleHistoryService;
import nst.domaci.service.SecretaryOfDepartmentHistoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secretaryOfDepartmentHistory")

public class SecretaryOfDepartmentHistoryController {


    private final SecretaryOfDepartmentHistoryService secretaryService;

    public SecretaryOfDepartmentHistoryController(SecretaryOfDepartmentHistoryService secretaryService) {
        this.secretaryService = secretaryService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody SecretaryOfDepartmentHistoryDto secretaryOfDepartmentHistoryDto) throws Exception{
        SecretaryOfDepartmentHistoryDto dto = secretaryService.save(secretaryOfDepartmentHistoryDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<SecretaryOfDepartmentHistoryDto> dtos = secretaryService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getAllByPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "department_id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {

        Pageable pageable;
        if (sortDirection.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
        }
        List<SecretaryOfDepartmentHistoryDto> dtos = secretaryService.getAll(pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SecretaryOfDepartmentHistoryDto findById(@PathVariable("id") SecretaryOfDepartmentHistoryId id) throws Exception {
        return secretaryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable SecretaryOfDepartmentHistoryId id) throws Exception {
        secretaryService.delete(id);
        return new ResponseEntity<>("Secretary of Department history removed!", HttpStatus.OK);
    }
}
