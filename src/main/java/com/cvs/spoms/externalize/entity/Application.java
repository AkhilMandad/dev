package com.cvs.spoms.externalize.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "APPLICATION", schema = "SECURITY")
public class Application implements Serializable {

    @Id
//    @GeneratedValue
    @Column(name = "APP_ID")
    private Long appId;

    @Column(name = "APP_NAME")
    private String appName;

    @Column(name = "IS_ACTIVE")
    private String activeInd;

    @OneToMany(mappedBy = "application")
    private List<AppEnvConfig> appEnvConfigs;

    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<AppEnvConfig> getAppEnvConfigs() {
        return appEnvConfigs;
    }

    public void setAppEnvConfigs(List<AppEnvConfig> appEnvConfigs) {
        this.appEnvConfigs = appEnvConfigs;
    }

    public String getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(String activeInd) {
        this.activeInd = activeInd;
    }
}
