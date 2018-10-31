package com.ys.inventory.controller;


import com.ys.inventory.common.core.Result;
import com.ys.inventory.entity.User;
import com.ys.inventory.service.LoginService;
import com.ys.inventory.system.log.annotation.LogAction;
import com.ys.inventory.system.log.annotation.LogModule;
import com.ys.inventory.vo.LoginVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author liusihua.
 * @date 2018/09/03.
 */
@Api(value = "Login ", tags = {"Login"})
@RestController
@LogModule(moduleName = "登录")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "进行登录")
    @ApiResponses({@ApiResponse(code = 200, message = "登录成功", response = Result.class)})
    @LogAction(value = "进行登录")
    @PostMapping(value = "/login")
    public User add(@ApiParam(value = "登录信息", required = true) @RequestBody LoginVO vo) {
        return loginService.login(vo);
    }

}
