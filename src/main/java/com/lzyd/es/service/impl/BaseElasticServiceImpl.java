package com.lzyd.es.service.impl;

import com.lzyd.es.service.BaseElasticService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Sunyutao
 * @version [V1.0, 2020/09/19]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Slf4j
@Service
public class BaseElasticServiceImpl implements BaseElasticService {
    @Override
    public Object createIndex(String idxName, String idxSQL) {
        return null;
    }

//    @Autowired
//    RestHighLevelClient restHighLevelClient;
//
//    /**
//     * @author WCNGS@QQ.COM
//     * @See
//     * @date 2019/10/17 17:30
//     * @param idxName   索引名称
//     * @param idxSQL    索引描述
//     * @return void
//     * @throws
//     * @since
//     */
//    @Override
//    public Object createIndex(String idxName,String idxSQL){
//        try {
//            if (!this.indexExist(idxName)) {
//                log.error(" idxName={} 已经存在,idxSql={}",idxName,idxSQL);
//                return false;
//            }
//            CreateIndexRequest request = new CreateIndexRequest(idxName);
//            buildSetting(request);
//            request.mapping(idxSQL, XContentType.JSON);
////            request.settings() 手工指定Setting
//            CreateIndexResponse res = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
//            System.out.println(res.toString());
//            if (!res.isAcknowledged()) {
//                throw new RuntimeException("初始化失败");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
//    /** 断某个index是否存在
//     * @author WCNGS@QQ.COM
//     * @See
//     * @date 2019/10/17 17:27
//     * @param idxName index名
//     * @return boolean
//     * @throws
//     * @since
//     */
//    public boolean indexExist(String idxName) throws Exception {
//        GetIndexRequest request = new GetIndexRequest(idxName);
//        request.local(false);
//        request.humanReadable(true);
//        request.includeDefaults(false);
//        request.indicesOptions(IndicesOptions.lenientExpandOpen());
//        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
//    }
//    /** 设置分片
//     * @author WCNGS@QQ.COM
//     * @See
//     * @date 2019/10/17 19:27
//     * @param request
//     * @return void
//     * @throws
//     * @since
//     */
//    public void buildSetting(CreateIndexRequest request){
//        request.settings(Settings.builder().put("index.number_of_shards",3)
//                .put("index.number_of_replicas",2));
//    }


}
