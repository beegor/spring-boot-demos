package demo;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.stereotype.Service;

@Service
public class SomeManager {

    private IMap<String, String> distrMap;

    public SomeManager(HazelcastInstance hazelcastInstance) {

        distrMap = hazelcastInstance.getMap("test");

        distrMap.put("1", "bla");

        System.out.println("Value from map: " + distrMap.get("1"));
    }
}
