package com.cvs.spoms.externalize.repo;

import com.cvs.spoms.externalize.entity.AppEnvConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AppEnvConfigRepo extends JpaRepository<AppEnvConfig,Long>{
}
