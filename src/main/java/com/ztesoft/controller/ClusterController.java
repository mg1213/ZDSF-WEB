package com.ztesoft.controller;

import com.ztesoft.dto.ClusterDto;
import com.ztesoft.service.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 技术二科 王永梅 on 2017/3/16.
 */
@Controller
@RequestMapping("/cluster")
public class ClusterController {
    @Autowired
    private ClusterService clusterService;

    @RequestMapping(value = "qryClusterList")
    @ResponseBody
    public List<ClusterDto> qryClusterList(String clusterName) throws Exception {
        return clusterService.qryClusterList(clusterName);
    }

}
