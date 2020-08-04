package ece448.iot_hub;


import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlugsResource {

	private final PlugsModel plugs;

	public PlugsResource(PlugsModel plugs) {
		this.plugs = plugs;
	}
	
	@GetMapping("/api/plugs")
	public Collection<Object> getPlugs() throws Exception {
		ArrayList<Object> ret = new ArrayList<>();
		for (String plug: plugs.getPlugs()) {
			ret.add(makePlug(plug));
		}
		logger.info("plugs: {}", ret);
		return ret;
	}

	@GetMapping("/api/plugs/{plug:.+}")
	public Object getGroup(
		@PathVariable("plug") String plug,
		@RequestParam(value = "action", required = false) String action) {
		if (action == null) {
			Object ret = makePlug(plug);
			logger.info("plug {}: {}", plug, ret);
			return ret;
        }
        
        plugs.updatePlug(plug, action);

		logger.info("Plug {}: action {}, {}", plug, action);
		return makePlug(plug);
	}


	protected Object makePlug(String plug) {
		// modify code below to include plug states
		HashMap<String, Object> ret = new HashMap<>();
		ret.put("name", plug);
        ret.put("state", plugs.getPlugState(plug));
        ret.put("power", plugs.getPlugPower(plug));
		return ret;
	}

	private static final Logger logger = LoggerFactory.getLogger(GroupsResource.class);	
}