package hungry.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by admin on 2019/4/17.
 */
public class UserInfo {

    private Long id;

    private String username;

    private Integer age;

    private BigDecimal score;

    private Integer department;

    private Boolean male;

    private List<String> historyRecordList;

    private List<Integer> gradeRecordList;

    public List<Integer> getGradeRecordList() {
        return gradeRecordList;
    }

    public void setGradeRecordList(List<Integer> gradeRecordList) {
        this.gradeRecordList = gradeRecordList;
    }

    public List<String> getHistoryRecordList() {
        return historyRecordList;
    }

    public void setHistoryRecordList(List<String> historyRecordList) {
        this.historyRecordList = historyRecordList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    @Override

    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", department=" + department +
                ", male=" + male +
                ", historyRecordList=" + historyRecordList +
                ", gradeRecordList=" + gradeRecordList +
                '}';
    }
}


