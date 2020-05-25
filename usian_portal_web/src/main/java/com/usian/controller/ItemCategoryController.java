package com.usian.controller;

import com.usian.feign.ItemServiceFeignClient;
import com.usian.utils.CatNode;
import com.usian.utils.CatResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页商品分类
 */
@RestController
@RequestMapping("/frontend/itemCategory")
public class ItemCategoryController {
    @Autowired
    private ItemServiceFeignClient itemServiceFeign;

    /**
     * 查询首页商品分类
     */
    @RequestMapping("/selectItemCategoryAll")
    public Result selectItemCategoryAll() {
        CatResult catNodeList = itemServiceFeign.selectItemCategoryAll();
        if(catNodeList.getData().size()>0){
            return Result.ok(catNodeList);
        }
        return Result.error("查无结果");
    }
}