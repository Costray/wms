package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.Goods;
import com.wms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wsm
 * @since 2023-06-29
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    //增
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods) {
        return goodsService.save(goods)? Result.suc(): Result.fail();
    }

    //更新
    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        return goodsService.updateById(goods)? Result.suc(): Result.fail();
    }

    //删
    @GetMapping("/del")
    public Result del(@RequestParam String id) {
        return goodsService.removeById(id)?Result.suc():Result.fail();
    }

    //分页
    @PostMapping("/listPage")
    public Result listPage(@RequestBody QueryPageParam query) {
        HashMap hm = query.getParam();
        String name = (String) hm.get("name");
        String goodstype = (String)hm.get("goodstypes");
        String storage = (String)hm.get("storage");
        Page<Goods> page = new Page<>(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<Goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)) {
            lambdaQueryWrapper.like(Goods::getName, name);
        }
        if (StringUtils.isNotBlank(goodstype) && !"null".equals(goodstype)) {
            lambdaQueryWrapper.eq(Goods::getGoodstype, goodstype);
        }
        if (StringUtils.isNotBlank(storage) && !"null".equals(storage)) {
            lambdaQueryWrapper.eq(Goods::getStorage, storage);
        }
        IPage result = goodsService.page(page, lambdaQueryWrapper);
        return Result.suc(result.getRecords(), result.getTotal());
    }
}
