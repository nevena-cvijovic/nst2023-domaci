package nst.domaci.domain;

import java.io.Serializable;
import java.util.Objects;

public class AcademicTitleHistoryId implements Serializable {
    private Member member;
    private AcademicTitle academicTitle;

    public AcademicTitleHistoryId() {
    }

    public AcademicTitleHistoryId(Member member, AcademicTitle academicTitle) {
        this.member = member;
        this.academicTitle = academicTitle;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public AcademicTitle getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(AcademicTitle academicTitle) {
        this.academicTitle = academicTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcademicTitleHistoryId that = (AcademicTitleHistoryId) o;
        return Objects.equals(member, that.member) && Objects.equals(academicTitle, that.academicTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, academicTitle);
    }
}
