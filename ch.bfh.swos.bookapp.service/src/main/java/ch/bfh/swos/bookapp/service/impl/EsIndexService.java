package ch.bfh.swos.bookapp.service.impl;

import ch.bfh.swos.bookapp.service.IndexService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
public class EsIndexService<T> implements IndexService<T> {
	
	public final String INDEX_NAME = "bookapp";
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Inject
	private Client elasticClient;
	
	@Override
	public long index(T item, String type) {
		IndexResponse indexResponse = null;
		try {
			 indexResponse = elasticClient.prepareIndex(INDEX_NAME, type).setSource(mapper.writeValueAsString(item)).execute().actionGet();
			 return Long.parseLong(indexResponse.getId());
		} catch (IOException e) {
			logger.error("Error indexing object", e);
		}
		return 0;
	}
	
	@Override
	public void index(T item, String type, long id) {		
		try {
			 elasticClient.prepareIndex(INDEX_NAME, type, Long.toString(id)).setSource(mapper.writeValueAsString(item)).execute().actionGet();
		} catch (IOException e) {
			logger.error("Error indexing object with id "+id, e);
		}
	}

	@Override
	public void delete(String type, long id) {
		elasticClient.prepareDelete(INDEX_NAME, type, Long.toString(id)).execute();
	}
}
