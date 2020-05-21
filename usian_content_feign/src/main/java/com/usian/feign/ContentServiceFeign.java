package com.usian.feign;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "usian-content-service")
public interface ContentServiceFeign {

    @RequestMapping("/service/content/selectContentCategoryByParentId")
    List<TbContentCategory> selectContentCategoryByParentId(@RequestParam Long id);
    @RequestMapping("/service/content/insertContentCategory")
    Integer insertContentCategory(TbContentCategory tbContentCategory);
    @RequestMapping("/service/content/deleteContentCategoryById")
    Integer deleteContentCategoryById(@RequestParam("categoryId") Long categoryId);
    @RequestMapping("/service/content/updateContentCategory")
    Integer updateContentCategory(TbContentCategory tbContentCategory);
    @RequestMapping("/service/content/selectTbContentAllByCategoryId")
    PageResult selectTbContentAllByCategoryId(@RequestParam Integer page, @RequestParam Integer rows, @RequestParam Long categoryId);
    @RequestMapping("/service/content/insertTbContent")
    Integer insertTbContent(TbContent tbContent);
    @RequestMapping("/service/content/deleteContentByIds")
    Integer deleteContentByIds(@RequestParam Long ids);
}