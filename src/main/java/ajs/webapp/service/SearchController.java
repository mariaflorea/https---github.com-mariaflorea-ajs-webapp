package ajs.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ajs.webapp.model.Monster;
import ajs.webapp.model.MonsterResponse;

@RestController
public class SearchController {

	@RequestMapping(value = "/monsters/{user}", produces = "application/json", method = RequestMethod.GET, params = {
			"code", "isAuthorizedOnly", "limit" })
	public ResponseEntity<MonsterResponse> getMonsters(
			@PathVariable("user") String user,
			@RequestParam("code") String code,
			@RequestParam("isAuthorizedOnly") Integer isAuthorizedOnly,
			@RequestParam("limit") Integer limit) {

		return getAllMonsters(limit);
	}

	private List<Monster> generateMonsters() {
		Monster m1 = new Monster("code1", "Ogre", "Earth", 1);
		Monster m2 = new Monster("code2", "Troll", "Earth", 0);
		Monster m3 = new Monster("code3", "Hydra", "Water", 0);
		Monster m4 = new Monster("code1", "Kraken ", "Water", 1);
		Monster m5 = new Monster("code3", "Dragon", "Fire", 0);
		Monster m6 = new Monster("code4", "Phoenix ", "Fire", 1);
		Monster m7 = new Monster("code5", "Griffin ", "Metal", 1);

		List<Monster> l = new ArrayList<>();
		l.add(m1);
		l.add(m2);
		l.add(m3);
		l.add(m4);
		l.add(m5);
		l.add(m6);
		l.add(m7);

		return l;
	}

	private ResponseEntity<MonsterResponse> getAllMonsters(Integer limit) {

		List<Monster> l = generateMonsters();

		Integer totalRows = l.size();

		if (limit > totalRows) {
			limit = totalRows;
		}

		MonsterResponse resp = new MonsterResponse(l.subList(0, limit), null,
				totalRows);

		return new ResponseEntity<MonsterResponse>(resp, HttpStatus.OK);
	}

}
