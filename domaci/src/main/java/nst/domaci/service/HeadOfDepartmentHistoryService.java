package nst.domaci.service;


import nst.domaci.domain.HeadOfDepartmentHistoryId;
import nst.domaci.dto.HeadOfDepartmentHistoryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HeadOfDepartmentHistoryService {
    HeadOfDepartmentHistoryDto save (HeadOfDepartmentHistoryDto headOfDepartmentHistoryDto) throws Exception;

    List<HeadOfDepartmentHistoryDto> getAll(Pageable pageable);
    List<HeadOfDepartmentHistoryDto> getAll();

    void delete (HeadOfDepartmentHistoryId headOfDepartmentHistoryId) throws Exception;

    void update (HeadOfDepartmentHistoryDto secretaryOfDepartmentHistoryDto) throws Exception;

    HeadOfDepartmentHistoryDto findById(HeadOfDepartmentHistoryId headOfDepartmentHistoryId) throws Exception;

}
