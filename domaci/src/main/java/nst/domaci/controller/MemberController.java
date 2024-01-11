package nst.domaci.controller;

import jakarta.validation.Valid;
import nst.domaci.dto.MemberDto;
import nst.domaci.service.MemberService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody MemberDto memberDto)throws Exception{
        MemberDto dtoMember = memberService.save(memberDto);
        return new ResponseEntity<>(dtoMember, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        List<MemberDto> memberDtos = memberService.getAll();
        return new ResponseEntity<>(memberDtos, HttpStatus.OK);
    }

    @GetMapping("/paging")
    public ResponseEntity<Object> getAllByPage(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "pageSize", defaultValue = "4") int pageSize,
            @RequestParam(name = "sortBy",defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDirection", defaultValue = "asc") String sortDirection){
        Pageable pageable;
        if(sortDirection.equals("asc")){
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).ascending());
        }else{
            pageable = PageRequest.of(page, pageSize, Sort.by(sortBy).descending());
        }

        List<MemberDto> memberDtos = memberService.getAll(pageable);
        return new ResponseEntity<>(memberDtos,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public MemberDto findById(@PathVariable("id") Long id) throws Exception{
        return memberService.findById(id);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) throws Exception{
       memberService.delete(id);
       return new ResponseEntity<>("Member removed", HttpStatus.OK);

    }
}