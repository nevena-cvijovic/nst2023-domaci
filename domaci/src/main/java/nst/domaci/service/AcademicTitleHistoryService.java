package nst.domaci.service;

import nst.domaci.domain.AcademicTitleHistoryId;
import nst.domaci.dto.AcademicTitleDto;
import nst.domaci.dto.AcademicTitleHistoryDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AcademicTitleHistoryService {

    AcademicTitleHistoryDto save (AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception;

    List<AcademicTitleHistoryDto> getAll(Pageable pageable);
    List<AcademicTitleHistoryDto> getAll();

    void delete (AcademicTitleHistoryId academicTitleHistoryId) throws Exception;

    void update (AcademicTitleHistoryDto academicTitleHistoryDto) throws Exception;

    AcademicTitleHistoryDto findById(AcademicTitleHistoryId academicTitleHistoryId) throws Exception;

}
