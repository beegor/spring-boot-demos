package sample;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;

@Configuration
public class HazelcastConfig {

	@Bean
	public Config config() {
		MapAttributeConfig attributeConfig = new MapAttributeConfig()
				.setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
				.setExtractor(PrincipalNameExtractor.class.getName());

		Config config = new Config();

		config.getMapConfig("spring:session:sessions")
				.addMapAttributeConfig(attributeConfig)
				.addMapIndexConfig(new MapIndexConfig(
						HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));

		return config;
	}

}
