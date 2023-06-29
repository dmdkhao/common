package com.dmdk.common.controller.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "const_team")
public class ConstTeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_acronym")
    private String nameAcronym;

    @Column(name = "team_sys_no")
    private Integer teamSysNo;    //班组编号

    @Column(name = "team_no")
    private String teamNo;      //班组编号

    @Column(name = "sync_status")
    private Integer syncStatus;

    @Column(name = "i8_team_id")
    private Long i8TeamId;

    @Column(name = "team_type")
    private String teamType;

    @Override
    public String toString() {
        return "ConstTeamEntity{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", name='" + name + '\'' +
                ", nameAcronym='" + nameAcronym + '\'' +
                ", teamSysNo=" + teamSysNo +
                ", teamNo='" + teamNo + '\'' +
                ", syncStatus=" + syncStatus +
                ", i8TeamId=" + i8TeamId +
                ", teamType='" + teamType + '\'' +
                '}';
    }
}
