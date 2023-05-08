package com.learning.springMvc.service;

import javax.validation.Valid;

import com.learning.springMvc.dto.PasswordReset;

public interface LoginService {

	String forgotPassword(@Valid PasswordReset passwordReset);

}
