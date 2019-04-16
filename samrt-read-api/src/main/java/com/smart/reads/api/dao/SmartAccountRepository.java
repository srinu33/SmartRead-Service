package com.smart.reads.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.smart.reads.api.entity.SmartAccount;

public interface SmartAccountRepository extends CrudRepository<SmartAccount, Long> { }
