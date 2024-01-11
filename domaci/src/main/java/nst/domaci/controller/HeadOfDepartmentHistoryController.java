package nst.domaci.controller;

import jakarta.validation.Valid;
import nst.domaci.domain.HeadOfDepartmentHistoryId;

import nst.domaci.dto.HeadOfDepartmentHistoryDto;

import nst.domaci.service.HeadOfDepartmentHistoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/headOfDepartmentHistory")
public class HeadOfDepartmentHistoryController {

    private final HeadOfDepartmentHistoryService headService;

    public HeadOfDepartmentHistoryController(HeadOfDepartmentHistoryService headService) {
        this.headService = headService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody HeadOfDepartmentHistoryDto headOfDepartmentHistoryDto) throws Exception{
        HeadOfDepartmentHistoryDto dto = headService.save(headOfDepartmentHistoryDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<HeadOfDepartmentHistoryDto> dtos = headService.getAll();
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
        List<HeadOfDepartmentHistoryDto> dtos = headService.getAll(pageable);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public HeadOfDepartmentHistoryDto findById(@PathVariable("id") HeadOfDepartmentHistoryId id) throws Exception {
        return headService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable HeadOfDepartmentHistoryId id) throws Exception {
        headService.delete(id);
        return new ResponseEntity<>("Head of Department history removed!", HttpStatus.OK);
    }
}
