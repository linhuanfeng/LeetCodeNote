package com.lhf.web;

import com.lhf.entity.Params;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/hello")
@Api(tags="job")
public class HelloController {

    @GetMapping("/say")
    @ApiOperation("获取首页职位列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "jobType", value = "职位类型，1实习，2校招，3社招", paramType = "query", dataType="int") ,
            @ApiImplicitParam(name = "cid", value = "分类id,本质是小分类jobSid", paramType = "query", dataType="String")
    })
    public String say(@RequestParam Map<String, Object> params){
        return "hello";
    }

    @GetMapping("/say3")
    @ApiOperation("获取首页职位列表3")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "当前页码，从1开始", paramType = "query", required = true, dataType="int") ,
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", paramType = "query",required = true, dataType="int") ,
            @ApiImplicitParam(name = "jobType", value = "职位类型，1实习，2校招，3社招", paramType = "query", dataType="int") ,
            @ApiImplicitParam(name = "cid", value = "分类id,本质是小分类jobSid", paramType = "query", dataType="String")
    })
    public String say3(Params params){
        return "hello";
    }

    public String say2(){
        return "hello";
    }
}
