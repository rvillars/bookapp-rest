package ch.bfh.swos.bookapp.service.elastic;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author rovi
 *
 */
public class ElasticsearchClientFactoryBean implements FactoryBean<Client>,
		InitializingBean, DisposableBean {

	protected final Log logger = LogFactory.getLog(getClass());

	private Map<String, String> settings;

	private Node node;

	public void setSettings(Map<String, String> settings) {
		this.settings = settings;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		internalCreateNode();
	}

	private void internalCreateNode() {
		final NodeBuilder nodeBuilder = NodeBuilder.nodeBuilder();

		if (null != settings) {
			nodeBuilder.getSettings().put(settings);
		}

		node = nodeBuilder.node();
	}

	@Override
	public void destroy() throws Exception {
		try {
			node.close();
		} catch (final Exception e) {
			logger.error("Error closing Elasticsearch node: ", e);
		}
	}

	@Override
	public Client getObject() throws Exception {
		return node.client();
	}

	@Override
	public Class<Client> getObjectType() {
		return Client.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}