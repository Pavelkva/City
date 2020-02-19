package test2;

import java.util.ArrayList;
import java.util.List;

public class Location {

  private int id;
  private String name;
  private List<Npc> npcs;
  private List<Location> paths;
  
  public Location(int id, String name) {
    this.id = id;
    this.name = name;
    this.npcs = new ArrayList<>();
    this.paths = new ArrayList<>();
  }

  public void addNpc(Npc npc) {
    npcs.add(npc);
    if (npc.getLocation() != null) {
      npc.getLocation().removeNpc(npc);
    }
    npc.setLocation(this);
  }
  
  public void removeNpc(Npc npc) {
    npcs.remove(npc);
  }
  
   /**
   * @return the npcs
   */
  public List<Npc> getNpcs() {
    return npcs;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @return the paths
   */
  public List<Location> getPaths() {
    return paths;
  }
  
  public void addPath(Location location) {
    paths.add(location);
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

 
  
}