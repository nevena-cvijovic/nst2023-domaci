package nst.domaci.domain;



import java.io.Serializable;
import java.util.Objects;

public class SecretaryOfDepartmentHistoryId implements Serializable {

    private Department department;

    private Member member;

    public SecretaryOfDepartmentHistoryId() {
    }

    public SecretaryOfDepartmentHistoryId(Department department, Member member) {
        this.department = department;
        this.member = member;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecretaryOfDepartmentHistoryId that = (SecretaryOfDepartmentHistoryId) o;
        return Objects.equals(department, that.department) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department, member);
    }
}
