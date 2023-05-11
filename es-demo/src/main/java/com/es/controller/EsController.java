package com.es.controller;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class EsController {

    private ElasticsearchOperations elasticsearchOperations;

    public EsController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @RequestMapping("/add")
    public boolean add(@RequestBody Employee employee) {
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(employee.getId().toString())
                .withObject(employee)
                .build();
        elasticsearchOperations.index(indexQuery, IndexCoordinates.of("employee"));
        return true;
    }

    @RequestMapping("/match")
    public List<Employee> match(@RequestParam("about") String about) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("about", about)).build();
        SearchHits<Employee> searchHits = elasticsearchOperations.search(nativeSearchQuery, Employee.class, IndexCoordinates.of("employee"));
        List<Employee> employeeList = new ArrayList<>();
        List<SearchHit<Employee>> searchHitList = searchHits.getSearchHits();
        for(SearchHit searchHit : searchHitList) {
            employeeList.add((Employee) searchHit.getContent());
        }
        return employeeList;
    }

}
