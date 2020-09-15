package com.lzyd.es.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
//@Document(indexName = "item",type = "docs",shards = 1, replicas = 0)
public class UserChapterFive {
//    @Id
//    private Integer id;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String customKey;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String userName;
//    @Field(type = FieldType.Keyword)
//    private String headImg;
//    @Field(type = FieldType.Keyword)
//    private String wechatNum;
//    @Field(type = FieldType.Keyword)
//    private String district;
//    @Field(type = FieldType.Keyword)
//    private Short identity;
//    @Field(type = FieldType.Keyword)
//    private Integer fansNum;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String introduction;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String ownResource;
//    @Field(type = FieldType.Text, analyzer = "ik_max_word")
//    private String wantResource;
//    @Field(type = FieldType.Keyword)
//    private Short status;
//    @Field(type = FieldType.Keyword)
//    private Date createTime;
//    @Field(type = FieldType.Keyword)
//    private Date modifyTime;


}