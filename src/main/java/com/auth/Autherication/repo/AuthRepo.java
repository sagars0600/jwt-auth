package com.auth.Autherication.repo;

import com.auth.Autherication.model.JWTRequest;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepo extends CrudRepository<JWTRequest,String> {
    public JWTRequest findByemail(String email);
}
