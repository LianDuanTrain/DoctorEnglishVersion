package  com.docker.restful.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import javax.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import com.docker.restful.demo.entities.User;



@Service
public class UserService {

	Map<String, User> map = new ConcurrentHashMap<String, User>();
	
	public List<User> findByPattern() {
		return  new ArrayList(map.values());
	}

	public User findById(final String userId) {
		User user = map.get(userId);
		if(user == null) {
			throw new NotFoundException("User does not exist in the DB");
		}
		return user;
	}

	public void save(final User user) {
		String id = UUID.randomUUID().toString();;
		user.setId(id);
		map.put(id, user);
		
	}

	public void update(final User user) {
		if(map.containsKey(user.getId())) {
			map.put(user.getId(), user);
		}else {
			throw new NotFoundException("User does not exist in the DB");
		}
	}

	public void delete(final String userId) {

		if(map.containsKey(userId)) {
			map.remove(userId);
		}else {
			throw new NotFoundException("User does not exist in the DB");
		}
	}


}
