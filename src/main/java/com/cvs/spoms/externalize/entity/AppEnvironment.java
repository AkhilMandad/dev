package com.cvs.spoms.externalize.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "APP_ENVIRONMENT", schema = "SECURITY")
public class AppEnvironment implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
	@SequenceGenerator(name="SEQUENCE1", sequenceName="Env_SEQ", allocationSize=1)
    @Column(name = "ENV_ID")
    private Long envId;

    @Column(name = "ENV_NAME")
    private String envName;

    @Column(name = "IS_ACTIVE")
    private String activeInd;

    @OneToMany(mappedBy = "appEnvironment")
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

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
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
