package com.gzh.springbootswagger.controller;

import com.gzh.springbootswagger.entity.UserRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @author GZH
 * @date 2021-12-11
 */
@Api(tags = "用户信息管理")
@RestController
@RequestMapping("userRecord")
public class UserRecordController {

    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("{id}")
    public String selectOne(@PathVariable Serializable id) {
        return "";
    }

    /**
     * 新增数据
     * @param userRecord 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping("insert")
    public String insert(@RequestBody UserRecord userRecord) {
        return "";
    }


}
