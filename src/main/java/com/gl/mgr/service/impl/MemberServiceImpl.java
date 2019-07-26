package com.gl.mgr.service.impl;

import com.gl.mgr.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Controller
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class MemberServiceImpl implements MemberService {

}
