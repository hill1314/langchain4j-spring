package dev.langchain4j.store.embedding.chroma.spring;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.chroma.ChromaEmbeddingStore;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

import java.time.Duration;
import java.util.Optional;

import static dev.langchain4j.store.embedding.chroma.spring.ChromaEmbeddingStoreProperties.*;

/**
 * ChromaEmbeddingStoreAutoConfiguration
 *
 * @author huleilei9
 * @date 2024/07/23
 */
@AutoConfiguration
@EnableConfigurationProperties(ChromaEmbeddingStoreProperties.class)
@ConditionalOnProperty(prefix = PREFIX, name = "enabled", havingValue = "true", matchIfMissing = true)
public class ChromaEmbeddingStoreAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ChromaEmbeddingStore milvusEmbeddingStore(ChromaEmbeddingStoreProperties properties,
                                                     @Nullable EmbeddingModel embeddingModel) {
        String url = Optional.ofNullable(properties.getUrl()).orElse(DEFAULT_URL);
        String collectionName = Optional.ofNullable(properties.getCollectionName()).orElse(DEFAULT_COLLECTION_NAME);
        Long timeout = Optional.ofNullable(properties.getTimeout()).orElse(DEFAULT_TIMEOUT);

        return ChromaEmbeddingStore.builder()
                .baseUrl(url)
                .collectionName(collectionName)
                .timeout(Duration.ofSeconds(timeout))
                .build();
    }
}
