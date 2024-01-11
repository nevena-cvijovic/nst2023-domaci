package nst.domaci.controller;

import jakarta.validation.Valid;

import nst.domaci.domain.AcademicTitleHistoryId;
import nst.domaci.dto.AcademicTitleHistoryDto;
import nst.domaci.service.AcademicTitleHistoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academicTitleHistory")
public class AcademicTitleHistoryController {

    private final AcademicTitleHistoryService academicTitleHistoryService;

    public AcademicTitleHistoryController(AcademicTitleHistoryService academicTitleHistoryService) {
        this.academicTitleHistoryService = academicTitleHistoryService;
    }


    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception{
        AcademicTitleHistoryDto dto = academicTitleHistoryService.save(academicTitleHistoryDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<AcademicTitleHistoryDto> dtos = academicTitleHistoryService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getAllByPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "member_id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection) {

        Pageable pageable;
        if (sortDirection.equals("asc")) {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        } else {
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
        }
        List<AcademicTitleHistoryDto> dtos = academicTitleHistoryService.getAll(pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AcademicTitleHistoryDto findById(@PathVariable("id") AcademicTitleHistoryId id) throws Exception {
        return academicTitleHistoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable AcademicTitleHistoryId id) throws Exception {
        academicTitleHistoryService.delete(id);
        return new ResponseEntity<>("Academic title history removed!", HttpStatus.OK);
    }
}
