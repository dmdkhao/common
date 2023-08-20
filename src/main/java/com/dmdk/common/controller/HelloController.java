package com.dmdk.common.controller;

import com.dmdk.common.util.GenerateSQLUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Api(tags = "小帮手控制器")
@RestController
@RequestMapping("/helloController")
public class HelloController {

    @ApiOperation(value = "helloWorld")
    @ResponseBody
    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }


    @ApiOperation(value = "品类enum生成sql")
    @ResponseBody
    @RequestMapping(value = "/productCategoryGenSQL", method = RequestMethod.GET)
    public String productCategoryGenSQL() {
        String result = GenerateSQLUtil.genProductCategorySQL();
        return result;
    }


    @ApiOperation(value = "品牌enum生成sql")
    @ResponseBody
    @RequestMapping(value = "/productBrandGenSQL", method = RequestMethod.GET)
    public String productBrandGenSQL() {
        String result = GenerateSQLUtil.genProductBrandSQL();
        return result;
    }
}
