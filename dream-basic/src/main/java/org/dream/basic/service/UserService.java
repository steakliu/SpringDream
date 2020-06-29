package org.dream.basic.service;

import org.dream.basic.pojo.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> list(int nodeId);
}
