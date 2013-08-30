elasticsearch
=============
bookapp-rest based example showing the possibilities of storing json data directly in elasticsearch.

Elasticsearch is initialized by a self-written factory bean in the service layer:
``` xml
<bean id="esNode" class="ch.bfh.swos.bookapp.service.elastic.ElasticsearchClientFactoryBean">
  <property name="settings">
	  <map>
		  <entry key="name" value="bookapp.node"/>
			<entry key="path.data" value="D:/temp/data"/>
			<entry key="node.local" value="true"/>
		</map>
	</property>
</bean>
```
