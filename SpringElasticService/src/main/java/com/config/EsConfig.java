package com.config;

import javax.swing.Spring;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@PropertySource(value = "classpath:application.properties")
@EnableElasticsearchRepositories(basePackages = "com.dao")
public class EsConfig extends AbstractFactoryBean{
	
	private static final Logger LOG = LoggerFactory.getLogger(EsConfig.class);
	@Value("${spring.data.elasticsearch.cluster-nodes}")
	private String clusterNodes;
	@Value("${spring.data.elasticsearch.cluster-name}")
	private String clusterName;
	private RestHighLevelClient restHighLevelClient;
	
	
	
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		try {
			if (restHighLevelClient != null) {
				restHighLevelClient.close();
			}
		}catch (final Exception e) {
			// TODO: handle exception
			LOG.error("Error closing Elasticsearch", e);
		}
	}
	
	
	
	@Override
	public Class<RestHighLevelClient> getObjectType(){
		return RestHighLevelClient.class;
	}
	
	@Override
	public boolean isSingleton() {
		return false;
	}
	
	@Override
	 public RestHighLevelClient createInstance() {
		return buildClient();
	}
	
	private RestHighLevelClient buildClient() {
		try {
			restHighLevelClient = new RestHighLevelClient(
					RestClient.builder(
							new HttpHost("localhost", 9200, "http"),
							new HttpHost("localhost", 9201, "http")));
		}catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return restHighLevelClient;
	}
}
