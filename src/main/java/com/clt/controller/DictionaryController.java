package com.clt.controller;

import com.clt.service.DictionaryService;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ：clt
 * @Date ：Created in 17:09 2020/03/29
 */
@RestController
@RequestMapping("dictionary")

public class DictionaryController {

    @Autowired
    private StringRedisTemplate template;

    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping("")
    public ResultUtil<Map<Object, Object>> insert(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key,
            @ApiParam @RequestParam String value
    ) {
        return this.dictionaryService.insert(field, key, value);
    }

    @GetMapping("")
    public ResultUtil<Map<Object, Object>> query(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key
    ) {
        return this.dictionaryService.query(field, key);
    }

    @GetMapping("/multiple")
    public ResultUtil< List<Map<Object, Object>>> multipleQuery(
            @ApiParam @RequestParam(required = false) List<String> fields
    ) {
        return this.dictionaryService.multipleQuery(fields);
    }



    @PutMapping("")
    public ResultUtil<Map<Object, Object>> update(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key,
            @ApiParam @RequestParam String value
    ) {
        return this.dictionaryService.update(field, key, value);
    }

    @Delete("")
    public ResultUtil<Map<Object, Object>> delete(
            @ApiParam @RequestParam(required = false) String field,
            @ApiParam @RequestParam String key
    ) {
        return this.dictionaryService.delete(field, key);
    }

    @GetMapping("/keys")
    public ResultUtil<Map<Object, Object>> queryKeys(){
        template.opsForValue().get("grade");
        return null;
    }
}
