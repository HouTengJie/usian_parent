package com.usian.controller;

import com.usian.feign.ItemServiceFeignClient;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/itemParam")
public class ItemParamController {
    @Autowired
    private ItemServiceFeignClient itemServiceFeignClient;

    @RequestMapping("/selectItemParamByItemCatId/{itemCatId}")
    public Result selectItemParamByItemCatId(@PathVariable Long itemCatId){
       TbItemParam itemParam = itemServiceFeignClient.selectItemParamByItemCatId(itemCatId);
       if (itemParam != null){
           return Result.ok(itemParam);
       }
       return Result.error("查无结果");
    }
    /**
     * 分页查询商品规格模板*/
    @RequestMapping("/selectItemParamAll")
    public Result selectItemParamAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "3") Integer rows){
       PageResult pageResult =  itemServiceFeignClient.selectItemParamAll(page,rows);
       if(pageResult.getResult().size()>0){
           return Result.ok(pageResult);
       }
        return Result.error("查无结果");
    }
    /**
     * 添加商品规格模板*/
    @RequestMapping("/insertItemParam")
    public Result insertItemParam(Long itemCatId,String paramData){
        Integer num = itemServiceFeignClient.insertItemParam(itemCatId,paramData);
        if(num==1){
            return Result.ok();
        }
        return Result.error("添加失败");
    }
}
