package dev.langchain4j.store.embedding.chroma.spring;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ChromaEmbeddingStoreProperties
 *
 * @author huleilei9
 * @date 2024/07/23
 */
@Getter
@Setter
@ConfigurationProperties(prefix = ChromaEmbeddingStoreProperties.PREFIX)
public class ChromaEmbeddingStoreProperties {

    static final String PREFIX = "langchain4j.chroma";
    static final String DEFAULT_URL = "localhost:8000";
    static final String DEFAULT_COLLECTION_NAME = "langchain4j_collection";
    static final Long DEFAULT_TIMEOUT = 5000L;

    private String url;
    private String collectionName;
    private Long timeout;
}
