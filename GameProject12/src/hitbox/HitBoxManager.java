package hitbox;

import java.util.Collection;
import java.util.HashMap;
public class HitBoxManager {

	public static HashMap<Integer, HBox> hitboxes = new HashMap<Integer, HBox>();

	public static void addHitBox(HBox box) {
		int id = hitboxes.size();
		box.setID(id);
		hitboxes.put(id, box);
	}

	public static Collection<HBox> getNearHitBoxes(HBox hitbox) {
		return hitboxes.values();
	}

}
